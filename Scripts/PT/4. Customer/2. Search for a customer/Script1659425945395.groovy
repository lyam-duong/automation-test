//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
//import com.kms.katalon.core.testobject.TestObject as TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
//import internal.GlobalVariable as GlobalVariable
//import org.openqa.selenium.Keys as Keys
//import java.util.Date;
//import java.lang.Math;
//
//// Login
////WebUI.openBrowser('http://0.0.0.0:8080/')
////WebUI.maximizeWindow()
////WebUI.setText(findTestObject('Object Repository/Customer/Sign_In/input_Email_username'), '?amp!$up_etanosrepmi%#ha.admin@ampup.io')
////WebUI.setEncryptedText(findTestObject('Object Repository/Customer/Sign_In/input_Password_password'), 'MR9siDEqC4R4k0p0Q8a43Q==')
////WebUI.click(findTestObject('Object Repository/Customer/Sign_In/span_Sign In'))
//
//// Click on the Customer Tab
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/a_Customers'))
//
//// Click on Create A New Customer
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/span_Ha Admin_anticon anticon-plus-circle'))
//
//// Fill in the info
//int timeStampInSecond = Math.round((new Date().getTime())/1000);
//String customerCompanyName = 'Automation Test - ' + timeStampInSecond
//String rootEmailForDuplicationTesting = 'ly+automation-test@ampup.io'
//String uniqueEmailAddress = 'ly+automation-test-' + timeStampInSecond + '@ampup.io'
//
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Company Name_customers_companyName'), customerCompanyName)
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Address_customers_address'), 
//    'AmpUp Vietnam, District 5, Ho Chi Minh City')
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Main Contact Name_customers_contactName'), 
//    'Lyam - Automation Test')
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Main Contact No_customers_contactPhone'), 
//    '+849385410174')
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Root Account Email_customers_email'),  rootEmailForDuplicationTesting)
//
//// Test the toggle
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/button_Off'))
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_Billing Contact Name_ant-switch-handle'))
//
//// Submit
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/button_Submit'))
//
//// Verify that there should be an error
//WebUI.waitForElementPresent(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_The customer with this email address ha_bb4cd9'), 7)
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/a_ant-notification-notice-close'))
//	
//// Test again with a unique email address
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Root Account Email_customers_email'), uniqueEmailAddress)
//
//// Submit again
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/button_Submit'))
//
//// Wait for the success message
//WebUI.waitForElementPresent(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_Created customer successfully'), 7)
//WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/a_ant-notification-notice-close'))
//
//// Verify if the created customer can be found
//WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
//    uniqueEmailAddress)
//WebUI.sendKeys(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
//    Keys.chord(Keys.ENTER))
//WebUI.verifyElementText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_Email lyautomation-test-1ampup.io'), uniqueEmailAddress)
//
//
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/svg_Installer Job_feather feather-arrow-left'))
////
////WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    'Lyam')
////
////WebUI.sendKeys(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    Keys.chord(Keys.ENTER))
////
////WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    'Lyam 2 Test - Cartwright')
////
////WebUI.sendKeys(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    Keys.chord(Keys.ENTER))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_Lite 19'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_Basic  1'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_Pro  4'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_Email ly2ampup.io'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_Contact Liana'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/h1_Lyam 2 Test - Cartwright - Wuckert'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_987 Alaina Inlet'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/h1_Lyam 2 Test - Cartwright - Wuckert'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/p_Lite 19'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/div_Pro  4'))
////
////WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    'Augustin Larkin')
////
////WebUI.sendKeys(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    Keys.chord(Keys.ENTER))
////
////WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    'Agustin')
////
////WebUI.sendKeys(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    Keys.chord(Keys.ENTER))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/h3_Agustin Larkin'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/svg'))
////
////WebUI.doubleClick(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'))
////
////WebUI.setText(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/input_Ha Admin_ant-input ant-input-lg'), 
////    '')
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/a_2'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/li_Next'))
////
////WebUI.click(findTestObject('Object Repository/Customer/Page_Deployment Provisioning Tool/svg_Installer Job_feather feather-arrow-left'))
//
