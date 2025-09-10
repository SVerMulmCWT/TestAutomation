package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class ChangeBranchLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public ChangeBranchLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Change Branch Fields ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_quickChangeTextBox")
	protected WebElement changeBranchCodeField;
	protected String changeBranchCodeFieldFieldName = "'Change Branch Code' Field";
	
	// ~~~ Search/Cancel Buttons ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_saveButton")
	protected WebElement searchButton;
	protected String searchButtonName = "'Search' Button";
	
	@FindBy(id="ContentPlaceHolder1_cancelButton")
	protected WebElement newButton;
	protected String newButtonName = "'Cancel' Button";
	
}