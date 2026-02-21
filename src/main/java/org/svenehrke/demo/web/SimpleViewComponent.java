package org.svenehrke.demo.web;


import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import org.springframework.beans.factory.annotation.Value;

@ViewComponent
public class SimpleViewComponent {

	@Value("${spring.profiles.active:}")
	private String activeProfile;

	public record Ctx(String helloWorld, boolean devMode) implements ViewContext {
	}

	public Ctx render() {
		return new Ctx("Hello World", activeProfile.contains("dev"));
	}
}
