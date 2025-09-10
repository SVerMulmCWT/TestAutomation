package pagemethods;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import pagelocators.CWTLoginLocators;

public class CWTLoginPage extends CWTLoginLocators {
	
	//Constructor
	public CWTLoginPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		super(eDriver, reportLogger);
	}
	
	// ~~~ Login & Logout ~~~ //
	
	public void cwtLogin(String userid, String password) {
		try {
			//Enter Credentials & Login
			useridField.sendKeys(userid);
			passwordField.sendKeys(password);
			loginButton.click();
		} catch (Exception e) {
			
		}
	}
	
}