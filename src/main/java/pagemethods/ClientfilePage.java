package pagemethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.ClientfileLocators;

public class ClientfilePage extends ClientfileLocators {
	
	//Constructor
	public ClientfilePage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Traveler Section ~~~ //
	
	public void expandTravelerSection() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Expanding the Traveler Section");
		
		//Expand the Traveler Section
		reportLoggerMethods.click(travelersSectionButton, travelersSectionButtonName);
	}
	
	public void openTravelerPage(int travelerEntry) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Traveler Page(s)");
		
		//Open the Traveler Details Page
		if (travelerEntry == 0) {
			reportLoggerMethods.reportFailedMessage("Unable to open correct Traveler Details Page, as the correct Traveler Full Name was not located. Opening First Traveler to ensure the Traveler Detail Page can open without error");
			reportLoggerMethods.click(travelerButton.get(1), travelerButtonName(1));
		} else {
			reportLoggerMethods.click(travelerButton.get(travelerEntry), travelerButtonName(travelerEntry));
		}
	}
	
	public void closeTravelerSection() {
		//Close the Traveler Section
		reportLoggerMethods.click(travelersSectionButton, travelersSectionButtonName);
	}
	
	// ~~~ Itinerary Section ~~~ //
	
	public void openAirItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Air Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(airItineraryButton.get(Integer.parseInt(listingNumber)-1), airItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openBusItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Bus Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(busItineraryButton.get(Integer.parseInt(listingNumber)-1), busItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openCarItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Car Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(carItineraryButton.get(Integer.parseInt(listingNumber)-1), carItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openHotelItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Hotel Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(hotelItineraryButton.get(Integer.parseInt(listingNumber)-1), hotelItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openInsuranceItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Insurance Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(insuranceItineraryButton.get(Integer.parseInt(listingNumber)-1), insuranceItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openMiscItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Miscellaneous Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(miscItineraryButton.get(Integer.parseInt(listingNumber)-1), miscItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openRailItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Rail Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(railItineraryButton.get(Integer.parseInt(listingNumber)-1), railItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openTourItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Tour Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(tourItineraryButton.get(Integer.parseInt(listingNumber)-1), tourItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void openShipItineraryPage(String listingNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the Ship Itinerary Page(s)");
		
		//Expand the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
		
		//Open the Itinerary Details Page
		reportLoggerMethods.click(shipItineraryButton.get(Integer.parseInt(listingNumber)-1), shipItineraryButtonName(Integer.parseInt(listingNumber)-1));
	}
	
	public void closeItinerarySection() {
		//Close the Itineraries Section
		reportLoggerMethods.click(itinerariesSectionButton, itinerariesSectionButtonName);
	}
	
	// ~~~ Accounting Section ~~~ //
	
	public int searchAccountingSection(String environment, String documentType, String documentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Searching the Accounting Section");
		
		//Initialize Variable(s)
		List<WebElement> accountingDocumentTypeLabel;	//List of Document Type info from Accounting column
		String accountingDocumentTypeLabelName;			//Error message if Document Type locator failed
		List<WebElement> accountingDocumentNumberLabel;	//List of Document Number info from Accounting column
		String accountingDocumentNumberLabelName;		//Error message if Document Number locator failed
		
		String currentDocumentType = "";	//When looping through the Accounting Row, keep track of current Accounting Row info
		String currentDocumentNumber = "";	//When looping through the Accounting Row, keep track of current Accounting Row info
		
		//Select which Accounting columns to reference for Document Type and Document Number
		switch (environment) {
		case "AU":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelAU;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelAUName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelAU;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelAUName;
			break;
		case "AU QA":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelAUQA;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelAUQAName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelAUQA;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelAUQAName;
			break;
		case "CA":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelCA;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelCAName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelCA;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelCAName;
			break;
		case "CA QA":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelCAQA;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelCAQAName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelCAQA;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelCAQAName;
			break;
		case "US":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelUS;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelUSName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelUS;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelUSName;
			break;
		case "US QA":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelUSQA;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelUSQAName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelUSQA;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelUSQAName;
			break;
		case "US PreProd":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelUSPreProd;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelUSPreProdName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelUSPreProd;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelUSPreProdName;
			break;
		case "D&G":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelDG;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelDGName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelDG;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelDGName;
			break;
		case "DG":
			accountingDocumentTypeLabel = accountingDocumentTypeLabelDG;
			accountingDocumentTypeLabelName = accountingDocumentTypeLabelDGName;
			accountingDocumentNumberLabel = accountingDocumentNumberLabelDG;
			accountingDocumentNumberLabelName = accountingDocumentNumberLabelDGName;
			break;
		default:
			accountingDocumentTypeLabel = new ArrayList<>();
			accountingDocumentTypeLabelName = "";
			accountingDocumentNumberLabel = new ArrayList<>();
			accountingDocumentNumberLabelName = "";
		}
		
		//Loop through the entire Accounting section
		for (int i = 2; i < accountingDocumentTypeLabel.size()-1; i++) {
			//Retrieve the Current Document Type and Document Number
			currentDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabel.get(i), accountingDocumentTypeLabelName);
			currentDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabel.get(i), accountingDocumentNumberLabelName);
			
			//Return the Accounting Row if the Document Type and Document Number match expectations
			if (currentDocumentType.equals(documentType) && currentDocumentNumber.equals(documentNumber)) {
				return i;
			} else if (documentType.equalsIgnoreCase("Ticket") && (currentDocumentType.equalsIgnoreCase("BSP Tickets") || currentDocumentType.equalsIgnoreCase("Non BSP Document") || currentDocumentType.equalsIgnoreCase("ARC Tickets") || currentDocumentType.equalsIgnoreCase("Non ARC Document")) && currentDocumentNumber.equalsIgnoreCase(documentNumber)) {
				return i;
			}
		}
		
		//Return 0 to indicate that relevant info was not found
		return 0;
	}
	
	public void openAUAccountingRowDetailPage(int accountingRow) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to an Accounting Entry Detail Page(s)");
		
		//Open the Accounting Row Details Page
		reportLoggerMethods.click(accountingDocumentTypeLabelAU.get(accountingRow), accountingDocumentTypeLabelAUName(accountingRow));
		
	}
	
	public void openCAAccountingRowDetailPage(int accountingRow) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to an Accounting Entry Detail Page(s)");
		
		//Open the Accounting Row Details Page
		reportLoggerMethods.click(accountingDocumentTypeLabelCA.get(accountingRow), accountingDocumentTypeLabelCAName(accountingRow));
		
	}
	
	public void openUSAccountingRowDetailPage(int accountingRow) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to an Accounting Entry Detail Page(s)");
		
		//Open the Accounting Row Details Page
		reportLoggerMethods.click(accountingDocumentTypeLabelUS.get(accountingRow), accountingDocumentTypeLabelUSName(accountingRow));
		
	}
	
	public void openDGAccountingRowDetailPage(int accountingRow) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to an Accounting Entry Detail Page(s)");
		
		//Open the Accounting Row Details Page
		reportLoggerMethods.click(accountingDocumentTypeLabelDG.get(accountingRow), accountingDocumentTypeLabelDGName(accountingRow));
		
	}
	
	// ~~~ Verify Clientfile Details ~~~ //
	
	public int verifyTravelerFullName(SoftAssert softAssert, String expectedFirstName, String expectedLastName) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Traveler Full Name");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		
		String actualFirstName;
		String actualLastName;
		
		//Loop through the entire list of existing Travelers in the Client File
		for (int i = 0; i < firstNameLabel.size(); i++) {
			//Retrieve the current row Traveler's Full Name
			actualFirstName = reportLoggerMethods.getText(firstNameLabel.get(i), firstNameLabelName(i+1));
			actualLastName = reportLoggerMethods.getText(lastNameLabel.get(i), lastNameLabelName(i+1));
			
			//Skip the current iteration, if the Traveler Full Name does not match
			if (!(expectedFirstName.equals(actualFirstName) && expectedLastName.equals(actualLastName))) {
				continue;
			}
			
			//Assert the Traveler Full Name
			softAssert.assertEquals(actualFirstName, expectedFirstName.toUpperCase());
			softAssert.assertEquals(actualLastName, expectedLastName.toUpperCase());
			
			//Output Success Message to the Report
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Traveler Full Name Matches Expectations");
			
			return i+1;
		}
		
		//Assert the Traveler Full Name
		softAssert.assertEquals("First Name '" + expectedFirstName + "' not found", expectedFirstName);
		softAssert.assertEquals("Last Name '" + expectedLastName + "' not found", expectedLastName);
		
		//Add to the Failure Message
		failureMessage += "Traveler Full Name (" + expectedFirstName + " " + expectedLastName + ") not found. ";
		
		//Output Failure Message to the Report
		reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyTravelerFulName");
		
		return 0;
	}
	
	public void verifyClientFileLabel(SoftAssert softAssert, String expectedClientfile) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Matrix Client File Value");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualClientfile = reportLoggerMethods.getText(clientFileLabel, clientFileLabelName);
		
		//Assert the Matrix Client File Value
		softAssert.assertEquals(actualClientfile, expectedClientfile);
		
		//Check the Matrix Client File Value
		if (!expectedClientfile.equals(actualClientfile)) {
			//Add to the Failure Message
			failureMessage += "Matrix Client File found (" + actualClientfile + ") does not match expectations (" + expectedClientfile + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Matrix Client File Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyClientFileLabel");
		}
	}
	
	public void verifyGDSLocatorLabel(SoftAssert softAssert, String expectedGDSLocator) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the GDS Locator Value");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualGDSLocator = reportLoggerMethods.getText(gdsLocatorLabel, gdsLocatorLabelName);
		
		//Assert the GDS Locator Value
		softAssert.assertEquals(actualGDSLocator, expectedGDSLocator);
		
		//Check the GDS Locator Value
		if (!expectedGDSLocator.equals(actualGDSLocator)) {
			//Add to the Failure Message
			failureMessage += "GDS Locator found (" + actualGDSLocator + ") does not match expectations (" + expectedGDSLocator + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: GDS Locator Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyGDSLocatorLabel");
		}
	}
	
	public void verifyDepartureDateLabel(SoftAssert softAssert, String expectedDepartureDate) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Departure Date");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDepartureDate = reportLoggerMethods.getText(departureDateLabel, departureDateLabelName);
		
		//Assert the Branch Value
		softAssert.assertEquals(actualDepartureDate, expectedDepartureDate);
		
		//Check the Departure Date
		if (!expectedDepartureDate.equals(actualDepartureDate)) {
			//Add to the Failure Message
			failureMessage += "Departure Date found (" + actualDepartureDate + ") does not match expectations (" + expectedDepartureDate + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Departure Date Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyDepartureDateLabel");
		}
	}
	
	public void verifyBranchLabel(SoftAssert softAssert, String expectedBranch) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Branch Value");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualBranch = reportLoggerMethods.getText(branchLabel, branchLabelName);
		
		//Assert the Branch Value
		softAssert.assertEquals(actualBranch, expectedBranch);
		
		//Check the Branch Value
		if (!expectedBranch.equals(actualBranch)) {
			//Add to the Failure Message
			failureMessage += "Branch found (" + actualBranch + ") does not match expectations (" + expectedBranch + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Branch Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyBranchLabel");
		}
	}
	
	public void verifyClientFileCode(SoftAssert softAssert, String expectedClientFileCode) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Client File Code");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualClientFileCode = reportLoggerMethods.getText(clientFileLabel, clientFileLabelName).substring(0, 3);
		
		//Assert the Client File Code
		softAssert.assertEquals(actualClientFileCode, expectedClientFileCode);
		
		//Check the Client File Code
		if (!expectedClientFileCode.equals(actualClientFileCode)) {
			//Add to the Failure Message
			failureMessage += "Client File Code found (" + actualClientFileCode + ") does not match expectations (" + expectedClientFileCode + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Client File Code Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyClientFileCode");
		}
	}
	
	// ~~~ Verify Accounting Section Details ~~~ //
	
	public void verifyAccountingListing(SoftAssert softAssert, String expectedDocumentType, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the '" + expectedDocumentType + "' Document");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: Did not locate the Document Type '" + expectedDocumentType + "' with Document Number '" + expectedDocumentNumber + "'";
		
		String expectedDocumentInfo = "Document Type '" + expectedDocumentType + "' with Document Number '" + expectedDocumentNumber + "'";
		String actualDocumentInfo = "Did not locate the Document Type '" + expectedDocumentType + "' with Document Number '" + expectedDocumentNumber + "'";
		
		//Assert the Client File Code
		softAssert.assertEquals(actualDocumentInfo, expectedDocumentInfo);
		
		//Output the Error Message
		reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyAccountingListing");
	}
	
	public void verifyAUTicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelAU.get(row), accountingDocumentTypeLabelAUName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelAU.get(row), accountingDocumentNumberLabelAUName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type - check BSP or nBSP Ticket if Docoument type is 'Ticket'
		if (expectedDocumentType.equalsIgnoreCase("Ticket")) {
			//Assert the Ticket Info
			softAssert.assertEquals("Ticket", expectedDocumentType);
			
			//Check the Document Type
			if (!(actualDocumentType.equalsIgnoreCase("BSP Tickets") || actualDocumentType.equalsIgnoreCase("Non BSP Document"))) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations ('BSP Tickets' or 'Non BSP Document'). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		} else {
			//Assert the Ticket Info
			softAssert.assertEquals(actualDocumentType, expectedDocumentType);
			
			//Check the Document Type
			if (!expectedDocumentType.equals(actualDocumentType)) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyAUTicketInfo");
		}
	}
	
	public void verifyAUTicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedSupplierCode, String expectedSupplierName, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelAU.get(row), accountingDocumentTypeLabelAUName(row));
		String actualSupplierCode = reportLoggerMethods.getText(accountingSupplierCodeLabelAU.get(row), accountingSupplierCodeLabelAUName(row));
		String actualSupplierName = reportLoggerMethods.getText(accountingSupplierNameLabelAU.get(row), accountingSupplierNameLabelAUName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelAU.get(row), accountingDocumentNumberLabelAUName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentType, expectedDocumentType);
		softAssert.assertEquals(actualSupplierCode, expectedSupplierCode);
		softAssert.assertEquals(actualSupplierName, expectedSupplierName);
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type
		if (!expectedDocumentType.equals(actualDocumentType)) {
			//Add to the Failure Message
			failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Supplier Code
		if (!expectedSupplierCode.equals(actualSupplierCode)) {
			//Add to the Failure Message
			failureMessage += "Supplier Code found (" + actualSupplierCode + ") does not match expectations (" + expectedSupplierCode + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Supplier Name
		if (!expectedSupplierName.equals(actualSupplierName)) {
			//Add to the Failure Message
			failureMessage += "Supplier Name found (" + actualSupplierName + ") does not match expectations (" + expectedSupplierName + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyAUTicketInfo");
		}
	}
	
	public void verifyCATicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelCA.get(row), accountingDocumentTypeLabelCAName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelCA.get(row), accountingDocumentNumberLabelCAName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type - check BSP or nBSP Ticket if Docoument type is 'Ticket'
		if (expectedDocumentType.equalsIgnoreCase("Ticket")) {
			//Assert the Ticket Info
			softAssert.assertEquals("Ticket", expectedDocumentType);
			
			//Check the Document Type
			if (!(actualDocumentType.equalsIgnoreCase("BSP Tickets") || actualDocumentType.equalsIgnoreCase("Non BSP Document"))) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations ('BSP Tickets' or 'Non BSP Document'). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		} else {
			//Assert the Ticket Info
			softAssert.assertEquals(actualDocumentType, expectedDocumentType);
			
			//Check the Document Type
			if (!expectedDocumentType.equals(actualDocumentType)) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyCATicketInfo");
		}
	}
	
	public void verifyCATicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedSupplierCode, String expectedSupplierName, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelCA.get(row), accountingDocumentTypeLabelCAName(row));
		String actualSupplierCode = reportLoggerMethods.getText(accountingSupplierCodeLabelCA.get(row), accountingSupplierCodeLabelCAName(row));
		String actualSupplierName = reportLoggerMethods.getText(accountingSupplierNameLabelCA.get(row), accountingSupplierNameLabelCAName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelCA.get(row), accountingDocumentNumberLabelCAName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentType, expectedDocumentType);
		softAssert.assertEquals(actualSupplierCode, expectedSupplierCode);
		softAssert.assertEquals(actualSupplierName, expectedSupplierName);
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type
		if (!expectedDocumentType.equals(actualDocumentType)) {
			//Add to the Failure Message
			failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Supplier Code
		if (!expectedSupplierCode.equals(actualSupplierCode)) {
			//Add to the Failure Message
			failureMessage += "Supplier Code found (" + actualSupplierCode + ") does not match expectations (" + expectedSupplierCode + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Supplier Name
		if (!expectedSupplierName.equals(actualSupplierName)) {
			//Add to the Failure Message
			failureMessage += "Supplier Name found (" + actualSupplierName + ") does not match expectations (" + expectedSupplierName + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyCATicketInfo");
		}
	}
	
	public void verifyUSTicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelUS.get(row), accountingDocumentTypeLabelUSName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelUS.get(row), accountingDocumentNumberLabelUSName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type - check BSP or nBSP Ticket if Docoument type is 'Ticket'
		if (expectedDocumentType.equalsIgnoreCase("Ticket")) {
			//Assert the Ticket Info
			softAssert.assertEquals("Ticket", expectedDocumentType);
			
			//Check the Document Type
			if (!(actualDocumentType.equalsIgnoreCase("ARC Tickets") || actualDocumentType.equalsIgnoreCase("Non ARC Document"))) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations ('ARC Tickets' or 'Non ARC Document'). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		} else {
			//Assert the Ticket Info
			softAssert.assertEquals(actualDocumentType, expectedDocumentType);
			
			//Check the Document Type
			if (!expectedDocumentType.equals(actualDocumentType)) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyUSTicketInfo");
		}
	}
	
	public void verifyUSQATicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedSupplierCode, String expectedSupplierName, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelUSQA.get(row), accountingDocumentTypeLabelUSQAName(row));
		String actualSupplierCode = reportLoggerMethods.getText(accountingSupplierCodeLabelUSQA.get(row), accountingSupplierCodeLabelUSQAName(row));
		String actualSupplierName = reportLoggerMethods.getText(accountingSupplierNameLabelUSQA.get(row), accountingSupplierNameLabelUSQAName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelUSQA.get(row), accountingDocumentNumberLabelUSQAName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentType, expectedDocumentType);
		softAssert.assertEquals(actualSupplierCode, expectedSupplierCode);
		softAssert.assertEquals(actualSupplierName, expectedSupplierName);
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type - check BSP or nBSP Ticket if Docoument type is 'Ticket'
		if (expectedDocumentType.equalsIgnoreCase("Ticket")) {
			//Assert the Ticket Info
			softAssert.assertEquals("Ticket", expectedDocumentType);
			
			//Check the Document Type
			if (!(actualDocumentType.equalsIgnoreCase("ARC Tickets") || actualDocumentType.equalsIgnoreCase("Non ARC Document"))) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations ('ARC Tickets' or 'Non ARC Document'). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		} else {
			//Assert the Ticket Info
			softAssert.assertEquals(actualDocumentType, expectedDocumentType);
			
			//Check the Document Type
			if (!expectedDocumentType.equals(actualDocumentType)) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Check the Supplier Code
		if (!expectedSupplierCode.equals(actualSupplierCode)) {
			//Add to the Failure Message
			failureMessage += "Supplier Code found (" + actualSupplierCode + ") does not match expectations (" + expectedSupplierCode + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Supplier Name
		if (!expectedSupplierName.equals(actualSupplierName)) {
			//Add to the Failure Message
			failureMessage += "Supplier Name found (" + actualSupplierName + ") does not match expectations (" + expectedSupplierName + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyUSQATicketInfo");
		}
	}
	
	public void verifyDGTicketInfo(SoftAssert softAssert, int row, String expectedDocumentType, String expectedDocumentNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Ticket Information (in Accounting Section)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualDocumentType = reportLoggerMethods.getText(accountingDocumentTypeLabelDG.get(row), accountingDocumentTypeLabelDGName(row));
		String actualDocumentNumber = reportLoggerMethods.getText(accountingDocumentNumberLabelDG.get(row), accountingDocumentNumberLabelDGName(row));
		
		//Assert the Ticket Info
		softAssert.assertEquals(actualDocumentNumber, expectedDocumentNumber);
		
		//Check the Document Type - check BSP or nBSP Ticket if Docoument type is 'Ticket'
		if (expectedDocumentType.equalsIgnoreCase("Ticket")) {
			//Assert the Ticket Info
			softAssert.assertEquals("Ticket", expectedDocumentType);
			
			//Check the Document Type
			if (!(actualDocumentType.equalsIgnoreCase("ARC Tickets") || actualDocumentType.equalsIgnoreCase("Non ARC Document"))) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations ('ARC Tickets' or 'Non ARC Document'). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		} else {
			//Assert the Ticket Info
			softAssert.assertEquals(actualDocumentType, expectedDocumentType);
			
			//Check the Document Type
			if (!expectedDocumentType.equals(actualDocumentType)) {
				//Add to the Failure Message
				failureMessage += "Document Type found (" + actualDocumentType + ") does not match expectations (" + expectedDocumentType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Check the Document Number
		if (!expectedDocumentNumber.equals(actualDocumentNumber)) {
			//Add to the Failure Message
			failureMessage += "Document Number found (" + actualDocumentNumber + ") does not match expectations (" + expectedDocumentNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Ticket Info in the Accounting Section Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyDGTicketInfo");
		}
	}
	
}