package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriend extends TestBase {
	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	EmailPage emailObj;
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration("marwa", "moaz", "testemail1733@gmail.com", "12345678");
        Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

	}
	
	@Test(priority = 2)

	public void searchWithAutoComplete()
	{
		searchObj=new SearchPage(driver);
		searchObj.searchUsingAutoSuggest("MacB");
		prodObj=new ProductDetailsPage(driver);
		 Assert.assertTrue(prodObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(prodObj.productNameBreadCrumb.getText(), productName);
	}

	@Test(priority =3)
	
	public void sendEmail()
	{
		prodObj.openSendEmail();
		emailObj=new EmailPage(driver);
		emailObj.sendEmailToFriend("aaa@tte.com", "hello!");
		Assert.assertTrue(emailObj.messageNotification.getText().contains("Your message has been sent"));
		
	}
	@Test(priority = 4)
	public void registeredUserCanLogOut()
	{
		registerobj.userLogout();
	}

}
