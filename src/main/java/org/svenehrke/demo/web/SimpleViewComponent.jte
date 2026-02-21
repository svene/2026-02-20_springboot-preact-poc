@import org.svenehrke.demo.web.SimpleViewComponent.Ctx
@param Ctx ctx

<h3>SimpleViewComponent</h3>

<div>${ctx.helloWorld()}</div>

<div id="hello"></div>
<script type="module">
	import { mountHello } from "/assets/fe/x/hello.js";
	mountHello("hello", "sven");
</script>
