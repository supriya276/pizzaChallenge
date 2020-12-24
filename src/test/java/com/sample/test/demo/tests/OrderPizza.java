package com.sample.test.demo.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.automation.pages.PizzaOrderForm;
import com.sample.test.demo.testData.TestDataNoToppingsPizza;
import com.sample.test.demo.testData.TestDataOneToppings;
import com.sample.test.demo.testData.TestDataTwoToppings;

public class OrderPizza extends TestBase {

	// Scenario 1: Happy Path - No Toppings
	@Test(dataProvider = "noTopping")
	public void submitOrderWithoutToppings(String pizzaName, int quantity, double price) throws Exception {
		PizzaOrderForm form = new PizzaOrderForm();
		form.selectPizza(pizzaName);
		form.calculateCost(quantity, price);
		form.enterPickUpInformation("Supriya Kothamasu", "11111111114");
		form.selectPaymentInformation("CREDIT CARD");
		form.placeOrder();
	}

	// Scenario 2:Happy Path - One Topping
	@Test(dataProvider = "oneTopping")
	public void submitOrderWithOneToppings(String pizzaName, int quantity, double price, String topping1)
			throws Exception {
		PizzaOrderForm form = new PizzaOrderForm();
		form.selectPizza(pizzaName, topping1);
		form.calculateCost(quantity, price);
		form.enterPickUpInformation("Supriya Kothamasu", "11111111114");
		form.selectPaymentInformation("CASH");
		form.placeOrder();
	}

	// Scenario 3:Happy Path - Two Toppings
	@Test(dataProvider = "twoTopping")
	public void submitOrderWithTwoToppings(String pizzaName, int quantity, double price, String topping1,
			String topping2) throws Exception {
		PizzaOrderForm form = new PizzaOrderForm();
		form.selectPizza(pizzaName, topping1, topping2);
		form.calculateCost(quantity, price);
		form.enterPickUpInformation("Supriya Kothamasu", "testData@test.com", "11111111114");
		form.selectPaymentInformation("CREDIT CARD");
		form.placeOrder();
	}

	// Scenario 4:Happy Path - Reset data
	@Test
	public void resetOrder() throws Exception {
		PizzaOrderForm form = new PizzaOrderForm();
		form.selectPizza("Large 10 Slices - no toppings");
		form.calculateCost(1, 11.75);
		form.enterPickUpInformation("Supriya Kothamasu", "11111111114");
		form.selectPaymentInformation("CASH");
		form.resetOrder();
	}

	// Scenario 5:Error Case-Missing Name and Phone Number
	@Test
	public void errorCase() throws Exception {
		PizzaOrderForm form = new PizzaOrderForm();
		form.selectPizza("Large 10 Slices - no toppings");
		form.calculateCost(1, 11.75);
		form.selectPaymentInformation("CASH");
		form.placeOrderWithError();
	}

	@DataProvider(name = "noTopping")
	public Object[] testData() {
		TestDataNoToppingsPizza toppings = new TestDataNoToppingsPizza();
		return toppings.testData();
	}

	@DataProvider(name = "oneTopping")
	public Object[] testData1() {
		TestDataOneToppings toppings = new TestDataOneToppings();
		return toppings.testData();
	}

	@DataProvider(name = "twoTopping")
	public Object[] testData2() {
		TestDataTwoToppings toppings = new TestDataTwoToppings();
		return toppings.testData();
	}

}
