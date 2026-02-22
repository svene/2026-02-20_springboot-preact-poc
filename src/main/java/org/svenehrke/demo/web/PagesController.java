package org.svenehrke.demo.web;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tools.jackson.databind.ObjectMapper;

@Controller
public class PagesController {

	private final SimpleViewComponent simpleViewComponent;
	private final ObjectMapper objectMapper;
	public PagesController(
		SimpleViewComponent simpleViewComponent,
		ObjectMapper objectMapper
	) {
		this.simpleViewComponent = simpleViewComponent;
		this.objectMapper = objectMapper;
	}

	@GetMapping("/")
	public String redirectRoot() {
		return "redirect:/ui/pages/page1";
	}

	@GetMapping("/ui/pages/page1")
	public String page1(Model model) {
		model.addAttribute("greetee", "You");
		record JJJ(String message){};
		model.addAttribute("jjj", objectMapper.writeValueAsString(
			new JJJ("myJJJ")
		));
		return "pages/page1";
	}

	@GetMapping("/simple")
	ViewContext simple() {
		return simpleViewComponent.render();
	}

}
