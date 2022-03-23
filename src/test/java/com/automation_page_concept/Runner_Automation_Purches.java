package com.automation_page_concept;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import com.automation_pom.Payment;
import com.automation_pom.Proceed;
import com.automation_pom.Signin_Page;
import com.automation_pom.T_Shirt;
import com.automation_pom.T_Shirt_Selection;
import com.automation_pom.login_page;
import com.page_object_manager.Object_Store;
import com.utility_baseclass.Automation_utility;

public class Runner_Automation_Purches extends Automation_utility {
	public static WebDriver driver = browser_launch("chrome");
	public static Object_Store obj = new Object_Store(driver);

	public static Logger log = Logger.getLogger(Runner_Automation_Purches.class);

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		geturl("http://automationpractice.com/index.php");
		implicitlyWait(5, TimeUnit.SECONDS);
		
		//BasicConfigurator.configure();


		click(obj.getLogin().getsignin());
		
		

		send(obj.getText().getEmail(),
				Data("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\Automation_TestCase.xlsx", 2, 5));
		send(obj.getText().getPass(),
				Data("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\Automation_TestCase.xlsx", 8, 5));
		click(obj.getText().getSub());
		log.info("info");
		log.fatal("Fatal");
		log.error("Error");
		log.warn("Warning");
		System.exit(0);
		

		click(obj.getTs().gettShirt());

		click(obj.gettShirt().getsize());
		selectDropDown(obj.gettShirt().getDrp1(), "index", "4");
		
		

		click(obj.gettShirt().getPic());
		click(obj.gettShirt().getQuantity());
		 click(obj.gettShirt().getQuantity());
		click(obj.gettShirt().getAdToCart());
		
		

		click(obj.getClick().getPro());
		click(obj.getClick().getPro1());
		click(obj.getClick().getPro2());
		click(obj.getClick().getCheck());
		click(obj.getClick().getPro3());
		
	

		click(obj.getPay().getPay());
		click(obj.getPay().getCon());
		click(obj.getPay().getCon1());

	}

}
