package com.test.UIAutomation.OneDat.Listener;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.test.UIAutomation.OneDat.TestBase.testBase;


public class RetryAnalyzer extends testBase implements IRetryAnalyzer{

  private int count = 0; 
  private int maxCount = 2;
  

	public boolean retry(ITestResult result) {
	  if(count < maxCount) {  
		  //logInReport("Retrying test " +"--"+ result.getName()+"--" + " with status " + getResultStatusName(result.getStatus()) + " for the " + (count + 1) + " time(s).");
		  logInReport("Retrying test " +"--"+ result.getName()+"--" + " for the " + (count + 1) + " time(s).");	    
		  count++;
      return true;        

	    } 
		return false;
	}

	
	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
	
	
	
}
