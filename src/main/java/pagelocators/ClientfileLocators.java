package pagelocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class ClientfileLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public ClientfileLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Client File Information (Header) Section ~~~ //
	
	@FindBy(id="ProfileHeader1_matrixClientFileLabel")
	protected WebElement clientFileLabel;
	protected String clientFileLabelName = "'Client File' Label";
	
	@FindBy(id="ProfileHeader1_gdsLocatorLabel")
	protected WebElement gdsLocatorLabel;
	protected String gdsLocatorLabelName = "'GDS Locator' Label";
	
	@FindBy(id="ProfileHeader1_departureDateLabel")
	protected WebElement departureDateLabel;
	protected String departureDateLabelName = "'Departure Date' Label";
	
	@FindBy(id="ProfileHeader1_branchLabel")
	protected WebElement branchLabel;
	protected String branchLabelName = "'Branch' Label";
	
	// ~~~ Traveler Section ~~~ //
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_TravellerList1_travellerGridView']//tr//td[2]")
	protected List<WebElement> firstNameLabel;
	protected String firstNameLabelName = "'First Name' Label";
	protected String firstNameLabelName(int i) {
		return "Traveler's Line #" + i + " 'First Name' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_TravellerList1_travellerGridView']//tr//td[3]")
	protected List<WebElement> lastNameLabel;
	protected String lastNameLabelName = "'Last Name' Label";
	protected String lastNameLabelName(int i) {
		return "Traveler's Line #" + i + " 'Last Name' Label";
	}
	
	// ~~~ Traveler Section ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_travellerImage")
	protected WebElement travelersSectionButton;
	protected String travelersSectionButtonName = "'Expand Travelers Section' Button";
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_TravellerList1_travellerGridView']//tr")
	protected List<WebElement> travelerButton;
	protected String travelerButtonName = "'Traveler' Entry";
	protected String travelerButtonName(int i) {
		return "Traveler Entry #" + i;
	}
	
	// ~~~ Itineraries Section ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_itineraryImage")
	protected WebElement itinerariesSectionButton;
	protected String itinerariesSectionButtonName = "'Expand Itineraries Section' Button";
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/air.gif'] | //img[@src='/CwtMyMatrix/images/air.gif'] | //img[@src='/MngMyMatrix/images/air.gif'] | //img[@src='/AusMyMatrix/images/air.gif'] | //img[@src='/AUMyMatrix/images/air.gif'] | //img[@src='/USMyMatrix/images/air.gif'] | //img[@src='/globqlt4/images/air.gif']")
	protected List<WebElement> airItineraryButton;
	protected String airItineraryButtonName = "'Air Itinerary' Listing";
	protected String airItineraryButtonName(int i) {
		return "Air Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/bus.gif'] | //img[@src='/CwtMyMatrix/images/bus.gif'] | //img[@src='/MngMyMatrix/images/bus.gif'] | //img[@src='/AusMyMatrix/images/bus.gif'] | //img[@src='/AUMyMatrix/images/bus.gif'] | //img[@src='/USMyMatrix/images/bus.gif'] | //img[@src='/globqlt4/images/bus.gif']")
	protected List<WebElement> busItineraryButton;
	protected String busItineraryButtonName = "'Bus Itinerary' Listing";
	protected String busItineraryButtonName(int i) {
		return "Bus Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/car.gif'] | //img[@src='/CwtMyMatrix/images/car.gif'] | //img[@src='/MngMyMatrix/images/car.gif'] | //img[@src='/AusMyMatrix/images/car.gif'] | //img[@src='/AUMyMatrix/images/car.gif'] | //img[@src='/USMyMatrix/images/car.gif'] | //img[@src='/globqlt4/images/car.gif']")
	protected List<WebElement> carItineraryButton;
	protected String carItineraryButtonName = "'Car Itinerary' Listing";
	protected String carItineraryButtonName(int i) {
		return "Car Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/hotel.gif'] | //img[@src='/CwtMyMatrix/images/hotel.gif'] | //img[@src='/MngMyMatrix/images/hotel.gif'] | //img[@src='/AusMyMatrix/images/hotel.gif'] | //img[@src='/AUMyMatrix/images/hotel.gif'] | //img[@src='/USMyMatrix/images/hotel.gif'] | //img[@src='/globqlt4/images/hotel.gif']")
	protected List<WebElement> hotelItineraryButton;
	protected String hotelItineraryButtonName = "'Hotel Itinerary' Listing";
	protected String hotelItineraryButtonName(int i) {
		return "Hotel Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/insurance.gif'] | //img[@src='/CwtMyMatrix/images/insurance.gif'] | //img[@src='/MngMyMatrix/images/insurance.gif'] | //img[@src='/AusMyMatrix/images/insurance.gif'] | //img[@src='/AUMyMatrix/images/insurance.gif'] | //img[@src='/USMyMatrix/images/insurance.gif'] | //img[@src='/globqlt4/images/insurance.gif']")
	protected List<WebElement> insuranceItineraryButton;
	protected String insuranceItineraryButtonName = "'Insurance Itinerary' Listing";
	protected String insuranceItineraryButtonName(int i) {
		return "Insurance Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/other.gif'] | //img[@src='/CwtMyMatrix/images/other.gif'] | //img[@src='/MngMyMatrix/images/other.gif'] | //img[@src='/AusMyMatrix/images/other.gif'] | //img[@src='/AUMyMatrix/images/other.gif'] | //img[@src='/USMyMatrix/images/other.gif'] | //img[@src='/globqlt4/images/other.gif']")
	protected List<WebElement> miscItineraryButton;
	protected String miscItineraryButtonName = "'Miscellaneous Itinerary' Listing";
	protected String miscItineraryButtonName(int i) {
		return "Miscellaneous Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/rail.gif'] | //img[@src='/CwtMyMatrix/images/rail.gif'] | //img[@src='/MngMyMatrix/images/rail.gif'] | //img[@src='/AusMyMatrix/images/rail.gif'] | //img[@src='/AUMyMatrix/images/rail.gif'] | //img[@src='/USMyMatrix/images/rail.gif'] | //img[@src='/globqlt4/images/rail.gif']")
	protected List<WebElement> railItineraryButton;
	protected String railItineraryButtonName = "'Rail Itinerary' Listing";
	protected String railItineraryButtonName(int i) {
		return "Rail Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/tour.gif'] | //img[@src='/CwtMyMatrix/images/tour.gif'] | //img[@src='/MngMyMatrix/images/tour.gif'] | //img[@src='/AusMyMatrix/images/tour.gif'] | //img[@src='/AUMyMatrix/images/tour.gif'] | //img[@src='/USMyMatrix/images/tour.gif'] | //img[@src='/globqlt4/images/tour.gif']")
	protected List<WebElement> tourItineraryButton;
	protected String tourItineraryButtonName = "'Tour Itinerary' Listing";
	protected String tourItineraryButtonName(int i) {
		return "Tour Itinerary Entry #" + i;
	}
	
	@FindBy(xpath="//img[@src='/MyMatrix/images/ship.gif'] | //img[@src='/CwtMyMatrix/images/ship.gif'] | //img[@src='/MngMyMatrix/images/ship.gif'] | //img[@src='/AusMyMatrix/images/ship.gif'] | //img[@src='/AUMyMatrix/images/ship.gif'] | //img[@src='/USMyMatrix/images/ship.gif'] | //img[@src='/globqlt4/images/ship.gif']")
	protected List<WebElement> shipItineraryButton;
	protected String shipItineraryButtonName = "'Ship Itinerary' Listing";
	protected String shipItineraryButtonName(int i) {
		return "Ship Itinerary Entry #" + i;
	}
	
	// ~~~ Accounting Section ~~~ //
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelAU;
	protected String accountingDocumentTypeLabelAUName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelAUName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelAUQA;
	protected String accountingDocumentTypeLabelAUQAName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelAUQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelCA;
	protected String accountingDocumentTypeLabelCAName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelCAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelCAQA;
	protected String accountingDocumentTypeLabelCAQAName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelCAQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelUS;
	protected String accountingDocumentTypeLabelUSName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelUSName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelUSQA;
	protected String accountingDocumentTypeLabelUSQAName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelUSQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelUSPreProd;
	protected String accountingDocumentTypeLabelUSPreProdName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelUSPreProdName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[3]")
	protected List<WebElement> accountingDocumentTypeLabelDG;
	protected String accountingDocumentTypeLabelDGName = "Accounting Section's 'Document Type' Label";
	protected String accountingDocumentTypeLabelDGName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Type' Label";
	}
	
	
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingSupplierCodeLabelAU;
	protected String accountingSupplierCodeLabelAUName = "Accounting Section's 'Supplier Code' Label";
	protected String accountingSupplierCodeLabelAUName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Code' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingSupplierCodeLabelCA;
	protected String accountingSupplierCodeLabelCAName = "Accounting Section's 'Supplier Code' Label";
	protected String accountingSupplierCodeLabelCAName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Code' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingSupplierCodeLabelUSQA;
	protected String accountingSupplierCodeLabelUSQAName = "Accounting Section's 'Supplier Code' Label";
	protected String accountingSupplierCodeLabelUSQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Code' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingSupplierCodeLabelPreProdQA;
	protected String accountingSupplierCodeLabelUSPreProdName = "Accounting Section's 'Supplier Code' Label";
	protected String accountingSupplierCodeLabelUSPreProdName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Code' Label";
	}
	
	
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[5]")
	protected List<WebElement> accountingSupplierNameLabelAU;
	protected String accountingSupplierNameLabelAUName = "Accounting Section's 'Supplier Name' Label";
	protected String accountingSupplierNameLabelAUName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Name' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[5]")
	protected List<WebElement> accountingSupplierNameLabelCA;
	protected String accountingSupplierNameLabelCAName = "Accounting Section's 'Supplier Name' Label";
	protected String accountingSupplierNameLabelCAName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Name' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[5]")
	protected List<WebElement> accountingSupplierNameLabelUSQA;
	protected String accountingSupplierNameLabelUSQAName = "Accounting Section's 'Supplier Name' Label";
	protected String accountingSupplierNameLabelUSQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Name' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[5]")
	protected List<WebElement> accountingSupplierNameLabelUSPreProd;
	protected String accountingSupplierNameLabelUSPreProdName = "Accounting Section's 'Supplier Name' Label";
	protected String accountingSupplierNameLabelUSPreProdName(int i) {
		return "Accounting Section's Line #" + i + " 'Supplier Name' Label";
	}
	
	
	
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[6]")
	protected List<WebElement> accountingDocumentNumberLabelAU;
	protected String accountingDocumentNumberLabelAUName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelAUName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[6]")
	protected List<WebElement> accountingDocumentNumberLabelAUQA;
	protected String accountingDocumentNumberLabelAUQAName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelAUQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[7]")
	protected List<WebElement> accountingDocumentNumberLabelCA;
	protected String accountingDocumentNumberLabelCAName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelCAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[7]")
	protected List<WebElement> accountingDocumentNumberLabelCAQA;
	protected String accountingDocumentNumberLabelCAQAName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelCAQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingDocumentNumberLabelUS;
	protected String accountingDocumentNumberLabelUSName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelUSName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[7]")
	protected List<WebElement> accountingDocumentNumberLabelUSQA;
	protected String accountingDocumentNumberLabelUSQAName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelUSQAName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[7]")
	protected List<WebElement> accountingDocumentNumberLabelUSPreProd;
	protected String accountingDocumentNumberLabelUSPreProdName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelUSPreProdName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_Main2_clientFileSnapshotTabContainer_TabPanel1_AccountingList1_ASPxGridView1_DXMainTable']//td[4]")
	protected List<WebElement> accountingDocumentNumberLabelDG;
	protected String accountingDocumentNumberLabelDGName = "Accounting Section's 'Document Number' Label";
	protected String accountingDocumentNumberLabelDGName(int i) {
		return "Accounting Section's Line #" + i + " 'Document Number' Label";
	}
	
	
	
	@FindBy(id="ContentPlaceHolder1_ticketNumberTextBox")
	protected WebElement documentNumberField;
	protected String documentNumberFieldName = "'Document Number' Field";
	@FindBy(id="ContentPlaceHolder1_cancelButton0")
	protected WebElement cancelButton;
	protected String cancelButtonName = "'Cancel' Button";
	
}