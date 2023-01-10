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
import java.util.Date;
import java.lang.Math;



'Start creating a new order'
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/btn-create-order'))

'Try creating a new customer'
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input.customers_customerId'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/div_Create a new customer'))
int nowInSecond = Math.round((new Date().getTime())/1000);
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Company Name_customers_companyName'),
	'Automation Test - ' + nowInSecond)
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Address_customers_address'),
	'Automation Test - Vietnam, District 5')
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Main Contact Name_customers_contactName'),
	'Automation Test - ' + nowInSecond)
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Main Contact No_customers_contactPhone'),
	'0938541177')
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Root Account Email_customers_email'),
	'ly+automation-test-' + nowInSecond + '@ampup.io')
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/button_Submit'))

'Verify if it is created successfully'
WebUI.waitForElementPresent(findTestObject('Object Repository/Regular_Flow/1.Create_Order/success notification - create customer'), 10)

'Select an existing customer to create an order'
WebUI.setText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/input_Customer Company Name_customers_customerId'),
	'automation')
WebUI.click(findTestObject('Regular_Flow/1.Create_Order/div_Automation Test'))

'Next step'
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/span_Next'))

'Fill in the location form'
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/subscriptionPlanIdInput'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/div_Lite'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/locations_0_locationId'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/div_Automation Test - Betsy Sauer'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/locations_0_chargerSpecs_0_chargerModel'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/div_EVC10 - 16 Amp'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/span_Next'))

'Review and submit'
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/span_Submit'))

'Back to dashboard and verify'
createdOrderId = WebUI.getText(findTestObject('Object Repository/Regular_Flow/1.Create_Order/b_1200d28b'))
WebUI.click(findTestObject('Object Repository/Regular_Flow/1.Create_Order/span_Back to Dashboard'))
WebUI.verifyTextPresent(createdOrderId, false)
