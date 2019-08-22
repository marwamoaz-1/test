package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id = "gender-male")
	WebElement genderRadioButton;
	
	@FindBy(id  ="FirstName")
	WebElement fNameTextBox;
	
	@FindBy(id  ="LastName")
	WebElement lastNameTextBox;
	
	@FindBy(id  ="Email")
	WebElement emailTextBox;
	
	@FindBy(id  ="Password")
	WebElement passwordTextBox;
	
	@FindBy (linkText = "Log out")
	public WebElement logoutLink;
	

	@FindBy(id  ="ConfirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy (css = "div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "My account")
	WebElement accountLink;
	
	
	public void userRegistration(String fname,String lname,String email,String pass)
	{
		clickButton(genderRadioButton);
		setTextElement(fNameTextBox, fname);
		setTextElement(lastNameTextBox, lname);
		setTextElement(emailTextBox, email);
		setTextElement(passwordTextBox, pass);
		setTextElement(confirmPasswordTextBox, pass);
		clickButton(registerButton);
		
	}
	
	public void userLogout()
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(accountLink);
	}
}
