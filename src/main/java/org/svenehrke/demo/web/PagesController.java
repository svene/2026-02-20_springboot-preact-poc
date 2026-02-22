package org.svenehrke.demo.web;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

	private final SimpleViewComponent simpleViewComponent;

	public PagesController(SimpleViewComponent simpleViewComponent) {
		this.simpleViewComponent = simpleViewComponent;
	}

	@GetMapping("/")
	public String redirectRoot() {
		return "redirect:/ui/pages/page1";
	}

	@GetMapping("/ui/pages/page1")
	public String page1(Model model) {
		model.addAttribute("greetee", "You");
		return "pages/page1";
	}

	@GetMapping("/simple")
	ViewContext simple() {
		return simpleViewComponent.render();
	}

}
