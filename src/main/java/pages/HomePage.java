package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor)driver;
		builder=new Actions(driver);
		
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy (id="customerCurrency")
	WebElement currencyDrl;
	
	@FindBy (linkText = "Contact us")
	WebElement contactUsLink;

	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > ul > li:nth-child(2) > a")
	WebElement notebookMenu;
	
	public void openRegistrationPage()
	{
		clickButton(registerLink);

	}

	public void openLoginPage()
	{
		clickButton(loginLink);

	}

	public void openContactUsPage()
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency()
	{
		 select=new Select(currencyDrl);
		 select.selectByVisibleText("Euro");
		
	}
	
	public void selectNotebooksMenu()
	{
		
		builder.moveToElement(computerMenu).moveToElement(notebookMenu).click().build().perform();
	}

}
