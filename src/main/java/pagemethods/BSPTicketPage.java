package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.BSPTicketLocators;

public class BSPTicketPage extends BSPTicketLocators {
	
	//Constructor
	public BSPTicketPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ BSP Ticket Page ~~~ //
	
	public void closePage() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Exiting the BSP Ticket Page");
		
		//Exit the BSP Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	// ~~~ Verify Methods ~~~ //
	
	public void verifyBSPTicket(SoftAssert softAssert, String expectedTicketNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the BSP Ticket's Detail Page Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualTicketNumber = reportLoggerMethods.getAttribute(ticketNumberField, ticketNumberFieldName, "value");
		
		//Assert the BSP Ticket Number
		softAssert.assertEquals(actualTicketNumber, expectedTicketNumber);
		
		//Check the Ticket Number
		if (!expectedTicketNumber.equals(actualTicketNumber)) {
			//Add to the Failure Message
			failureMessage += "Ticket Number found (" + actualTicketNumber + ") does not match expectations (" + expectedTicketNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: BSP Ticket Detail Page Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyBSPTicket");
		}
	}
	
	public void verifyBSPTicket(SoftAssert softAssert, String expectedSupplierCode, String expectedTicketNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the BSP Ticket's Detail Page Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		expectedSupplierCode = expectedSupplierCode.trim();
		
		String actualSupplier = reportLoggerMethods.getAttribute(supplierField, supplierFieldName, "value").trim();
		String actualTicketNumber = reportLoggerMethods.getAttribute(ticketNumberField, ticketNumberFieldName, "value");
		
		//Assert the BSP Ticket Number
		softAssert.assertEquals(actualSupplier, expectedSupplierCode);
		softAssert.assertEquals(actualTicketNumber, expectedTicketNumber);
		
		//Check the Supplier
		if (!expectedSupplierCode.equals(actualSupplier)) {
			//Add to the Failure Message
			failureMessage += "Supplier found (" + actualSupplier + ") does not match expectations (" + expectedSupplierCode + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Ticket Number
		if (!expectedTicketNumber.equals(actualTicketNumber)) {
			//Add to the Failure Message
			failureMessage += "Ticket Number found (" + actualTicketNumber + ") does not match expectations (" + expectedTicketNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: BSP Ticket Detail Page Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyBSPTicket");
		}
	}
	
}