package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id = "FriendEmail")
	 WebElement emailFriendTxt;
	
	@FindBy (id = "PersonalMessage")
	WebElement personalMessageTxt;
	
	@FindBy (name = "send-email")
	WebElement sendEmailBtn;
	
	
	
	@FindBy (css= "div.result")
	public WebElement messageNotification;
	
	public void sendEmailToFriend(String friendEmail, String personalMessage)
	{
		setTextElement(emailFriendTxt, friendEmail);
		setTextElement(personalMessageTxt, personalMessage);
		clickButton(sendEmailBtn);
	}
	
	

}
