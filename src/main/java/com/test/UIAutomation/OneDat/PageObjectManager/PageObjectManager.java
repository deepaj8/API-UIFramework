package com.test.UIAutomation.OneDat.PageObjectManager;

import org.openqa.selenium.WebDriver;

import com.test.UIAutomation.OneDat.Pages.OneDatElements;
import com.test.UIAutomation.OneDat.Pages.OneDatForm;
import com.test.UIAutomation.OneDat.Pages.OneDatHome;
import com.test.UIAutomation.OneDat.Pages.OneDatLogin;
import com.test.UIAutomation.OneDat.Pages.OneDatPortal;
import com.test.UIAutomation.OneDat.Pages.PracticePage;

public class PageObjectManager {
	private WebDriver driver;
	private OneDatPortal portal;
	private OneDatHome home;
	private OneDatLogin login;
	private OneDatForm form;
	private OneDatElements elements;
	private PracticePage page;
	
	public PageObjectManager(WebDriver driver) {
	     this.driver = driver;
	}
	
	/*Page Object Creation Method
	This method has two responsibilities:
		1.To create an Object of Page Class only if the object is null.
		2.To supply the already created object if it is not null */
	
	 public OneDatPortal getPortalPage(){
		 return (portal == null) ? portal = new OneDatPortal() : portal;
		 }
	 
	 public OneDatHome getHomePage(){
		 return (home == null) ? home = new OneDatHome() : home;
		 }
	 
	 public OneDatLogin getLoginPage(){
		 return (login == null) ? login = new OneDatLogin() : login;
		 }
	 
	 public OneDatForm getFormPage(){
		 return (form == null) ? form = new OneDatForm() : form;
		 }
	 public OneDatElements getElementsPage() {
		 return (elements==null)?elements=new OneDatElements():elements;
	     }
	 public PracticePage getPage() {
		 return (page==null)?page=new PracticePage():page;
	     }
	 
}
