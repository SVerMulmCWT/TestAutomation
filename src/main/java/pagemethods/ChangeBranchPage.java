package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.ChangeBranchLocators;

public class ChangeBranchPage extends ChangeBranchLocators {
	
	//Constructor
	public ChangeBranchPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Search Clientfile ~~~ //
	
	public void changeBranch(String changeBranchCode) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Changing the current branch to -> " + changeBranchCode);
		
		//Enter the 'Change Branch Code'
		reportLoggerMethods.sendKeys(changeBranchCodeField, changeBranchCodeFieldFieldName, changeBranchCode);
		
		//Click 'Change'
		reportLoggerMethods.click(searchButton, searchButtonName);
	}
	
}