import { render } from "preact";

/*
function App() {
	return (
		<span>Hello</span>
	)
}


render(<App />, document.getElementById("app")!);
*/

export function mountHello(elementId: string, name: string) {
	const el = document.getElementById(elementId);
	if (!el) return;

	function App() {
		return <h1>Hello {name}</h1>;
	}

	render(<App />, el);
}
