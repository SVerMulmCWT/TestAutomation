package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.CarItineraryLocators;

public class CarItineraryPage extends CarItineraryLocators {
	
	//Constructor
	public CarItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Car Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyCarItinerary(SoftAssert softAssert, String expectedCarLimoRental, String expectedCarLimoType, String expectedPickupCity, String expectedPickupDate) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Car Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualCarLimoRental = reportLoggerMethods.getAttribute(carLimoRentalField, carLimoRentalFieldName, "value");
		String actualCarLimoType = reportLoggerMethods.getText(carLimoTypeDropDownSelection, carLimoTypeDropDownSelectionName);
		String actualPickupCity = reportLoggerMethods.getAttribute(pickupCityField, pickupCityFieldName, "value");
		String actualPickupDate = reportLoggerMethods.getAttribute(pickupDateField, pickupDateFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualCarLimoRental, expectedCarLimoRental);
		softAssert.assertEquals(actualCarLimoType, expectedCarLimoType);
		softAssert.assertEquals(actualPickupCity, expectedPickupCity);
		softAssert.assertEquals(actualPickupDate, expectedPickupDate);
		
		//Check the Car/Limo Rental Info
		if (!expectedCarLimoRental.equals(actualCarLimoRental)) {
			//Add to the Failure Message
			failureMessage += "Car/Limo found (" + actualCarLimoRental + ") does not match expectations (" + expectedCarLimoRental + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Car/Limo Type Info
		if (!expectedCarLimoType.equals(actualCarLimoType)) {
			//Add to the Failure Message
			failureMessage += "Car/Limo Type found (" + actualCarLimoType + ") does not match expectations (" + expectedCarLimoType + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Pickup City Info
		if (!expectedPickupCity.equals(actualPickupCity)) {
			//Add to the Failure Message
			failureMessage += "Pickup City found (" + actualPickupCity + ") does not match expectations (" + expectedPickupCity + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Pickup Date Info
		if (!expectedPickupDate.equals(actualPickupDate)) {
			//Add to the Failure Message
			failureMessage += "Pickup Date found (" + actualPickupDate + ") does not match expectations (" + expectedPickupDate + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Car Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyCarItinerary");
		}
	}
	
}