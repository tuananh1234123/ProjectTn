package poly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Icdetail")
public class Icdetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iCDetailID;
	private int importCouponID;
	private int productID;
	private int quantity;
	private Float price;
	
	public Icdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getiCDetailID() {
		return iCDetailID;
	}
	public void setiCDetailID(int iCDetailID) {
		this.iCDetailID = iCDetailID;
	}
	public int getImportCouponID() {
		return importCouponID;
	}
	public void setImportCouponID(int importCouponID) {
		this.importCouponID = importCouponID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	@ManyToOne
	@JoinColumn(name="FK_ICDETAIL_IMPORTCOUPON")
	private ImportCoupon importCoupon;
	public ImportCoupon getImportcoupon() {
		return importCoupon;
	}
	public void setImportcoupon(ImportCoupon importCoupon) 
	{
		this.importCoupon=importCoupon;
	}
	
	@ManyToOne
	@JoinColumn(name="FK_ICDETAIL_PRODUCT1")
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) 
	{
		this.product=product;
	}
}
