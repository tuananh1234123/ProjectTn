package poly.controller.customer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Product;

@Transactional
@Controller(value="HomeControllerOfWed")
public class ViewProductController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("/home")
	public String homePage1(ModelMap model) {
		Session session= factory.openSession();
		String hql= "FROM Product";
		Query query= session.createQuery(hql);
		List<Product> list= query.list();
		model.addAttribute("sanpham", list);
		session.close();
		return "web/home";
	}
}
