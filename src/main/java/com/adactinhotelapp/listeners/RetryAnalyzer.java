package com.adactinhotelapp.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			ChainTestListener.log(
					"Retrying test case:" + result.getName() + " | Attempt: " + retryCount + " of " + maxRetryCount);
			return true;
		}

		ChainTestListener.log("Test case failed after " + maxRetryCount + " retries: " + result.getName());
		return false;

	}

	public int getRetryCount() {
		return retryCount;
	}

	public static int getMaxRetryCount() {
		return maxRetryCount;
	}

}
