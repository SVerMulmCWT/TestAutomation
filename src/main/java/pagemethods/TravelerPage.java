package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.TravelerLocators;

public class TravelerPage extends TravelerLocators {
	
	//Constructor
	public TravelerPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Traveler Page ~~~ //
	
	public void closePage(SoftAssert softAssert, String lastName) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Exiting the Traveler Page");
		
		//Exit the Traveler Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	// ~~~ Verify Methods ~~~ //
	
	public void verifyTraveler(SoftAssert softAssert, String expectedFirstName, String expectedLastName) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Traveler Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualFirstName = reportLoggerMethods.getAttribute(firstNameField, firstNameFieldName, "value");
		String actualLastName = reportLoggerMethods.getAttribute(lastNameField, lastNameFieldName, "value");
		
		//Assert the Full Name Values
		softAssert.assertEquals(actualFirstName, expectedFirstName.toUpperCase());
		softAssert.assertEquals(actualLastName, expectedLastName.toUpperCase());
		
		//Check the Traveler First Name
		if (!expectedFirstName.equals(actualFirstName)) {
			//Add to the Failure Message
			failureMessage += "First Name found (" + actualFirstName + ") does not match expectations (" + expectedFirstName + ")";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Traveler Name Info
		if (!expectedLastName.equals(actualLastName)) {
			//Add to the Failure Message
			failureMessage += "Last Name found (" + actualLastName + ") does not match expectations (" + expectedLastName + ")";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Traveler Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "VerfyTraveler");
		}
	}
	
}