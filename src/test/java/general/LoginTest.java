package general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.CWTLoginPage;
import pagemethods.LoginPage;
import utilityClasses.ExcelMethods;

public class LoginTest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public LoginTest() {
		super();
	}
	
	public void performSetup(String reportTitle, String scriptName) {
		//Inherit the method from the parent class
		super.performSetup(reportTitle, scriptName);
		
		//Setup PageFactories
		cwtLoginPage = new CWTLoginPage(eDriver, reportLogger);
		loginPage = new LoginPage(eDriver, reportLogger);
	}
	
	@BeforeClass
	public void beforeClass() {
		//Inherit the method from the parent class
		super.beforeClass();
		System.out.println(constantVariables.dataTablePath + currentDataTable);
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Login");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_LoginTest(String active, String reportTitle, String environment, String user, String application, String logout, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_LoginTest");
			
			//Go To MyMatrix QA SSO website
			loginPage.accessWebsite(activeWebsite);
			
			//Log in to CWT
			cwtLoginPage.cwtLogin(cwtUserID, cwtPassword);
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(1000);
			
			//Select the SSO Region
			loginPage.selectRegion(environment);
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(1000);
			
			//Select the relevant user, if any are listed
			loginPage.selectUser(user);
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(3000);
			
			//Click to connect  to the relevant application
			loginPage.selectApplication(application);
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(3000);
			
			//Verify Login Status
			loginPage.verifyMyMatrixLoginStatus(checkpoint, application);
			
			//Pause the script for a bit
			genMethods.waitForMilliseconds(3000);
			
			//Logout of MyMatrix
			if (logout.equalsIgnoreCase("y") || logout.equalsIgnoreCase("yes")) {
				loginPage.myMatrixLogout(application);
			} else if (logout.equalsIgnoreCase("n")) {
				
			}
			
			//Assert all Checkpoints
			checkpoint.assertAll();
		} else {
			System.out.println("Skipped row #" + iteration + " because it is not an active testing row.");
		}
	}
}