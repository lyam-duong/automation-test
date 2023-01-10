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
import org.openqa.selenium.WebElement


// Open the Brwoser
WebUI.openBrowser('http://0.0.0.0:8080/')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Object Repository/Charging Station/Sign_In/input_Email_username'), '?amp!$up_etanosrepmi%#ha.admin@ampup.io')
WebUI.setEncryptedText(findTestObject('Object Repository/Charging Station/Sign_In/input_Password_password'), 'MR9siDEqC4R4k0p0Q8a43Q==')
WebUI.click(findTestObject('Object Repository/Charging Station/Sign_In/span_Sign In'))

// Navigate to Charging Station
WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/a_Charging Stations'))
WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/main'))

// Test: Filtering by Charger ID
WebUI.setText(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/input_searchFilterChargerID'), 
    '7POJczhB')
WebUI.waitForElementPresent(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_7POJczhB'), 10)

// There should be 2 rows
TestObject chargerIdResultRowTO = findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/tr_resultRow')
List<WebElement> elements = WebUI.findWebElements(chargerIdResultRowTO, 10)
assert elements.size() == 2

// Clear the search
WebUI.setText(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/input_searchFilterChargerID'), 
    ' ')
WebUI.delay(5)

// Verify there should now a list of chargers
List<WebElement> elementList2 = WebUI.findWebElements(chargerIdResultRowTO, 10)
assert elementList2.size() > 20

// Search using SERIAL
WebUI.setText(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/input_searchFilterSerial'),
    'IPLPHB')
WebUI.waitForElementPresent(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_IPLPHBSCAK'), 7)

// There should be 1 row only
List<WebElement> elementList3 = WebUI.findWebElements(chargerIdResultRowTO, 10)
assert elementList2.size() == 1

// Check the data
String foundChargerID = WebUI.executeJavaScript('document.querySelector(".column-cell-0").innerText', null)
assert foundChargerID == 'LAKBCHHLRM'

//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_IPLPHBSCAK'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_IPLPHBSCAK'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_ACTIVATED'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test - Melba Beahan'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test - Leanna'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/td_07272022'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/td_LITE'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_1'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_JB3.0-321'))
//
//WebUI.setText(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/input_searchFilterChargerID'),
//    'HSBDDQIOHH')
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_HSBDDQIOHH'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_HSBDDQIOHH'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_HSBDDQIOHH'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_ACTIVATED'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test - Melba Beahan'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test - Leanna'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/td_07272022'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_Automation Test'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/td_LITE'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_1'))
//
//WebUI.click(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/span_JB3.0-321'))
//
//WebUI.setText(findTestObject('Object Repository/Charging Station/Page_Deployment Provisioning Tool/input_searchFilterChargerID'),
//    '')
//
//WebUI.closeBrowser()


