package pagelocators.itineraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class BusItineraryLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public BusItineraryLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_supIdTextBox")
	protected WebElement supplierField;
	protected String supplierFieldName = "'Supplier' Field";
	
	@FindBy(id="ContentPlaceHolder1_serviceTextBox")
	protected WebElement busNumberField;
	protected String busNumberFieldName = "'Bus Number' Field";
	
	@FindBy(id="ContentPlaceHolder1_originTextBox")
	protected WebElement departureCityField;
	protected String departureCityFieldName = "'Departure City' Field";
	
	@FindBy(id="ContentPlaceHolder1_destinTextBox")
	protected WebElement arrivalCityField;
	protected String arrivalCityFieldName = "'Arrival City' Field";
	
	@FindBy(id="ContentPlaceHolder1_startTextBox")
	protected WebElement departureDateField;
	protected String departureDateFieldName = "'Departure Date' Field";
	
	@FindBy(id="ContentPlaceHolder1_classTextBox")
	protected WebElement classField;
	protected String classFieldName = "'Class' Field";
	
	@FindBy(id="ContentPlaceHolder1_cancelButton")
	protected WebElement cancelButton;
	protected String cancelButtonName = "'Cancel' Button";
	
}