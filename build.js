import { build } from "bun";
import { readdirSync, statSync } from "fs";
import { join } from "path";

const base = "src/main/java/org/svenehrke/demo/web";

function collectTsxFiles(dir) {
	let files = [];
	for (const f of readdirSync(dir)) {
		const fullPath = join(dir, f);
		if (statSync(fullPath).isDirectory()) {
			files.push(...collectTsxFiles(fullPath));
		} else if (f.endsWith(".tsx")) {
			files.push(fullPath);
		}
	}
	return files;
}

const entrypoints = collectTsxFiles(base);

await build({
	entrypoints,
	outdir: "dist",
	target: "browser",
	format: "esm",
	jsx: {
		mode: "react-jsx",
		importSource: "preact"
	}
});

console.log("✅ Built all TSX files into frontend/dist");
