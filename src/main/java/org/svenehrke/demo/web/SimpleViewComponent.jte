@import org.svenehrke.demo.web.SimpleViewComponent.Ctx
@param Ctx ctx

<head>
	<meta charset="UTF-8">
	<title>SimpleViewComponent</title>
	@if(ctx.devMode())
		<script src="http://localhost:35729/livereload.js"></script>
	@endif
	<script src="/assets/js/mount.js" type="module"></script>
</head>
<body>
<hr>
<h3>JTE: SimpleViewComponent</h3>
<div>${ctx.helloWorld()}</div>

<hr>
<h3>Island</h3>
<div data-island="x/hello" data-props='{"message": "World!"}'></div>

</body>
