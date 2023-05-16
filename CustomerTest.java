package streamtest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import streampractice.Customer;
import streampractice.Order;
import streampractice.Product;

public class CustomerTest {
	public static void main(String[] args) {
          Customer customer=new Customer();
		List<Customer> customerList = new ArrayList<Customer>();

		// adding products
		customerList.add(new Customer(1234567890l, "Sugumar", 1));
		customerList.add(new Customer(1234567891l, "Vitheesh", 2));
		customerList.add(new Customer(1234567892l, "Arivu", 3));
		customerList.add(new Customer(1234567893l, "Raja", 4));

        //adding product Book details
        List <Product>productList=new ArrayList<Product>();
        productList.add(new Product(3000000l,"Jane Eyre","Books",10000d));
        productList.add(new Product(3000001l,"Invisible Man","Books",12000d));
        productList.add(new Product(3000002l,"Great Expectations","Books",20000d));
        productList.add(new Product(3000003l,"Beloved","Books",300d));
        productList.add(new Product(3000004l,"Make it Unique","Books",70d));
        productList.add(new Product(3000005l,"Keep it Simple","Books",2400d));
        
        //adding product Toys details
        productList.add(new Product(00001l,"Barbie","Toys",700d));
        productList.add(new Product(00002l,"Doll","Toys",500d));
        productList.add(new Product(00003l,"Lego","Toys",400d));
        productList.add(new Product(00004l,"Puzzle","Toys",300d));
        productList.add(new Product(00005l,"Yo-Yo","Toys",200d));
        productList.add(new Product(00006l,"Teddy Bear","Toys",100d));
           
        //adding Product Baby details
        productList.add(new Product(101l,"Baby sleepers ","Baby",100d));
        productList.add(new Product(102l,"Baby socks","Baby",200d));
        productList.add(new Product(103l,"Disposable diapers","Baby",300d));
        productList.add(new Product(104l,"Disposable wipes","Baby",400d));
        productList.add(new Product(104l,"Socks","Baby",500d));
        
        //Adding Order Details
        List <Order>orderList=new ArrayList<Order>();
        orderList.add(new Order(100001l,"Shipped",LocalDate.of(2021, 03, 15),LocalDate.of(2001, 01, 05),productList,customer));
        orderList.add(new Order(100002l,"Pending",LocalDate.of(2021, 03, 14),LocalDate.of(2001, 02, 14),productList,customer));
        orderList.add(new Order(100003l,"Shipped",LocalDate.of(2021, 2, 1),LocalDate.of(2001, 03, 21),productList,customer));
        orderList.add(new Order(100004l,"Pending",LocalDate.of(2023, 03, 20),LocalDate.of(2001, 04, 23),productList,customer));
        orderList.add(new Order(100005l,"Deliverd",LocalDate.of(2023, 02, 25),LocalDate.of(2001, 05, 25),productList,customer));
        orderList.add(new Order(100006l,"Deliverd",LocalDate.of(2023, 01, 13),LocalDate.of(2001, 06, 23),productList,customer));
        
        //1). Obtain a list of products belongs to category “Books” with price > 100
        List<Product> expensiveBooks = productList.stream()
            .filter(product -> product.getProductCategory().equals("Books"))
            .filter(product -> product.getPrice() > 100)
            .collect(Collectors.toList());
        System.out.println("Books:"+expensiveBooks);
        
        //or
        List<Boolean> booklist = productList.stream()
            .filter(products -> products.getProductCategory().equalsIgnoreCase("Books"))
            .map(products -> products.getPrice() > 100)
            .collect(Collectors.toList());    
        System.out.println("Books:"+booklist);
             
        //2). Obtain a list of order with products belong to category “baby”
        List<Product> babyOrders = productList.stream()
                .filter(baby -> baby.getProductCategory().equals("Baby"))
                .collect(Collectors.toList());
        System.out.println("Baby:"+babyOrders);
        
        //3). Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> productDiscount = productList.stream()
        		.filter(discount -> discount.getProductCategory().equals("Toys"))
        		.peek(discount -> discount.setPrice(discount.getPrice() * 0.9))
        		.collect(Collectors.toList());
        System.out.println("Product Discount:"+productDiscount);

        //4). Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021		
        List<Product> orderedProducts = orderList.stream()
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2023, 1, 31)) &&
                                 order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2)))
                .filter(order -> order.getOrderId() == customer.getId() &&
                                 customer.getTier() == 2)
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println("Order By Customer Tier:"+orderedProducts);
        
        //5.Get the cheapest products of “Books” category    
         Optional<Product> cheapestBook = productList
                    .stream()
                    .filter(p -> p.getProductCategory().equalsIgnoreCase("Books"))
                    .sorted(Comparator.comparing(Product::getPrice))
                    .findFirst();
          System.out.println("Cheapest Book:"+cheapestBook);
            
          //6.Get the 3 most recent placed order    
          List<Order> recent = orderList
                    .stream()
                    .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                    .limit(3)
                    .collect(Collectors.toList());
           System.out.println("Recent Order:"+recent);
        
          //7). Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
          List<Order> filteredOrders = orderList.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.parse("15-03-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .peek(order -> System.out.println("Order ID: " + order.getOrderId() + ", Products: " + order.getStatus()))
                .collect(Collectors.toList());
          System.out.println("Filtered Orders:"+filteredOrders);
       
          //8). Calculate total lump sum of all orders placed in Feb 2021 
          Double sum = orderList
                .stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();      
          System.out.println("sum of all orders:"+sum);
       
          //9). Calculate order average payment placed on 14-Mar-2021
          OptionalDouble averageList = orderList
                .stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .average();      
          System.out.println("Calculate order average payment:"+averageList);
        
          //10). Obtain a data map with order id and order’s product count
          Map<Long, Object>  count = orderList.stream()
                .collect(Collectors.toMap(
                        order -> order.getOrderId(),
                        order -> order.getProducts().size()
                        )
                    );
          System.out.println("Product Count:"+count);
                      
          //11). Get the most expensive product by category
          Map<String, Product> mostExpensiveByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getProductCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                Optional::get
                        )
                ));
        
          System.out.println("Expensive Category:"+mostExpensiveByCategory);
     
	}
}
