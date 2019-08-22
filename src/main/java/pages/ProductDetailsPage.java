package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;

	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendButton;

	@FindBy(css = "span.price-value-4")
	public	WebElement productPriceLabel;

	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy (css="input.button-2.add-to-wishlist-button")
	WebElement addToWishListBtn;
	
	@FindBy (css="input.button-2.add-to-compare-list-button")
	WebElement compareBtn;
	
	@FindBy(id="add-to-cart-button-5")
	WebElement addToCartBtn;
	
	public void openSendEmail()
	{
		clickButton(emailFriendButton);
	}
	
	public void addReviewPage()
	{
		clickButton(addReviewLink);
	}
	
	public void addToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void addToCompare()
	{
		clickButton(compareBtn);
	}
	
	public void addToCart()
	{
		clickButton(addToCartBtn);
	}
}
