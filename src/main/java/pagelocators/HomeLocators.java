package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class HomeLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public HomeLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Header Labels ~~~ //
	
	@FindBy(id="ProfileHeader1_sigInBranchLabel")
	protected WebElement branchLabelField;
	protected String branchLabelFieldName = "'Current Branch' Label";
	
	// ~~~ Drop-Down Menus ~~~ //
	
	@FindBy(xpath="//div[@class='menuBar']//a[text()='View'] | //div[@class='menuBar']//a[text()='GoTo']")
	protected WebElement viewDropDown;
	protected String viewDropDownName = "'View' Menu Listing Drop-Down";
	
	@FindBy(xpath="//a[text()='Clientfile Information']")
	protected WebElement viewClientfileInformationOption;
	protected String viewClientfileInformationOptionName = "'View -> Clientfile Information' Drop-Down Option";
	
	@FindBy(xpath="//a[text()='Calendar/Tasks/Queues']")
	protected WebElement viewCalendarTasksQueuesOption;
	protected String viewCalendarTasksQueuesOptionName = "'View -> Calendar/Tasks/Queues' Drop-Down Option";
	
	@FindBy(xpath="//div[@class='menuBar']//a[text()='Change Branch']")
	protected WebElement changeBranchDropDown;
	protected String changeBranchDropDownName = "'Change Branch' Menu Listing Drop-Down";
	
	@FindBy(xpath="//div[@id='ChangeBranch_subMenu']//a[text()='Change Branch']")
	protected WebElement changeBranchOption;
	protected String changeBranchOptionName = "'Change Branch -> Change Branch' Drop-Down Option";
}