package mypackage;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        CartService service = context.getBean(CartServiceImpl.class);

        service.addItemToCart(0, 1);
        service.addItemToCart(2, 1);
        service.addItemToCart(4, 3);
        service.addItemToCart(4, 2);
        service.removeItemFromCart(0);
        service.addItemToCart(2, 10);
        service.addItemToCart(3, 100);
        service.displayRecentActivity();

        System.out.printf("Total cart cost £%.2f, sales tax £%.2f, delivery charge £%.2f\n",
                service.calculateCartCost(),
                service.calculateSalesTax(),
                service.calculateDeliveryCharge());

        ShoppingSession shoppingSession = context.getBean(ShoppingSession.class);
        shoppingSession.displayStartDateTime();

        // Get profile-specific properties.
        ResourcesBean resourcesBean = context.getBean(ResourcesBean.class);
        System.out.println("Profile-specific properties: " + resourcesBean);
        
        ProductSuggestionRepository productRepo = context.getBean(ProductSuggestionRepository.class);
        productRepo.modifyPrice(2, 60);
//        System.out.println(productRepo.getProductSuggestions());

        ProductSuggestionCrudRepository pcr = context.getBean(ProductSuggestionCrudRepository.class);
        
        System.out.println("\nAll ProductSuggestion objects: ");
        for (ProductSuggestion ps : pcr.findAll()) {
        	System.out.println(ps);
        }
        
        List<ProductSuggestion> newProducts = List.of( 
        		new ProductSuggestion("Bicycle", 500, 5000),
        		new ProductSuggestion("Lamp", 5, 1000),
        		new ProductSuggestion("Window", 75, 600));
        
        int rowsModifyPrice = 0;
        for (ProductSuggestion newPs : newProducts) {
        	pcr.save(newPs);
        	long id = newPs.getId();
        	rowsModifyPrice += pcr.modifyRecommendedPrice(id, 50);
        	pcr.modifyAnnualSales(id, 100);
        	ProductSuggestion modifiedProduct = pcr.findById(id).get();
        	System.out.println("Modified id: " + id + ", result = " + modifiedProduct);
        	
            System.out.println("modifying price affected " + rowsModifyPrice + " rows");
        }

        int rowsIncrPrice = pcr.increasePrice(200L);
        System.out.println("increasing price affected " + rowsIncrPrice + " rows");
        for (ProductSuggestion ps : pcr.findAll()) {
        	System.out.println(ps);
        }
        
    }
}