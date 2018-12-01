package com.seleniumdemo.utis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

	public HashMap<String, HashMap<Integer, List<String>>> readexcel(String file, int sheetIndex) throws IOException
	{
		HashMap<String, HashMap<Integer, List<String>>> excelData = new HashMap<String, HashMap<Integer,List<String>>>();
		File f = new File(file);
		FileInputStream fis = new FileInputStream (f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);//can try to use sheet name having multiple sheet in excel
		XSSFRow row;
		XSSFCell col;
		Iterator<Row> rows = sheet.rowIterator();
		int rowId=1;
		HashMap<Integer, List<String>> rowData = new HashMap<Integer, List<String>>();
		while (rows.hasNext())
		{
			row = (XSSFRow)rows.next();
			Iterator cols = row.cellIterator(); 
			List<String> colData = new ArrayList<String>();
			while(cols.hasNext())
			{
				col = (XSSFCell)cols.next();
				String celValue = col.getStringCellValue();
				colData.add(celValue);
			}
			rowData.put(rowId, colData);
			rowId++;	
		}
		excelData.put(sheet.getSheetName(), rowData);
		return excelData;
	}

	public void write(String file) throws IOException
	{
		String sheetname = "Mydata";
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetname);
		//iterating no of rows how many want to add
		for (int i =0 ; i <2 ;i++)
		{
			XSSFRow row = sheet.createRow(i);
			//iterating for columns
			for (int c=0; c<5;c++)
			{
				XSSFCell cell = row.createCell(c);
				cell.setCellValue("BNP");

			}  
		}
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fos.flush();
		fos.close();
	} 
}
