package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase {

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="OldPassword")
	WebElement oldPassTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPassTxt;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPassTxt;
	
	@FindBy(linkText = "Change password")
	WebElement changePassword;
	
	@FindBy(linkText = "ConfirmNewPassword")
	WebElement confirmNewPassword;
	
	@FindBy(css="div.result")
	public WebElement resultLbl;
	
	@FindBy(css = "input.button-1.change-password-button")
	 WebElement changePassButton;
	
	public void openChangePasswordPage()
	{
		clickButton(changePassword);
	}
	public void changepPassword(String oldPass,String newPass)
	{
		setTextElement(oldPassTxt, oldPass);
		setTextElement(newPassTxt, newPass);
        setTextElement(confirmNewPassTxt, newPass);
        clickButton(changePassButton);
	}

}
