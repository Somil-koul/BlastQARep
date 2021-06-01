package com.disney.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.testng.asserts.SoftAssert;

import com.disney.browsermanager.WebDriverFactory;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
import com.disney.browsermanager.WebDriverFactory;


public class CustomAssert extends WebDriverFactory  {
	// org.testng.asserts.SoftAssert
	//SoftAssert softAssert;
	private String methodName = "";
	private String className = "";
	private String fullMethodName = "";
	private String fullClassName = "";
	private boolean isTakeScreen = true;
	private boolean isMakePDF = true;
	private String screenDirectory = System.getProperty("ScreenshotDirectoryName");

	public CustomAssert(String methodName) {
		this.fullMethodName = methodName;
		this.methodName = methodName.length() > 20 ? methodName.substring(0, 20) : methodName;
	}

	public CustomAssert(String methodName, String className) {
		//softAssert = new SoftAssert();
		this.fullMethodName = methodName;
		this.fullClassName = className;
		this.methodName = methodName.length() > 20 ? methodName.substring(0, 20) : methodName;
		this.className = className.length() > 20 ? className.substring(0, 20) : className;
	}

	public CustomAssert() {
		methodName = "Assertion";
	}

	
	public void assertTrue(boolean condition) {
		String methodName = this.methodName;
		if (!condition)
			methodName = methodName + ":failed";
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertTrue(condition);
	}

	
	public void assertTrue(boolean condition, String message) {
		String methodName = this.methodName;
		if (!condition)
			methodName = methodName + ":failed";
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertTrue(condition, message);
	}

	
	public void assertEquals(boolean actual, boolean expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(boolean actual, boolean expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");

		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(byte actual, byte expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(byte actual, byte expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(byte[] actual, byte[] expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(byte[] actual, byte[] expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(char actual, char expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(char actual, char expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(Collection<?> actual, Collection<?> expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(double actual, double expected, double delta) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta);
	}

	
	public void assertEquals(double actual, double expected, double delta, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta, message);
	}

	
	public void assertEquals(float actual, float expected, float delta) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta);
	}

	
	public void assertEquals(float actual, float expected, float delta, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta, message);
	}

	
	public void assertEquals(int actual, int expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(int actual, int expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(long actual, long expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(long actual, long expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(Map<?, ?> actual, Map<?, ?> expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(Object[] actual, Object[] expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(Object[] actual, Object[] expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(Set<?> actual, Set<?> expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(Set<?> actual, Set<?> expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(short actual, short expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(short actual, short expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEquals(String actual, String expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public void assertEquals(String actual, String expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public <T> void assertEquals(T actual, T expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	
	public <T> void assertEquals(T actual, T expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	
	public void assertEqualsNoOrder(Object[] actual, Object[] expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEqualsNoOrder(actual, expected);
	}

	
	public void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEqualsNoOrder(actual, expected, message);
	}

	
	public void assertFalse(boolean condition) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertFalse(condition);
	}

	
	public void assertFalse(boolean condition, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertFalse(condition, message);
	}

	
	public void assertNotEquals(double actual, double expected, double delta) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta);
	}

	
	public void assertNotEquals(double actual, double expected, double delta, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta, message);
	}

	
	public void assertNotEquals(float actual, float expected, float delta) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta);
	}

	
	public void assertNotEquals(float actual, float expected, float delta, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta, message);
	}

	
	public void assertNotEquals(Object actual, Object expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected);
	}

	
	public void assertNotEquals(Object actual, Object expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, message);
	}

	
	public void assertNotNull(Object object) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotNull(object);
	}

	
	public void assertNotNull(Object object, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotNull(object, message);
	}

	
	public void assertNotSame(Object actual, Object expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotSame(actual, expected);
	}

	
	public void assertNotSame(Object actual, Object expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotSame(actual, expected, message);
	}

	
	public void assertNull(Object object) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNull(object);
	}

	
	public void assertNull(Object object, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNull(object, message);
	}

	
	public void assertSame(Object actual, Object expected) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertSame(actual, expected);
	}

	
	public void assertSame(Object actual, Object expected, String message) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertSame(actual, expected, message);
	}

	public void assertTrue(boolean condition, boolean isTakeScreen) {
		String methodName = this.methodName;
		if (!condition)
			methodName = methodName + ":failed";
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertTrue(condition);
	}

	public void assertTrue(boolean condition, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertTrue(condition, message);
	}

	public void assertEquals(boolean actual, boolean expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(boolean actual, boolean expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(byte actual, byte expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(byte actual, byte expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(byte[] actual, byte[] expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(byte[] actual, byte[] expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(char actual, char expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(char actual, char expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(Collection<?> actual, Collection<?> expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(Collection<?> actual, Collection<?> expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(double actual, double expected, double delta, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta);
	}

	public void assertEquals(double actual, double expected, double delta, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta, message);
	}

	public void assertEquals(float actual, float expected, float delta, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta);
	}

	public void assertEquals(float actual, float expected, float delta, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, delta, message);
	}

	public void assertEquals(int actual, int expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(int actual, int expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(long actual, long expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(long actual, long expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(Map<?, ?> actual, Map<?, ?> expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(Object[] actual, Object[] expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(Object[] actual, Object[] expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(Set<?> actual, Set<?> expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(Set<?> actual, Set<?> expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(short actual, short expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(short actual, short expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEquals(String actual, String expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public void assertEquals(String actual, String expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public <T> void assertEquals(T actual, T expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected);
	}

	public <T> void assertEquals(T actual, T expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEquals(actual, expected, message);
	}

	public void assertEqualsNoOrder(Object[] actual, Object[] expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEqualsNoOrder(actual, expected);
	}

	public void assertEqualsNoOrder(Object[] actual, Object[] expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertEqualsNoOrder(actual, expected, message);
	}

	public void assertFalse(boolean condition, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertFalse(condition);
	}

	public void assertFalse(boolean condition, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertFalse(condition, message);
	}

	public void assertNotEquals(double actual, double expected, double delta, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta);
	}

	public void assertNotEquals(double actual, double expected, double delta, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta, message);
	}

	public void assertNotEquals(float actual, float expected, float delta, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta);
	}

	public void assertNotEquals(float actual, float expected, float delta, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, delta, message);
	}

	public void assertNotEquals(Object actual, Object expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected);
	}

	public void assertNotEquals(Object actual, Object expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotEquals(actual, expected, message);
	}

	public void assertNotNull(Object object, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotNull(object);
	}

	public void assertNotNull(Object object, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotNull(object, message);
	}

	public void assertNotSame(Object actual, Object expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotSame(actual, expected);
	}

	public void assertNotSame(Object actual, Object expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNotSame(actual, expected, message);
	}

	public void assertNull(Object object, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNull(object);
	}

	public void assertNull(Object object, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertNull(object, message);
	}

	public void assertSame(Object actual, Object expected, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertSame(actual, expected);
	}

	public void assertSame(Object actual, Object expected, String message, boolean isTakeScreen) {
		if (isTakeScreen)
			WebDriverFactory.AddVerificationScreenShot("Assertion ScreenShot");
		softAssert.assertSame(actual, expected, message);
	}

	
	public void assertAll() {
		softAssert.assertAll();
		// if (isMakePDF)
		// mergeScreenshotsToPDF();
	}

	/*
	 * public void takeScreenshot(String fileType) { try { Calendar calendar =
	 * Calendar.getInstance(); SimpleDateFormat formater = new
	 * SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); // try { //
	 * BaseTest.webDriver.finder().findElement(By.XPath("//html")).executeScript(
	 * "arguments[0].focus();"); // // } catch (Exception e) { //
	 * e.printStackTrace(); // } File scrFile =
	 * BaseTest.webDriver.screen().getImage(); // File scrFile = ((TakesScreenshot)
	 * // BaseTest.webDriver).getScreenshotAs(OutputType.FILE); try { String
	 * directoryTime = new DateUtil().getDate(); if (screenDirectory == null ||
	 * System.getProperty("ScreenshotDirectoryName") == null) screenDirectory = "";
	 * if (System.getProperty("ScreenshotDirectory") == null)
	 * System.setProperty("ScreenshotDirectory", screenDirectory + directoryTime);
	 * String reportDirectory = new
	 * File(System.getProperty("user.dir")).getAbsolutePath() +
	 * "\\test-output\\screenshots\\" + screenDirectory + directoryTime + "\\
	 * assertion"; if (className == null || className.length() == 0) className =
	 * methodName; if (className != null) reportDirectory = reportDirectory + "\\" +
	 * className; String fileType1 = fileType.split(":")[0]; String fileType2 =
	 * fileType.contains(":") ? "_" + fileType.split(":")[1] : "";
	 * 
	 * System.out.println("Assert screenshot dir>" + reportDirectory); File destFile
	 * = new File((String) reportDirectory + "\\" + fileType1 + "_" +
	 * formater.format(calendar.getTime()) + fileType2 + ".png");
	 * FileUtils.copyFile(scrFile, destFile); } catch (IOException e) {
	 * e.printStackTrace(); } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	// Pending merging for multi test case run
	/*
	 * public void mergeScreenshotsToPDF() {
	 * 
	 * String directoryTime = new DateUtil().getDate(); if (screenDirectory == null
	 * || System.getProperty("ScreenshotDirectoryName") == null) screenDirectory =
	 * ""; String reportDirectory = new
	 * File(System.getProperty("user.dir")).getAbsolutePath() +
	 * "\\test-output\\screenshots\\" + screenDirectory + directoryTime + "\\
	 * assertion"; if (className == null || className.length() == 0) className =
	 * methodName; if (fullClassName == null || fullClassName.length() == 0)
	 * fullClassName = fullMethodName;
	 * 
	 * reportDirectory = reportDirectory + "\\" + className; try { File dir = new
	 * File(reportDirectory);
	 * 
	 * File[] allFiles = dir.listFiles();
	 * 
	 * System.out.println(allFiles.length);
	 * 
	 * Document document = new Document();
	 * 
	 * // Instantiate the PDF writer
	 * 
	 * PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new
	 * File(reportDirectory + "\\" + fullClassName + ".pdf"))); writer.open();
	 * document.open();
	 * 
	 * for (File singleFile : allFiles) { if (singleFile.isFile() &&
	 * (singleFile.getAbsolutePath().toLowerCase().contains(".png") ||
	 * singleFile.getAbsolutePath().toLowerCase().contains(".jpg"))) {
	 * 
	 * String filename = singleFile.getAbsolutePath(); System.out.println(filename);
	 * // open the pdf for writing
	 * 
	 * // process content into image Image im = Image.getInstance(filename);
	 * 
	 * // set the size of the image im.scaleToFit(((PageSize.A4.getWidth()) * 9) /
	 * 10, PageSize.A4.getHeight());
	 * 
	 * // add the captured image to PDF document.add(im); document.add(new
	 * Paragraph(" ")); }
	 * 
	 * } // close the files and write to local system document.close();
	 * writer.close(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * // copy pdf file to common pdf folder File srcFile = new File(reportDirectory
	 * + "\\" + fullClassName + ".pdf"); String pdfDirectory = new
	 * File(System.getProperty("user.dir")).getAbsolutePath() +
	 * "\\test-output\\screenshots\\" + screenDirectory + directoryTime + "\\pdf";
	 * File destFile = new File(pdfDirectory + "\\" + fullClassName + ".pdf"); try {
	 * FileUtils.copyFile(srcFile, destFile); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}
