package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.TravelerPage;
import utilityClasses.ExcelMethods;

public class ClientfileSearchTest_Traveller extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public ClientfileSearchTest_Traveller() {
		super();
	}
	
	public void performSetup(String reportTitle, String scriptName) {
		//Inherit the method from the parent class
		super.performSetup(reportTitle, scriptName);
		
		//Setup PageFactories
		homePage = new HomePage(eDriver, reportLogger);
		clientfileInformationPage = new ClientfileInformationPage(eDriver, reportLogger);
		clientfilePage = new ClientfilePage(eDriver, reportLogger);
		travelerPage = new TravelerPage(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Inherit the method from the parent class
		super.beforeClass();
		
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Clientfile Search");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_ClientfileSearchTest(String active, String reportTitle, String environment, String lastName, String firstName, String pnr, String departureDate, String clientFileNumber, String bookingBranch, String documentType, String documentNumber, String supplierBookingNumber, String clientFileCode, String ticketingBranch, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_ClientfileSearchTest");
			
			//Navigate to the 'Clientfile Information' Page
			homePage.goToClientfileInformationPage();
			
			//Search for a Clientfile
			clientfileInformationPage.searchClientfile(lastName, firstName, pnr, departureDate, clientFileNumber, documentType, bookingBranch, documentNumber, supplierBookingNumber, clientFileCode, ticketingBranch);
			
//			//Navigate to the Traveler Page(s)
//			clientfilePage.openTravelerPage(checkpoint, lastName);
//			
//			//Verify the Traveler Info
//			travelerPage.verifyTraveler(checkpoint, lastName);
			
			//Exit the Traveler Page(s)
			travelerPage.closePage(checkpoint, lastName);
			
			//Close the Traveler Section
			clientfilePage.closeTravelerSection();
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}