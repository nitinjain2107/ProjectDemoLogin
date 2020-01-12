package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.baseclass.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(xpath="//*[@id='SubmitLogin']/span")
	WebElement signinBtn;
	
	
public LoginPage(){
	PageFactory.initElements(driver, this);
	
}
public String validateLoginTitle(){
	return driver.getTitle();
	
}
public HomePage login(String un,String pass){
	username.sendKeys(un);
	password.sendKeys(pass);
	signinBtn.click();
	return new HomePage();
	
}

} 
