package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	String productName="Asus N551JK-XO076H Laptop";
	String productName2="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	WishListPage wishlistObj;

	@Test(priority = 1)

	public void searchWithAutoComplete()
	{
		searchObj=new SearchPage(driver);
		searchObj.searchUsingAutoSuggest("MacB");
		prodObj=new ProductDetailsPage(driver);
		 Assert.assertTrue(prodObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName2));
		Assert.assertEquals(prodObj.productNameBreadCrumb.getText(), productName2);
	
	}
	
	@Test(priority = 2)

	public void addToWishList()
	{
		prodObj=new ProductDetailsPage(driver);
		prodObj.addToWishList();
		driver.navigate().to("http://demo.nopcommerce.com/"+"/wishlist");
	    wishlistObj=new WishListPage(driver);
	    Assert.assertTrue(wishlistObj.wishlistHeader.isDisplayed());
	    Assert.assertTrue(wishlistObj.productCell.getText().contains(productName));
	}
	
	@Test(priority = 2)

	public void removeProductFromCart()
	{
		wishlistObj=new WishListPage(driver);
		wishlistObj.removeProductFromwishList();
		Assert.assertTrue(wishlistObj.emptyCartLbl.getText().contains("The wishlist is empty!"));
	}
	
	
	
	

}
