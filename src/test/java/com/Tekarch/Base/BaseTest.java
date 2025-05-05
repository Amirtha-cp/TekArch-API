package com.Tekarch.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.TekarchAPI.utils.APIConstants;
import com.TekarchAPI.utils.ExtentReportUtils;
import com.TekarchAPI.utils.TekarchProperties;


public class BaseTest {

	protected static Logger logger = LogManager.getLogger(BaseTest.class);
	protected static ExtentReportUtils extentReportUtilsObj = ExtentReportUtils.getInstance();
	protected String username = TekarchProperties.readDatafromConfigPropertiesFile(APIConstants.API_PROPERTIES, "username");
	protected String password = TekarchProperties.readDatafromConfigPropertiesFile(APIConstants.API_PROPERTIES, "password");
}
