package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagemethods.BSPTicketPage;
import pagemethods.CWTLoginPage;
import pagemethods.ChangeBranchPage;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.LoginPage;
import pagemethods.NonBSPTicketPage;
import pagemethods.QueuesPage;
import pagemethods.TravelerPage;
import pagemethods.itineraries.AirItineraryPage;
import pagemethods.itineraries.BusItineraryPage;
import pagemethods.itineraries.CarItineraryPage;
import pagemethods.itineraries.HotelItineraryPage;
import pagemethods.itineraries.InsuranceItineraryPage;
import pagemethods.itineraries.MiscItineraryPage;
import pagemethods.itineraries.RailItineraryPage;
import pagemethods.itineraries.ShipItineraryPage;
import pagemethods.itineraries.TourItineraryPage;
import utilityClasses.ConstantVariables;
import utilityClasses.EncryptionMethods;
import utilityClasses.EventHandler;
import utilityClasses.ExcelMethods;
import utilityClasses.ExtentFactory;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	//Declare Variable(s) for accessing general classes
	protected static Properties prop;
	protected static ConstantVariables constantVariables;
	
	//Declare Variable(s) for accessing the Excel File(s)
	protected ExcelMethods excelMethods;
	protected GeneralMethods genMethods;
	protected EncryptionMethods encryptionMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	protected String path;
	protected String sheetName;
	protected int iteration;
	
	//Declare Variable(s) for performing 'retries' in the test suite
	protected int retryCount = 0;
	protected int maxRetryCount = 3;
	
	//Declare Variable(s) for initializing the WebDriver
//	protected static DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	protected static DesiredCapabilities caps = new DesiredCapabilities();
	private static WebDriver driver; //used to setup a connection to one or more browsers for testing
	private static EventHandler eHandler;  //used in conjunction with the EventFiringWebDriver
	protected static EventFiringWebDriver eDriver; //used in conjunction with the WebDriver
	
	public static AndroidDriver<AndroidElement> aDriver;
	public static AppiumDriver<MobileElement> bDriver;
	
	//Misc. Variables
	protected static String activeWebsite;
	protected static String activeBrowser;
	protected static String activeBrowserVersion;
	
	protected static String cwtUserID;
	protected static String cwtPassword;
	
	protected static String currentDataTable;
	
	//Declare the Report Logger
	protected ExtentReports report; //used to setup a report that will hold the testing info of the script(s)
	protected ExtentTest reportLogger; //used to store testing details in the report
	
	//Declare PageFactories
	protected AirItineraryPage airItineraryPage;
	protected BusItineraryPage busItineraryPage;
	protected CarItineraryPage carItineraryPage;
	protected HotelItineraryPage hotelItineraryPage;
	protected InsuranceItineraryPage insuranceItineraryPage;
	protected MiscItineraryPage miscItineraryPage;
	protected RailItineraryPage railItineraryPage;
	protected ShipItineraryPage shipItineraryPage;
	protected TourItineraryPage tourItineraryPage;
	
	protected BSPTicketPage bspTicketPage;
	protected ChangeBranchPage changeBranchPage;
	protected ClientfileInformationPage clientfileInformationPage;
	protected ClientfilePage clientfilePage;
	protected CWTLoginPage cwtLoginPage;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected NonBSPTicketPage nonbspTicketPage;
	protected TravelerPage travelerPage;
	protected QueuesPage queuesPage;
	
	public TestBase() {
		try {
			//Initialize an object for the 'Constant Variables' class to access its values
			constantVariables = new ConstantVariables();
			System.out.println("ASDF - 1");
			//Initialize an object for the 'Properties' file to access its values
			prop = new Properties();
			FileInputStream ip = new FileInputStream(constantVariables.propertiesFileLocation);
			prop.load(ip);
			System.out.println("ASDF - 2");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String encryptText(String text) {
		byte[] encodedString = Base64.encodeBase64(text.getBytes());
		
		return(new String(encodedString));
	}
	
	public String decryptText(String text) {
		byte[] decodedString = Base64.decodeBase64(text);
		return(new String(decodedString));
	}
	
	public void performSetup(String reportTitle, String scriptName) {
		//Setup the Report
		report = ExtentFactory.getInstance(activeWebsite, activeBrowser, activeBrowserVersion);
		reportLogger = report.startTest(reportTitle);
		
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
		
		//Output the name of the test case
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		reportLoggerMethods.reportInfo("Performing the testcase -> " + scriptName);
		
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Initializing the script's PageFactories");
	}
	
	public static void initializeDriver() {
		//Initialize the relevant browser driver
		if (activeBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (activeBrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", constantVariables.firefoxDriverPath);
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (activeBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().browserVersion("105.0.5195.125").setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("Cannot setup the driver due to invalid input");
			driver.quit();
		}
		
		//Retrieve the browser version
//		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//		activeBrowserVersion = caps.getVersion();
		
		//Setup the Event Driver
		eDriver = new EventFiringWebDriver(driver);
		eHandler = new EventHandler();
		eDriver.register(eHandler);
		
		//Configure the testing browser
		eDriver.manage().window().maximize();
		eDriver.manage().deleteAllCookies();
		eDriver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
		eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	@Parameters({"browser", "website", "userid", "password", "dataTable"})
	public void beforeTest(String browser, String website, String userid, String password, String dataTable) {
		System.out.println("Performing the script's setups (@BeforeSuite)");
		
		//Delete the previous Extent Report
		ExtentFactory.deleteExtentReport();
		
		//Set the active Browser value for the Extent Report
		activeBrowser = browser;
		
		//Set the Environment value for the Extent Report
		activeWebsite = website;
		
		//Set the active CWT Userid value
		cwtUserID = userid;
		
		//Set the active CWT Password value
		cwtPassword = password;
		
		//Set the active testing DataTable
		currentDataTable = dataTable;
		
		//Initialize the testing browser via WebDriver, configured with the Listeners
		initializeDriver();
		
		//Initialize an object for the 'Report Logger Methods' class to access its methods
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Setup objects for general methods
		excelMethods = new ExcelMethods();
		genMethods = new GeneralMethods();
		encryptionMethods = new EncryptionMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	@AfterSuite
	public void afterSuite() {
		//Close the testing browser and its WebDriver & Listeners
		eDriver.quit();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		try {
			if(result.getStatus() == ITestResult.FAILURE) {
				//Increase the retryCount by 1
				retryCount++;
				
				//If the retryCount does not match the maxRetryCount, then skip sending out an error message since it will perform a retry
				if (retryCount != maxRetryCount) {
					return;
				}
				
				//Output the FAIL status to the Report & Excel
				reportLoggerMethods.reportFailedMessage("The Test Case that failed is: " + result.getName());
				reportLoggerMethods.reportFailedMessage("The Test Case that failed is: " + result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
				//Increase the retryCount by 1
				retryCount++;
				
				//If the retryCount does not match the maxRetryCount, then skip sending out an error message since it will perform a retry
				if (retryCount != maxRetryCount) {
					return;
				}
				
				//Output the SKIP status to the Report & Excel
				reportLoggerMethods.reportSkippedMessage("The Test Case that was skipped is: " + result.getName());
				reportLoggerMethods.reportSkippedMessage("The Test Case that was skipped is: " + result.getThrowable());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				//Output the SUCCESS status to the Report
				reportLoggerMethods.reportSuccessfulCheckpoint("The Test Case that passed is: " + result.getName());
			} else {
				//Increase the retryCount by 1
				retryCount++;
				
				//If the retryCount does not match the maxRetryCount, then skip sending out an error message since it will perform a retry
				if (retryCount != maxRetryCount) {
					return;
				}
				
				//Output the Script status to the Report & Excel
				reportLoggerMethods.reportUnknownMessage("Unknown error upon completion of a @Test -> the @Test neither passed, failed, or was skipped");
			}
			
			//Reset the retry counter to zero
			retryCount = 0;
			
			//End/Tie-up the Report
			report.endTest(reportLogger);
			report.flush();
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}