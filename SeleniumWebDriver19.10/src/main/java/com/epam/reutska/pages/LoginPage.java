package com.epam.reutska.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AnyPage {
	@FindBy(id = "Email")
	public WebElement userNameField;
	@FindBy(id = "Passwd")
	public WebElement passwordField;
	@FindBy(xpath = ".//*[@id='signIn']")
	public WebElement loginButton;

	public boolean isOnThisPage() {
		return loginButton.isDisplayed();
	}

	@Override
	void tryToOpen() {
		try {
			MyPageFactory.getPage(driver, InternalPage.class).logout();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public InternalPage loginWithValidCredentials(String username, String password)
			throws InterruptedException {

		userNameField.clear();
		userNameField.sendKeys(username);

		passwordField.clear();
		passwordField.sendKeys(password);

		loginButton.click();
		return MyPageFactory.getPage(driver, InternalPage.class);

	}
	public LoginPage loginWithInValidCredentials(String username, String password)
			throws InterruptedException {

		userNameField.clear();
		userNameField.sendKeys(username);

		passwordField.clear();
		passwordField.sendKeys(password);

		loginButton.click();
		return MyPageFactory.getPage(driver, LoginPage.class);

	}

}
