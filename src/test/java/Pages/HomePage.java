package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	JavascriptExecutor js;
	WebDriverWait wait;
	WebDriver driver;
	Actions act;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
	}

	// TC 01
	public void click2ndSectionWomenShoesAndCloseTab() {

		js.executeScript("window.scrollTo(0, 1000);");

		WebElement WomenshoesCTA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'category-card')]//a[normalize-space(text())=\"WOMEN'S SHOES\"]\r\n" + "")));

		String parent = driver.getWindowHandle();

		// Open in new tab
		act.keyDown(Keys.CONTROL).click(WomenshoesCTA).keyUp(Keys.CONTROL).perform();

		// Wait till child tab opens
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to child tab
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(parent)) {
				driver.switchTo().window(tab);
				break;
			}
		}

		// Simple wait (page is usable)
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		// EXTRA 2 seconds wait (as required)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close child tab and switch back
		driver.close();
		driver.switchTo().window(parent);
	}

	// TC 02
	public void click2ndSectionMenShoesAndCloseTab() {

		js.executeScript("window.scrollTo(0, 1000);");

		WebElement MenshoesCTA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'category-card')]//a[normalize-space(text())=\"MEN'S SHOES\"]\r\n" + "")));

		String parent = driver.getWindowHandle();

		// Open in new tab
		act.keyDown(Keys.CONTROL).click(MenshoesCTA).keyUp(Keys.CONTROL).perform();

		// Wait till child tab opens
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to child tab
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(parent)) {
				driver.switchTo().window(tab);
				break;
			}
		}

		// Simple wait (page is usable)
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		// EXTRA 2 seconds wait (as required)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close child tab and switch back
		driver.close();
		driver.switchTo().window(parent);
	}
}
