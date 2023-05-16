package streampractice;

import java.time.LocalDate;
import java.util.List;

public class Order {
	
	//parameters
	Long orderId;
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Product>products;
	Customer customer;
	//default constructor
	public Order() {
		
	}

	//parameterized constructor
	public Order(Long orderId, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}

	

	//to generate getters and setters
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	//to generate toString
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + ", products=" + products + ", customer=" + customer + "]";
	}
	
	
}
