package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisterCheckOut extends TestBase {
	
	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	ShoppingCartPage shoppObj;
	CheckOutPage checkOutObj;
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration("marwa", "moaz", "testemail1001@gmail.com", "12345678");
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
	
	@Test(priority = 3)
	public void userAddToShoppingCart()
	{
		
		prodObj=new ProductDetailsPage(driver);
		prodObj.addToCart();
		driver.navigate().to("http://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(prodObj.productNameBreadCrumb.getText().contains(productName));
	}
	
	@Test(priority = 4)
	public void checkUserOut()
	{
		checkOutObj=new CheckOutPage(driver);
		checkOutObj.checkOut("marwa", "cairo", "fifth", "112", "0123");
		checkOutObj.confirm();
	}
	
	@Test (priority = 5)
	public void logOut()
	{
		
			registerobj.userLogout();
		
	}
}
