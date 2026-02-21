import { render, h } from "preact";

function App(props: {message: string}) {
	return <h1>Hello {props.message}</h1>;
}

export {render, h, App}
