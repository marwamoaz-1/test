package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration("marwa", "moaz", "test010100001@gmail.com", "12345678");
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
		loginObj.userLogin("testemail1238@gmail.com", "12345678");
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
	}

}

