package com.test.UIAutomation.OneDat.ExcelUtility;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.test.UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.Constants;

public class ExcelReader extends testBase {
	public static Connection connection = null;
	
	// Take input-filename,sheetname and testcase name and set path and make a connection to Fillo and call a method
	// which extracts data from cell
	public Object[][] getData(String fileName,String SheetName, String testcaseName) {
		Object[][] data=null;
		
		log.info("Excel File Name is---" + fileName);
		 connection = GetCount.makeFilloConnection(fileName);
			try {
				data = getDataFromCell(SheetName, testcaseName);
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return data;
		
	}	
	
//get data from all the columns based on row number	
	public HashMap<String,String> getDataFromRow(String fileName,String sheetName,int testcaseid ) throws FilloException
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		GetCount.makeFilloConnection(fileName);
		String query="select * from "+sheetName+" where testcaseid="+testcaseid+"";
		GetCount gc=new GetCount();
		int columns=gc.getColumnsCount(fileName, sheetName);
		Recordset rs=gc.exeQuery(fileName,query);
		rs.moveNext();
		for(int i=0;i<columns;i++)
		{
			
			hm.put(rs.getFieldNames().get(i),rs.getField(rs.getFieldNames().get(i)));
		}
		rs.close();
		return hm;
	}

	
/*	public Object[][] getDataFromCell(String sheetName, String testcaseName) throws FilloException {
		log.info("Sheet Name is---" + sheetName);
		log.info("TestCase Name is---" + testcaseName);
		
		String query = "Select * from " + sheetName+" where TestCase= '"+testcaseName+"'";
		log.info(query);
		Recordset recordset = connection.executeQuery(query);
		int numberOfRows = recordset.getCount();
		log.info("Number Of Rows in a " + sheetName + " Sheet is---" + numberOfRows);
		ArrayList<String> columnNames = recordset.getFieldNames();
		int numberOfColumns = columnNames.size();
		log.info("Number Of Columns in a " + sheetName + " Sheet is---" + numberOfColumns);
		Object[][] dataSets = new String[numberOfRows][numberOfColumns-2];
		recordset.next();
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 2; j < numberOfColumns; j++) {
				String colName = columnNames.get(j);
				String colVal = recordset.getField(j).value();
				dataSets[i][j-2]=recordset.getField(j).value();
				log.info(colName);
				log.info(colVal);

			}
			recordset.next();
		}

		connection.close();
		return dataSets;
	}
*/
	
	public Object[][] getDataFromCell(String sheetName, String testcaseName) throws FilloException{
		HashMap<String, String> map;		  
		
		log.info("Sheet Name is---" + sheetName);
		log.info("TestCase Name is---" + testcaseName);
		
		String query = "Select * from " + sheetName+" where TestCase='"+testcaseName+"' and Run='Y'";
		log.info(query);
		Recordset recordset = connection.executeQuery(query);
		int numberOfRows = recordset.getCount();
		log.info("Number Of Rows in a " + sheetName + " Sheet is---" + numberOfRows);
		  Object[][] data = new Object[numberOfRows][1];
		  
		  int rowIndex = 0;
		  
		  while (recordset.next()) {
		   map = new HashMap<String,String>(); //creating a Hashmap
		   for (String strColumn : recordset.getFieldNames()) {
	// putting table header (column name) and corresponding data in hash map as key value pair
        map.put(strColumn, recordset.getField(strColumn.toString()));
		                    		   }
		   data[rowIndex][0] = map; // putting hash map into Object array
		   rowIndex++;
		  }

		  recordset.close();
		  connection.close();
		  return data;
	
	}
	
		
	
}
