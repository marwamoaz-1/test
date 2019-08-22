package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id  ="Email")
	WebElement emailTextBox;
	
	@FindBy(id  ="Password")
	WebElement passwordTextBox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginButton;
	
	public void userLogin(String email,String password)
	{
		setTextElement(emailTextBox, email);
		setTextElement(passwordTextBox, password);
		clickButton(loginButton);
		
	}

}
