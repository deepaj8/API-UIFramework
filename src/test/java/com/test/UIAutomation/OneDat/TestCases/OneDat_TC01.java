package com.test.UIAutomation.OneDat.TestCases;

import static org.testng.Assert.assertTrue;


import java.util.HashMap;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.test.UIAutomation.OneDat.Pages.OneDatChkUtility;
import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDat_TC01 extends testBase{
	
	
	@DataProvider(name="data")
	public Object[][] getTestDta(){
		return excelReader.getData("sample2","TC_Data","TC1");
		
	}
	
	@Test(enabled=false)
	public void OneDat_Login() throws FilloException {
		log.info("=======Starting Login test========");
		 OneDatChkUtility util=new OneDatChkUtility(driver);
 		util.check();
		
	}
	
	
     @Test(dataProvider="data")
     public void OneDat_ChkFunctions(HashMap<String, String> data) throws FilloException {
    	 OneDatChkUtility util=new OneDatChkUtility(driver);
    		util.check();
    	System.out.println("Order Date "+data.get("OrderDate"));
		System.out.println("Units "+data.get("Units"));
		System.out.println("UnitCost "+data.get("Unit Cost"));
		System.out.println("Total "+data.get("Total"));
     }
     
  
}
