package com.sample.test.demo.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.test.demo.TestBase;

public class Utilities extends TestBase{
	
	public static void selectElement(WebElement element, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByValue(value);			
		} catch (Exception e){
			System.out.println("\" Select element \" log info message" + e.getMessage());
		}
	}

}
