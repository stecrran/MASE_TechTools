//package tus.string.calc;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class StringCalcTest {
//
//	StringCalc calc;
//
//	@BeforeEach
//	public void setUp() {
//		calc = new StringCalc();
//	}
//
//	@Test
//	public void testAddNumberZeroValue() {
//		assertEquals(0, calc.addNumber(""));
//	}
//
//	@Test
//	public void testAddNumberOneValue() {
//		String test = "5";
//		assertEquals(5, calc.addNumber(test));
//	}
//
//	@Test
//	public void testAddNumberTwoValue() {
//		String test = "5,7";
//		assertEquals(12, calc.addNumber(test));
//	}
//
//	@Test
//	public void testAddNumberwithNewLineValue() {
//		String test = "5,\n,7";
//		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//			calc.addNumber(test);
//		});
//		assertEquals("Double delimiter not allowed", exception.getMessage());
//	}
//
//}
