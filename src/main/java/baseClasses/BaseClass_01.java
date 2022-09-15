package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import configurationClass.ConfigurationClass;

public class BaseClass_01 {
	
	public static WebDriver driver;
	
	public String excelsheet(int rownum, int colnum) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream file = new FileInputStream(ConfigurationClass.excelsheetpath);
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
		String data = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
	}

	public void intdriver() {
		System.setProperty("webdriver.chrome.driver", ConfigurationClass.chromepath);
		driver = new ChromeDriver();
		driver.get(ConfigurationClass.build);
		driver.manage().window().maximize();
	}
	
	public void screenshot(String id) throws IOException {
		
		 File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Date d = new Date();
		 String str = d.toString();
		 str = str.replace(" ", "_");
		 str = str.replace(":", "_");
		 File file = new File(ConfigurationClass.screenshotpath + id + "_Failed_" + str + ".jpeg");
		 FileHandler.copy(ss, file);
		
		
		
	}
	
	public String readfile(String data) throws IOException {
		
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(ConfigurationClass.credentialfile);
		p.load(f);
		String value = p.getProperty(data);
	//	System.out.println(value);
		return value;

	}
	
	public void screenshot1(String id) throws IOException {
		
		 File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Date d = new Date();
		 String str = d.toString();
		 str = str.replace(" ", "_");
		 str = str.replace(":", "_");
		 File file = new File(ConfigurationClass.screenshotpath + id +"_Pass_" + str + ".jpeg");
		 FileHandler.copy(ss, file);
		
		
		
	}
	
	
}
