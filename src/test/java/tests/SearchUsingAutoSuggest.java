package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggest extends TestBase {

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage prodObj;

	@Test

	public void searchWithAutoComplete()
	{
		searchObj=new SearchPage(driver);
		searchObj.searchUsingAutoSuggest("MacB");
		prodObj=new ProductDetailsPage(driver);
		 Assert.assertTrue(prodObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(prodObj.productNameBreadCrumb.getText(), productName);
	
	}

	
}
