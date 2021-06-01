package com.disney.listeners;

import java.util.concurrent.TimeUnit;
import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.disney.browsermanager.InitMethod;
import com.disney.utils.ResultSender;

public class TestListener extends InitMethod implements ITestListener {

	public void onStart(ITestContext context) {
		logger.info("*** TEST SUITE " + context.getName() + " STARTED ***");
	}

	public void onFinish(ITestContext context) {
		logger.info(("*** TEST SUITE" + context.getName() + " ENDING ***"));
		this.sendTestClassStatus(context);
	}

	public void onTestStart(ITestResult result) {
		logger.info(("*** RUNNING TEST METHOD " + result.getMethod().getMethodName() + "..."));

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("*** EXECUTED " + result.getMethod().getMethodName() + " TEST SUCCESSFULLY...");
	}

	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getClass().getSimpleName();
		this.sendTestMethodStatus(result, "FAIL");
		logger.info(testCaseName);

	}

	public void onTestSkipped(ITestResult result) {

		logger.info(("*** TEST " + result.getMethod().getMethodName() + " SKIPPED ***"));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	private void sendTestMethodStatus(ITestResult iTestResult, String status) {
		Point point = Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("testclass", iTestResult.getTestClass().getName()).tag("name", iTestResult.getName())
				.tag("description", iTestResult.getMethod().getDescription()).tag("result", status)
				.addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
		ResultSender.send(point);
	}

	private void sendTestClassStatus(ITestContext iTestContext) {
		Point point = Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
				.addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
				.build();
		ResultSender.send(point);
	}

}
