import { render, h } from "preact";

function Child(props: {message: string}) {
	return <div style="border-style: solid; border-width: 1px; padding: 5px">
		<p>Child: {props.message}</p>
	</div>
}

export {render, h, Child}
