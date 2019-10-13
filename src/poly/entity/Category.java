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
@Table(name = "Category")
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	private String categoryName;
	private String description;
	
	@OneToMany(mappedBy="Category", fetch = FetchType.LAZY)
	private Collection<Product> product;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCategoryid() {
		return categoryID;
	}
	public void setCategoryid(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String photo;
	
	public Collection<Product> getProduct()
	{
		return product;
	}
	public void  setProduct(Collection<Product> product) {
		this.product=product;
	}
}
