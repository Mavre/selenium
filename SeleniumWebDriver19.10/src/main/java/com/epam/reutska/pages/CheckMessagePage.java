package com.epam.reutska.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckMessagePage extends InternalPage {
	@FindBy(css = "td.yX.xY")
	public WebElement oneLetter;
	@FindBy(css = "span.go")
	public WebElement oneLetterSender;

	public void checkInbox() {

		inbox.click();

		oneLetter.click();

		assertEquals("<testseleniumidemariia@gmail.com>",
				oneLetterSender.getText());

	}

}
