import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Login
WebUI.openBrowser('')
WebUI.navigateToUrl('https://provision-tool-dev.web.app/login')
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/input_Email_username'), 'ha+admin@ampup.io')
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/input_Password_password'), 
    'AmpUp@123')
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/span_Sign In'))

// Navigate to the Installer Job Tab
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/a_Installer Job'))
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/svg'))

// Input insstaller info & Note
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/input_Job Creator Form_installers_0_name'), 
    'Lyam')
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/input_Job Creator Form_installers_0_email'), 
    'ly@ampup.io')
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/textarea_Some randome note'), 
    'Some random notes')

// Input the location
WebUI.click(findTestObject('Object Repository/Create Job/locationNameSelector'))
WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/span_Some randome note_ant-select-selection-item'), 
    'Lyam 50 - Jovan Dickinson 2')
WebUI.click(findTestObject('Object Repository/Create Job/locationOptionLyam2'))


// Add chargers
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/span_lyautomationampup.io_ant-select-select_14c301'))
WebUI.setText(findTestObject('Object Repository/Create Job/chargerInput'), "EVC10 - 48 Amp")
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/div_EVC10 - 48 Amp'))

// Create Job
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/button_Create Job'))
String jobId = WebUI.getAttribute(findTestObject('Object Repository/Page_Deployment Provisioning Tool/firstCreatedJob'), 'data-id')
GlobalVariable.jobId = jobId

//// Open job detail
//WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/div_ID  1204365d 3'))
//
//WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/span_Delete'))
//
//WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/textarea_Same text for testing'), 
//    'Same text for testing')
//
//// Delete job
//WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/button_Delete'))
//
//WebUI.closeBrowser()

