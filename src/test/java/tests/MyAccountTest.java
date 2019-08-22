package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	String fName="marwa";
	String lName="moaz";
	String email="testemail513@gmail.com";
	String oldPass="12345678";
	String newPass="12345679";
	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	AccountPage accPage;
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(fName, lName, email, oldPass);
		Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

	}

	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void changePass()
	{
		accPage=new AccountPage(driver);
		registerobj.openMyAccountPage();
		accPage.openChangePasswordPage();
		accPage.changepPassword(oldPass,newPass);
		Assert.assertTrue(accPage.resultLbl.getText().contains("Password was changed"));
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
		loginObj.userLogin(email, newPass);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
	}

}
