package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.kms.katalon.core.configuration.RunConfiguration



class login {



	@Given("I navigate to login page")
	def I_navigate_to_login_page() {
		RunConfiguration.setWebDriverPreferencesProperty("args", [
			"--window-size=1920,1080",
			"--chrome"
		])
		WebUI.openBrowser('https://ileads-frontend-support-dev.apps.ocp-jkt.pegadaian.co.id/')
		WebUI.refresh()
		WebUI.maximizeWindow()
		//WebUI.waitForPageLoad(30)


	}

	@When("I enter username (.*) and password (.*)")
	def I_enter_valid_username_password(String username, String password) {

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type = 'text' and @name = 'username' and @placeholder = 'NIK HCIS/Aralia']"), username)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type = 'password' and @name = 'password' and @placeholder = 'Password HCIS/Aralia']"), password)
	}

	@And("I click sign in button")
	def I_click_sign_btn() {

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type = 'submit' and (text() = 'Sign In' or . = 'Sign In')]"))
	}

	@Then("I should be able to login successfully")
	def I_login_successfully() {

		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Home Page' or . = 'Home Page')]"),0)
	}
}