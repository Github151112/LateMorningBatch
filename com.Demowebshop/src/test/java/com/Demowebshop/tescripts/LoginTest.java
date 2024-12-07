package com.Demowebshop.tescripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Demowebshop.genericlib.BaseTest;
import com.Demowebshop.genericlib.CustomListener;
import com.Demowebshop.genericlib.Flib;
import com.Demowebshop.pompages.SigninPage;
import com.Demowebshop.pompages.WelcomePage;

@Listeners(CustomListener.class)
public class LoginTest extends BaseTest {

	@Test(groups = "FT")
	public void login() throws EncryptedDocumentException, IOException {

		String email = Flib.getDataFromExcel(EXCEL_PATH, LOGINSHEET, 1, 0);
		String password = Flib.getDataFromExcel(EXCEL_PATH, LOGINSHEET, 1, 1);
		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		/*
		 * hard assert Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		 */

		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(), "hbdfhjbdshbdbch");

		// login
		SigninPage sip = new SigninPage(driver);
		sip.toSignInDemoWeb(email, password);

		/*
		 * hard assert Assert.assertEquals(sip.getLogoutLink().isDisplayed(), true);
		 */

		s.assertAll();

	}

}
