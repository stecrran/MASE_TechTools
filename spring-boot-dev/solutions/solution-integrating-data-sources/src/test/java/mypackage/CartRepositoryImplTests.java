package mypackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;


public class CartRepositoryImplTests {
	
	CartRepositoryImpl cartRepo;
	
	@BeforeEach
	public void setup() {
		cartRepo = new CartRepositoryImpl();
	}
	
	@Test
	void cart_emptyInitially() {
		assertEquals(0, cartRepo.getAll().size());
	}

	@Test
	void addItems_itemsAdded() {
		cartRepo.add(1, 50);
		cartRepo.add(2, 100);
		cartRepo.add(3, 200);
//		int i = 1;
//		for (Entry<Integer, Integer> entry : cartRepo.getAll().entrySet()) {
//			assertEquals(i, entry.getKey());
//			i++;
//		}
//		int j = 50;
//		for (Entry<Integer, Integer> entry : cartRepo.getAll().entrySet()) {
//			assertEquals(j, entry.getValue());
//			j = j*2;
//		}
		Map<Integer, Integer> test = cartRepo.getAll();
		assertEquals(50, test.get(1));
		assertEquals(100, test.get(2));
		assertEquals(200, test.get(3));
		
		assertEquals(3, cartRepo.getAll().size());
	}

	@Test
	void addSameItem_countIncremented() {
		cartRepo.add(1, 50);
		cartRepo.add(2, 100);
		cartRepo.add(3, 200);
		cartRepo.add(1, 50);
		cartRepo.add(2, 100);
		cartRepo.add(3, 200);
		cartRepo.add(1, 50);
		cartRepo.add(2, 100);
		cartRepo.add(3, 200);
		assertEquals(3, cartRepo.getAll().size());
		assertEquals(150, cartRepo.getAll().get(1));
		assertEquals(300, cartRepo.getAll().get(2));
		assertEquals(600, cartRepo.getAll().get(3));
	}

	@Test
	void removeItem_itemRemoved() {
		cartRepo.add(1, 50);
		cartRepo.add(2, 100);
		cartRepo.add(3, 200);
		
		cartRepo.remove(2);
		assertEquals(2, cartRepo.getAll().size());
		assertEquals(null, cartRepo.getAll().get(2));
		assertEquals(50, cartRepo.getAll().get(1));
		assertEquals(200, cartRepo.getAll().get(3));
		
	}
}
