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

WebUI.openBrowser('')
WebUI.navigateToUrl('https://provision-tool-dev.web.app/login')

// Log in again with OEM Account
WebUI.setText(findTestObject('Object Repository/Page_Deployment Provisioning Tool/input_Email_username'), 'ha+oem@ampup.io')
WebUI.setText(findTestObject('Object Repository/Page_Deployment Provisioning Tool/input_Password_password'), '1qa2ws3ed')
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/span_Sign In'))

// Create order
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/span_Ha OEM_anticon anticon-plus-circle'))
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/a_Standard Order'))

// Select distributor
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/div_Select or create a new distributor'))
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/div_Ha.Tran1'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Deployment Provisioning Tool/chargerSelect'), 3)

// Input Content
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/chargerSelect'))
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/div_EVC10 - 48 Amp_1'))

String randomString = WebUI.executeJavaScript("return Math.ceil(new Date().getTime() / 1000).toString()", null)
String QrId = 'AMPJ-' + randomString
GlobalVariable.qrId = QrId
GlobalVariable.chargerId = 'id_' + randomString
WebUI.setText(findTestObject('Object Repository/Page_Deployment Provisioning Tool/input_PASSWORD_chargerId'), GlobalVariable.chargerId)
WebUI.setText(findTestObject('Object Repository/Page_Deployment Provisioning Tool/input_EVC10 - 48 Amp_serial'), 'ser_' + randomString)
WebUI.setText(findTestObject('Object Repository/Page_Deployment Provisioning Tool/input_EVC10 - 48 Amp_qrId'), QrId)

// Create order
WebUI.click(findTestObject('Object Repository/Page_Deployment Provisioning Tool/span_Create Order'))

// Move ticket to SHIPPED
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Deployment Provisioning Tool/firstCreatedOrder'), 7)
String orderId = WebUI.getAttribute(findTestObject('Object Repository/Page_Deployment Provisioning Tool/firstCreatedOrder'), 'data-rbd-draggable-id')
WebUI.executeJavaScript("window.testUtilPutOrderStatus(arguments[0],700)",[orderId])

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Deployment Provisioning Tool/successMessage'), 7)
