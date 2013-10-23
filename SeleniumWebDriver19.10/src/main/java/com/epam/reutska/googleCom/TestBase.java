package com.epam.reutska.googleCom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.epam.reutska.factory.WebDriverFactory;
import com.epam.reutska.pages.LoginPage;
import com.epam.reutska.pages.MyPageFactory;

public class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	protected WebDriverWait wait;

	protected StringBuffer verificationErrors = new StringBuffer();
	protected LoginPage loginPage;

	@BeforeClass
	public void setUp() throws Exception {
		driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());

		baseUrl = "https://accounts.google.com/";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	protected LoginPage goToMainPage() {
		driver.get(baseUrl
				+ "/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2&emr=1");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		return MyPageFactory.getPage(driver, LoginPage.class);
	}
}
