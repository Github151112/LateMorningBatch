package com.Demowebshop.tescripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Demowebshop.genericlib.BaseTest;
import com.Demowebshop.genericlib.Flib;
import com.Demowebshop.pompages.SigninPage;
import com.Demowebshop.pompages.WelcomePage;

public class LoginTest extends BaseTest {

	@Test(groups = "FT")
	public void login() throws EncryptedDocumentException, IOException {

		String email = Flib.getDataFromExcel(EXCEL_PATH, LOGINSHEET, 1, 0);
		String password = Flib.getDataFromExcel(EXCEL_PATH, LOGINSHEET, 1, 1);

		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		// login
		SigninPage sip = new SigninPage(driver);
		sip.toSignInDemoWeb(email, password);

	}

}
