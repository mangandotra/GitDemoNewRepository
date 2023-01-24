package com.java.excelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPractice1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis= new FileInputStream("C:\\Users\\nipun\\OneDrive\\Documents\\ExcelSeleniumPractice.xlsx");
		XSSFWorkbook wb1=new XSSFWorkbook(fis);
		int sheets=wb1.getNumberOfSheets();
		System.out.println("Total number of sheets="+sheets);
		
		for(int i=0;i<sheets;i++) {
			
			if(wb1.getSheetName(i).equalsIgnoreCase("PracticeSheet1")) {
				XSSFSheet sheet=wb1.getSheetAt(i);
				System.out.println("PracticeSheet1 accessed");
				
				Iterator<Row> rows=sheet.rowIterator();
				Row firstRow=rows.next();
				
				Iterator<Cell> ce=firstRow.cellIterator();
				
				int column=0;
				int k = 0;
				
				while(ce.hasNext()) {
					Cell value=ce.next();
					System.out.println("while loop entered");
					if(value.getStringCellValue().equalsIgnoreCase("city")) {
						System.out.println("Desired cell: "+value);
						
						column=k;
						
					}
					k++;
				}
				System.out.println("column is "+column);
				
				
				while(rows.hasNext()) {
					Row r =rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("goa")) {
						System.out.println("goa");
					}
				}
				
			}
			
		}

	}

}
