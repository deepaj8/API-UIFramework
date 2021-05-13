package com.test.UIAutomation.OneDat.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.APIAutomation.OneDat.Resources.ApiResources;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.test.UIAutomation.OneDat.ExcelUtility.ExcelReader;
import com.test.UIAutomation.OneDat.ExcelUtility.ExcelWriter;
import com.test.UIAutomation.OneDat.ExcelUtility.GetCount;
import com.test.UIAutomation.OneDat.PageObjectManager.PageObjectManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonFunctions {
	protected final Logger log = Logger.getLogger(CommonFunctions.class.getName());
	public static Properties prop;
	//public static ExtentTest test;
	public static WebDriver driver;
	public static SimpleDateFormat format;
	//public static ExtentReports extent;
	public static Calendar cal;
	public static SelectActions selectHandler;
	public static AlertActions alertHandler;
	public static CustomWait customWait;
	public static JavaScriptActions jsActions;
	public static FrameActions frameHandler;
	public static CheckBoxActions checkboxhandler;
	public static MultipleWindowActions multiwindowhandler;
	public static CookieActions cookieHandler;
	public static GetCount excelCount;
	public static ExcelReader excelReader;
	public static ExcelWriter excelWriter;
	public static RadioActions radioHandler;
	public static PageObjectManager pomanager;
	public static StringActions stringHandler;
	public static MouseActions mouseHandler;
	public static RequestSpecification requestSpec; 
	public static ResponseSpecification responseSpec;
	public static PrintStream logapi;
	public static Response response;
	
/****loads the requested data from the property file and returns the value*****/
	public String loadData(String configVal) {
		prop = new Properties();
		try {
			// prop.load(new FileInputStream(System.getProperty("user.dir")
			// + "/src/main/java/com/test/automation/OneDat/ConfigFile/config.properties"));
			prop.load(new FileInputStream(Constants.CONFIG_FILE_PATH));
		} catch (Exception e) {

			log.info("Error reading configuration file with exception :" + e);
		}
		return prop.getProperty(configVal).trim();
	}

/*****initialise extent report for creating reports , false means append the data in a report, if the html report does not exist create new one.below is the static/class initializer block which gets invoked only once when the class is loaded.*****/
	static {
		cal = Calendar.getInstance();
		format = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		//extent = new ExtentReports(Constants.REPORTS_PATH + format.format(cal.getTime()) + ".html", false);

	}
	

/*****Select Browser*****/
	
	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (loadData("disablecookie").equalsIgnoreCase("yes")) {
				driver = new ChromeDriver(cookieHandler.disablecookieOnChrome());
			} else {
				driver = new ChromeDriver();
			}
			initializeObjects();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (loadData("disablecookie").equalsIgnoreCase("yes")) {
				driver = new FirefoxDriver(cookieHandler.disableCookieOnFirefox());
			} else {
				driver = new FirefoxDriver();
			}
			initializeObjects();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			initializeObjects();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			initializeObjects();
		}
		setDriver(driver);
	}
	private void setDriver(WebDriver driver) {
		this.driver = driver;
		
	}

/*****get URL, maximize it and add implicit wait*****/
	/*public void getURL(String url)
	{
		getDriver().get(url);
		log.info(url);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}*/
	
	public void getURL(String url) {
		driver.get(url);
		log.info(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


/*****Initialize Property,Driver and Log4j*****/
	public void init() {
		String log4jconfigpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
		selectBrowser(loadData("browser"));
		//initializeObjects();
		if (loadData("screenrecord").equalsIgnoreCase("yes")) {
			try {
				VideoRecorder.startRecord("AutomationTestRecord");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getURL(loadData("url"));
	}
	

/*****close the browser and end the extent report*****/
	public void closeBrowser() {
		driver.quit();
		log.info("All the browser instances are closed");
		//extent.endTest(test);
		//extent.flush();
	}



/*****Get the result after executing the test*****/
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
		//	test.log(LogStatus.PASS, result.getName() + "--Test is Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
		//	test.log(LogStatus.FAIL, result.getName() + "--Test is Failed--" + result.getThrowable().getLocalizedMessage() + test.addScreenCapture(captureScreenShot(result)));
		} else if (result.getStatus() == ITestResult.SKIP) {
		//	test.log(LogStatus.SKIP, result.getName() + "--Test is Skipped and the Reason is--" + result.getThrowable());
		}
	}
	

/*****Take Screenshot place it in Destination folder and return the path for failure tests*****/
	public String captureScreenShot(ITestResult result) throws IOException {
		File destfile = null;
		if (result.getStatus() == ITestResult.FAILURE) {
			log.info("Inside captureScreenShot Utility");
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String path = new File(System.getProperty("user.dir")).getAbsolutePath() + Constants.SCREENSHOT_PATH;
			destfile = new File((String) path + result.getName() + "_" + format.format(cal.getTime()) + ".png");
			FileHandler.copy(srcfile, destfile);
		}

		return destfile.getAbsolutePath();
	}
	

/*****Log custom message into the Report*****/
	public void logInReport(String data) {
		log.info("Inside logInReport Utility");
		log.info(data);
		Reporter.log(data);
	//	test.log(LogStatus.INFO, data);
	}
	

/*****Takes Screenshot irrespective of result and place it in Destination folder and logs into the report*****/
	public void getScreenShot(String testname) {
		File destfile = null;

		log.info("Inside getScreenShot Utility");
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path = new File(System.getProperty("user.dir")).getAbsolutePath() + Constants.SCREENSHOT_PATH;
			destfile = new File((String) path + testname + "_" + format.format(cal.getTime()) + ".png");
			FileHandler.copy(srcfile, destfile);
		//	test.log(LogStatus.INFO, testname + test.addScreenCapture(destfile.getAbsolutePath()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

/*****To take a screen shot on the element eg on logo*****/
	public void getScreenShotOnElement(WebElement el, String elementName) {
		File destfile = null;
		File srcfile = el.getScreenshotAs(OutputType.FILE);
		try {
			String path = new File(System.getProperty("user.dir")).getAbsolutePath() + Constants.SCREENSHOT_PATH;
			destfile = new File((String) path + elementName + "_" + format.format(cal.getTime()) + ".png");
			FileHandler.copy(srcfile, destfile);
		//	test.log(LogStatus.INFO, elementName + test.addScreenCapture(destfile.getAbsolutePath()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*****To initialize all objects of different classes*****/
	private void initializeObjects() {
		selectHandler = new SelectActions();
		alertHandler = new AlertActions();
		customWait = new CustomWait();
		jsActions = new JavaScriptActions();
		frameHandler = new FrameActions();
		checkboxhandler = new CheckBoxActions();
		multiwindowhandler = new MultipleWindowActions();
		cookieHandler = new CookieActions();
		excelCount = new GetCount();
		excelReader = new ExcelReader();
		excelWriter=new ExcelWriter();
		radioHandler = new RadioActions();
		stringHandler = new StringActions();
		mouseHandler = new MouseActions();
		pomanager = new PageObjectManager(driver);
		// videoRecorder=new VideoRecorder();
	}

/*****To delete the videos*****/
	public void deleteVideos(String pathOfVideos) {
		File dir = new File(pathOfVideos);
		File[] files = dir.listFiles();
		for (File file : files) {
			file.delete();
		}
	}
	
	
	
/******************COMMON FUNCTIONS FOR API TESTING *************************/
	
	
	public RequestSpecification setBaseUri() throws IOException {
		if(requestSpec==null)
		{	logapi=new PrintStream(new FileOutputStream("APIRequest_ResponseReport.txt"));
		requestSpec = new RequestSpecBuilder()
        		.setBaseUri(loadData("baseUri"))
        		.addFilter(RequestLoggingFilter.logRequestTo(logapi))
				.addFilter(ResponseLoggingFilter.logResponseTo(logapi))
        		.build();
		return requestSpec;
		}
		return requestSpec;
	}
	
	public ResponseSpecification responseSpecForJson() {
		 responseSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	return responseSpec;
	}

	
	/****Request Specification for Json Content Type if Query Parameters Present *****/
	
	public RequestSpecification requestSpecForJsonWithQueryParams() throws IOException {	
		return setBaseUri().queryParam("key", loadData("queryParam")).contentType(ContentType.JSON);			
	}
	
/****Request Specification for XML Content Type if Query Parameters Present *****/
	
	public RequestSpecification requestSpecForXMLWithQueryParams() throws IOException {	
		return setBaseUri().queryParam("key", loadData("queryParam")).contentType(ContentType.XML);			
	}
	
	/****Request Specification for Json Content Type ****/
	public RequestSpecification requestSpecForJSON() throws IOException {
		return setBaseUri().contentType(ContentType.JSON);
	}
	
	/****Request Specification for XML Content Type ****/
	public RequestSpecification requestSpecForXML() throws IOException {
		return setBaseUri().contentType(ContentType.XML);
	}
	
	/****convert json to jsonpath object to evaluate response****/
	public JsonPath getJsonPath(Response response)
	{
		String s=response.asString();
		JsonPath js=new JsonPath(s);
		return js;
	}
	
	/****get the string value from the response based on the json key****/
	public String getStringFromJson(Response response,String key)
	{
		return getJsonPath(response).get(key).toString();
	}
	
	/****get the int value from the response based on the json key****/
	public int getIntFromJson(Response response,String key)
	{
		return getJsonPath(response).getInt(key);
	}
	
	/****get the double value from the response based on the json key****/
	public double getDoubleFromJson(Response response,String key)
	{
		return getJsonPath(response).getDouble(key);
	}
	
	
	/****convert static json file to string****/
	public String readJsonFile(String fileName) throws IOException
	{
		
		return new String(Files.readAllBytes(Paths.get(Constants.TESTDATA_PATH+fileName+".json")));
	}
	
	/****get resource path****/
	public String getResourcePath(String resource)
	{
		ApiResources resourceApi=ApiResources.valueOf(resource);
		return resourceApi.getResource();
	}
	
	
}
