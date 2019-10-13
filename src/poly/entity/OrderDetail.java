package poly.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERDETAIL")
public class OrderDetail {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int OrderDetailID;
	private int OrderID;
	private int PorductID;
	private float Price;
	private int Discount;
	public int getOrderDetailID() {
		return OrderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		OrderDetailID = orderDetailID;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getPorductID() {
		return PorductID;
	}
	public void setPorductID(int porductID) {
		PorductID = porductID;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	@JoinColumn(name="FK_ORDERDETAIL_PRODUCT")
	private Product product;
	public Product getProduct() 
	{
		return product;
	}
	public void setProduct(Product product) 
	{
		this.product=product;
	}
	@ManyToOne
	@JoinColumn(name="FK_ORDERDETAIL_ORDER")
	private Order order;
	public Order getOrder() 
	{
		return order;
	}
	public void setOrder(Order order) 
	{
		this.order=order;
	}
}
