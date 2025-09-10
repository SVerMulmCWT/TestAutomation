package pagemethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.ClientfileInformationLocators;

public class ClientfileInformationPage extends ClientfileInformationLocators {
	
	//Constructor
	public ClientfileInformationPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Search Clientfile ~~~ //
	
	public void selectDocumentType(String doocumentType, String ticketingBranch) {
		//Click the 'Document Type' Drop-Dpwn
		reportLoggerMethods.click(documentTypeDropDown, documentTypeDropDownName);
		
		switch (doocumentType) {
		case "": //Select the '(Blank)' Option
			reportLoggerMethods.click(documentTypeBlankOption, documentTypeBlankOptionName);
			break;
		case "Cheque": //Select the 'Cheque' Option
			reportLoggerMethods.click(documentTypeChequeOption, documentTypeChequeOptionName);
			break;
		case "EFT Receipt": //Select the 'EFT Receipt' Option
			reportLoggerMethods.click(documentTypeEFTReceiptOption, documentTypeEFTReceiptOptionName);
			break;
		case "GDS Invoice": //Select the 'GDS Invoice' Option
			reportLoggerMethods.click(documentTypeGDSInvoiceOption, documentTypeGDSInvoiceOptionName);
			break;
		case "Matrix Invoice": //Select the 'Matrix Invoice' Option
			reportLoggerMethods.click(documentTypeMatrixInvoiceOption, documentTypeMatrixInvoiceOptionName);
			break;
		case "Matrix Receipt": //Select the 'Matrix Receipt' Option
			reportLoggerMethods.click(documentTypeMatrixReceiptOption, documentTypeMatrixReceiptOptionName);
			break;
		case "Servicefee": //Select the 'Servicefee' Option
			reportLoggerMethods.click(documentTypeServicefeeOption, documentTypeServicefeeOptionName);
			break;
		case "Ticket": //Select the 'Ticket' Option
			reportLoggerMethods.click(documentTypeTicketOption, documentTypeTicketOptionName);
			
			//Enter the 'Ticketing Branch' Info
			reportLoggerMethods.sendKeys(TicketingBranchField, TicketingBranchFieldName, ticketingBranch);
			break;
		}
	}
	
	public void searchClientfile(String lastName, String firstName, String pnr, String departureDate, String clientFileNumber, String documentType, String bookingBranch, String documentNumber, String supplierBookingNumber, String clientFileCode, String ticketingBranch) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Searching for a Clientfile");
		
		//Enter the 'Last Name' Search Criteria
		reportLoggerMethods.sendKeys(lastNameField, lastNameFieldName, lastName);
		
		//Enter the 'First Name' Search Criteria
		reportLoggerMethods.sendKeys(firstNameField, firstNameFieldName, firstName);
		
		//Enter the 'PNR' Search Criteria
		reportLoggerMethods.sendKeys(pnrLocatorField, pnrLocatorFieldName, pnr);
		
		//Click to focus on the 'Departure Date' Field
		reportLoggerMethods.click(departureDateField, departureDateFieldName);
		
		//Move the focus to the farthest left part of the 'Departure Date' Field
		for (int i = 0; i < 10; i++) {
			reportLoggerMethods.sendKeys(departureDateField, departureDateFieldName, Keys.ARROW_LEFT);
		}
		
		//Enter the 'Departure Date' Search Criteria
		reportLoggerMethods.sendKeys(departureDateField, departureDateFieldName, departureDate);
		
		//Enter the 'Client File Number' Search Criteria
		reportLoggerMethods.sendKeys(clientFileNumberField, clientFileNumberFieldName, clientFileNumber);
		
		//Enter the 'Booking Branch' Search Criteria
		reportLoggerMethods.sendKeys(bookingBranchField, bookingBranchFieldName, bookingBranch);
		
		//Click the 'Document Type' Drop-Dpwn
		selectDocumentType(documentType, ticketingBranch);
				
		//Enter the 'Document Number' Search Criteria
		reportLoggerMethods.sendKeys(documentNumberField, documentNumberFieldName, documentNumber);
		
		//Enter the 'Supplier Booking Number' Search Criteria
		reportLoggerMethods.sendKeys(supplierBookingNumberField, supplierBookingNumberFieldName, supplierBookingNumber);
		
		//Enter the 'Client File Code' Search Criteria
		reportLoggerMethods.sendKeys(clientFileCodeField, clientFileCodeFieldName, clientFileCode);
		
		//Pause the script for a bit
		genMethods.waitForMilliseconds(1000);
		
		//Click out of the Input Fields
		reportLoggerMethods.click(clientFileSearchLabel, clientFileSearchLabelName);
		
		//Pause the script for a bit
		genMethods.waitForMilliseconds(1000);
		
		//Click 'Search'
		reportLoggerMethods.click(searchButton, searchButtonName);
		
		//Click the First Search Result, if it exists
		try {
			firstSearchResult.click();
		} catch (Exception e) {
			
		}
	}
	
}