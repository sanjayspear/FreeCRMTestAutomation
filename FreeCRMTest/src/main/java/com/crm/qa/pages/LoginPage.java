package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
   
	//Page Factory - OR (Object Repository):
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//font[text()='Sign Up']")
	WebElement SignUpLink;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this); 
		this.driver = driver;//Instead of this we can also use LoginPage.class
    }
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
	    username.sendKeys(un);
	    password.sendKeys(pwd);
	    loginBtn.click();
	    
	    return new HomePage(); 
	}
	
}
