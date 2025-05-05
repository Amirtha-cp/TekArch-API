package com.TekarchAPI.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.Automation.Base.BaseTest;


public class APITestListeners extends com.Tekarch.Base.BaseTest implements ITestListener {
	private static ExtentReportUtils extentReportUtilsObj;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
//		logger.info(result.getMethod().getMethodName()+" Using getmethod().getmethodName()");
		logger.info(result.getName()+" Using getName()");
		extentReportUtilsObj.startEachTestcase(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info(result.getMethod().getMethodName());
		extentReportUtilsObj.logTestpassed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentReportUtilsObj.logTestFailed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.warn(result.getMethod().getMethodName()+" skiped...........................");
		extentReportUtilsObj.logTestFailed(result.getMethod().getMethodName()+"end with skip...........");
		extentReportUtilsObj.logTestFailedWithException(result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReportUtilsObj = ExtentReportUtils.getInstance();
		extentReportUtilsObj.startExtentReport();
		logger.info(context.getName());
		logger.info(context.getClass());


	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		logger.info(context.getName());
		logger.info(context.getClass());
		extentReportUtilsObj.endExtentReport();

	}

}

