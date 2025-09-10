package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.NonBSPTicketLocators;

public class NonBSPTicketPage extends NonBSPTicketLocators {
	
	//Constructor
	public NonBSPTicketPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Non-BSP Ticket Page ~~~ //
	
	public void closePage() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Exiting the Non-BSP Ticket Page");
		
		//Exit the Non-BSP Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	// ~~~ Verify Methods ~~~ //
	
	public void verifyNonBSPTicketNumber(SoftAssert softAssert, String expectedTicketNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Non-BSP Ticket's Ticket Number (listed in the Non-BSP Ticket Detailed Page)");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualTicketNumber = reportLoggerMethods.getAttribute(ticketNumberField, ticketNumberFieldName, "value");
		
		//Assert the Non-BSP Ticket Number
		softAssert.assertEquals(actualTicketNumber, expectedTicketNumber);
		
		//Check the Ticket Number
		if (!expectedTicketNumber.equals(actualTicketNumber)) {
			//Add to the Failure Message
			failureMessage += "Ticket Number found (" + actualTicketNumber + ") does not match expectations (" + expectedTicketNumber + ")";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Non-BSP Ticket Detail Page Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyNonBSPTicketNumber");
		}
	}
	
	public void verifyNonBSPTicket(SoftAssert softAssert, String expectedSupplier, String expectedTicketNumber) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Non-BSP Ticket Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		expectedSupplier = expectedSupplier.trim();
		
		String actualSupplier = reportLoggerMethods.getText(supplierField, supplierFieldName).trim();
		String actualTicketNumber = reportLoggerMethods.getAttribute(ticketNumberField, ticketNumberFieldName, "value");
		
		//Assert the Non-BSP Ticket Details
		softAssert.assertEquals(actualSupplier, expectedSupplier.toUpperCase());
		softAssert.assertEquals(actualTicketNumber, expectedTicketNumber.toUpperCase());
		
		//Check the Supplier
		if (!expectedSupplier.equals(actualSupplier)) {
			//Add to the Failure Message
			failureMessage += "Supplier found (" + actualSupplier + ") does not match expectations (" + expectedSupplier + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Ticket Number Info
		if (!expectedTicketNumber.equals(actualTicketNumber)) {
			//Add to the Failure Message
			failureMessage += "Ticket Number found (" + actualTicketNumber + ") does not match expectations (" + expectedTicketNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Non-BSP Ticket Detail Page Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyNonBSPTicket");
		}
	}
	
}