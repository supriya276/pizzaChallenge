package com.sample.test.demo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.sample.test.demo.utilities.Utilities;
import com.sample.test.demo.TestBase;

public class PizzaOrderForm extends TestBase {

	private static final String pizza1 = "pizza1Pizza";
	private static final String pizza1Toppings1 = "//div[@id='pizza1']//select[@class='toppings1']";
	private static final String pizza1Toppings2 = "//div[@id='pizza1']//select[@class='toppings2']";
	private static final String pizza1Quantity = "pizza1Qty";
	private static final String pizza1Cost = "pizza1Cost";
	private static final String radioCreditCard = "ccpayment";
	private static final String radioCash = "cashpayment";
	private static final String email = "email";
	private static final String name = "name";
	private static final String phone = "phone";
	private static final String placeOrderButton = "placeOrder";
	private static final String resetButton = "reset";
	private static final String dialog = "dialog";
	private static final String dialogText = "//div[@id='dialog']/p";
	private static final String dialogTextMissingPhone = "//div[@id='dialog']/p/br";
	private static final String closeDialog = "//button[@title=\"Close\"]";

	@FindBy(id = pizza1)
	private WebElement pizza1DropDown;

	@FindBy(xpath = pizza1Toppings1)
	private WebElement pizzaToppingsDropDown1;

	@FindBy(xpath = pizza1Toppings2)
	private WebElement pizzaToppingsDropDown2;

	@FindBy(id = pizza1Quantity)
	private WebElement pizzaQuantity;

	@FindBy(id = pizza1Cost)
	private WebElement pizzaCost;

	@FindBy(id = radioCreditCard)
	private WebElement creditCardPayment;

	@FindBy(id = radioCash)
	private WebElement cashPayment;

	@FindBy(id = email)
	private WebElement customerEmail;

	@FindBy(id = phone)
	private WebElement customerPhone;

	@FindBy(id = name)
	private WebElement customerName;

	@FindBy(id = placeOrderButton)
	private WebElement placeOrder;

	@FindBy(id = resetButton)
	private WebElement resetOrder;

	@FindBy(id = dialog)
	private WebElement dialogError;

	@FindBy(xpath = dialogText)
	private WebElement dialogErrorText;

	/*
	 * Select a pizza without Toppings
	 */
	public void selectPizza(String pizzaName) {
		selectPizzaFromDropDown(pizzaName);
	}

	/*
	 * Select a pizza with one Toppings - Param : pizza name , toppings
	 */
	public void selectPizza(String pizzaName, String toppings1) {
		selectPizzaFromDropDown(pizzaName);
		selectToppings1FromDropDown(toppings1);
	}

	/*
	 * Select a pizza with Two Toppings - Param : pizza name , topping1,topping2
	 */

	public void selectPizza(String pizzaName, String toppings1, String toppings2) {
		selectPizzaFromDropDown(pizzaName);
		selectToppings1FromDropDown(toppings1);
		selectToppings2FromDropDown(toppings2);
	}

	/*
	 * method to calculate the cost of pizza param: Quantity price
	 */

	public void calculateCost(int quantity, double price) {
		driver.findElement(By.id(pizza1Quantity)).sendKeys(String.valueOf(quantity));
	}
	/*
	 * Method to Enter Pick UP Information param:Customar name ,Customer Phone
	 */

	public void enterPickUpInformation(String customerName, String customerPhone) {
		driver.findElement(By.id(name)).sendKeys(customerName);
		driver.findElement(By.id(phone)).sendKeys(customerPhone);
	}

	/*
	 * Method to Enter Pick UP Information param:Customar name ,Customer
	 * Email,Customer Phone
	 */
	public void enterPickUpInformation(String customerName, String customerEmail, String customerPhone) {
		driver.findElement(By.id(name)).sendKeys(customerName);
		driver.findElement(By.id(email)).sendKeys(customerEmail);
		driver.findElement(By.id(phone)).sendKeys(customerPhone);
	}
	/*
	 * Method to enter Payment Information Param :Payment Method
	 */

	public void selectPaymentInformation(String paymentMethod) {
		if (paymentMethod.toUpperCase() == "CASH") {
			driver.findElement(By.id(radioCash)).click();
		} else if (paymentMethod.toUpperCase() == "CREDIT CARD") {
			driver.findElement(By.id(radioCreditCard)).click();
		} else {
			System.out.println("Please select valid payment method");
		}
	}

	/*
	 * Method to Place Order
	 */
	public void placeOrder() {
		driver.findElement(By.id(placeOrderButton)).click();
		driver.findElement(By.xpath(closeDialog)).click();
	}
	/*
	 * Method to Place Order with Error
	 */

	public void placeOrderWithError() {
		driver.findElement(By.id(placeOrderButton)).click();

		String dailogTextMissingName = driver.findElement(By.xpath(dialogText)).getText();

		if (!dailogTextMissingName.contains("Missing name")) {
			Assert.fail("Missing name is not displayed");
		}

		driver.findElement(By.xpath(closeDialog)).click();
	}

	/*
	 * Method to Reset Order
	 */
	public void resetOrder() {
		driver.findElement(By.id(resetButton)).click();
	}

	/*
	 * Method to select Pizza from Dropdown Param: Pizza Name
	 */
	public void selectPizzaFromDropDown(String pizzaName) {
		WebElement pizzaDropDown = driver.findElement(By.id(pizza1));
		pizzaDropDown.click();
		Utilities.selectElement(pizzaDropDown, pizzaName);
	}

	/*
	 * Method to Select Toppings1 From DropDown param: toppings
	 */
	public void selectToppings1FromDropDown(String toppings) {
		WebElement toppings1DropDown = driver.findElement(By.xpath(pizza1Toppings1));
		toppings1DropDown.click();
		Utilities.selectElement(toppings1DropDown, toppings);
	}

	/*
	 * Method to select Toppings2 From DropDown Param: Toppings
	 */
	public void selectToppings2FromDropDown(String toppings) {
WebElement toppings2DropDown = driver.findElement(By.xpath(pizza1Toppings2));
		toppings2DropDown.click();
		Utilities.selectElement(toppings2DropDown, toppings);
	}

}

