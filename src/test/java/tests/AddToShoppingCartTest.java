package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddToShoppingCartTest extends TestBase {
	SearchPage searchobj;
	ProductDetailsPage detailsObj;
	ShoppingCartPage shoppingObj;
	
	String productname="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void searchAuto()
	{
		searchobj=new SearchPage(driver);
		searchobj.searchUsingAutoSuggest("MacB");
		detailsObj=new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().contains(productname));
	}
	
	@Test(priority = 2)
	public void userAddToShoppingCart()
	{
		
		detailsObj=new ProductDetailsPage(driver);
		detailsObj.addToCart();
		driver.navigate().to("http://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().contains(productname));
	}
	@Test(priority = 3)
	public void removeFromCart()
	{
		shoppingObj=new ShoppingCartPage(driver);
		shoppingObj.removeFromCart();
		Assert.assertTrue(detailsObj.productNameBreadCrumb.getText().contains(productname));
	}
}
