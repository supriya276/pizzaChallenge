package com.sample.test.demo.testData;

public class TestDataNoToppingsPizza {
	public Object[] testData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Small 6 Slices - no toppings";
		data[0][1] = 2;
		data[0][2] = 6.75;

		data[1][0] = "Large 10 Slices - no toppings";
		data[1][1] = 2;
		data[1][2] = 11.75;
		return data;
	}

}
