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

orderId = WebUI.getText(findTestObject('Object Repository/Regular_Flow/2_Commissioning/orderId'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/2_Commissioning/firstKanbanCard'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/2_Commissioning/button_Commissioning Form'))

WebUI.setText(findTestObject('Object Repository/Regular_Flow/2_Commissioning/input_EVC10 - 16 Amp_chargerId'), 
    GlobalVariable.qrIdList[0])

WebUI.setText(findTestObject('Object Repository/Regular_Flow/2_Commissioning/input_EVC10 - 16 Amp_serial'), 
    GlobalVariable.qrIdList[0])

WebUI.setText(findTestObject('Object Repository/Regular_Flow/2_Commissioning/input_EVC10 - 16 Amp_qrId'), 
    GlobalVariable.qrIdList[0])

WebUI.click(findTestObject('Object Repository/Regular_Flow/2_Commissioning/button_Next'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/2_Commissioning/button_Submit'))

WebUI.click(findTestObject('Object Repository/Regular_Flow/2_Commissioning/button_Back to Dashboard'))

// Expect
WebUI.verifyElementText(findTestObject('Object Repository/Regular_Flow/2_Commissioning/Order ID In Test Column'), orderId)