package com.epam.reutska.googleCom;

import org.testng.annotations.Test;

import com.epam.reutska.pages.InternalPage;
import com.epam.reutska.pages.MyPageFactory;

public class LogoutTest extends TestBase {
	

	
	

	@Test
	public void testGooglecom() throws Exception {

		MyPageFactory.getPage(driver, InternalPage.class).logout();

	}

}
