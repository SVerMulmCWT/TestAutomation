package pagemethods.itineraries;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.itineraries.HotelItineraryLocators;

public class HotelItineraryPage extends HotelItineraryLocators {
	
	//Constructor
	public HotelItineraryPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Itinerary Page ~~~ //
	
	public void closePage() {
		//Exit the Itinerary Page
		reportLoggerMethods.click(cancelButton, cancelButtonName);
	}
	
	public void verifyHotelItinerary(SoftAssert softAssert, String expectedHotelChain, String expectedHotelName, String expectedCity, String expectedAddress, String expectedPhoneNumber, String expectedRoomType, String expectedCheckinDate) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying the Hotel Itinerary Info");
		
		//Initialize Variable(s)
		String failureMessage = "Failure: ";
		boolean accurateVerifyInfo = true;
		
		String actualHotelChain = reportLoggerMethods.getAttribute(hotelChainField, hotelChainFieldName, "value");
		String actualHotelName = reportLoggerMethods.getAttribute(hotelNameField, hotelNameFieldName, "value");
		String actualCity = reportLoggerMethods.getAttribute(cityField, cityFieldName, "value");
		String actualAddress = reportLoggerMethods.getAttribute(addressField, addressFieldName, "value");
		String actualPhoneNumber = reportLoggerMethods.getAttribute(phoneNumberField, phoneNumberFieldName, "value");
		String actualRoomType = reportLoggerMethods.getText(roomTypeDropDown, roomTypeDropDownName);
		String actualCheckinDate = reportLoggerMethods.getAttribute(checkinDateField, checkinDateFieldName, "value");
		
		//Assert the Itinerary Values
		softAssert.assertEquals(actualHotelChain, expectedHotelChain);
		softAssert.assertEquals(actualHotelName, expectedHotelName);
		softAssert.assertEquals(actualCity, expectedCity);
		softAssert.assertEquals(actualAddress, expectedAddress);
		softAssert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
		softAssert.assertEquals(actualRoomType, expectedRoomType);
		softAssert.assertEquals(actualCheckinDate, expectedCheckinDate);
		
		//Check the Hotel Chain Info
		if (!expectedHotelChain.equals(actualHotelChain)) {
			//Add to the Failure Message
			failureMessage += "Hotel Chain found (" + actualHotelChain + ") does not match expectations (" + expectedHotelChain + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Hotel Name Info
		if (!expectedHotelName.equals(actualHotelName)) {
			//Add to the Failure Message
			failureMessage += "Hotel Name found (" + actualHotelName + ") does not match expectations (" + expectedHotelName + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the City Info
		if (!expectedCity.equals(actualCity)) {
			//Add to the Failure Message
			failureMessage += "City found (" + actualCity + ") does not match expectations (" + expectedCity + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Address Info
		if (!expectedAddress.equals(actualAddress)) {
			//Add to the Failure Message
			failureMessage += "Address found (" + actualAddress + ") does not match expectations (" + expectedAddress + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Phone Number Info
		if (!expectedPhoneNumber.equals(actualPhoneNumber)) {
			//Add to the Failure Message
			failureMessage += "Phone Number found (" + actualPhoneNumber + ") does not match expectations (" + expectedPhoneNumber + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Room Type Info
		if (!expectedRoomType.equals(actualRoomType)) {
			//Add to the Failure Message
			failureMessage += "Room Type found (" + actualRoomType + ") does not match expectations (" + expectedRoomType + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check the Checkin Date Info
		if (!expectedCheckinDate.equals(actualCheckinDate)) {
			//Add to the Failure Message
			failureMessage += "Checkin Date found (" + actualCheckinDate + ") does not match expectations (" + expectedCheckinDate + "). ";
			
			//Indicate that the Check failed
			accurateVerifyInfo = false;
		}
		
		//Check if the Verify Info Matches Expectations
		if (accurateVerifyInfo) {
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: Hotel Itinerary Info Matches Expectations");
		} else {
			reportLoggerMethods.reportFailedCheckpoint(failureMessage, "verifyHotelItinerary");
		}
	}
	
}