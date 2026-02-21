import { render, h } from "preact";

export function mountHello(elementId: string, name: string) {
	const el = document.getElementById(elementId);
	if (!el) return;

	function App() {
		return <h1>Hello {name}</h1>;
	}

	render(<App />, el);
}

function App2(props: {message: string}) {
	return <h1>Hello {props.message}</h1>;
}

export {render, h, App2}
