package com.test.UIAutomation.OneDat.TestCases;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.test.UIAutomation.OneDat.Pages.PracticePage;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC5 extends testBase{
	PracticePage page;
	@Test
	public void getDadtaFromTable() throws FilloException
	{
		page=pomanager.getPage();
		int rows=page.getRows();
		int columns=page.getColumns();
		HashMap<String,List<String>> data=page.getTableData(rows, columns);
		excelWriter.writeData("Tables","Courses" , data);
	}

}
