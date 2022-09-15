package pomClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseClass_01;

public class PomKiteLogin1 {
	
	BaseClass_01 base = new BaseClass_01();
	
	@FindBy(xpath="//input[@id='userid']") private static WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton;
	@FindBy(xpath="//span[contains(text(), 'Password should be minimum 6')]") private WebElement passtexterrormsg;
	@FindBy(xpath="//span[contains(text(), 'User ID should be')]") private WebElement usertexterrormsg;
	
	public PomKiteLogin1(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public static void uname(String uname) throws EncryptedDocumentException, IOException {
		
	
		username.sendKeys(uname);
	}
	
	public void passw(String pass) throws EncryptedDocumentException, IOException {
		password.sendKeys(pass);
	}
	
	public void loginbutton() {
		loginbutton.click();
	}
	
	public String errormsgusername() {
		String uact = usertexterrormsg.getText();
		return uact;
	}
	
	public String errormsgpassword() {
		String pact = passtexterrormsg.getText();
		return pact;
	}
	
}
