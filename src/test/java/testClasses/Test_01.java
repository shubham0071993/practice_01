package testClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import configurationClass.ConfigurationClass;

public class Test_01 {

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(ConfigurationClass.credentialfile);
		p.load(f);
		String value = p.getProperty("password");
		System.out.println(value);
		
	}
}
