package poly.entity;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderID;
	private int customerID;
	private int staffID;
	private Date orderDate;
	private int shipperID;
	private String description;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public int getStaffID() {
		return staffID;
	}


	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public int getShipperID() {
		return shipperID;
	}


	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy="Order", fetch = FetchType.LAZY)
	private Collection<OrderDetail> orderDetail;
	public Collection<OrderDetail> getOrderdetail()
	{
	return orderDetail;	
	}
	public void setOrderdetail(Collection<OrderDetail> orderDetail) 
	{
		this.orderDetail=orderDetail;
	}
	
	@ManyToOne
	@JoinColumn(name="FK_CUSTOMER")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToOne
	@JoinColumn(name="FK_SHIPPER")
	private Shipper shipper;

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	
}

