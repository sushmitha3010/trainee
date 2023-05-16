package streampractice;

public class Customer {

	//parameters
	Long id;
	String name;
	Integer tier;
	
	//default constructor
	public Customer() {
		
	}
     
	//parameterized constructor
	public Customer(Long id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
    
	//To generate getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	//to generate toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
	
	

}
