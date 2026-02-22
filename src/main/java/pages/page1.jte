@param boolean devMode
@param String greetee
@param String jjj

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
	@if(devMode)
		<script src="http://localhost:35729/livereload.js"></script>
	@endif
	<script src="/assets/js/mount.js" type="module"></script>
</head>
<body>
<h1>Page 1</h1>

<p>Hey ${greetee} ${jjj}</p>

<hr>
<h1>Literal Parameter</h1>
<div data-island="x/hello" data-props='{"message": "World!"}'></div>
<hr>
<h1>Parameter from Spring-Model</h1>
<div data-island="x/hello" data-props="${jjj}"></div>
<hr>
<h1>Component tree (parent and child)</h1>
<div data-island="x/parent" data-props="${jjj}"></div>
<hr>
</body>
</html>
