package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase {
	HomePage homeObj;
	@Test 
	public void userCanHoverMenu()
	{
		homeObj=new HomePage(driver);
		homeObj.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
