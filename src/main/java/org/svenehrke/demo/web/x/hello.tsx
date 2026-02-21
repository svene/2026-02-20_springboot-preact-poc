import { render } from "preact";

export function mountHello(elementId: string, name: string) {
	const el = document.getElementById(elementId);
	if (!el) return;

	function App() {
		return <h1>Hello X {name}</h1>;
	}

	render(<App />, el);
}
