package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.QueuesLocators;

public class QueuesPage extends QueuesLocators {
	
	//Constructor
	public QueuesPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Tasks/Queues Section ~~~ //
	
	public void selectRMIQueue() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Selecting the RMI Queue");
		
		//Click the Type Drop-Down
		reportLoggerMethods.click(queueTypeDropDown, queueTypeDropDownName);
		
		//Select the 'RMI' Option
		reportLoggerMethods.click(rmiOption, rmiOptionName);
	}
	
	public void selectRMAQueue() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Selecting the RMA Queue");
		
		//Click the Type Drop-Down
		reportLoggerMethods.click(queueTypeDropDown, queueTypeDropDownName);
		
		//Select the 'RMI' Option
		reportLoggerMethods.click(rmaOption, rmaOptionName);
	}
	
	public void clickSearch() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Clicking 'Search'");
		
		//Click the 'Search' Button
		reportLoggerMethods.click(searchButton, searchButtonName);
	}
	
	public void clickQueueCount() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Clicking 'Queue Count'");
		
		//Click the 'Queue Count' Button
		reportLoggerMethods.click(queueCountButton, queueCountButtonName);
	}
	
	public void verifySearchResults(SoftAssert softAssert) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying RMI Search/Queue-Count Results");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		boolean searchResults = reportLoggerMethods.isDisplayed(searchResult1Row, searchResult1RowName);
		boolean queueCountResults = reportLoggerMethods.isDisplayed(queueCountResult1, queueCountResult1Name);
		boolean noSearchResults = reportLoggerMethods.isDisplayed(noResultsLabel, noResultsLabelName);
		
		//Check if Search Results were returned
		if (searchResults || queueCountResults || noSearchResults) {
			//Assert the Itinerary Values
			softAssert.assertEquals(true, true);
		} else {
			//Assert the Itinerary Values
			softAssert.assertEquals(false, true);
			
			//Add to the Failure Message
			failureMessage += "The Search/Queue-Count did not properly return Searched Results or a 'No Results' message";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: The Tasks/Queues Search/Queue-Count Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifySearchResults");
		}
	}
	
}