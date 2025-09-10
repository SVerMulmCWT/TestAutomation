package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.BusItineraryLocators;

public class BusItineraryPage extends BusItineraryLocators {
	
	//Constructor
	public BusItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyBusItinerary(SoftAssert softAssert, String expectedSupplier, String expectedBusNumber, String expectedDepartureCity, String expectedArrivalCity, String expectedDepartureDate, String expectedClass) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Bus Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualSupplier = reportLoggerMethods.getAttribute(supplierField, supplierFieldName, "value");
		String actualBusNumber = reportLoggerMethods.getAttribute(busNumberField, busNumberFieldName, "value");
		String actualDepartureCity = reportLoggerMethods.getAttribute(departureCityField, departureCityFieldName, "value");
		String actualArrivalCity = reportLoggerMethods.getAttribute(arrivalCityField, arrivalCityFieldName, "value");
		String actualDepartureDate = reportLoggerMethods.getAttribute(departureDateField, departureDateFieldName, "value");
		String actualClass = reportLoggerMethods.getAttribute(classField, classFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualSupplier, expectedSupplier);
		softAssert.assertEquals(actualBusNumber, expectedBusNumber);
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
		
		//Check the Bus Number Info
		if (!expectedBusNumber.equals(actualBusNumber)) {
			//Add to the Failure Message
			failureMessage += "Bus Number found (" + actualBusNumber + ") does not match expectations (" + expectedBusNumber + "). ";
			
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
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Bus Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyBusItinerary");
		}
	}
	
}