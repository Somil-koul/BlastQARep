
package com.disney.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.disney.browsermanager.WebDriverFactory;
import com.disney.common.Constants;

@SuppressWarnings("deprecation")
public class ExplicitWaiting extends WebDriverFactory {

	/* Select using WebElements */
	/** To Wait Until Element to be Clickable */
	public static void explicitWaitElementToBeClickable(WebElement element, int time) {

		WebDriverWait clickableWait = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		clickableWait.until(angularHasFinishedProcessing());
		clickableWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/** To Wait Until Element to be Selectable */
	public static void explicitWaitElementToBeSelected(WebElement element, int time) {
		WebDriverWait selectableWait = new WebDriverWait(driver, time);
		selectableWait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/** To Wait Until Element has the text */
	public static void explicitWaitTextToBePresentInElement(WebElement element, int time, String text) {
		WebDriverWait textToBePresent = new WebDriverWait(driver, time);
		textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/** To Wait Until Title contains the text */
	public static void explicitWaitTitleContains(WebElement element, int time, String title) {
		WebDriverWait titleContains = new WebDriverWait(driver, time);
		titleContains.until(ExpectedConditions.titleContains(title));
	}

	/** To Wait Until Title is */
	public static void explicitWaitTitleIs(WebElement element, int time, String title) {
		WebDriverWait titleIs = new WebDriverWait(driver, time);
		titleIs.until(ExpectedConditions.titleIs(title));
	}

	/** To Wait Until Element to be Visible */
	public static void explicitWaitVisibilityOfElement(WebElement element, int time) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		elementToBeVisible.until(angularHasFinishedProcessing());
		try {
			elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			Assert.fail(element + " is not visible and timedout");
		}
	}

	public static void explicitWaitVisibilityOfElementLocated(String xPathSplit, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathSplit)));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/** To Wait Until Element is Selected */
	public static void explicitWaitSelectionStateToBe(WebElement element, int time, boolean selected) {
		WebDriverWait elementIsSelected = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	/** To Wait Until Elements to be Visible */
	@SuppressWarnings("unused")
	public static void explicitWaitVisibilityOfElements(List<WebElement> element, int time) {
		WebDriverWait elementsToBeVisible = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void explicitWaitVisibilityOfElements(By element, int time) {
		WebDriverWait elementsToBeVisible = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		elementsToBeVisible.until(angularHasFinishedProcessing());
		elementsToBeVisible
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(element)));
	}

	/* Select using By Method */
	/** To Wait Until Element to be Clickable */
	public static void explicitWaitElementToBeClickable(By element, int time) {
		WebDriverWait clickableWait = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		clickableWait.until(angularHasFinishedProcessing());
		clickableWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/** To Wait Until Element to be Selectable */
	public static void explicitWaitElementToBeSelected(By element, int time) {
		WebDriverWait selectableWait = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		selectableWait.until(angularHasFinishedProcessing());
		selectableWait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/** To Wait Until Title contains the text */
	public static void explicitWaitTitleContains(By element, int time, String title) {
		WebDriverWait titleContains = new WebDriverWait(driver, time);
		titleContains.until(ExpectedConditions.titleContains(title));
	}

	/** To Wait Until Title is */
	public static void explicitWaitTitleIs(By element, int time, String title) {
		WebDriverWait titleIs = new WebDriverWait(driver, time);
		titleIs.until(ExpectedConditions.titleIs(title));
	}

	/** To Wait Until Element to be Visible */
	public static void explicitWaitVisibilityOfElement(By element, int time) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, Constants.XXLARGE_PAUSE_MILLISECONDS);
		elementToBeVisible.until(angularHasFinishedProcessing());
		elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	/** To Wait Until Element is Selected */
	public static void explicitWaitSelectionStateToBe(By element, int time, boolean selected) {
		WebDriverWait elementToBeVisible = new WebDriverWait(driver, time);
		elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	/** To Wait for the Alert */
	public static void explicitWaitForAlert(int time) {
		WebDriverWait waitForAlert = new WebDriverWait(driver, time);
		waitForAlert.until(ExpectedConditions.alertIsPresent());
	}

	public static void explicitWaitForFrame(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("iframe"))));
	}

	private ExpectedCondition<?> getDefaultCondition(By myBy, WebElement element) {
		// generate the most popular wiatCondition to check if element visible or
		// present
		ExpectedCondition<?> waitCondition = null;
		if (element != null) {
			waitCondition = ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(myBy),
					ExpectedConditions.visibilityOfElementLocated(myBy), ExpectedConditions.visibilityOf(element));
		} else {
			waitCondition = ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(myBy),
					ExpectedConditions.visibilityOfElementLocated(myBy));
		}

		return waitCondition;
	}

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript(
						"return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
						.toString());
			}
		};
	}
}
