package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.RailItineraryLocators;

public class RailItineraryPage extends RailItineraryLocators {
	
	//Constructor
	public RailItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyRailItinerary(SoftAssert softAssert, String expectedSupplier, String expectedRailNumber, String expectedDepartureCity, String expectedArrivalCity, String expectedDepartureDate, String expectedClass) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Rail Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualSupplier = reportLoggerMethods.getAttribute(supplierField, supplierFieldName, "value");
		String actualRailNumber = reportLoggerMethods.getAttribute(trainNumberField, trainNumberFieldName, "value");
		String actualDepartureCity = reportLoggerMethods.getAttribute(departureCityField, departureCityFieldName, "value");
		String actualArrivalCity = reportLoggerMethods.getAttribute(arrivalCityField, arrivalCityFieldName, "value");
		String actualDepartureDate = reportLoggerMethods.getAttribute(departureDateField, departureDateFieldName, "value");
		String actualClass = reportLoggerMethods.getAttribute(classField, classFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualSupplier, expectedSupplier);
		softAssert.assertEquals(actualRailNumber, expectedRailNumber);
		softAssert.assertEquals(actualDepartureCity, expectedDepartureCity);
		softAssert.assertEquals(actualArrivalCity, expectedArrivalCity);
		softAssert.assertEquals(actualDepartureDate, expectedDepartureDate);
		softAssert.assertEquals(actualClass, expectedClass);
		
		//Check the Supplier Info
		if (!expectedSupplier.equals(actualSupplier)) {
			//Add to the Failure Message
			failureMessage += "Supplier found (" + actualSupplier + ") does not match expectations (" + expectedSupplier + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Train Number Info
		if (!expectedRailNumber.equals(actualRailNumber)) {
			//Add to the Failure Message
			failureMessage += "Train Number found (" + actualRailNumber + ") does not match expectations (" + expectedRailNumber + "). ";
			
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
		
		//Check the Class Info
		if (!expectedClass.equals(actualClass)) {
			//Add to the Failure Message
			failureMessage += "Class found (" + actualClass + ") does not match expectations (" + expectedClass + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Train Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyRailItinerary");
		}
	}
	
}