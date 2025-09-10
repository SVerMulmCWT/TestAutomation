package general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.BSPTicketPage;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.NonBSPTicketPage;
import pagemethods.TravelerPage;
import utilityClasses.ExcelMethods;

public class ClientfileSearchTest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public ClientfileSearchTest() {
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
		bspTicketPage = new BSPTicketPage(eDriver, reportLogger);
		nonbspTicketPage = new NonBSPTicketPage(eDriver, reportLogger);
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
	public void testcases_ClientfileSearchTest(String active, String reportTitle, String environment, String lastName, String firstName, String pnr, String departureDate, String expectedDepartureDate, String clientFileNumber, String expectedClientFileNumber, String bookingBranch, String expectedBookingBranch, String documentType, String documentNumber, String supplierBookingNumber, String clientFileCode, String ticketingBranch, String finalResult, String dataRow) {
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
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(3000);
			
			//Check the Traveler Full Name, if applicable
			if (!lastName.equalsIgnoreCase("") && !firstName.equalsIgnoreCase("")) {
				//Expand the Traveler Section
				clientfilePage.expandTravelerSection();
				
				//Pause the script for a bit
				genMethods.waitForMilliseconds(1000);
				
				//Verify the Traveler Full Name
				int travelerNameRow = clientfilePage.verifyTravelerFullName(checkpoint, firstName, lastName);
				 
				//Navigate to the Traveler Page
				clientfilePage.openTravelerPage(travelerNameRow);
				
				//Verify the Traveler Info
				travelerPage.verifyTraveler(checkpoint, firstName, lastName);
				
				//Exit the Traveler Page(s)
				travelerPage.closePage(checkpoint, lastName);
				
				//Close the Traveler Section
				clientfilePage.closeTravelerSection();
			}
			
			//Check the PNR Value, if applicable
			if (!pnr.equalsIgnoreCase("")) {
				//Verify the GDS Locator Value
				clientfilePage.verifyGDSLocatorLabel(checkpoint, pnr);
			}
			
			//Check the Departure Date Value, if applicable
			if (!departureDate.equalsIgnoreCase("")) {
				//Verify the Departure Date
				clientfilePage.verifyDepartureDateLabel(checkpoint, expectedDepartureDate);
			}
			
			//Check the Matrix Client File Value, if applicable
			if (!clientFileNumber.equalsIgnoreCase("")) {
				//Verify the Matrix Client File Value
				clientfilePage.verifyClientFileLabel(checkpoint, expectedClientFileNumber);
			}
			
			//Check the Branch Value, if applicable
			if (!bookingBranch.equalsIgnoreCase("")) {
				//Verify the Branch Value
				clientfilePage.verifyBranchLabel(checkpoint, expectedBookingBranch);
			}
			
			//Check the Ticket Document Number Value, if applicable
			if (!documentNumber.equalsIgnoreCase("")) {
				//Locate the Accounting row for the relevant Ticket
				int accountingRow = clientfilePage.searchAccountingSection(environment, documentType, documentNumber);
				
				//Verify the Ticket Document Number
				if (accountingRow == 0) {
					clientfilePage.verifyAccountingListing(checkpoint, documentType, documentNumber);
				} else if (environment.equalsIgnoreCase("AU")) {
					//Verify Ticket Info in Accounting Section
					clientfilePage.verifyAUTicketInfo(checkpoint, accountingRow, documentType, documentNumber);
					//Open the Ticket Page
					clientfilePage.openAUAccountingRowDetailPage(accountingRow);
					//Verify the Ticket Number in the Ticket Detailed Page
					bspTicketPage.verifyBSPTicket(checkpoint, documentNumber);
					//Close the Ticket Page
					bspTicketPage.closePage();
				} else if (environment.equalsIgnoreCase("CA")) {
					//Verify Ticket Info in Accounting Section
					clientfilePage.verifyCATicketInfo(checkpoint, accountingRow, documentType, documentNumber);
					//Open the Ticket Page
					clientfilePage.openCAAccountingRowDetailPage(accountingRow);
					//Verify the Ticket Number in the Ticket Detailed Page
					bspTicketPage.verifyBSPTicket(checkpoint, documentNumber);
					//Close the Ticket Page
					bspTicketPage.closePage();
				} else if (environment.equalsIgnoreCase("US")) {
					//Verify Ticket Info in Accounting Section
					clientfilePage.verifyUSTicketInfo(checkpoint, accountingRow, documentType, documentNumber);
					//Open the Ticket Page
					clientfilePage.openUSAccountingRowDetailPage(accountingRow);
					//Verify the Ticket Number in the Ticket Detailed Page
					bspTicketPage.verifyBSPTicket(checkpoint, documentNumber);
					//Close the Ticket Page
					bspTicketPage.closePage();
				} else if (environment.equalsIgnoreCase("D&G") || environment.equalsIgnoreCase("DG")) {
					//Verify Ticket Info in Accounting Section
					clientfilePage.verifyDGTicketInfo(checkpoint, accountingRow, documentType, documentNumber);
					//Open the Ticket Page
					clientfilePage.openDGAccountingRowDetailPage(accountingRow);
					//Verify the Ticket Number in the Ticket Detailed Page
					bspTicketPage.verifyBSPTicket(checkpoint, documentNumber);
					//Close the Ticket Page
					bspTicketPage.closePage();
				}
			}
			
			//Check the Client File Code, if applicable
			if (!clientFileCode.equalsIgnoreCase("")) {
				//Verify the Client File Code
				clientfilePage.verifyClientFileCode(checkpoint, clientFileCode);
			}
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}