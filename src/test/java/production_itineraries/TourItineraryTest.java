package production_itineraries;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.ClientfileInformationPage;
import pagemethods.ClientfilePage;
import pagemethods.HomePage;
import pagemethods.itineraries.TourItineraryPage;
import utilityClasses.ExcelMethods;

public class TourItineraryTest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public TourItineraryTest() {
		super();
	}
	
	public void performSetup(String reportTitle, String scriptName) {
		//Inherit the method from the parent class
		super.performSetup(reportTitle, scriptName);
		
		//Setup PageFactories
		homePage = new HomePage(eDriver, reportLogger);
		clientfileInformationPage = new ClientfileInformationPage(eDriver, reportLogger);
		clientfilePage = new ClientfilePage(eDriver, reportLogger);
		tourItineraryPage = new TourItineraryPage(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Inherit the method from the parent class
		super.beforeClass();
		
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Tour Itinerary");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_TourItineraryTest(String active, String reportTitle, String environment, String cfaSearch, String segmentNumber, String tourOperator, String departureCity, String arrivalCity, String departureDate, String unitType, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_TourItineraryTest");
			
			//Search for a Clientfile
			if (!cfaSearch.equalsIgnoreCase("")) {
				//Navigate to the 'Clientfile Information' Page
				homePage.goToClientfileInformationPage();
				
				//Search for a Clientfile
				clientfileInformationPage.searchClientfile("", "", "", "", cfaSearch, "", "", "", "", "", "");
			}
			
			//Navigate to the Tour Itinerary Page
			clientfilePage.openTourItineraryPage(segmentNumber);
			
			//Verify the Tour Itinerary Info
			tourItineraryPage.verifyTourItinerary(checkpoint, environment, tourOperator, departureCity, arrivalCity, departureDate, unitType);
			
			//Exit the Itinerary Page
			tourItineraryPage.closePage();
			
			//Close the Itinerary Section
			clientfilePage.closeItinerarySection();
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}