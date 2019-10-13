package poly.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPER")
public class Shipper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shipperID;
	private String shipperName;
	private String companyName;
	private String phone;
	
	public Shipper() {
		super();
	}
	public int getShipperID() {
		return shipperID;
	}
	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@OneToMany(mappedBy="Shipper", fetch = FetchType.LAZY)
	private Collection<Order> order;
	
	public Collection<Order> getOrder() {
		return order;
	}
	public void setOrder(Collection<Order> order) {
		this.order = order;
	}
}
