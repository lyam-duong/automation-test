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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor;

//WebUI.openBrowser('')
//WebUI.maximizeWindow()
//WebUI.navigateToUrl('https://provision-tool-staging.web.app/')
//
//WebUI.setText(findTestObject('Object Repository/Common/Sign_In/input_Email_username'),
//	'?amp!$up_etanosrepmi%#ha.admin@ampup.io')
//WebUI.setEncryptedText(findTestObject('Object Repository/Common/Sign_In/input_Password_password'),
//	'MR9siDEqC4R4k0p0Q8a43Q==')
//WebUI.click(findTestObject('Object Repository/Common/Sign_In/span_Sign In'))

'Move order from Commisioning Column to the Test Column'
String fullOrderId = attribute = WebUI.getAttribute(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/full chargerId of the first charger in Commissioning Column'), 'data-order-id')

'Move the order to the TEST column'
WebUI.executeJavaScript("testUtilPutOrderStatus(arguments[0],arguments[1])", [fullOrderId, 500])

'Click on the first order on the Test Column'
WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/first ticket on test column'))

'Click the Start Test button'
WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/button_Start Test'))

'Get Charger ID of the first charger'
String firstChargerID = WebUI.getText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/charger id of the first charger')).substring(
    0, 10)

'Open the emulator'
WebUI.executeJavaScript('window.open()', null)

WebUI.switchToWindowTitle('')

WebUI.navigateToUrl('https://ocpp-emulator.web.app/login/')

WebUI.setText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/input_Email_email'), 'quy.nguyen@ampup.io')

WebUI.setEncryptedText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/input_Password_password'), 
    'HuE7JP8OUQWjqQTmmb/YKA==')

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Login'))

'Add info'
WebUI.setText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/partner input'), 'juicebar')

WebUI.setText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/charger input'), firstChargerID)

WebUI.setText(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/power input'), '5')

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/div_Dev_ant-switch-handle'))

'Connect'
WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Connect'))

'Back to the test page to Remote Start Transaction'
WebUI.switchToWindowTitle('Deployment Provisioning Tool')

WebUI.waitForElementVisible(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/div_Available'), 
    7)

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/first charger box'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/button_Send'))

'To go the emulator to plug the charger in'
WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Plug'))

'Go back to the test page and wait till see "In use"'
WebUI.switchToWindowTitle('Deployment Provisioning Tool')

WebUI.waitForElementVisible(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/div_In-use'), 
    7)

'Choose Remote Stop Transaction'
WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/span_RemoteStartTransaction'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/div_RemoteStopTransaction'), 
    5)

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/div_RemoteStopTransaction'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/button_Send'))

'Back to Emulator'
WebUI.switchToWindowIndex(1)

WebUI.waitForElementClickable(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Unplug'), 
    7)

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Unplug'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Emulator/button_Disconnect'))

'Back to Order to verify'
WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('Object Repository/Regular_Flow/3_Test_Order/Test_Page/a_Orders'))

