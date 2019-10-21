package poly.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Customer;


@Transactional
@Controller(value = "HomeControllerOfWed")
public class HomeController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("/home")

	public String homePage2(ModelMap model) {
		Session session = factory.openSession();
		String hql = "SELECT COUNT(t1.product.ProductID) AS SLBan, t1.product.ProductID, t2.productName, t2.price, t2.photo"
				+ " FROM OrderDetail  t1"
				+ " INNER JOIN Product  t2 ON (t1.product.ProductID = t2.ProductID)"
		Query query = session.createQuery(hql);
		List result = query.list();
		model.addAttribute("sp", result);
		System.out.println(result);

		session.close();
		return "web/home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {

		ModelAndView mav = new ModelAndView("web/register");
		mav.addObject("Customer", new Customer());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("Customer") Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			customer.setStatus(1);
			session.save(customer);
			t.commit();
			model.addAttribute("message", "Tạo tài khoản thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Tạo tài khoản thất bại !");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "web/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView mav = new ModelAndView("web/login");
		mav.addObject("Customer", new Customer());
		return mav;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("Customer") Customer dn, ModelMap mm) {
		Customer customer = login(dn.getEmail(), dn.getPassword());
		if (customer != null) {
			HttpSession session = request.getSession();
			session.setAttribute("Customer", customer);
			return "web/home";
		} else {
			mm.put("message", "Incorrect id or password!");
			return "login.php";
		}
	}

	public Customer login(String email, String password) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer where email = :email and password = :password");
			query.setString("email", email);
			query.setString("password", password);
			Customer nv = (Customer) query.uniqueResult();
			transaction.commit();
			return nv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
