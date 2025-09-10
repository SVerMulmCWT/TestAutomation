package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilityClasses.ExcelMethods;
import utilityClasses.GeneralMethods;
import utilityClasses.ReportLoggerMethods;

public class QueuesLocators {
	
	//Initialize Variable(s)
	protected ExtentTest reportLogger;
	protected EventFiringWebDriver eDriver;
	protected GeneralMethods genMethods;
	protected ExcelMethods excelMethods;
	protected ReportLoggerMethods reportLoggerMethods;
	
	//Constructor
	public QueuesLocators(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize objects
		genMethods = new GeneralMethods();
		excelMethods = new ExcelMethods();
		reportLoggerMethods = new ReportLoggerMethods(eDriver, reportLogger);
	}
	
	// ~~~ Tasks/Queues Section ~~~ //
	
	@FindBy(id="ContentPlaceHolder1_typeDropDownList")
	protected WebElement queueTypeDropDown;
	protected String queueTypeDropDownName = "'Type' Drop-Down";
	
	@FindBy(xpath="//option[text()='RMI Rejected Interface Records']")
	protected WebElement rmiOption;
	protected String rmiOptionName = "'RMI Rejected Interface Records' Drop-Down Option";
	
	@FindBy(xpath="//option[text()='RMA System Queue']")
	protected WebElement rmaOption;
	protected String rmaOptionName = "'RMI Rejected Interface Records' Drop-Down Option";
	
	@FindBy(id="ContentPlaceHolder1_goButton")
	protected WebElement searchButton;
	protected String searchButtonName = "'Search' Button";
	
	@FindBy(id="ContentPlaceHolder1_queueCountButton")
	protected WebElement queueCountButton;
	protected String queueCountButtonName = "'Queue Count' Button";
	
	
	
	@FindBy(id="ContentPlaceHolder1_ASPxGridView1_DXDataRow0")
	protected WebElement searchResult1Row;
	protected String searchResult1RowName = "'Searched Result Row #1' Row";
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_branchQueueCountGridView']/tbody/tr[2]/td[1]")
	protected WebElement queueCountResult1;
	protected String queueCountResult1Name = "'Queue Count Searched Result Row #1' Row";
	
	@FindBy(id="ContentPlaceHolder1_ErrorPanelControl1_errorLabel")
	protected WebElement noResultsLabel;
	protected String noResultsLabelName = "'Search returned no results' Label";
	
	
}