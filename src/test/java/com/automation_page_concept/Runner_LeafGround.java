package com.automation_page_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import com.utility_baseclass.Automation_utility;

public class Runner_LeafGround extends Automation_utility {
	public static WebDriver driver;
	//public static Select drp;

	public static void main(String[] args) throws Throwable {
		driver = browser_launch("chrome");
//	    geturl("http://automationpractice.com/index.php");
//		get_title();
//		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
//		click(signIn);
//		WebElement email=driver.findElement(By.id("email"));
//		send(email, "navin123@gmail.com");
//		WebElement pass=driver.findElement(By.id("passwd"));
//		send(pass, "sakthive");
//		WebElement in=driver.findElement(By.id("SubmitLogin"));
//		click(in);
		geturl("http://leafground.com/");
		driver.navigate().to("http://leafground.com/pages/Dropdown.html");
		WebElement dr=driver.findElement(By.id("dropdown1"));
		selectDropDown(dr, "index", "2");
		//drp=select(dr, "index", "", "4");
		WebElement mul=driver.findElement(By.xpath("//select[@multiple]"));
		//drp=select(mul, "index", "", "2");
		selectDropDown(mul, "index", "3");
	    WebElement country=driver.findElement(By.xpath("//select[@multiple]"));
		selectDropDown(country, "index", "4");
		driver.navigate().back();
		WebElement al=driver.findElement(By.xpath("(//a[@class='wp-categories-link maxheight'])[9]"));
		click(al);
		WebElement butt=driver.findElement(By.xpath("//button[@onclick='normalAlert()']"));
		click(butt);
		alert("ok", "");
		navigate("back", "");
		WebElement frame=driver.findElement(By.xpath("(//a[@class='wp-categories-link maxheight'])[10]"));
		click(frame);
		frame("index", "0", "");
		WebElement click=driver.findElement(By.id("Click"));
		click(click);
		oldWindow();
		frame("index", "1", "");
		frame("id", "","frame2");
		WebElement frame1=driver.findElement(By.id("Click1"));
		click(frame1);
		navigate("back", "");
		Actions s=new Actions(driver);
		WebElement drag=driver.findElement(By.xpath("(//a[@class='wp-categories-link maxheight'])[14]"));
		//s.moveToElement(drag).build().perform();
		drag("scrowll", drag, null);;
		click(drag);
		WebElement dragable=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		drag("draganddrop", dragable, drop);
		navigate("back", "");
		//screenshot("utils", "\\screenshot\\image1.png");
		//screenshot("handler", "\\screenshot\\image2.png");
		close_Quit("quit");
		
		
		
		

	}

}
