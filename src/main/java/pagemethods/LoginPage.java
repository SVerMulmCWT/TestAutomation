package pagemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.LoginLocators;

public class LoginPage extends LoginLocators {
	
	//Constructor
	public LoginPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Access Specified Website ~~~ //
	
	public void accessWebsite(String website) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Navigating to the website -> " + website);
		
		//Access the specified website
		for (int i = 0; i < 3; i++) {
			try {
				eDriver.get(website);
				selectSSOLoginButton.click();
				break;
			} catch (Exception e) {
				
			}
		}
	}
	
	public void selectRegion(String region) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Selecting the Region -> " + region);
		
		//Open the Drop-Down list before selecting the Region Option
		reportLoggerMethods.click(regionDropDown, regionDropDownName);
		genMethods.waitForMilliseconds(3000);
		//Select the 'Region' Option
		if (region.equalsIgnoreCase("AU") || region.equalsIgnoreCase("AU Pre-Prod") || region.equalsIgnoreCase("AU PreProd") || region.equalsIgnoreCase("AU QA")) {
			//Select 'Australia' for the Region
			reportLoggerMethods.click(regionAustraliaOption, regionAustraliaOptionName);
		} else if (region.equalsIgnoreCase("CA") || region.equalsIgnoreCase("CA Pre-Prod") || region.equalsIgnoreCase("CA PreProd") || region.equalsIgnoreCase("CA QA")) {
			//Select 'Canada' for the Region
			reportLoggerMethods.click(regionCanadaOption, regionCanadaOptionName);
		} else if (region.equalsIgnoreCase("US") || region.equalsIgnoreCase("US Pre-Prod") || region.equalsIgnoreCase("US PreProd") || region.equalsIgnoreCase("US QA")) {
			//Select 'US Commercial' for the Region
			reportLoggerMethods.click(regionUSCommercialOption, regionUSCommercialOptionName);
		} else if (region.equalsIgnoreCase("D&G") || region.equalsIgnoreCase("DG") || region.equalsIgnoreCase("D&G Pre-Prod") || region.equalsIgnoreCase("DG Pre-Prod") || region.equalsIgnoreCase("D&G PreProd") || region.equalsIgnoreCase("DG PreProd") || region.equalsIgnoreCase("D&G QA") || region.equalsIgnoreCase("DG QA")) {
			//Select 'DG' for the Region
			reportLoggerMethods.click(regionUSDnGOption, regionUSDnGOptionName);
		}
	}
	
	public void selectUser(String user) {
		try {
			eDriver.findElement(By.xpath("//td[text()='" + user + "']")).click();
		} catch (Exception e) {
			
		}
	}
	
	public void selectApplication(String application) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Selecting the Application -> " + application);
		
		switch (application) {
		case "AU MyMatrix":
			reportLoggerMethods.click(auMyMatrixProductionButton, auMyMatrixProductionButtonName);
			break;
		case "AU IRDB":
			reportLoggerMethods.click(auIRDBProductionButton, auIRDBProductionButtonName);
			break;
		case "CA CMR":
			reportLoggerMethods.click(caCMRProductionButton, caCMRProductionButtonName);
			break;
		case "CA Financial Suite":
			reportLoggerMethods.click(caFinancialSuiteProductionButton, caFinancialSuiteProductionButtonName);
			break;
		case "CA FrontLine":
			reportLoggerMethods.click(caFrontLineProductionButton, caFrontLineProductionButtonName);
			break;
		case "CA HotelRec":
			reportLoggerMethods.click(caHotelRecProductionButton, caHotelRecProductionButtonName);
			break;
		case "CA MatrixeD":
			reportLoggerMethods.click(caMatrixeDProductionButton, caMatrixeDProductionButtonName);
			break;
		case "CA IRDB":
			reportLoggerMethods.click(caIRDBProductionButton, caIRDBProductionButtonName);
			break;
		case "CA MyMatrix":
			reportLoggerMethods.click(caMyMatrixProductionButton, caMyMatrixProductionButtonName);
			break;
		case "US CMR":
			reportLoggerMethods.click(usCMRProductionButton, usCMRProductionButtonName);
			break;
		case "US MyMatrix":
			reportLoggerMethods.click(usMyMatrixProductionButton, usMyMatrixProductionButtonName);
			break;
		case "US IRDB":
			reportLoggerMethods.click(usIRDBProductionButton, usIRDBProductionButtonName);
			break;
		case "D&G CMR":
			reportLoggerMethods.click(dngCMRProductionButton, dngCMRProductionButtonName);
			break;
		case "D&G MyMatrix":
			reportLoggerMethods.click(dngMyMatrixProductionButton, dngMyMatrixProductionButtonName);
			break;
		case "D&G IRDB":
			reportLoggerMethods.click(dngIRDBProductionButton, dngIRDBProductionButtonName);
			break;
		default:
		}
	}
	
	public void myMatrixLogout(String application) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Logout of " + application);
		
		//Logout of MyMatrix
		switch (application) {
		case "AU MyMatrix":
			reportLoggerMethods.click(myMatrixLogoutButton, myMatrixLogoutButtonName);
			break;
		case "AU IRDB":
			reportLoggerMethods.click(irdbLogoutButton, irdbLogoutButtonName);
			break;
		case "CA CMR":
			eDriver.switchTo().frame(cmrFrame);
			reportLoggerMethods.click(cmrLogoutButton, cmrLogoutButtonName);
			eDriver.switchTo().defaultContent();
			break;
		case "CA Financial Suite":
//			reportLoggerMethods.click(asdf, asdf);
			break;
		case "CA FrontLine":
			reportLoggerMethods.click(frontLineLogoutButton, frontLineLogoutButtonName);
			break;
		case "CA HotelRec":
			reportLoggerMethods.click(hotelRecLogoutButton, hotelRecLogoutButtonName);
			break;
		case "CA MatrixeD":
			eDriver.switchTo().frame(matrixeDFrame);
			reportLoggerMethods.click(matrixeDLogoutButton, matrixeDLogoutButtonName);
			eDriver.switchTo().defaultContent();
			break;
		case "CA IRDB":
			reportLoggerMethods.click(irdbLogoutButton, irdbLogoutButtonName);
			break;
		case "CA MyMatrix":
			reportLoggerMethods.click(myMatrixLogoutButton, myMatrixLogoutButtonName);
			break;
		case "US CMR":
			eDriver.switchTo().frame(cmrFrame);
			reportLoggerMethods.click(cmrLogoutButton, cmrLogoutButtonName);
			eDriver.switchTo().defaultContent();
			break;
		case "US MyMatrix":
			reportLoggerMethods.click(myMatrixLogoutButton, myMatrixLogoutButtonName);
			break;
		case "US IRDB":
			reportLoggerMethods.click(irdbLogoutButton, irdbLogoutButtonName);
			break;
		case "D&G CMR":
			eDriver.switchTo().frame(cmrFrame);
			reportLoggerMethods.click(cmrLogoutButton, cmrLogoutButtonName);
			eDriver.switchTo().defaultContent();
			break;
		case "D&G MyMatrix":
			reportLoggerMethods.click(myMatrixLogoutButton, myMatrixLogoutButtonName);
			break;
		case "D&G IRDB":
			reportLoggerMethods.click(irdbLogoutButton, irdbLogoutButtonName);
			break;
		default:
		}
		
		//Pause the script for a bit
		genMethods.waitForMilliseconds(3000);
		
//		//Select "Return to my users" option after logging out
//		reportLoggerMethods.click(myMatrixLogoutOption1, myMatrixLogoutOption1Name);
//		
//		//Pause the script for a bit
//		genMethods.waitForMilliseconds(3000);
//		
//		//
//		reportLoggerMethods.click(myMatrixQARegionSelectPreviousButton, myMatrixQARegionSelectPreviousButtonName);
		
		//
//		reportLoggerMethods.click(selectSSOLoginButton, selectSSOLoginButtonName);
	}
	
	public void verifyMyMatrixLoginStatus(SoftAssert softAssert, String application) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying if the user is logged in");
		
		boolean logoutButtonExists = false;
		
		switch (application) {
		case "AU MyMatrix":
			if (reportLoggerMethods.isDisplayed(myMatrixLogoutButton, myMatrixLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "AU IRDB":
			if (reportLoggerMethods.isDisplayed(irdbLogoutButton, irdbLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "CA CMR":
			eDriver.switchTo().frame(cmrFrame);
			
			if (reportLoggerMethods.isDisplayed(cmrLogoutButton, cmrLogoutButtonName)) {
				logoutButtonExists = true;
			}
			
			eDriver.switchTo().defaultContent();
			break;
		case "CA Financial Suite":
//			reportLoggerMethods.click(asdf, asdf);
//			if (reportLoggerMethods.isDisplayed(asdf, asdf)) {
//				logoutButtonExists = true;
//			}
			break;
		case "CA FrontLine":
			if (reportLoggerMethods.isDisplayed(frontLineLogoutButton, frontLineLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "CA HotelRec":
			if (reportLoggerMethods.isDisplayed(hotelRecLogoutButton, hotelRecLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "CA MatrixeD":
			eDriver.switchTo().frame(matrixeDFrame);
			
			if (reportLoggerMethods.isDisplayed(matrixeDLogoutButton, matrixeDLogoutButtonName)) {
				logoutButtonExists = true;
			}
			
			eDriver.switchTo().defaultContent();
			break;
		case "CA MyMatrix":
			if (reportLoggerMethods.isDisplayed(myMatrixLogoutButton, myMatrixLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "CA IRDB":
			if (reportLoggerMethods.isDisplayed(irdbLogoutButton, irdbLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "US CMR":
			eDriver.switchTo().frame(cmrFrame);
			
			if (reportLoggerMethods.isDisplayed(cmrLogoutButton, cmrLogoutButtonName)) {
				logoutButtonExists = true;
			}
			
			eDriver.switchTo().defaultContent();
			break;
		case "US MyMatrix":
			if (reportLoggerMethods.isDisplayed(myMatrixLogoutButton, myMatrixLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "US IRDB":
			if (reportLoggerMethods.isDisplayed(irdbLogoutButton, irdbLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "D&G CMR":
			eDriver.switchTo().frame(cmrFrame);
			
			if (reportLoggerMethods.isDisplayed(cmrLogoutButton, cmrLogoutButtonName)) {
				logoutButtonExists = true;
			}
			
			eDriver.switchTo().defaultContent();
			break;
		case "D&G MyMatrix":
			if (reportLoggerMethods.isDisplayed(myMatrixLogoutButton, myMatrixLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		case "D&G IRDB":
			if (reportLoggerMethods.isDisplayed(irdbLogoutButton, irdbLogoutButtonName)) {
				logoutButtonExists = true;
			}
			break;
		default:
		}
		
		//Verify if the user is logged in
		if (logoutButtonExists) {
			//Assert if the user is logged in
			softAssert.assertEquals("The user successfully logged in", "The user successfully logged in");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: The user successfully logged in");
		} else {
			//Assert if the user is logged in
			softAssert.assertEquals("The user failed  to log in", "The user successfully logged in");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportFailedCheckpoint("Failed: The user failed  to log in", "verifyMyMatrixLoginStatus");
		}
	}
	
	// ~~~ Login & Logout ~~~ //
	
	public void logoutIfAble() {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Logging out");
		
		//Check if a user is currently logged in
		if (reportLoggerMethods.isDisplayed(logoutLink, logoutLinkName)) {
			//Attempt to logout of Smart Suite
			reportLoggerMethods.click(logoutLink, logoutLinkName);
		}
	}
	
	public void login(String userid, String password) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Logging in");
		
		//Enter the user id
		reportLoggerMethods.sendKeys(useridField, useridFieldName, userid);
		
		//Enter the password
		reportLoggerMethods.sendKeys(passwordField, passwordFieldName, password);
		
		//Click 'Login' to attempt to login
		reportLoggerMethods.click(loginButton, loginButtonName);
	}
	
	public void loginIfAble(String userid, String password) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Logging in");
		
		//Login the User if not already logged in
		if (reportLoggerMethods.isDisplayed(useridField, useridFieldName)) {
			//Enter the user id
			reportLoggerMethods.sendKeys(useridField, useridFieldName, userid);
			
			//Enter the password
			reportLoggerMethods.sendKeys(passwordField, passwordFieldName, password);
			
			//Click 'Login' to attempt to login
			reportLoggerMethods.click(loginButton, loginButtonName);
		}
	}
	
	public void verifyLoginStatus(SoftAssert softAssert) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying if the user is logged in");
		
		//Verify if the user is logged in
		if (reportLoggerMethods.isDisplayed(logoutLink, logoutLinkName)) {
			//Assert if the user is logged in
			softAssert.assertEquals("The user successfully logged in", "The user successfully logged in");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: The user successfully logged in");
		} else {
			//Assert if the user is logged in
			softAssert.assertEquals("The user failed  to log in", "The user successfully logged in");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportFailedCheckpoint("Failed: The user failed  to log in", "verifyLoginStatus");
		}
	}
	
	public void verifyLogoutStatus(SoftAssert softAssert) {
		//Output an info status to the Extent Report & System
		reportLoggerMethods.reportInfo("Verifying if the user is logged out");
		
		//Verify if the user is logged out
		if (reportLoggerMethods.isDisplayed(loginButton, loginButtonName)) {
			//Assert if the user is logged out
			softAssert.assertEquals("The user is logged out", "The user is logged out");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportSuccessfulCheckpoint("Success: The user is logged out");
		} else {
			//Assert if the user is logged out
			softAssert.assertEquals("The user is logged in", "The user is logged out");
			
			//Report the assert status to the Extent Report & System
			reportLoggerMethods.reportFailedCheckpoint("Failure: The user is logged in", "verifyLogoutStatus");
		}
	}
	
}