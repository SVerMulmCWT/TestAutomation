package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class ClientfileInformationLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public ClientfileInformationLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Client File Search Fields ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_Label3")
	protected WebElement clientFileSearchLabel;
	protected String clientFileSearchLabelName = "'Search Client Files' Label";
	
	@FindBy(id="ContentPlaceHolder1_lastNameTextBox")
	protected WebElement lastNameField;
	protected String lastNameFieldName = "'Last Name' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_firstNameTextBox")
	protected WebElement firstNameField;
	protected String firstNameFieldName = "'First Name' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_pnrLocatorTextBox")
	protected WebElement pnrLocatorField;
	protected String pnrLocatorFieldName = "'PNR Locator' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_departureDateTextBox")
	protected WebElement departureDateField;
	protected String departureDateFieldName = "'Departure Date' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_cfaTextBox")
	protected WebElement clientFileNumberField;
	protected String clientFileNumberFieldName = "'Client File Number' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_bookingBranchTextBox")
	protected WebElement bookingBranchField;
	protected String bookingBranchFieldName = "'Booking Branch' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_documentTypeDropDownList")
	protected WebElement documentTypeDropDown;
	protected String documentTypeDropDownName = "'Document Type' Drop-Down";
	
		@FindBy(xpath="//option[@value='BLANK']")
		protected WebElement documentTypeBlankOption;
		protected String documentTypeBlankOptionName = "'Document Type - BLANK' Option";
		
		@FindBy(xpath="//option[@value='CHK']")
		protected WebElement documentTypeChequeOption;
		protected String documentTypeChequeOptionName = "'Document Type - Cheque' Option";
		
		@FindBy(xpath="//option[@value='EFT']")
		protected WebElement documentTypeEFTReceiptOption;
		protected String documentTypeEFTReceiptOptionName = "'Document Type - EFT Receipt' Option";
		
		@FindBy(xpath="//option[@value='CRS']")
		protected WebElement documentTypeGDSInvoiceOption;
		protected String documentTypeGDSInvoiceOptionName = "'Document Type - GDS Invoice' Option";
		
		@FindBy(xpath="//option[@value='INV']")
		protected WebElement documentTypeMatrixInvoiceOption;
		protected String documentTypeMatrixInvoiceOptionName = "'Document Type - Matrix Invoice' Option";
		
		@FindBy(xpath="//option[@value='REC']")
		protected WebElement documentTypeMatrixReceiptOption;
		protected String documentTypeMatrixReceiptOptionName = "'Document Type - Matrix Receipt' Option";
		
		@FindBy(xpath="//option[@value='FEE']")
		protected WebElement documentTypeServicefeeOption;
		protected String documentTypeServicefeeOptionName = "'Document Type - Servicefee' Option";
		
		@FindBy(xpath="//option[@value='TKT']")
		protected WebElement documentTypeTicketOption;
		protected String documentTypeTicketOptionName = "'Document Type - Ticket' Option";
			
			@FindBy(id="ContentPlaceHolder1_ticketingBranchTextBox")
			protected WebElement TicketingBranchField;
			protected String TicketingBranchFieldName = "'Ticketing Branch' Field";
	
	@FindBy(id="ContentPlaceHolder1_documentNumberTextBox")
	protected WebElement documentNumberField;
	protected String documentNumberFieldName = "'Document Number' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_supplierBookingNumber")
	protected WebElement supplierBookingNumberField;
	protected String supplierBookingNumberFieldName = "'Supplier Booking Number' Search Field";
	
	@FindBy(id="ContentPlaceHolder1_clientFileCodeTextBox")
	protected WebElement clientFileCodeField;
	protected String clientFileCodeFieldName = "'Client File Code' Search Field";
	
	// ~~~ Search/New Buttons ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_searchButton")
	protected WebElement searchButton;
	protected String searchButtonName = "'Search' Button";
	
	@FindBy(id="ContentPlaceHolder1_searchButton")
	protected WebElement newButton;
	protected String newButtonName = "'New' Button";
	
	// ~~~ Search Results ~~~ //
	
	@FindBy(xpath="//tr[@id='ContentPlaceHolder1_ClientfileSearchUserControlGrid_clientFileSearchGridViewDX_DXDataRow0'] | //tr[@id='ContentPlaceHolder1_QBD_TicketUserControlGrid_qbdTicketSearchGridViewDX_DXDataRow0']")
	protected WebElement firstSearchResult;
	protected String firstSearchResultName = "First Search Result Button";
	
}