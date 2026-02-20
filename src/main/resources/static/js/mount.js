document.querySelectorAll("[data-island]").forEach(async (el) => {
	const name = el.dataset.island;
	const props = JSON.parse(el.dataset.props || "{}");

	try {
		const {default: Component, render, h} = await import(`/js/islands/${name}.js`);
		el.innerHTML = "";
		render(h(Component, props), el);
	} catch (err) {
		console.error(`Failed to mount island "${name}":`, err);
		el.innerHTML = '<div class="alert alert-error">Component could not be loaded.</div>';
	}
});
