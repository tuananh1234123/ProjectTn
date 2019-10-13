package poly.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;
import java.util.Date;;

@Entity
@Table(name = "IMPORTCOUPON")
public class ImportCoupon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int importCouponID;
	private int staffID;
	private Date importDate;
	private String Description;
	
	public ImportCoupon() {
		super();
	}
	public int getImportCouponID() {
		return importCouponID;
	}
	public void setImportCouponID(int importCouponID) {
		this.importCouponID = importCouponID;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@OneToMany(mappedBy="ImportCoupon", fetch = FetchType.LAZY)
	private Collection<Icdetail> iCDetail;
	
	@ManyToOne
	@JoinColumn(name="FK_STAFF")
	private Staff staff;

	public Collection<Icdetail> getiCDetail() {
		return iCDetail;
	}
	public void setiCDetail(Collection<Icdetail> iCDetail) {
		this.iCDetail = iCDetail;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
