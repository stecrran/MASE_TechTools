package mypackage;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		CartService service = context.getBean(CartServiceImpl.class);
		
		service.printEmail();
		service.printSalesTaxRate();
		
		// Buy items (id, quantity)
		service.addItemToCart(1, 2);
		
		service.addItemToCart(0, 0);
		service.addItemToCart(0, 1);
		
		service.addItemToCart(2, 1);
		
		service.addItemToCart(4, 3);
		service.addItemToCart(4, 2);
		
		// remove an added item (id)
		service.removeItemFromCart(0);
		
		service.getAllItemsInCart();
		
		// display total cost
		double totalCost = service.calculateCartCost();
		System.out.printf("Total cart cost is €%.2f\n", totalCost);
		
		// display info about when the customer started shipping 
		ShoppingSession shoppingSession = context.getBean(ShoppingSession.class);
		shoppingSession.displayStartDateTime();		
		
	}
}
