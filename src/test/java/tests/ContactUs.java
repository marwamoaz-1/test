package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs extends TestBase{
	HomePage homeObj;
	ContactUsPage contObj;
	
	String email="test@test.com";
	String fullName="Test User";
	String enquiry="Hello Admin , This is for test";
	
	@Test
	public void userCanContactUs()
	{
		homeObj=new HomePage(driver);
		homeObj.openContactUsPage();
		contObj=new ContactUsPage(driver);
		contObj.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contObj.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}
