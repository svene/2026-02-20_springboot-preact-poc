import {Glob} from "bun";

const sourceRoot = "../src/main/java/org/svenehrke/demo/web/";
const scanRoot = "../src/main/java";
const glob = new Glob("**/*.tsx");
const entrypoints: string[] = [];

for await (const file of glob.scan(scanRoot)) {
	entrypoints.push(`${scanRoot}/${file}`);
}

console.log(`Found ${entrypoints.length} island(s):`);
entrypoints.forEach((e) => console.log(`  ${e}`));

if (entrypoints.length > 0) {
	await Bun.build({
		entrypoints,
		outdir: "../src/main/resources/static/js/islands",
		root: sourceRoot,
		minify: true,
		naming: "[dir]/[name].js",
	});
}
console.log("Build complete.");
