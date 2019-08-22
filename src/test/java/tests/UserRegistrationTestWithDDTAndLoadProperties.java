package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndLoadProperties extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;

	String fn=LoadProperties.userData.getProperty("fname");
	String ln=LoadProperties.userData.getProperty("lname");
	String email=LoadProperties.userData.getProperty("email");
	String pss=LoadProperties.userData.getProperty("pass");

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(fn, ln,email,pss);
		Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

	}

	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogOut()
	{
		registerobj.userLogout();
	}

	@Test(dependsOnMethods = {"registeredUserCanLogOut"})
	public void registeredUserCanLogIn()
	{
		homeobj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin(email,pss);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
	}

}

