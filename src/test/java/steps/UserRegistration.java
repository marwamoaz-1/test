package steps;


import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

	HomePage home;
	UserRegistrationPage userReg;

	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		home=new HomePage(driver);
		home.openRegistrationPage();

	}

	@When("^I click on register link$")
	public void i_click_on_register_link() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}

	/*
	 * @When("^I entered the user data$") public void i_entered_the_user_data() { //
	 * Write code here that turns the phrase above into concrete actions 
	 * userReg=newUserRegistrationPage(driver); 
	 userReg.userRegistration("marwa", "moaz",
	 * "m1m1@gmail.com", "123445555"); }
	 */

	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) {
		userReg=new UserRegistrationPage(driver); 
		 userReg.userRegistration(firstname, lastname, email,password); 
		 }
	    
	

	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() {
		// Write code here that turns the phrase above into concrete actions
		userReg.userLogout();
	}


}
