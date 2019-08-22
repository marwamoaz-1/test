package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	ProductReviewPage productReviewObj;

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration("marwa", "moaz", "testemail1762@gmail.com", "12345678");
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

	public void reviewProduct()
	{
		prodObj.addReviewPage();
		productReviewObj=new ProductReviewPage(driver);
		productReviewObj.addReview("new review", "good!");
		Assert.assertTrue(productReviewObj.reviewNotification.getText().contains("Product review is successfully added."));

	}
	@Test(priority = 4)
	public void registeredUserCanLogOut()
	{
		registerobj.userLogout();
	}

}
