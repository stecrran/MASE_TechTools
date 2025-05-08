package mypackage;

import java.util.Map;

public interface CartService {
	void printEmail();
	void printSalesTaxRate();
    void addItemToCart(int id, int quantity);
    void removeItemFromCart(int id);
    Map<Integer, Integer> getAllItemsInCart();
    double calculateCartCost();
}
