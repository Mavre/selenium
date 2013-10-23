package com.epam.reutska.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.reutska.googleCom.Letter;

public class InternalPage extends AnyPage {
	@FindBy(css = "[href='https://profiles.google.com/?hl=ru&tab=mX']")
	public WebElement LinkEmailForQuit;
	@FindBy(id = "gb_71")
	public WebElement buttonQuit;
	
	@FindBy(css = "a.J-Ke.n0")
	public WebElement inbox;

	@FindBy(xpath="//div[@class='z0']/div")
	public WebElement compose;
	@FindBy(css=".vO")
	public WebElement recipient;
	@FindBy(css=".aoT" )
	public WebElement subject;
	@FindBy(css="body" )
	public WebElement messageBodyText;
	@FindBy(xpath="//div[contains(@class, 'Ar')]/div[contains(@class, 'Am')]/iframe" )
	public WebElement messageBodyFrame;
	@FindBy(css=".T-I.J-J5-Ji.aoO.T-I-atl.L3" )
	public WebElement sendButton;

	public boolean isOnThisPage() {
		return LinkEmailForQuit.isDisplayed();
	}

	public void logout() throws InterruptedException {

		LinkEmailForQuit.click();

		buttonQuit.click();

	}

	@Override
	void tryToOpen() {
		try {
			MyPageFactory.getPage(driver, LoginPage.class).loginWithInValidCredentials(
					"testseleniumidemariia@gmail.com", "Reutskaya");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void sendMessage(Letter letter) throws InterruptedException {
		compose.click();
		
		
		recipient.clear();
		recipient.sendKeys(letter.getSender());

		
		subject.clear();
		subject.sendKeys(letter.getSubject());

		driver.switchTo().frame(messageBodyFrame);
		
		
		
		
		messageBodyText.sendKeys(letter.getBody());
		
	

		driver.switchTo().defaultContent();
		
		sendButton.click();
		
	}
}
