package com.adactinhotelapp.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class TestNGListener  implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
		Allure.label("Test case has been started" , result.getMethod().getMethodName());
		
		System.out.println("Test case started ..");
		
		Allure.step("Starting od test case "+ result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		Allure.step("Test case completed successfully  "+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Allure.step("test case failed  "+ result.getTestName());
		
		//take screenshot code 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
}
