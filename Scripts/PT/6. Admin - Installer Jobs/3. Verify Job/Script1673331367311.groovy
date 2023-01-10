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
WebUI.navigateToUrl('https://ampup-installer-dev.web.app/'+GlobalVariable.jobId)
//WebUI.navigateToUrl('https://install.ampup.io/63ae3da408736600125f8647')

// Set localStoarge to debug QR ID
WebUI.executeJavaScript('sessionStorage.setItem(\'showQrInput\', \'true\')', null)

// Start
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/button_START VERIFICATION'))
//String QrId = "AMPJ-123123123"
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/button_Enter QR ID'))
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/input_Enter QR ID_qrId'))
WebUI.setText(findTestObject('Object Repository/Page_AmpUp - Installer Web App/input_Enter QR ID_qrId'), GlobalVariable.qrId)
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/button_Submit'))
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/button_Next'))

// Open the emulator
WebUI.executeJavaScript('window.open()', null)
WebUI.switchToWindowTitle('')
WebUI.navigateToUrl('https://ocpp-emulator.web.app/login/')
WebUI.switchToWindowTitle('ampUp Emulator App')

// Login
WebUI.setText(findTestObject('Object Repository/Page_ampUp Emulator App/input_Email_email'), 'quy.nguyen@ampup.io')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_ampUp Emulator App/input_Password_password'), 'HuE7JP8OUQWjqQTmmb/YKA==')
WebUI.click(findTestObject('Object Repository/Page_ampUp Emulator App/button_Login'))

WebUI.setText(findTestObject('Object Repository/Page_ampUp Emulator App/input_Dev_rc_select_0'), 'joint-tech')
WebUI.click(findTestObject('Object Repository/Page_ampUp Emulator App/input_joint-tech_ant-input ant-input-lg sc-_1f0d9e'))

WebUI.setText(findTestObject('Object Repository/Page_ampUp Emulator App/input_joint-tech_ant-input ant-input-lg sc-_1f0d9e'), 
    GlobalVariable.chargerId)
WebUI.setText(findTestObject('Object Repository/Page_ampUp Emulator App/input_Dev_ant-input ant-input-lg sc-eCImvq gbHenx'), 
    '8')

WebUI.click(findTestObject('Object Repository/Page_ampUp Emulator App/button_Connect'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Deployment Provisioning Tool/successMessage'), 7)

// Back to the Installer App
WebUI.switchToWindowTitle('AmpUp - Installer Web App')
WebUI.click(findTestObject('Object Repository/Page_AmpUp - Installer Web App/button_Reload Status'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Deployment Provisioning Tool/successMessage'), 7)
