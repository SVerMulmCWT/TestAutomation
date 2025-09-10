package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.AirItineraryLocators;

public class AirItineraryPage extends AirItineraryLocators {
	
	//Constructor
	public AirItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyAirItinerary(SoftAssert softAssert, String expectedAirline, String expectedFlightNumber, String expectedClass, String expectedDepartureCity, String expectedArrivalCity, String expectedDepartureDate) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Air Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualAirline = reportLoggerMethods.getAttribute(airlineField, airlineFieldName, "value");
		String actualFlightNumber = reportLoggerMethods.getAttribute(flightNumberField, flightNumberFieldName, "value");
		String actualClass = reportLoggerMethods.getAttribute(classField, classFieldName, "value");
		String actualDepartureCity = reportLoggerMethods.getAttribute(departureCityField, departureCityFieldName, "value");
		String actualArrivalCity = reportLoggerMethods.getAttribute(arrivalCityField, arrivalCityFieldName, "value");
		String actualDepartureDate = reportLoggerMethods.getAttribute(departureDateField, departureDateFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualAirline, expectedAirline);
		softAssert.assertEquals(actualFlightNumber, expectedFlightNumber);
		softAssert.assertEquals(actualClass, expectedClass);
		softAssert.assertEquals(actualDepartureCity, expectedDepartureCity);
		softAssert.assertEquals(actualArrivalCity, expectedArrivalCity);
		softAssert.assertEquals(actualDepartureDate, expectedDepartureDate);
		
		//Check the Airline Info
		if (!expectedAirline.equals(actualAirline)) {
			//Add to the Failure Message
			failureMessage += "Airline found (" + actualAirline + ") does not match expectations (" + expectedAirline + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Flight Number Info
		if (!expectedFlightNumber.equals(actualFlightNumber)) {
			//Add to the Failure Message
			failureMessage += "Flight Number found (" + actualFlightNumber + ") does not match expectations (" + expectedFlightNumber + "). ";
			
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
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Air Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyAirItinerary");
		}
	}
	
}