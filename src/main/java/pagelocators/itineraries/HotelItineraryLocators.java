package pagelocators.itineraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class HotelItineraryLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public HotelItineraryLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
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
	protected WebElement hotelChainField;
	protected String hotelChainFieldName = "'Hotel Chain' Field";
	
	@FindBy(id="ContentPlaceHolder1_hotelNameTextBox")
	protected WebElement hotelNameField;
	protected String hotelNameFieldName = "'Hotel Name' Field";
	
	@FindBy(id="ContentPlaceHolder1_originTextBox")
	protected WebElement cityField;
	protected String cityFieldName = "'City' Field";
	
	@FindBy(id="ContentPlaceHolder1_add1TextBox")
	protected WebElement addressField;
	protected String addressFieldName = "'Address' Field";
	
	@FindBy(id="ContentPlaceHolder1_phoneTextBox")
	protected WebElement phoneNumberField;
	protected String phoneNumberFieldName = "'Phone Number' Field";
	
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_roomTypeDropDownList']//option[@selected='selected']")
	protected WebElement roomTypeDropDown;
	protected String roomTypeDropDownName = "'Room Type' Drop-Down";
	
	@FindBy(id="ContentPlaceHolder1_startTextBox")
	protected WebElement checkinDateField;
	protected String checkinDateFieldName = "'Checkin Date' Field";
	
	@FindBy(id="ContentPlaceHolder1_cancelButton")
	protected WebElement cancelButton;
	protected String cancelButtonName = "'Cancel' Field";
	
}