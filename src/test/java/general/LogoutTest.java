package general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pagemethods.CWTLoginPage;
import pagemethods.LoginPage;
import utilityClasses.ExcelMethods;

public class LogoutTest extends TestBase {
	
	//Define Variable(s)
	SoftAssert checkpoint;
	
	//Constructor
	public LogoutTest() {
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
		
		//Setup the DataTable from Excel
		excelMethods.setDataTablePath(constantVariables.dataTablePath + currentDataTable);
		excelMethods.setSheetName("Logout");
	}
	
	@Test(dataProvider="inputs", dataProviderClass=ExcelMethods.class)
	public void testcases_LogoutTest(String active, String reportTitle, String environment, String user, String application, String logout, String finalResult, String dataRow) {
		//Initialize Variable(s)
		checkpoint = new SoftAssert(); //SoftAssert Setup (for identifying checkpoints)
		iteration = Integer.valueOf(dataRow); //Indicates which row of Excel data the @Test is reading & which row to output the results
		
		//If the current row is not an active test row, skip it
		if (active.equalsIgnoreCase("y") || active.equalsIgnoreCase("yes")) {
			
			//Setup the report & PageFactories
			performSetup(reportTitle, "testcases_LogoutTest");
			
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