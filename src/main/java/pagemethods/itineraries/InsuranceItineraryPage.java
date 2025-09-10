package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.InsuranceItineraryLocators;

public class InsuranceItineraryPage extends InsuranceItineraryLocators {
	
	//Constructor
	public InsuranceItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyInsuranceItinerary(SoftAssert softAssert, String expectedInsuranceProvider, String expectedDepartureCity, String expectedArrivalCity, String expectedProductType, String expectedDepartureDate) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Insurance Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualInsuranceProvider = reportLoggerMethods.getAttribute(insuranceProviderField, insuranceProviderFieldName, "value");
		String actualDepartureCity = reportLoggerMethods.getAttribute(departureCityField, departureCityFieldName, "value");
		String actualArrivalCity = reportLoggerMethods.getAttribute(arrivalCityField, arrivalCityFieldName, "value");
		String actualProductType = reportLoggerMethods.getAttribute(productTypeField, productTypeFieldName, "value");
		String actualDepartureDate = reportLoggerMethods.getAttribute(departureDateField, departureDateFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualInsuranceProvider, expectedInsuranceProvider);
		softAssert.assertEquals(actualDepartureCity, expectedDepartureCity);
		softAssert.assertEquals(actualArrivalCity, expectedArrivalCity);
		softAssert.assertEquals(actualProductType, expectedProductType);
		softAssert.assertEquals(actualDepartureDate, expectedDepartureDate);
		
		//Check the Insurance Provider Info
		if (!expectedInsuranceProvider.equals(actualInsuranceProvider)) {
			//Add to the Failure Message
			failureMessage += "Insurance Provider found (" + actualInsuranceProvider + ") does not match expectations (" + expectedInsuranceProvider + "). ";
			
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
		
		//Check the Product Type Info
		if (!expectedProductType.equals(actualProductType)) {
			//Add to the Failure Message
			failureMessage += "Product Type found (" + actualProductType + ") does not match expectations (" + expectedProductType + "). ";
			
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
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Insurance Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyInsuranceItinerary");
		}
	}
	
}