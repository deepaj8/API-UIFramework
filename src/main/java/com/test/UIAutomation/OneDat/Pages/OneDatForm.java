package com.test.UIAutomation.OneDat.Pages;

import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.UIAutomation.OneDat.TestBase.testBase;

public class OneDatForm extends testBase{
	@FindBy(xpath="//*[@class='main-header']")
	WebElement homePageHeader;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(xpath="//label[@class='custom-control-label']")
	List<WebElement> radioBtn;
	
	@FindBy(id="userNumber")
	WebElement mobileNumber;
	
	@FindBy(id="dateOfBirthInput")
	WebElement dob;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement selectMonth;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement selectYear;
	
	@FindBy(xpath="//*[@class='react-datepicker__week']//div[@role='option']")
	List<WebElement> selectDay;
	
	@FindBy(id="subjects-label")//we have to use to_right_of for subjects input
	WebElement subjects;
	
	@FindBy(id="hobbies-checkbox-1")
	WebElement hobbieCheckbox;
	
	@FindBy(id="uploadPicture")
	WebElement uploadPic;
	
	@FindBy(id="currentAddress")
	WebElement currentAddr;
	
	@FindBy(id="state")
	WebElement state;

	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="submit")
	WebElement submit;
	
	@FindBy(id="example-modal-sizes-title-lg")
	WebElement confirmMsg;
	
	@FindBy(id="closeLargeModal")
	WebElement closeModal;
	
	
	
	public OneDatForm() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void submitForm(HashMap<String, String> data) {
		firstName.sendKeys(data.get("FirstName"));
		lastName.sendKeys(data.get("LastName"));
		userEmail.sendKeys(data.get("Email"));
		radioHandler.selectRadioButton(radioBtn, data.get("Gender"));
		mobileNumber.sendKeys(data.get("Mobile"));
		radioHandler.selectRadioButton(radioBtn, data.get("Hobbies"));
		uploadPic.sendKeys(System.getProperty("user.dir") + "/src/main/java/com/test/API_UIAutomation/OneDat/Reports/" + "OneDatPic.png");
		currentAddr.sendKeys(data.get("Address"));
		dob.click();
	selectHandler.selByVisibleText(selectMonth, "April");
	selectHandler.selByVisibleText(selectYear, "1980");
	stringHandler.selectText(selectDay, "3");
		mouseHandler.clickAndHoldKeyDownElement(state, 2);
		customWait.waitForElementToBeClickble(city,driver,2);
		mouseHandler.clickAndHoldKeyDownElement(city, 1);
		submit.click();
		
	}
	
	public String confirmSubmit() {
		String actual=confirmMsg.getText();
		return actual;
	}
	
	
	
	public String valText() {
		String actual=homePageHeader.getText();
		return actual;
	}
	
}
