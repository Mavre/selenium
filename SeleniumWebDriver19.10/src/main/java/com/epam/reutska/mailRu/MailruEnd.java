package com.epam.reutska.mailRu;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MailruEnd {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://mail.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMailruEnd() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("mailbox__login")).clear();
    driver.findElement(By.id("mailbox__login")).sendKeys("testseleniumidemariia");
    driver.findElement(By.id("mailbox__password")).clear();
    driver.findElement(By.id("mailbox__password")).sendKeys("Reutskaya");
    try {
      assertTrue(isElementPresent(By.id("mailbox__auth__button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("mailbox__auth__button")).click();
    try {
      assertTrue(isElementPresent(By.id("HeaderBtnSentMsg")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("HeaderBtnSentMsg"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("HeaderBtnSentMsg")).click();
    driver.findElement(By.id("sentmsgab_compose_to")).clear();
    driver.findElement(By.id("sentmsgab_compose_to")).sendKeys("testseleniumidemariia@mail.ru");
    driver.findElement(By.id("sentmsgab_compose_subj")).clear();
    driver.findElement(By.id("sentmsgab_compose_subj")).sendKeys("Subject");
   
    
    try {
      assertTrue(isElementPresent(By.cssSelector("#sentmsgbottomComposeControls > div.nojsdn > a.button-a.js-send")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("#sentmsgbottomComposeControls > div.nojsdn > a.button-a.js-send")).click();
    driver.findElement(By.xpath("(//input[@value='body'])[4]")).click();
    assertTrue(isElementPresent(By.cssSelector("span.menu__item__link__text.menu__item__link__text_linear")));
    driver.findElement(By.cssSelector("span.menu__item__link__text.menu__item__link__text_linear")).click();
    driver.findElement(By.cssSelector("span.messageline__body__name")).click();
    try {
      assertTrue(isElementPresent(By.xpath("//tr[@id='msgFieldFrom']/td[2]/span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.id("PH_logoutLink")));
    driver.findElement(By.id("PH_logoutLink")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

