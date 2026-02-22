import { render, h } from "preact";
import {Child} from "./child";

function App(props: {message: string}) {
	return (
		<>
		<div style="border-style: solid; border-width: 1px; padding: 5px">
			<p>Parent: {props.message}</p>
		<Child message={props.message}></Child>
		</div>
		</>);

}

export {render, h, App}
