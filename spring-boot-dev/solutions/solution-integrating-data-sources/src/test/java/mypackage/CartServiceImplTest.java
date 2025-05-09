package mypackage;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CartServiceImplTest {

	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@MockBean
	private CartRepository cartRepo;
	
	
	@Test
	void addItemToCart_itemAdded() {
		cartServiceImpl.addItemToCart(0, 1000);
		verify(cartRepo).add(eq(0),eq(1000));
	}
	
	@Test
	void addUnknownItemToCart_noAction() {
		cartServiceImpl.addItemToCart(5, 1000);
		verify(cartRepo, times(0)).add(anyInt(), anyInt());
	}
}
