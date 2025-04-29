package tus.string.calc;

public class StringCalc {

	public int addNumber(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		int sum = 0;
		char[] chars = numbers.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			
			if (chars[i] == ',' && chars[i + 1] != '\\') {
				throw new IllegalArgumentException("Double delimiter not allowed");

			} else {
				if (chars[i] == ',') {
					continue;
				}
				sum += Integer.parseInt(String.valueOf(chars[i]));
			}
		}

		return sum;
	}
}
