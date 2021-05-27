package com.test.UIAutomation.OneDat.Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.API_UIAutomation.OneDat.TestBase.testBase;

public class PracticePage extends testBase {
	@FindBy(xpath="(//table)[1]/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath="(//table)[1]/tbody/tr/th")
	List<WebElement> columns;
	public PracticePage() {
		PageFactory.initElements(driver,this);
	}
	
	public int getRows()
	{
		return rows.size();
	}
	
	public int getColumns()
	{
		return columns.size();
	}
	
	public HashMap<String,List<String>> getTableData(int noRows,int noCols){
		HashMap<String,List<String>> hm=new HashMap<String,List<String>>();
		for(int i=1;i<=noCols;i++)
		{
			ArrayList<String> colValues=new ArrayList<String>();
			for(int j=2;j<=noRows;j++)
			{
				colValues.add(driver.findElement(By.xpath("(//table)[1]/tbody/tr["+j+"]/td["+i+"]")).getText());
			}
			WebElement e=driver.findElement(By.xpath("(//table)[1]/tbody/tr/th["+i+"]"));
			hm.put(e.getText(), colValues);
		}
		return hm;
	}

}
