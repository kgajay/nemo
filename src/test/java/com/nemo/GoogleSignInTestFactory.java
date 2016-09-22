package com.nemo;

import com.nemo.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author ajay.kg created on 21/09/16.
 */
@Slf4j
@Test(suiteName = "GoogleSignInFactory")
public class GoogleSignInTestFactory {

	public static String fileName = "Test.xlsx";

	@DataProvider()
	static public Object[][] getTestData() throws Exception {

		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "//src//main//resources//" + fileName;
		ExcelUtils excelUtils = new ExcelUtils(excelPath, "Sheet3");
		log.info("Total Rows: {} ", excelUtils.excelGetRows());
		// String[][] data = excelUtils.getExcelData();
		String[][] data = excelUtils.readExcelRows(1, 1);
		return data;
	}

	@Factory(dataProvider = "getTestData")
	public Object[] createInstance(String user, String passwd) {
		ArrayList<Object> ar = new ArrayList<Object>();
		ar.add(new GoogleSignInTest(user, passwd));
		Object[] res = new Object[ar.size()];
		res = ar.toArray();
		return res;
	}
}
