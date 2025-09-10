package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class TravelerLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public TravelerLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Verify Traveler Details Page ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_firstNameTextBox")
	protected WebElement firstNameField;
	protected String firstNameFieldName = "'First Name' Field";
	
	@FindBy(id="ContentPlaceHolder1_lastNameTextBox")
	protected WebElement lastNameField;
	protected String lastNameFieldName = "'Last Name' Field";
	
	@FindBy(id="ContentPlaceHolder1_cancelButton")
	protected WebElement cancelButton;
	protected String cancelButtonName = "'Cancel' Button";
}