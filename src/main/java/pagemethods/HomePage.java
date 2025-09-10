package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.HomeLocators;

public class HomePage extends HomeLocators {
	
	//Constructor
	public HomePage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Navigate to Pages ~~~ //
	
	public void goToClientfileInformationPage() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the 'Clientfile Information' Page");
		
		//Click the 'View' Drop-Down
		reportLoggerMethods.click(viewDropDown, viewDropDownName);
		
		//Click the 'Clientfile Information' Option
		reportLoggerMethods.click(viewClientfileInformationOption, viewClientfileInformationOptionName);
	}
	
	public void goToQueuesPage() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the 'Calendar/Tasks/Queues' Page");
		
		//Click the 'View' Drop-Down
		reportLoggerMethods.click(viewDropDown, viewDropDownName);
		
		//Click the 'Clientfile Information' Option
		reportLoggerMethods.click(viewCalendarTasksQueuesOption, viewCalendarTasksQueuesOptionName);
	}
	
	public void goToChangeBranchPage() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the 'Change Branch' Page");
		
		//Click the 'View' Drop-Down
		reportLoggerMethods.click(changeBranchDropDown, changeBranchDropDownName);
		
		//Click the 'Clientfile Information' Option
		reportLoggerMethods.click(changeBranchOption, changeBranchOptionName);
	}
	
	// ~~~ Header Label Checks ~~~ //
	
	public void verifyChangedBranch(SoftAssert softAssert, String expectedBranchLabel) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Branch Label -> " + expectedBranchLabel);
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualBranchLabel = reportLoggerMethods.getText(branchLabelField, branchLabelFieldName);
		actualBranchLabel = actualBranchLabel.trim();
		
		//Assert the Branch Label Value
		softAssert.assertEquals(actualBranchLabel, expectedBranchLabel);
		
		//Check the Branch Label Info
		if (!expectedBranchLabel.equals(actualBranchLabel)) {
			//Add to the Failure Message
			failureMessage += "Branch Label found (" + actualBranchLabel + ") does not match expectations (" + expectedBranchLabel + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Branch Label Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyChangedBranch");
		}
	}
	
}