package com.epam.reutska.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.reutska.googleCom.Letter;

public class InboxPage extends MessagePage<Letter> {
	private static final String LETTER_ROWS_SELECTOR = "table.F.cf.zt>tbody>tr";
	@FindBy(css = LETTER_ROWS_SELECTOR)
	public List<WebElement> letterRows;

	private static final String BUTTON_DELETE_SELECTOR = ".ar9.T-I-J3.J-J5-Ji";
	@FindBy(css = BUTTON_DELETE_SELECTOR)
	public WebElement buttonDelete;

	private void refreshElements() {
		inbox.click(); // refresh the page

		letterRows = new WebDriverWait(driver, 15)
				.until(new ExpectedCondition<List<WebElement>>() {
					public List<WebElement> apply(WebDriver webDriver) {
						try {
							return webDriver.findElements(By
									.cssSelector(LETTER_ROWS_SELECTOR));
						} catch (StaleElementReferenceException e) {
							return null;
						}
					}
				});
	}

	@Override
	public List<Letter> getItems() {
		refreshElements();

		List<Letter> letters = new ArrayList<>();

		int rowNum = 1;
		for (WebElement row : letterRows) {
			// letters.add(convertRowToLetter(row));
			letters.add(convertRowToLetter(rowNum++));
		}
		return letters;
	}

	private Letter convertRowToLetter(final int rowNum) {
		// private Letter convertRowToLetter(final WebElement row) {
		final List<WebElement> cells = new WebDriverWait(driver, 15)
				.until(new ExpectedCondition<List<WebElement>>() {
					public List<WebElement> apply(WebDriver webDriver) {
						try {
							return webDriver.findElements(By
									.xpath("//div[@class='Cp']/div/table/tbody/tr["
											+ rowNum + "]/td"));
						} catch (StaleElementReferenceException e) {
							return null;
						}
					}
				});

		// List<WebElement> cells = row.findElements(By.tagName("td"));

		String sender = new WebDriverWait(driver, 15)
				.until(new ExpectedCondition<String>() {
					public String apply(WebDriver webDriver) {
						try {
							return cells.get(4).findElement(By.tagName("span"))
									.getAttribute("email");
						} catch (StaleElementReferenceException e) {
							return "";
						}
					}
				});
		String subject = new WebDriverWait(driver, 15)
				.until(new ExpectedCondition<String>() {
					public String apply(WebDriver webDriver) {
						try {
							return cells.get(5)
									.findElements(By.tagName("span")).get(0)
									.getText();
						} catch (StaleElementReferenceException e) {
							return "";
						}
					}
				});
		String body = new WebDriverWait(driver, 15)
				.until(new ExpectedCondition<String>() {
					public String apply(WebDriver webDriver) {
						try {
							return cells.get(5)
									.findElements(By.tagName("span")).get(1)
									.getText();
						} catch (StaleElementReferenceException e) {
							return "";
						}
					}
				});

		if (body.indexOf(" - ") == 0) {
			body = body.substring(3);
		}

		return new Letter().withSender(sender).withSubject(subject)
				.withBody(body);
	}

	public void deleteLetter(Letter letter) {
		int rowNum = 1;
		for (WebElement row : letterRows) {
			// if (letter.equals(convertRowToLetter(row))) {
			// row.findElement(By.cssSelector(".T-Jo-auh")).click();
			// break;
			// }
			if (letter.equals(convertRowToLetter(rowNum++))) {
				row.findElement(By.cssSelector(".T-Jo-auh")).click();
				break;
			}
		}

		buttonDelete.click();
	}
}
