/* Author name: Nitin 
*
*/
package com.demo.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.baseclass.TestBase;
import com.demo.pageObjects.HomePage;
import com.demo.pageObjects.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
		System.out.println("login");
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage=new LoginPage();
	}
	@Test(priority=2)
	public void LoginTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
	String title=loginPage.validateLoginTitle();
	Assert.assertEquals("Login - My Store", title);
	
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
