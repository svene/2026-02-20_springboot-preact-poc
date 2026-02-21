package org.svenehrke.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties;
import org.springframework.boot.devtools.classpath.ClassPathRestartStrategy;
import org.springframework.boot.devtools.classpath.PatternClassPathRestartStrategy;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.boot.devtools.livereload.LiveReloadServer;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.devtools.restart.Restarter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.time.Duration;

@Configuration
@Profile("dev")
@ConditionalOnClass(FileSystemWatcher.class)
@EnableConfigurationProperties(DevToolsProperties.class)
public class IslandLiveReloadConfig {

	private static final Logger logger = LoggerFactory.getLogger(IslandLiveReloadConfig.class);
	// src/main/resources/static/fe/x
	public static final String JSX_JS_ROOT = "src/main/resources/static/fe/x";

	/**
	 * Debounced LiveReloadServer -- prevents double-reload when both
	 * our island watcher and devtools classpath watcher fire.
	 */
	@Bean
	@RestartScope
	LiveReloadServer liveReloadServer(DevToolsProperties properties) {
		return new LiveReloadServer(
			properties.getLivereload().getPort(),
			Restarter.getInstance().getThreadFactory()
		) {
			private volatile long lastReloadTime = 0L;

			@Override
			public void triggerReload() {
				long now = System.currentTimeMillis();
//				if (now - lastReloadTime < 500) {
//					logger.debug("Debounced duplicate livereload");
//					return;
//				}
				lastReloadTime = now;
				logger.info("triggering livereload");
				super.triggerReload();
			}
		};
	}

	/**
	 * Watches bun build output for changes and triggers LiveReload.
	 */
	@Bean
	FileSystemWatcher islandFileSystemWatcher(LiveReloadServer liveReloadServer) {
		var watcher = new FileSystemWatcher(
			true, Duration.ofMillis(50), Duration.ofMillis(10)
		);
		var islandsDir = new File(JSX_JS_ROOT);
		watcher.addSourceDirectory(islandsDir);
		watcher.addListener(changeSet -> {
			boolean hasJs = changeSet.stream()
				.flatMap(cf -> cf.getFiles().stream())
				.anyMatch(f -> f.getRelativeName().endsWith(".js"));
			if (hasJs) {
				liveReloadServer.triggerReload();
			}
		});
		watcher.start();
		return watcher;
	}

	/**
	 * Exclude .tsx from triggering a full app restart.
	 */
	@Bean
	ClassPathRestartStrategy classPathRestartStrategy(DevToolsProperties properties) {
		var delegate = new PatternClassPathRestartStrategy(properties.getRestart().getAllExclude());
		return changedFile -> {
			if (changedFile.getRelativeName().endsWith(".tsx"))
				return false;
			return delegate.isRestartRequired(changedFile);
		};
	}
}
