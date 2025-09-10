package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class NonBSPTicketLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public NonBSPTicketLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ BSP Ticket Details Page ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_nonBSPSupplierLabel")
	protected WebElement supplierField;
	protected String supplierFieldName = "'Supplier' Field";
	
	@FindBy(id="ContentPlaceHolder1_ticketNumberTextBox")
	protected WebElement ticketNumberField;
	protected String ticketNumberFieldName = "'Ticket Number' Field";
	
	@FindBy(id="ContentPlaceHolder1_cancelButton0")
	protected WebElement cancelButton;
	protected String cancelButtonName = "'Cancel' Button";
}