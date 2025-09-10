package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class LoginLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public LoginLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ SSO Page ~~~ //
	
	@FindBy(id="MainContent_btnSSO")
	protected WebElement selectSSOLoginButton;
	protected String selectSSOLoginButtonName = "Select 'SSO Login' Button";
	
	@FindBy(id="MainContent_btnNonSSO")
	protected WebElement selectNonSSOLoginButton;
	protected String selectNonSSOLoginButtonName = "Select 'Non-SSO Login' Button";
	
	// ~~~ SSO Region & Options ~~~ //
	
	@FindBy(id="MainContent_ddlRegion")
	protected WebElement regionDropDown;
	protected String regionDropDownName = "'Region' Drop-Down";
	
	@FindBy(xpath="//select[@id='MainContent_ddlRegion']/option[text()='Australia']")
	protected WebElement regionAustraliaOption;
	protected String regionAustraliaOptionName = "'Australia' Drop-Down Option";
	
	@FindBy(xpath="//select[@id='MainContent_ddlRegion']/option[text()='Canada']")
	protected WebElement regionCanadaOption;
	protected String regionCanadaOptionName = "'Canada' Drop-Down Option";
	
	@FindBy(xpath="//select[@id='MainContent_ddlRegion']/option[text()='US Commercial']")
	protected WebElement regionUSCommercialOption;
	protected String regionUSCommercialOptionName = "'US Commercial' Drop-Down Option";
	
	@FindBy(xpath="//select[@id='MainContent_ddlRegion']/option[text()='US D&G']")
	protected WebElement regionUSDnGOption;
	protected String regionUSDnGOptionName = "'US D&G' Drop-Down Option";
	
	//AU
	@FindBy(id="MainContent_imgMyMatrixAU")
	protected WebElement auMyMatrixProductionButton;
	protected String auMyMatrixProductionButtonName = "AU 'MyMatrix' Button";
	
	@FindBy(id="MainContent_imgIRDBAU")
	protected WebElement auIRDBProductionButton;
	protected String auIRDBProductionButtonName = "AU 'IRDB' Button";
	
	//CA
	@FindBy(id="MainContent_imgCMRCA")
	protected WebElement caCMRProductionButton;
	protected String caCMRProductionButtonName = "CA 'CMR' Button";
	
	@FindBy(id="MainContent_imgFinsuiteCA")
	protected WebElement caFinancialSuiteProductionButton;
	protected String caFinancialSuiteProductionButtonName = "CA 'Financial Suite' Button";
	
	@FindBy(id="MainContent_imgFrontCA")
	protected WebElement caFrontLineProductionButton;
	protected String caFrontLineProductionButtonName = "CA 'FrontLine' Button";
	
	@FindBy(id="MainContent_imgHotelCA")
	protected WebElement caHotelRecProductionButton;
	protected String caHotelRecProductionButtonName = "CA 'HotelRec' Button";
	
	@FindBy(id="MainContent_imgMatrixEDCA")
	protected WebElement caMatrixeDProductionButton;
	protected String caMatrixeDProductionButtonName = "CA 'MatrixeD' Button";
	
	@FindBy(id="MainContent_imgIRDBCA")
	protected WebElement caIRDBProductionButton;
	protected String caIRDBProductionButtonName = "CA 'IRDB' Button";
	
	@FindBy(id="MainContent_imgMyMatrixCA")
	protected WebElement caMyMatrixProductionButton;
	protected String caMyMatrixProductionButtonName = "CA 'MyMatrix' Button";
	
	//US
	@FindBy(id="MainContent_imgCMRUS")
	protected WebElement usCMRProductionButton;
	protected String usCMRProductionButtonName = "U.S. Commercial's 'CMR' Button";
	
	@FindBy(id="MainContent_imgMyMatrixUSComm")
	protected WebElement usMyMatrixProductionButton;
	protected String usMyMatrixProductionButtonName = "U.S. Commercial's 'MyMatrix' Button";
	
	@FindBy(id="MainContent_imgIRDBUS")
	protected WebElement usIRDBProductionButton;
	protected String usIRDBProductionButtonName = "U.S. Commercial's 'IRDB' Button";
	
	//D&G
	@FindBy(id="MainContent_imgCMRUS")
	protected WebElement dngCMRProductionButton;
	protected String dngCMRProductionButtonName = "U.S. D&G's 'CMR' Button";
	
	@FindBy(id="MainContent_imgMyMatrixUSComm")
	protected WebElement dngMyMatrixProductionButton;
	protected String dngMyMatrixProductionButtonName = "U.S. D&G's 'MyMatrix' Button";
	
	@FindBy(id="MainContent_imgIRDBUS")
	protected WebElement dngIRDBProductionButton;
	protected String dngIRDBProductionButtonName = "U.S. D&G's 'IRDB' Button";
	
	
	
	
	
	// ~~~ Login ~~~ //
	
	@FindBy(id="ProfileHeader1_companyImage")
	protected WebElement myMatrixCompanyLogoLabel;
	protected String myMatrixCompanyLogoLabelName = "'MyMatrix Company Logo' Label";
	
	// ~~~ Logout ~~~ //
	
	@FindBy(id="ProfileHeader1_ImageButton1")
	protected WebElement myMatrixLogoutButton;
	protected String myMatrixLogoutButtonName = "'MyMatrix Logout' Button";
	
	@FindBy(xpath="/html/frameset/frame[1]")
	protected WebElement cmrFrame;
	protected String cmrFrameName = "CMR Frame";
	
	@FindBy(xpath="//img[@alt='Sign Out']")
	protected WebElement cmrLogoutButton;
	protected String cmrLogoutButtonName = "'CMR Logout' Button";
	
	@FindBy(xpath="//a[text()='Logout']")
	protected WebElement irdbLogoutButton;
	protected String irdbLogoutButtonName = "'IRDB Logout' Button";
	
	
	
	@FindBy(xpath="//span[text()='Sign Out']")
	protected WebElement frontLineLogoutButton;
	protected String frontLineLogoutButtonName = "'FrontLine Logout' Button";
	
	@FindBy(xpath="//span[text()='Logout']")
	protected WebElement hotelRecLogoutButton;
	protected String hotelRecLogoutButtonName = "'HotelRec Logout' Button";
	
	@FindBy(xpath="/html/frameset/frame[1]")
	protected WebElement matrixeDFrame;
	protected String matrixeDFrameName = "MatrixeD Frame";
	
	@FindBy(xpath="//img[@src='./images/logout.gif']")
	protected WebElement matrixeDLogoutButton;
	protected String matrixeDLogoutButtonName = "'MatrixeD Logout' Button";
	
	
	
	@FindBy(xpath="//a[text()=' Return to my users'] | //a[text()='Return to my users']")
	protected WebElement myMatrixLogoutOption1;
	protected String myMatrixLogoutOption1Name = "MyMatrix Logout's 'Return to my users' Button";
	
	@FindBy(xpath="//a[@id=\"MainContent_lnkPrevious\"]//b[text()='Previous']")
	protected WebElement myMatrixQARegionSelectPreviousButton;
	protected String myMatrixQARegionSelectPreviousButtonName = "MyMatrix Region Select's 'Previous' Button";
	
	// ~~~ Verify Current Page Title ~~~ //
	
	@FindBy(id="username_txt")
	protected WebElement useridField;
	protected String useridFieldName = "Enter 'Username' Field for Login";
	
	@FindBy(id="password_txt")
	protected WebElement passwordField;
	protected String passwordFieldName = "Enter 'Password' Field for Login";
	
	@FindBy(xpath="//img[@title='Log In']")
	protected WebElement loginButton;
	protected String loginButtonName = "'Login' button";
	
	@FindBy(id="logout_link")
	protected WebElement logoutLink;
	protected String logoutLinkName = "Enter 'Password' Field for Login";
	
	// ~~~ Verify Current Page Title ~~~ //
	
	
	
}