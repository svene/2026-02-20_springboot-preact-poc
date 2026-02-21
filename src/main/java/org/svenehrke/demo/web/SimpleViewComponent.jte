@import org.svenehrke.demo.web.SimpleViewComponent.Ctx
@param Ctx ctx

<head>
	<meta charset="UTF-8">
	<title>SimpleViewComponent</title>
	@if(ctx.devMode())
		<script src="http://localhost:35729/livereload.js"></script>
	@endif
</head>
<body>
<h3>SimpleViewComponent</h3>

<div>${ctx.helloWorld()}</div>

<div id="hello"></div>
<script type="module">
	import { mountHello } from "/assets/fe/x/hello.js";
	mountHello("hello", "sven");
</script>
</body>
