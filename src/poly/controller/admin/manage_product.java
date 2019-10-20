
package poly.controller.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Product;

@Transactional
@Controller
@RequestMapping("/homeAdmin/product")

public class manage_product {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();	
		model.addAttribute("products", list);
		System.out.println(list.get(0).getPrice());
		return "admin/manage_product";
	}
}
