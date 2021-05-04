package com.test.UIAutomation.OneDat.ExcelUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class ExcelWriter extends testBase {
	public static Connection connection = null;
	
	//Take filename,sheet name & web table data as input and write the data into excel sheet
	public void writeData(String fileName,String sheetName,HashMap<String,List<String>> data) throws FilloException
	{
		connection=GetCount.makeFilloConnection(fileName);
		ArrayList<String> col=new ArrayList<String>();
		ArrayList<List<String>> colValues=new ArrayList<List<String>>();
		for(String colName:data.keySet())
		{
			col.add(colName);
			colValues.add(data.get(colName));
		}
			for(int i=0;i<colValues.get(0).size();i++)
			{
				String query="Insert into "+ sheetName+"("+col.get(0)+","+col.get(1)+","+col.get(2)+") values('"+colValues.get(0).get(i)+"','"+colValues.get(1).get(i)+"','"+colValues.get(2).get(i)+"')";
				connection.executeUpdate(query);
			}
		connection.close();
	}
}
