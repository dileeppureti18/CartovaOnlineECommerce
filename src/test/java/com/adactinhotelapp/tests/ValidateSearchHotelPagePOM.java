package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.pages.SearchHotelPage;
import com.adactinhotelapp.utils.ExcelUtils;

public class ValidateSearchHotelPagePOM extends BaseTest{
	
	@Test(dataProvider = "getTestData")
	public void validateSearchHotelTest(HashMap<String, String> dataMap)
	{
		LoginPage lp=new LoginPage(driver);
		lp.doLogin();
		Assert.assertEquals(lp.getTitle(), AppConstants.SEARCH_HOTEL_PAGE_TITLE);
		
		
		SearchHotelPage shp=new SearchHotelPage(driver);
		shp.locationDropdown(dataMap.get("Location"));
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		HashMap<String, String> testDataMap=ExcelUtils.getTestDataFromExcel("TC103");
		data[0][0]=testDataMap;
		return data;
		
	}
	

}
