package poly.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="HomeControllerOfWed")
public class HomeController {
	@RequestMapping("/home")
	public String homePage1() {
		
		return "web/home";
	}
}
