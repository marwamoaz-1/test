package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	
	@DataProvider(name="ExcelData")
	
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader er=new ExcelReader();
		return er.getExcelData();
	}
	@Test(priority = 1,alwaysRun = true,dataProvider = "ExcelData")
	public void userCanRegisterSuccessfully(String fn,String ln,String email,String pass)
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(fn, ln, email,pass);
        Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));
        registerobj.userLogout();
        homeobj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin(email, pass);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
		registerobj.userLogout();
	}
	
	
	
	

}

