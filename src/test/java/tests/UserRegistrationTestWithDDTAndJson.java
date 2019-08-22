package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJson extends TestBase{
	JsonDataReader JsonReader;
	

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		JsonReader=new JsonDataReader();
		JsonReader.jsonreader();
		homeobj=new HomePage(driver);
		homeobj.openRegistrationPage();
		registerobj=new UserRegistrationPage(driver);
		registerobj.userRegistration(JsonReader.fn, JsonReader.ln, JsonReader.email, JsonReader.ps);
		Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

		registerobj.userLogout();

		homeobj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin( JsonReader.email, JsonReader.ps);
		Assert.assertTrue(registerobj.logoutLink.isDisplayed());

		registerobj.userLogout();

	}





}

