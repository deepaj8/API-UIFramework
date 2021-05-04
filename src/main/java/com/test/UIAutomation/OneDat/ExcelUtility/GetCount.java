package com.test.UIAutomation.OneDat.ExcelUtility;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Field;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.test.UIAutomation.OneDat.TestBase.testBase;
import com.test.UIAutomation.OneDat.Utility.Constants;

public class GetCount extends testBase{
	public static Connection connection = null;
	
	public static final Connection makeFilloConnection(String fileName) {
		Fillo fillo=new Fillo();
		try {
			connection=fillo.getConnection(Constants.TESTDATA_PATH+fileName+".xlsx");
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//Return Rows Count but displays all the rows of first column
	public int getRowsCount(String fileName,String sheetName) throws FilloException {
	connection=makeFilloConnection(fileName);
	String query="Select * from "+ sheetName;
	Recordset recordset=connection.executeQuery(query);
	int numberOfRows=recordset.getCount();
	ArrayList<String>allColumns=recordset.getFieldNames();
	log.info("Number Of Rows "+numberOfRows);
	while(recordset.next()) {
	String colVal=allColumns.get(0);
	log.info("Row Values-"+recordset.getField(colVal));}
	recordset.close();
	connection.close();
	return numberOfRows;
	
	}
	
	
	//Returns Columns Count but displays all the column names i.e Headers
	public int getColumnsCount(String fileName,String sheetName) throws FilloException {
		connection=makeFilloConnection(fileName);
	String query="Select * from "+ sheetName;
	Recordset recordset=connection.executeQuery(query);
	ArrayList<String> allColumns=recordset.getFieldNames();
	log.info("[Column headers are]="+allColumns);
	int numberOfColumns=allColumns.size();
	log.info("Number Of Columns "+numberOfColumns);
	recordset.close();
	connection.close();
	return numberOfColumns;
	
	}
	
	
	public void getSheetNames(String fileName) {
	connection=makeFilloConnection(fileName);
	log.info("Sheet(s) present in file name '"+fileName+"' is/are---"+connection.getMetaData().getTableNames());
	
	connection.close();
	}	
	
	
	public void getSheetContents(String fileName,String sheetName) throws FilloException {
		connection=makeFilloConnection(fileName);
		String query="Select * from "+ sheetName;
		Recordset recordset=connection.executeQuery(query);
		System.out.println("Total Number Of Rows "+recordset.getCount());
		while(recordset.next()) {
		ArrayList<String> allColumns=recordset.getFieldNames();
		for(String column:allColumns) {
			System.out.print(recordset.getField(column)+" | ");
	}
		System.out.println();
		}
		recordset.close();
		connection.close();
	}
	
	public void executeUpdateQuery(String fileName,String query) throws FilloException {
		log.info(query);
	
		connection=makeFilloConnection(fileName);
		//String q1="Update TC_Data set Item='wxyz' where Rep='Smith'";
		connection.executeUpdate(query);
		connection.close();
	}
	

	public void updateQuery(String fileName,String query) throws FilloException {
		log.info(query);
		connection=makeFilloConnection(fileName);
		connection.executeUpdate(query);
		connection.close();
	}
	
	//execute the query and return set of values in sheet
	public Recordset exeQuery(String fileName,String query)throws FilloException{
		//log.info(query);
		connection=makeFilloConnection(fileName);
		Recordset res=connection.executeQuery(query);
		connection.close();
		return res;
	}
}
