package mypackage;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private Catalog catalog;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Value("${contactEmail}")
	private String contactEmail;
	
	@Value("${onlineRetailer.salesTaxRate}")
	private double salesTax;
	
	public void printSalesTaxRate() {
		System.out.printf("Sales Tax = %.0f%%\n", salesTax*100);
	}
	
	public void printEmail() {
		System.out.println("Email: " + contactEmail);
	}


	@Override
	public void addItemToCart(int id, int quantity) {
		Item item = catalog.getItemById(id);
		if (item != null) {
			cartRepository.add(id, quantity);
		}
	}

	@Override
	public void removeItemFromCart(int id) {
		cartRepository.remove(id);
		
	}

	@Override
	public Map<Integer, Integer> getAllItemsInCart() {
		Map<Integer, Integer> items = cartRepository.getAll();
		
		for (Integer id : items.keySet()) {
			Item item = catalog.getItemById(id);
			System.out.println("id:" + id + ", Quantity: " + cartRepository.getAll().get(id) + ", Price: " + item.getPrice());
		}
		return cartRepository.getAll();
	}

	@Override
	public double calculateCartCost() {
		Map<Integer, Integer> items = cartRepository.getAll();
		double total = 0.0;
		for (var entry : items.entrySet()) {
			int id = entry.getKey();
			int quantity = entry.getValue();
			double itemCost = catalog.getItemById(id).getPrice() * quantity;
			total += itemCost;
		}
		return total;
	}

}
