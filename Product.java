package streampractice;

public class Product {
	
	//parameters
	Long productId;
	String productName;
	String productCategory;
	Double price;
	
	//default constructor
	public Product() {
		
	}

	//parameterized constructor
	public Product(Long productId, String productName, String productCategory, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}

	//to generate getters and setters
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	//to generate toString
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", price=" + price + "]";
	}
	
	
	

}
