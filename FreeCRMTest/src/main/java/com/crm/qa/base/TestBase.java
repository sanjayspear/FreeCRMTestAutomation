package com.crm.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase implements IAutoConst {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	

	public TestBase(){
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("F://FrameWork//FreeCRM//FreeCRMTest//src//main//java//com//crm//qa//config//config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
/*		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("F://FrameWork//FreeCRM//FreeCRMTest//src//main//java//com//crm//qa//config//config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");*/
		
		
		if(BROWSER.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		}
		
	/*	else if(BROWSER.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(URL); 
	}
	
}




















