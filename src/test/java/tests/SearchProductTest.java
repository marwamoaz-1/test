package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;
	@Test
	public void userCanSearchForProducts()
	{
		searchObj=new SearchPage(driver);
		prodObj=new ProductDetailsPage(driver);
		searchObj.productSearch(productName);
		searchObj.openProductDetails();
		//Assert.assertTrue(prodObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	  Assert.assertEquals(prodObj.productNameBreadCrumb.getText(), productName);	
	}
	

}
