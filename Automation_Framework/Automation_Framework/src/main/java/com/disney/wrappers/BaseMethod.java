package com.disney.wrappers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.disney.browsermanager.BrowserFactory;
import com.disney.browsermanager.WebDriverFactory;
import com.disney.browsermanager.WebDriverFactory;
import com.disney.common.Constants;
import com.disney.utils.ExplicitWaiting;

@SuppressWarnings("deprecation")
public class BaseMethod extends WebDriverFactory {

	/* To get the Website Name */
	public String getUrlTitle() throws Exception {
		URL aURL = new URL(WebsiteURL);
		String WebName = aURL.getHost();
		String WebSiteName = WebName.toUpperCase();
		return WebSiteName;
	}

	/* To Press ENTER Key using Robot */
	public synchronized void hitEnter() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_ENTER);
		re.keyRelease(KeyEvent.VK_ENTER);
	}

	/* To Press BACKSPACE Key using Robot */
	public synchronized void hitBackspace() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_BACK_SPACE);
		re.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	/* To Press DELETE Key using Robot */
	public synchronized void hitDelete() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_DELETE);
		re.keyRelease(KeyEvent.VK_DELETE);
	}

	/* To Select all the Text/Web Elements using ROBOT */
	public synchronized void selectAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_A);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_A);
	}

	/* To Copy all the Selected Text/Web Elements using ROBOT */
	public synchronized void copyAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_C);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_C);
	}

	/* To Paste all the Selected Text/Web Elements using ROBOT */
	public synchronized void pasteAll() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_V);
	}

	/* To Capture Screenshot(Replaces if already exists) */
	/*
	 * Also, Make sure that the automation in running in the foreground to capture
	 * the Image of the Browser. Else, It'll capture the open Window
	 */
	public synchronized void robotScreenCapture(String robotImageName) throws Exception {
		re = new Robot();
		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = re.createScreenCapture(area);
		// Save as PNG
		File file = new File(robotImageName);
		if (file.exists()) {
			file.delete();
		}
		ImageIO.write(bufferedImage, "png", file);
	}

	/* To ZoomOut */
	public synchronized void robotZoomOut() throws Exception {

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_CONTROL);

	}

	/* To ZoomOut */
	public synchronized void keyPress(int keycode) throws Exception {
		re = new Robot();
		re.keyPress(keycode);

	}

	/* To ZoomOut */
	public synchronized void keyRelease(int keycode) throws Exception {
		re = new Robot();
		re.keyRelease(keycode);

	}

	/* To ZoomIn */
	public synchronized void robotZoomIn() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}

	/* To ScrollUp using ROBOT */
	public synchronized void robotScrollUp() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_UP);
		re.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	/* To ScrollDown using ROBOT */
	public synchronized void robotScrollDown() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		re.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	/* To ScrollUp using JavaScript Executor */
	public synchronized void scrollUp() throws Exception {
		((JavascriptExecutor) BrowserFactory.driver).executeScript("scroll(0, -100);");
	}

	/* To ScrollDown using JavaScript Executor */
	public synchronized void scrollDown() throws Exception {
		((JavascriptExecutor) BrowserFactory.driver).executeScript("scroll(0, 1000);");
	}

	/* To Move cursor to the Desired Location */
	public synchronized void moveCursor(int X_Position, int Y_Position) throws Exception {
		re.mouseMove(X_Position, Y_Position);
	}

	/* To Accept the Alert Dialog Message */
	public synchronized void alertAccept() throws Exception {
		al = BrowserFactory.driver.switchTo().alert();
		al.accept();
	}

	/* To Dismiss the Alert Dialog Message */
	public synchronized void alertDismiss() throws Exception {
		al = BrowserFactory.driver.switchTo().alert();
		al.dismiss();
	}

	/* To Get the Alert Messages */
	public String getAlertText() throws Exception {
		al = driver.switchTo().alert();
		String text = al.getText();
		Thread.sleep(2000);
		alertAccept();
		return text;
	}

	/* To Perform a WebAction of Mouse Over */
	public synchronized void mousehover(WebElement element) {
		newaction.moveToElement(element).build().perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}
	}

	/* To Perform Select Option by Visible Text */
	public synchronized void selectByVisibleText(WebElement element, String value) {
		se = new Select(element);
		se.selectByVisibleText(value);
	}

	/* To Perform Select Option by Index */
	public synchronized void selectByIndex(WebElement element, int value) {
		se = new Select(element);
		se.selectByIndex(value);
	}

	/* To Perform Select Option by Value */
	public synchronized void selectByValue(WebElement element, String value) {
		se = new Select(element);
		se.selectByValue(value);
	}

	/* To click a certain Web Element */
	public synchronized void click(WebElement element) {
		waitForJSandJQueryToLoad();
		element.click();
	}

	public static String getText(WebElement element) {
		String text = "";
		int attempts = 0;
		while (attempts < 2) {
			try {
				text = element.getText();
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return text;
	}

	/* To click a certain Web Element using DOM/ JavaScript Executor */
	public synchronized void JSclick(WebElement element) {
		waitForJSandJQueryToLoad();
		((JavascriptExecutor) BrowserFactory.driver).executeScript("return arguments[0].click();", element);

	}

	/* To Type at the specified location */
	public synchronized void sendKeys(WebElement element, String value) {
		waitForJSandJQueryToLoad();
		element.sendKeys(value);

	}

	public synchronized void sendKeys(WebElement element, Keys keyvalue) {
		waitForJSandJQueryToLoad();
		element.sendKeys(keyvalue);

	}

	/* To Clear the content in the input location */
	public synchronized void clear(WebElement element) {
		waitForJSandJQueryToLoad();
		element.clear();
	}

	/* To Drag and Drop from Source Locator to Destination Locator */
	public synchronized void dragandDrop(WebElement Source, WebElement Destination) {
		// ac = new Actions(BrowserFactory.driver);
		newaction.dragAndDrop(Source, Destination);
	}

	/*
	 * To Drag from the given WebElement Location and Drop at the given WebElement
	 * location
	 */
	public synchronized void dragandDropTo(WebElement Source, int XOffset, int YOffset) throws Exception {
		newaction.dragAndDropBy(Source, XOffset, YOffset);
	}

	/* To Open a Page in New Tab */
	public synchronized void rightClick(WebElement element) {
		ExplicitWaiting.explicitWaitVisibilityOfElement(element, 30);
		newaction.contextClick(element).build().perform();
	}

	/* To Close Current Tab */
	public synchronized void closeCurrentTab() {
		BrowserFactory.driver.close();
	}

	/* To Perform Click and Hold Action */
	public synchronized void clickAndHold(WebElement element) {
		ac = new Actions(BrowserFactory.driver);
		ac.clickAndHold(element);
		ac.build().perform();
	}

	/* To Perform Click and Hold Action */
	public synchronized void doubleClick(WebElement element) {
		scrollToElementLoc(element);
		ac = new Actions(BrowserFactory.driver);
		ac.doubleClick(element);
		ac.build().perform();
	}

	/* To Switch To Frame By Index */
	public synchronized void switchToFrameByIndex(int index) throws Exception {
		BrowserFactory.driver.switchTo().frame(index);

	}

	/* To Switch To Frame By Frame Name */
	public synchronized void switchToFrameByFrameName(String frameName) throws Exception {
		BrowserFactory.driver.switchTo().frame(frameName);
	}

	/* To Switch To Frame By Web Element */
	public synchronized void switchToFrameByWebElement(WebElement element) throws Exception {
		BrowserFactory.driver.switchTo().frame(element);
	}

	/* To Switch out of a Frame */
	public synchronized void switchOutOfFrame() throws Exception {
		BrowserFactory.driver.switchTo().defaultContent();
	}

	/* To Get Tooltip Text */
	public String getTooltipText(WebElement element) {
		String tooltipText = element.getAttribute("title").trim();
		return tooltipText;
	}

	/* Scroll to the specific element of the page */
	public synchronized void scrollToElementLoc(WebElement element) {
		int attempts = 0;
		while (attempts < 2) {
			try {

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
	}

	/* Wait for visibility of Element */
	public synchronized void waitUntilVisible(WebElement element) {
		new WebDriverWait(BrowserFactory.driver, 150).until(ExpectedConditions.visibilityOf(element));
		explicitWait(Constants.MEDIUM_PAUSE_MILLISECONDS);
	}

	/* Wait for Element to Clickable */
	public synchronized void waitUntilClickable(WebElement airingschedule2) {
		new WebDriverWait(BrowserFactory.driver, 120).until(ExpectedConditions.visibilityOf(airingschedule2));

	}

	public synchronized void waitForPageLoad() {
		new WebDriverWait(BrowserFactory.driver, 120).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	/*
	 * Scroll to the Bottom of the Page
	 */
	public synchronized void scrollToPageBottom() {

		((JavascriptExecutor) BrowserFactory.driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static synchronized void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectationLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(2000);
//			WebDriverWait waitForLoad = new WebDriverWait(BrowserFactory.driver, 33);
			WebDriverWait waitForLoad = new WebDriverWait(BrowserFactory.driver, 33);
			waitForLoad.until(expectationLoad);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static synchronized void waitForAjaxFinished() {
		ExpectedCondition<Boolean> expectationAjax = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
			}
		};
		try {
			Thread.sleep(2000);
//			WebDriverWait waitForAjax = new WebDriverWait(BrowserFactory.driver, 33);
			WebDriverWait waitForAjax = new WebDriverWait(BrowserFactory.driver, 33);
			waitForAjax.until(expectationAjax);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Ajax Finished to complete.");
		}
	}

	protected boolean waitForJSandJQueryToLoad() {

//		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 70);
		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 70);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(3000);

					return ((Long) ((JavascriptExecutor) driver).executeScript("return document.readyState") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static synchronized void copyPaste(WebElement element, String stringtoPaste) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(stringtoPaste);
		clipboard.setContents(strSel, null);
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public static boolean isDisplayed(WebElement element) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
		}
		boolean status = false;

		int attempts = 0;
		while (attempts < 2) {
			try {
				status = element.isDisplayed();
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return status;
	}

	public boolean isDisplayed(List<WebElement> element) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
		}
		boolean status = false;

		int attempts = 0;
		while (attempts < 2) {
			try {
				status = element.size() > 0;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return status;
	}

	/*
	 * Waits for the element to be invisible
	 */
	public synchronized void waitToInvisible(String xpathName) {
		logger.info("Waiting for the element to be invisible");
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathName)));
		logger.info("Element is invisible");
	}

	public synchronized void mouseHover(WebElement parentElement, WebElement childElement) {
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement parent = wait.until(ExpectedConditions.visibilityOf(parentElement));
		act.moveToElement(parent).moveToElement(childElement).click().build().perform();

	}

	public synchronized void clickXpath(WebElement element) {
		WebElement ele = element;
//		Actions action = new Actions(BrowserFactory.driver);
		Actions action = new Actions(BrowserFactory.driver);
		action.moveToElement(ele).click().perform();
	}

	public static WebElement getElement(WebElement Webelement) {
		final long startTime = System.currentTimeMillis();
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element. Try number " + (tries++));
			try {
				// we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				we = wait.until(ExpectedConditions.visibilityOf(Webelement));

				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			} catch (TimeoutException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			logger.info("Found element after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.info("Failed to find element after " + totalTime + " milliseconds.");
		}
		return we;
	}

	public static List<WebElement> getElements(List<WebElement> Webelements) {
		final long startTime = System.currentTimeMillis();
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		List<WebElement> we = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element. Try number " + (tries++));
			try {
				we = wait.until(ExpectedConditions.visibilityOfAllElements(Webelements));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			logger.info("Found element after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.info("Failed to find element after " + totalTime + " milliseconds.");
		}
		return we;
	}

	public static synchronized void rightClickJavaScript(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String javaScript = "var evt = document.createEvent('MouseEvents');" + "var RIGHT_CLICK_BUTTON_CODE = 2;"
				+ "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
				+ "arguments[0].dispatchEvent(evt)";

		js.executeScript(javaScript, webElement);
	}

	public synchronized void staleElementClick(WebElement element) {
		for (int i = 0; i <= 2; i++) {
			try {
				click(element);
				break;
			} catch (Exception e) {
				// logger.info(e.getMessage());
				try {
					Thread.sleep(2000);
					i++;
				} catch (InterruptedException e1) {

				}
			}
		}
	}

	public synchronized void waitUntilStaleElement(WebElement element) {
		for (int i = 0; i <= 2; i++) {
			try {
				new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(element));
				break;
			} catch (Exception e) {
				// logger.info(e.getMessage());
				try {
					Thread.sleep(2000);
					i++;
				} catch (InterruptedException e1) {

				}
			}
		}
	}

	public static synchronized void javascriptDoubleClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}

	public static boolean waitUntilVisbility(WebElement element) {
		boolean status = false;

		for (int i = 0; i <= 2; i++) {
			try {
//				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 5);
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 5);
				status = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
				break;

			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {

				}
				i++;
			}

		}
		return status;
	}

	public synchronized void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//				((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
				((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);

			} else {
				logger.info("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			logger.info("Element with " + HoverElement + "is not attached to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			logger.info("Element " + HoverElement + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Error occurred while hovering" + e.getStackTrace());
		}
	}

	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

	public static synchronized void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static synchronized void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static synchronized void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static synchronized void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static synchronized void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static String getBrowserInfo(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public static synchronized void sendKeysUsingJSWithID(WebDriver driver, String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public static synchronized void sendKeysUsingJSWithClassName(WebDriver driver, String className, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + className + "').value='" + value + "'");
	}

	public static synchronized void sendKeysUsingJSWithName(WebDriver driver, String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + name + "').value='" + value + "'");
	}

	public static synchronized void explicitWait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized static void Iselementdisabled(WebElement ele) {
		boolean fname = ele.isEnabled();
		System.out.print("Textbox is disabled : " + fname);
	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @throws Exception
	 */
	protected static synchronized void waitForElementToBePresent(String description, WebElement element)
			throws Exception {
		logger.info("Wait for [" + description + "] to become visible");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("[" + description + "] is visible now");
		} catch (Exception e) {
			logger.error("Unable to find [" + description + "]", e);
			throw e;
		}
	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @param seconds     : Time in seconds
	 * @throws Exception
	 */
	public static synchronized void waitForElementToBePresent(String description, WebElement element, long seconds)
			throws Exception {
		logger.info("Wait for [" + description + "] to become visible");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("[" + description + "] is visible now");
		} catch (Exception e) {
			logger.error("Unable to find [" + description + "]", e);
			throw e;
		}
	}

	/**
	 * This method is used to switch between the windows
	 */
	public static synchronized void switchtoWindow() {
		{
			// It will return the parent window name as a String
			String parent = driver.getWindowHandle();

			Set<String> s = driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				String child_window = I1.next();

				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
				}
			}
		}
	}
}