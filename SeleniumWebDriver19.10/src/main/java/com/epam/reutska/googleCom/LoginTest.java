package com.epam.reutska.googleCom;

import org.testng.annotations.Test;

import com.epam.reutska.pages.LoginPage;
import com.epam.reutska.pages.MyPageFactory;

public class LoginTest extends TestBase {

	@Test
	public void testGooglecom() throws Exception {
		goToMainPage().loginWithValidCredentials(
				"testseleniumidemariia@gmail.com", "Reutskaya");

	}

}
