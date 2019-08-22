package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataProvider extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	
	@DataProvider(name="testData")
	public static  Object [] [] userData()
	{
		return new Object[][] {
			{"marwa","moaz","testerxxx2101@gmail.com","123456"},{"nabil","moataz","testuser52124230@gmail.com","12345678"}
			};
	}
	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fname,String lname,String email,String pass)
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(fname, lname, email, pass);
		
        Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

        registerobj.userLogout();
        
        homeobj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin(email,pass);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());
		registerobj.userLogout();
	}
	
	

}

