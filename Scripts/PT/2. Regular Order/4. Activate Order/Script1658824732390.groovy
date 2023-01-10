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

//'Login'
//WebUI.openBrowser('')
//WebUI.navigateToUrl('http://0.0.0.0:8080/')
//WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Email_username'),
//	'?amp!$up_etanosrepmi%#ha.admin@ampup.io')
//WebUI.setEncryptedText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Password_password'),
//	'MR9siDEqC4R4k0p0Q8a43Q==')
//WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/span_Sign In'))

//'Upload PO'
//WebUI.click(findTestObject('Object Repository/Regular_Flow/4. Activate Order/first ticket in test column'))
//WebUI.uploadFile(findTestObject('Object Repository/Regular_Flow/4. Activate Order/button_Upload File'), '/Users/lyduong/Downloads/Sample.pdf')
//WebUI.waitForElementPresent(findTestObject('Object Repository/Regular_Flow/4. Activate Order/div_Purchase order has been uploaded successfully'), 10)
//WebUI.click(findTestObject('Object Repository/Regular_Flow/4. Activate Order/notification close button'))
//WebUI.click(findTestObject('Object Repository/Regular_Flow/4. Activate Order/close modal button'))

'Move order to Shipped column'
String fullTicketId = WebUI.getAttribute(findTestObject('Object Repository/Regular_Flow/4_Activate_Order/ticket full id'), 'data-order-id')
WebUI.executeJavaScript("testUtilPutOrderStatus(arguments[0],arguments[1])", [fullTicketId, 700])
WebUI.waitForElementPresent(findTestObject('Object Repository/Regular_Flow/4_Activate_Order/success notification - update order status'), 10)

'Move order to Install column'
WebUI.executeJavaScript("testUtilPutOrderStatus(arguments[0],arguments[1])", [fullTicketId, 800])
WebUI.waitForElementPresent(findTestObject('Object Repository/Regular_Flow/4_Activate_Order/success notification - update order status'), 10)

'Move order to Activated column'
WebUI.executeJavaScript("testUtilPutOrderStatus(arguments[0],arguments[1])", [fullTicketId, 900])
WebUI.waitForElementPresent(findTestObject('Object Repository/Regular_Flow/4_Activate_Order/success notification - update order status'), 10)
