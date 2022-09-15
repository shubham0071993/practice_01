package testClasses;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass_01;
import pomClasses.PomKiteLogin1;

public class KiteLoginTest2 {
	
	BaseClass_01 base;
	PomKiteLogin1 pom;
	
	@BeforeClass
	public void initializebrowser() {
		
	//	pom = new PomKiteLogin1(base.driver);
		base = new BaseClass_01();
		base.intdriver();
		pom = new PomKiteLogin1(base.driver);
	}
	
	@BeforeMethod
	public void validcredential() throws IOException, InterruptedException {
		
		Thread.sleep(2000);
		String user1 = base.readfile("username");
		pom.uname(user1);
		
		Thread.sleep(2000);
		String pass1 = base.readfile("password");
		pom.passw(pass1);
		
	//	System.out.println(user1);
	//	System.out.println(pass1);
		
		
		//pom.loginbutton();
		
		
	
	}
	
	@Test
	public void m1() {
		Reporter.log("TC is running");
	}
	
	

}
