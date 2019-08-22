package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddCompareTest extends TestBase{
	
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	
	ProductDetailsPage prodObj;
	HomePage homeObj;
	ComparePage compareObj;
	SearchPage searchObj;
	
	@Test(priority = 1)
	public void userCanCompareproduct()
	{
		searchObj=new SearchPage(driver);
		prodObj=new ProductDetailsPage(driver);
		compareObj=new ComparePage(driver);
		
		searchObj.searchUsingAutoSuggest("MacB");
		Assert.assertTrue(prodObj.productNameBreadCrumb.getText().contains(firstProductName));
		prodObj.addToCompare();
		
		searchObj.searchUsingAutoSuggest("Asus");
		Assert.assertTrue(prodObj.productNameBreadCrumb.getText().contains(secondProductName));
		prodObj.addToCompare();
		
		driver.navigate().to("http://demo.nopcommerce.com"+"/compareproducts");
		Assert.assertTrue(compareObj.firstProductName.isDisplayed());
		Assert.assertTrue(compareObj.secondProductName.isDisplayed());
		compareObj.compareProducts();
		
		
	}
   @Test(priority = 2)
   
   public void clearCompare()
   {
	   compareObj.clearCompareList();
       Assert.assertTrue(compareObj.noDataLbl.getText().contains("You have no items to compare."));
   }
}
