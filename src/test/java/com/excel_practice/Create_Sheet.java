package com.excel_practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.math3.ode.MainStateJacobianProvider;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create_Sheet {
	public static void sheet_creation() throws IOException {
		File f = new File("C:\\Users\\Naveen\\Desktop\\userData.xlsx");
	    FileInputStream fis = new FileInputStream(f);
	    Workbook wb =new XSSFWorkbook(fis);
	    wb.createSheet("DATA").createRow(0).createCell(0).setCellValue("NAME");
	    wb.getSheet("DATA").getRow(0).createCell(1).setCellValue("EMAIL");
	    wb.getSheet("DATA").getRow(0).createCell(2).setCellValue("PASSWORD");
	    wb.getSheet("DATA").createRow(1).createCell(0).setCellValue("NAVEEN");
	    wb.getSheet("DATA").getRow(1).createCell(1).setCellValue("naveen@");
	    wb.getSheet("DATA").getRow(1).createCell(2).setCellValue("12345");
	      FileOutputStream fos=new FileOutputStream(f);
	    wb.write(fos);
	    wb.close();
	    System.out.println("succes");
	    
	   	}
	public static void main(String[] args) throws Throwable {
		sheet_creation();
		
	}
 
}
