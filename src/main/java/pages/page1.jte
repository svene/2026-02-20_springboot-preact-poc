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

<div data-island="x/hello" data-props='{"message": "World!"}'></div>
<div data-island="x/hello" data-props="${jjj}"></div>

<a href="/simple">Simple Component</a>
</body>
</html>
