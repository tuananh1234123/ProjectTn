package poly.controller.customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller()
public class ProductController {
	@RequestMapping("/product")
	public String homePage1(ModelMap model) {
		String keyProduct = "product";
		model.addAttribute("keyProduct", keyProduct);
		return "web/product";
	}
}
