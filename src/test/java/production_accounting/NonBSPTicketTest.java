package production_accounting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.NonBSPTicketPage;
import pagemethods.TravelerPage;
import utilityClasses.ExcelMethods;

public class NonBSPTicketTest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public NonBSPTicketTest() {
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
		nonbspTicketPage = new NonBSPTicketPage(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Inherit the method from the parent class
		super.beforeClass();
		
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Non-BSP Ticket");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_NonBSPTicketTest(String active, String reportTitle, String environment, String cfaSearch, String documentType, String supplierCode, String supplierName, String documentNumber, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_NonBSPTicketTest");
			
			//Search for a Clientfile
			if (!cfaSearch.equalsIgnoreCase("")) {
				//Navigate to the 'Clientfile Information' Page
				homePage.goToClientfileInformationPage();
				
				//Search for a Clientfile
				clientfileInformationPage.searchClientfile("", "", "", "", cfaSearch, "", "", "", "", "", "");
			}
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(3000);
			
			//Locate the Accounting row for the relevant Ticket
			int accountingRow = clientfilePage.searchAccountingSection(environment, documentType, documentNumber);
			
			//Verify the Ticket Document Number
			if (accountingRow == 0) {
				clientfilePage.verifyAccountingListing(checkpoint, documentType, documentNumber);
			} else if (environment.equalsIgnoreCase("AU") || environment.equalsIgnoreCase("AU Pre-Prod") || environment.equalsIgnoreCase("AU PreProd") || environment.equalsIgnoreCase("AU QA")) {
				//Verify Ticket Info in Accounting Section
				clientfilePage.verifyAUTicketInfo(checkpoint, accountingRow, documentType, supplierCode, supplierName, documentNumber);
				//Open the Ticket Page
				clientfilePage.openAUAccountingRowDetailPage(accountingRow);
				//Verify the Ticket Number in the Ticket Detailed Page
				nonbspTicketPage.verifyNonBSPTicket(checkpoint, supplierCode, documentNumber);
				//Close the Ticket Page
				nonbspTicketPage.closePage();
			} else if (environment.equalsIgnoreCase("CA") || environment.equalsIgnoreCase("CA Pre-Prod") || environment.equalsIgnoreCase("CA PreProd") || environment.equalsIgnoreCase("CA QA")) {
				//Verify Ticket Info in Accounting Section
				clientfilePage.verifyCATicketInfo(checkpoint, accountingRow, documentType, supplierCode, supplierName, documentNumber);
				//Open the Ticket Page
				clientfilePage.openCAAccountingRowDetailPage(accountingRow);
				//Verify the Ticket Number in the Ticket Detailed Page
				nonbspTicketPage.verifyNonBSPTicket(checkpoint, supplierCode, documentNumber);
				//Close the Ticket Page
				nonbspTicketPage.closePage();
			} else if (environment.equalsIgnoreCase("US")) {
				//Verify Ticket Info in Accounting Section
				clientfilePage.verifyUSTicketInfo(checkpoint, accountingRow, documentType, documentNumber);
				//Open the Ticket Page
				clientfilePage.openUSAccountingRowDetailPage(accountingRow);
				//Verify the Ticket Number in the Ticket Detailed Page
				nonbspTicketPage.verifyNonBSPTicket(checkpoint, supplierCode, documentNumber);
				//Close the Ticket Page
				nonbspTicketPage.closePage();
			} else if (environment.equalsIgnoreCase("US Pre-Prod") || environment.equalsIgnoreCase("US PreProd") || environment.equalsIgnoreCase("US QA")) {
				//Verify Ticket Info in Accounting Section
				clientfilePage.verifyUSQATicketInfo(checkpoint, accountingRow, documentType, supplierCode, supplierName, documentNumber);
				//Open the Ticket Page
				clientfilePage.openUSAccountingRowDetailPage(accountingRow);
				//Verify the Ticket Number in the Ticket Detailed Page
				nonbspTicketPage.verifyNonBSPTicket(checkpoint, supplierCode, documentNumber);
				//Close the Ticket Page
				nonbspTicketPage.closePage();
			} else if (environment.equalsIgnoreCase("D&G") || environment.equalsIgnoreCase("DG") || environment.equalsIgnoreCase("D&G Pre-Prod") || environment.equalsIgnoreCase("DG Pre-Prod") || environment.equalsIgnoreCase("D&G PreProd") || environment.equalsIgnoreCase("DG PreProd") || environment.equalsIgnoreCase("D&G QA") || environment.equalsIgnoreCase("DG QA")) {
				//Verify Ticket Info in Accounting Section
				clientfilePage.verifyDGTicketInfo(checkpoint, accountingRow, documentType, documentNumber);
				//Open the Ticket Page
				clientfilePage.openDGAccountingRowDetailPage(accountingRow);
				//Verify the Ticket Number in the Ticket Detailed Page
				nonbspTicketPage.verifyNonBSPTicket(checkpoint, supplierCode, documentNumber);
				//Close the Ticket Page
				nonbspTicketPage.closePage();
			}
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}