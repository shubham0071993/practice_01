package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClasses.BaseClass_01;
import pomClasses.PomKiteLogin1;

public class KiteLoginTest1 {
	
	String TCID = "01";

	PomKiteLogin1 pomlogin1;              
	BaseClass_01 base;
	
	@BeforeClass
	public void m1() {
		base = new BaseClass_01();
		base.intdriver();
		pomlogin1 = new PomKiteLogin1(base.driver);
		
	}
	
	@Test (priority=1)
	public void onlyusername() throws EncryptedDocumentException, IOException, InterruptedException {
		TCID = "01";
		PomKiteLogin1.uname(base.excelsheet(0, 0));
		Thread.sleep(2000);
	//	base.screenshot(TCID);
		pomlogin1.loginbutton();
		Thread.sleep(2000);
	//	base.screenshot(TCID);
		
		String actual = pomlogin1.errormsgpassword();
		String expected = "Password should be minimum 6 characters.";
		Assert.assertEquals(actual, expected);

		
		}
	
//	@Test (priority=2)
//	public void onlypassword() throws EncryptedDocumentException, IOException, InterruptedException {
//		
//		TCID ="02";
//		Thread.sleep(2000);
//		pomlogin1.passw(base.excelsheet(0 , 1));
//		base.screenshot1(TCID);
//		Thread.sleep(200);
//		pomlogin1.loginbutton();
//		Thread.sleep(1000);
//	//	base.screenshot(TCID);
//		Thread.sleep(2000);
//		
//		
//	}
	
	@AfterClass
	public void driverClose() {
		base.driver.quit();
		
	}
	
	
	
//	@AfterMethod
//	public void refreshloginpage(ITestResult result) throws IOException {
//		
//		if(ITestResult.FAILURE==result.getStatus()) {
//			base.screenshot(TCID);
//		}
//		base.driver.navigate().refresh();
//	}

}
