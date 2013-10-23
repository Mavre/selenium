package com.epam.reutska.googleCom;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.epam.reutska.pages.InboxPage;
import com.epam.reutska.pages.MyPageFactory;

public class SendMessageTest extends TestBase {

	@Test
	public void testGooglecom() throws Exception {

		InboxPage inbox = MyPageFactory.getPage(driver, InboxPage.class);

		List<Letter> oldList = inbox.getItems();
		Letter letter = new Letter();
		letter.withSender("testseleniumidemariia@gmail.com")
				.withSubject("Subject").withBody("Body");

		if(oldList.contains(letter)){
			inbox.deleteLetter(letter);
			oldList=inbox.getItems();
		}

		inbox.sendMessage(letter);

		List<Letter> newList = inbox.getItems();

		oldList.add(letter);
		
		Collections.sort(oldList);
		Collections.sort(newList);
		
		assertEquals(oldList, newList);
	}

}
