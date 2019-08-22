package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObj;
	ProductDetailsPage detailObj;

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;


	@Test(priority = 2)

	public void searchWithAutoComplete()
	{
		searchObj=new SearchPage(driver);
		searchObj.searchUsingAutoSuggest("MacB");
		detailObj=new ProductDetailsPage(driver);
		Assert.assertTrue(detailObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailObj.productNameBreadCrumb.getText(), productName);
	    Assert.assertTrue(detailObj.productPriceLabel.getText().contains("Ђ"));
	    System.out.println(detailObj.productPriceLabel.getText());
	}

	@Test(priority  =1)
	public void changecurrency()
	{
		homeObj=new HomePage(driver);
		homeObj.changeCurrency();
		

	}
}
