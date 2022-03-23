package com.excel_practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.collections4.trie.PatriciaTrie;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data {
	public static void Particular_cell_data() throws IOException {
		File f = new File("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\userData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(1);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		if (cellType.equals(cellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);

		} else if (cellType.equals(cellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			System.out.println(numericCellValue);
		}
		wb.close();
	}

	public static void All_Data() throws IOException {
		File f = new File("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\userData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheetAt(0);
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {

			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {

				Cell c = r.getCell(j);
				CellType type = c.getCellType();

				if (type.equals(CellType.STRING)) {

					String value = c.getStringCellValue();

					System.out.println(value);
				} else if (type.equals(CellType.NUMERIC)) {

					double numericCellValue = c.getNumericCellValue();

					int v = (int) numericCellValue;

					String value = Integer.toString(v);

					System.out.println(value);
				}
				wb.close();
			}
		}
	}

	public static void Read_Particulr_row() throws IOException {

		File f = new File("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\userData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheetAt(0);
		Row r = s.getRow(2);
		int numberOfCells = r.getPhysicalNumberOfCells();
		for (int i = 0; i < numberOfCells; i++) {

			Cell c = r.getCell(i);
			CellType type = c.getCellType();

			if (type.equals(CellType.STRING)) {

				String value = c.getStringCellValue();

				System.out.println(value);

			} else if (type.equals(CellType.NUMERIC)) {

				double numericCellValue = c.getNumericCellValue();

				int v = (int) numericCellValue;

				String value = Integer.toString(v);

				System.out.println(value);
			}
		}
		wb.close();
	}

	public static void Read_Particular_Column() throws IOException {

		File f = new File("C:\\Users\\Naveen\\Desktop\\SELINIUM\\com.maven\\march22_pb\\userData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheetAt(0);
		int norows = s.getPhysicalNumberOfRows();
		for (int i = 0; i < norows; i++) {
			Row row = s.getRow(i);
			Cell cell = row.getCell(1);
			CellType type = cell.getCellType();
			if (type.equals(CellType.STRING)) {
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);

			} else if (type.equals(CellType.NUMERIC)) {
				double value = cell.getNumericCellValue();
				int v = (int) value;
				String string = Integer.toString(v);
				System.out.println(string);
			}
		}
		wb.close();

	}

	public static void main(String[] args) throws Throwable {
		System.out.println("PARTICULAR CELL");
		Particular_cell_data();

		All_Data();

		Read_Particulr_row();
		Read_Particular_Column(); 

	}

}
