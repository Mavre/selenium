
package com.epam.reutska.googleCom;

import org.testng.annotations.Test;

import com.epam.reutska.pages.CheckMessagePage;
import com.epam.reutska.pages.MyPageFactory;

public class CheckMessageTest extends TestBase {

	@Test
	public void testGooglecom() throws Exception {

		MyPageFactory.getPage(driver, CheckMessagePage.class).checkInbox();

	}

}