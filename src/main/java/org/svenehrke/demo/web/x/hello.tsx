import { render, h } from "preact";

function App(props: {message: string}) {
	return <p>Hello {props.message}</p>;
}

export {render, h, App}
