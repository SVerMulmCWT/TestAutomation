package queues;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.QueuesPage;
import pagemethods.itineraries.AirItineraryPage;
import utilityClasses.ExcelMethods;

public class RMITest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public RMITest() {
		super();
	}
	
	public void performSetup(String reportTitle, String scriptName) {
		//Inherit the method from the parent class
		super.performSetup(reportTitle, scriptName);
		
		//Setup PageFactories
		homePage = new HomePage(eDriver, reportLogger);
		clientfileInformationPage = new ClientfileInformationPage(eDriver, reportLogger);
		clientfilePage = new ClientfilePage(eDriver, reportLogger);
		queuesPage = new QueuesPage(eDriver, reportLogger);
		airItineraryPage = new AirItineraryPage(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Inherit the method from the parent class
		super.beforeClass();
		
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Queues");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_RMITest(String active, String reportTitle, String environment, String queueType, String searchType, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_RMITest");
			
			//Navigate to the 'Calendar/Tasks/Queues' Page
			homePage.goToQueuesPage();
			
			if (queueType.equalsIgnoreCase("RMI")) {
				//Select the RMI Queue
				queuesPage.selectRMIQueue();
			} else if (queueType.equalsIgnoreCase("RMA")) {
				//Select the RMA Queue
				queuesPage.selectRMAQueue();
			}
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(1000);
			
			//Click Search or Queue Count
			if (searchType.equalsIgnoreCase("Search")) {
				queuesPage.clickSearch();
			} else if(searchType.equalsIgnoreCase("Queue Count")) {
				queuesPage.clickQueueCount();
			}
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(1000);
			
			//Verify RMI Search/Queue-Count Results
			queuesPage.verifySearchResults(checkpoint);
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}