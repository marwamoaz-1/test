package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name  ="removefromcart")
    WebElement removeCheck;
	
	@FindBy (name="updatecart")
	WebElement updateCartbtn;
	
	@FindBy(css = "input.qty-input valid")
	public WebElement qtyTxt;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	@FindBy(id="termsofservice")
	WebElement agreeCheckBox;
	
	
	public void removeFromCart()
	{
		clickButton(removeCheck);
        clickButton(updateCartbtn);
	}
	
	public void removeFromCart2(String quantity)
	{
		cleartxt(qtyTxt);
		setTextElement(qtyTxt, quantity);
        clickButton(updateCartbtn);
	}
	
	public void openCheckOutPage()
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
}
