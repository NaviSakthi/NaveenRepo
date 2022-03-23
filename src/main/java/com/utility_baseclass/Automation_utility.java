package com.utility_baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Automation_utility {
	public static WebDriver driver;
	public static String value;

	// public static Select drp;
//BROWSER LANCH-------------------------------------------------------------------------------------
	public static WebDriver browser_launch(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "");

		} else if (type.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe");

		}
		driver.manage().window().maximize();
		return driver;
	}

//CLOSE AND QUIT------------------------------------------------------------------------------------
	public static void close_Quit(String type) {

		if (type.equalsIgnoreCase("close")) {
			driver.close();
		} else if (type.equalsIgnoreCase("quit")) {
			driver.quit();
		}
	}

//GET URL------------------------------------------------------------------------------------------
	public static void geturl(String url) {

		driver.get(url);

	}

//GET TITLE-----------------------------------------------------------------------------------------
	public static void get_title() {

		System.out.println(driver.getTitle());
	}

//CLICK---------------------------------------------------------------------------------------------
	public static void click(WebElement click) {

		click.click();

	}

//SEND KEYS----------------------------------------------------------------------------------------
	public static void send(WebElement send, String keys) {

		send.sendKeys(keys);
	}

//	public static Select select(WebElement ref,String f, String a1, String par) {
//		drp = new Select(ref);
//
//		if (f.equalsIgnoreCase("Index")) {
//		int index=Integer.parseInt(par);
//			drp.selectByIndex(index);
//
//		} else if (f.equalsIgnoreCase("value")) {
//			drp.selectByValue(a1);
//
//		} else if (f.equalsIgnoreCase("visibletext")) {
//			drp.selectByVisibleText(a1);
//
//		}
//		return drp;
//SELECT BY----------------------------------------------------------------------------------------
	public static void selectDropDown(WebElement ref, String type, String value) {

		Select select = new Select(ref);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);

			break;

		default:
			System.out.println("plese give the correct method");
			break;
		}

	}

//ALERT-------------------------------------------------------------------------------------------
	public static void alert(String click, String text) {

		Alert al = driver.switchTo().alert();
		if (click.equalsIgnoreCase("ok")) {
			al.accept();

		} else if (click.equalsIgnoreCase("cancel")) {
			al.dismiss();
		} else if (click.equalsIgnoreCase("text")) {
			al.sendKeys(text);
		} else {
			System.out.println("Pass the correct click values");
		}
	}

//NAVIGATE----------------------------------------------------------------------------------------
	public static void navigate(String method, String url) { 
		switch (method) {
		case "to":
			driver.navigate().to(url);

			break;
		case "back":
			driver.navigate().back();
			break;
		case "refresh":
			driver.navigate().refresh();
			break;
		case "forward":
			driver.navigate().forward();

		default:
			System.out.println("pass the correct method");
			break;
		}

	}

//FRAMES-----------------------------------------------------------------------------------------
	public static void frame(String type, String index, String idOrName) {

		if (type.equalsIgnoreCase("id")) {
			driver.switchTo().frame(idOrName);
		} else if (type.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt(index));

		}
	}

//DEFAULT CONTENT FRAMES--------------------------------------------------------------------------
	public static void oldWindow() {

		driver.switchTo().defaultContent();
	}

//ACTION-----------------------------------------------------------------------------------------
	public static void drag(String type, WebElement src, WebElement dist) {

		Actions s = new Actions(driver);
		if (type.equalsIgnoreCase("scroll")) {
			s.moveToElement(src);
		} else if (type.equalsIgnoreCase("dragAndDrop")) {
			s.dragAndDrop(src, dist).build().perform();

		}
	}
//SCREES SHOT---------------------------------------------------------------------------------------

	public static void screenshot(String type, String path) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + path);
		if (type.equalsIgnoreCase("utils")) {
			FileUtils.copyFile(src, target);
		} else if (type.equalsIgnoreCase("handler")) {
			org.openqa.selenium.io.FileHandler.copy(src, target);

		}

	}

	public static void implicitlyWait(int time,TimeUnit unit) {
	
		driver.manage().timeouts().implicitlyWait(time,unit);
  	}
	//excel_read_data--------------------------------------------------------------------------------------
	
	public static String Data(String path,int Rowindex,int CellIndex) throws IOException {
		File f = new File(path);
	    FileInputStream fis = new FileInputStream(f);
	    Workbook wb =new XSSFWorkbook(fis);
	    Sheet at = wb.getSheetAt(0);
	    Row row = at.getRow(Rowindex);
	    Cell cell = row.getCell(CellIndex);
	    CellType type = cell.getCellType();
	    if (type.equals(CellType.STRING)) {
	    	value=cell.getStringCellValue();
	    	
			
		} else if(type.equals(CellType.NUMERIC)) {
			double cellValue = cell.getNumericCellValue();
			int s =(int)cellValue;
			String string = Integer.toString(s);
			

		}
		return value;
	   

}

}
