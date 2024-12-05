package com.Demowebshop.tescripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Demowebshop.genericlib.BaseTest;
import com.Demowebshop.genericlib.Flib;
import com.Demowebshop.pompages.SigninPage;
import com.Demowebshop.pompages.WelcomePage;

public class InvalidLoginTest extends BaseTest {

	@DataProvider(name = "TestData")
	public Object[][] invalidData() throws EncryptedDocumentException, IOException {
		return Flib.readExcel(EXCEL_PATH, INVALIDATA);

	}

	@Test(dataProvider = "TestData", groups = "ST")
	public void invalidLogin(String username, String password) {
		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		// sign in
		SigninPage sip = new SigninPage(driver);
		sip.toInvalidSignInDemoWeb(username, password);
	}

}
