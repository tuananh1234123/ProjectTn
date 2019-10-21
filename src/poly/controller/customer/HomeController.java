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

@Transactional
@Controller(value="HomeControllerOfWed")
public class HomeController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("/home")
	
	public String homePage2(ModelMap model) {
		Session session = factory.openSession();
		String hql = "SELECT COUNT(t1.product.ProductID) AS SLBan, t1.product.ProductID, t2.productName, t2.price, t2.photo"
				+ " FROM OrderDetail  t1"
				+ " INNER JOIN Product  t2 ON (t1.product.ProductID = t2.ProductID)"
				+ " GROUP BY t1.product.ProductID, t2.productName, t2.price, t2.photo"
				+ " ORDER BY SLBan DESC";
		Query query = session.createQuery(hql);
		List result = query.list();
		model.addAttribute("sp", result);
		System.out.println(result);
		
		session.close();
		return "web/home";
	}
}
