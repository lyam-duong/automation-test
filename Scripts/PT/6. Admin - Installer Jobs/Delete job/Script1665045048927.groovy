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
WebUI.openBrowser('http://localhost:8080/login')
WebUI.setText(findTestObject('Object Repository/Common/Sign_In/input_Email_username'),
	'ly+admin-automation@ampup.io')
WebUI.setText(findTestObject('Object Repository/Common/Sign_In/input_Password_password'),
	'AmpUp@123')
WebUI.click(findTestObject('Object Repository/Common/Sign_In/span_Sign In'))

// Navigate to the Installer Job Tab
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/a_Installer Job'))

// Open the job detail and delete the first item
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/firstJobCard'))
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/span_Delete'))

WebUI.setText(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/textarea_Same text for testing'),
	'Same text for testing')
WebUI.click(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/button_Delete'))

// Expectation
WebUI.waitForElementPresent(findTestObject('Object Repository/Create Job/Page_Deployment Provisioning Tool/notification_job-deleted'), 7000)

