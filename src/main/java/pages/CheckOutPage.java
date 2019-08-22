package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;
	
	@FindBy(xpath="//*[@id=\'billing-buttons-container\']/input")
	WebElement continueBtn;
   
	@FindBy(id = "shippingoption_1")
	WebElement shippingMethodRdo;
    
	@FindBy(xpath="//*[@id=\'shipping-method-buttons-container\']/input")
	WebElement continueShippingBtn;
	
	@FindBy(xpath="//*[@id=\'payment-method-buttons-container\']/input")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath="//*[@id=\'payment-info-buttons-container\']/input")
	WebElement continueInfoBtn;
	
	@FindBy(css="a.product-name")
	WebElement productName;
	
	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css="h1")
	public WebElement thankYou;
	
	@FindBy(css="div.title")
	public WebElement successMessage;
	
	@FindBy(linkText ="Click here for order details.")
	WebElement orderDetailsLink;
	
	public void checkOut(String cName, String city ,String address, String postcode,String phone)
	{
		select=new Select(countryList);
		select.selectByVisibleText(cName);
		setTextElement(cityTxt, city);
		setTextElement(addressTxt, address);
		setTextElement(postalCodeTxt, postcode);
		setTextElement(phoneTxt, phone);
		clickButton(continueBtn);
        clickButton(shippingMethodRdo);
        clickButton(continueShippingBtn);
        clickButton(continuePaymentBtn);
        clickButton(continueInfoBtn);
        
	}
   
   public void confirm()
   {
	   clickButton(confirmBtn);
   }
   
   
}
