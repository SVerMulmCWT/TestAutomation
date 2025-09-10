package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.MiscItineraryLocators;

public class MiscItineraryPage extends MiscItineraryLocators {
	
	//Constructor
	public MiscItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyMiscItinerary(SoftAssert softAssert, String environment, String expectedTourOperator, String expectedDepartureCity, String expectedArrivalCity, String expectedDepartureDate, String expectedUnitType) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Miscellaneous Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualTourOperator = reportLoggerMethods.getAttribute(tourOperatorField, tourOperatorFieldName, "value");
		String actualDepartureCity = reportLoggerMethods.getAttribute(departureCityField, departureCityFieldName, "value");
		String actualArrivalCity = reportLoggerMethods.getAttribute(arrivalCityField, arrivalCityFieldName, "value");
		String actualDepartureDate = reportLoggerMethods.getAttribute(departureDateField, departureDateFieldName, "value");
		
		//Check AU Specific Info
		if (environment.equalsIgnoreCase("au") || environment.equalsIgnoreCase("Australia")) {
			//Initialize Variable(s)
			String actualUnitType = reportLoggerMethods.getAttribute(unitTypeField, unitTypeFieldName, "value");
			
			//Assert the Last Name Value
			softAssert.assertEquals(actualUnitType, expectedUnitType);
			
			//Check the Unit Type Info
			if (!expectedUnitType.equals(actualUnitType)) {
				//Add to the Failure Message
				failureMessage += "Unit Type found (" + actualUnitType + ") does not match expectations (" + expectedUnitType + "). ";
				
				//Indicate that the Check failed
				accurateVerifyInfo = false;
			}
		}
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualTourOperator, expectedTourOperator);
		softAssert.assertEquals(actualDepartureCity, expectedDepartureCity);
		softAssert.assertEquals(actualArrivalCity, expectedArrivalCity);
		softAssert.assertEquals(actualDepartureDate, expectedDepartureDate);
		
		//Check the Tour Operator Info
		if (!expectedTourOperator.equals(actualTourOperator)) {
			//Add to the Failure Message
			failureMessage += "Tour Operator found (" + actualTourOperator + ") does not match expectations (" + expectedTourOperator + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Departure City Info
		if (!expectedDepartureCity.equals(actualDepartureCity)) {
			//Add to the Failure Message
			failureMessage += "Departure City found (" + actualDepartureCity + ") does not match expectations (" + expectedDepartureCity + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Arrival City Info
		if (!expectedArrivalCity.equals(actualArrivalCity)) {
			//Add to the Failure Message
			failureMessage += "Arrival City found (" + actualArrivalCity + ") does not match expectations (" + expectedArrivalCity + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Departure Date Info
		if (!expectedDepartureDate.equals(actualDepartureDate)) {
			//Add to the Failure Message
			failureMessage += "Departure Date found (" + actualDepartureDate + ") does not match expectations (" + expectedDepartureDate + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Misc Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyMiscItinerary");
		}
	}
	
}