package mypackage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CartRepositoryImpl implements CartRepository {
	
	private Map<Integer, Integer> cartMap = new HashMap<Integer, Integer>();

	@Override
	public void add(int itemId, int quantity) {
		Integer existing = cartMap.get(itemId);
		if (existing != null) {
			quantity += existing;
		}
		cartMap.put(itemId, quantity);
	}

	@Override
	public void remove(int itemId) {
		cartMap.remove(itemId);
		
	}

	@Override
	public Map<Integer, Integer> getAll() {
		return cartMap;
	}

}
