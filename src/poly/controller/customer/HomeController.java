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

import poly.entity.Order;
import poly.entity.Product;

@Transactional
@Controller(value="HomeControllerOfWed")
public class HomeController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("/home")
//	public String homePage1(ModelMap model) {
//		Session session = factory.openSession();
//		String hql = "FROM Product WHERE status = 1";
//		Query query = session.createQuery(hql);
//		List<Product> list = query.list();
//		model.addAttribute("sp", list);
//		session.close();
//		return "web/home";
//	}
	
	public String homePage2(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Order";
		Query query = session.createQuery(hql);
		List<Order> list = query.list();
		model.addAttribute("od", list);
		session.close();
		return "web/home";
	}
}
