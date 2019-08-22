package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFacker extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	Faker fakeData=new Faker();
	String fn=fakeData.name().firstName();
	String ln=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String pass=fakeData.number().digits(8).toString();

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(fn, ln, email, pass);
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
		loginObj.userLogin(email, pass);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
	}

}

