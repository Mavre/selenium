package com.epam.reutska.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	public WebDriver driver;

	public boolean isOnThisPage() {
		return true;
	}
	abstract void  tryToOpen();

}
