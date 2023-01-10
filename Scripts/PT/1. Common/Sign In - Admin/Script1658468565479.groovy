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

WebUI.openBrowser('https://provision.ampup.io/')
WebUI.maximizeWindow()


WebUI.setText(findTestObject('Object Repository/Common/Sign_In/input_Email_username'), 
    '?amp!$up_etanosrepmi%#ha.admin@ampup.io')
WebUI.setText(findTestObject('Object Repository/Common/Sign_In/input_Password_password'), 
    '@13ga$%2(82d1vA')
WebUI.click(findTestObject('Object Repository/Common/Sign_In/span_Sign In'))

// Verify
WebUI.waitForElementVisible(findTestObject('Object Repository/Regular_Flow/1.Create_Order/welcome-user'), 
    10)
WebUI.verifyTextPresent('Welcome,', false)
WebUI.verifyTextPresent('Ha Admin', false)

