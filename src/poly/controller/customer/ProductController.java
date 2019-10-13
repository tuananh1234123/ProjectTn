package poly.controller.customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller()
public class ProductController {
	@RequestMapping("/product")
	public String homePage1() {
		return "web/product";
	}
}
