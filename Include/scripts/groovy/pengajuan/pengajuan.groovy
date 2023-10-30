package pengajuan
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.After
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
import upload.uploadData





class pengajuan {

	@Given("I navigate to home page")
	def I_navigate_to_home_page() {

		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Home Page' or . = 'Home Page')]"),0)
	}

	@When("I click Learning Wallet menu")
	def I_click_Learning_Wallet_menu() {

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="menu-Learning Wallet"]/span'))
	}
	@And ("I click Pengajuan Pelatihan dropdown")
	def I_click_Pengajuan_Pelatihan_dropdown() {

		WebUI.waitForElementClickable(new TestObject().addProperty('id', ConditionType.EQUALS, "menu-Pengajuan Pelatihan"), 0)
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "menu-Pengajuan Pelatihan"))
	}

	@And ("I click Pengajuan menu")
	def I_click_Pengajuan__menu() {

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Pengajuan' or . = 'Pengajuan')]"))
	}

	@And ("I click Pengajuan Learning Program")
	def I_click_Pengajuan_Learning_Program() {

		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="app"]/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div/button[1]'), 0)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="app"]/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div/button[1]'))
	}

	@Then("I should be able to open modul Form Pengajuan")
	def I_should_be_able_to_open_modul_Form_Pengajuan() {

		WebUI.verifyElementPresent(new TestObject().addProperty('id', ConditionType.EQUALS, "modal-submission___BV_modal_title_"),0)
	}
}


class pengisian{

	String Deskripsi = 'ini deskripsi pengajuan'
	String Nilai = '1000'
	String Tujuan = 'Improvment'
	String Lokasi = 'Jakarta'
	String Vendor = 'Paramatech'


	@Given("I navigate to form pengajuan")
	def I_navigate_to_form_pengajuan() {

		WebUI.verifyElementPresent(new TestObject().addProperty('id', ConditionType.EQUALS, "modal-submission___BV_modal_title_"),0)
	}

	@When("I select job kopetensi field")
	def I_select_job_kopetensi_field() {

		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "vs5__combobox"))
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "vs5__option-4"))
	}

	@And ("I type deskripsi pengajuan field")
	def I_type_deskripsi_pengajuan_field() {

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.CONTAINS, "//input[@placeholder = 'DESKRIPSI PENGAJUAN']"), Deskripsi)
	}

	@And ("I set nilai pengajuan field")
	def I_set_nilai_pengajuan_field() {

		WebUI.clearText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = '100']"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = '100']"), Nilai)
	}

	@And ("I type Tujuan megajukan field")
	def I_type_Tujuan_megajukan_field() {

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "note"), Tujuan)
	}

	@And ("I type lokasi training field")
	def I_type_lokasi_training_field() {

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'LOKASI TRAINING']"), Lokasi)
	}

	@And ("I type vendor field")
	def I_type_vendor_field() {

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'VENDOR']"), Vendor)
	}

	@And ("I upload bukti pengajuan")
	def I_upload_bukti_pengajuan() {

		String imagePath1 = 'C:\\Users\\Ozy\\Downloads\\upload_test.pdf'
		new uploadData().uploadFile1(new TestObject().addProperty('id', ConditionType.EQUALS, "dropzone"), imagePath1)
	}

	@And ("I click ceklist box")
	def I_click_ceklist_box() {

		//WebUI.waitForElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='__BVID__267']/div/div"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='__BVID__267']/div/div"))
		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='__BVID__267']/div/div//*[@id='__BVID__377']/div/div/label"))

	}

	@And ("I click simpan button")
	def I_click_simpan_button() {

		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type = 'button' and (text() = 'Simpan' or . = 'Simpan')]"), 0)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type = 'button' and (text() = 'Simpan' or . = 'Simpan')]"))
	}
}