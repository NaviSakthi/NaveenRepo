package com.automation_page_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility_baseclass.Automation_utility;

public class WindowHandle extends Automation_utility {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = browser_launch("chrome");
		geturl("http://leafground.com/");

		WebElement window = driver.findElement(By.xpath
				("(//a[@class='wp-categories-link maxheight'])[11]"));
		click(window);
		WebElement multi =driver.findElement(By.xpath
				("//button[@onclick='openWindows()']"));
		click(multi);

	}

}
