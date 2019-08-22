package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase{

	HomePage homeobj;
	UserRegistrationPage registerobj;
	LoginPage loginObj;
	CSVReader reader;
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully() throws IOException
	{
		String csvFile=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader=new CSVReader(new FileReader(csvFile));

		String[] csvCell;
		while((csvCell=reader.readNext())!=null)
		{
			String fn=csvCell[0];
			String ln=csvCell[1];
			String email=csvCell[2];
			String pss=csvCell[3];



			homeobj=new HomePage(driver);
			homeobj.openRegistrationPage();
			registerobj=new UserRegistrationPage(driver);
			registerobj.userRegistration(fn, ln, email, pss);
			Assert.assertTrue(registerobj.successMessage.getText().contains("Your registration completed"));

			registerobj.userLogout();

			homeobj.openLoginPage();
			loginObj=new LoginPage(driver);
			loginObj.userLogin(email, pss);
			Assert.assertTrue(registerobj.logoutLink.isDisplayed());
			registerobj.userLogout(); 
		}
	}



}

