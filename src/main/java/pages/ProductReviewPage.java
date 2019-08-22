package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends HomePage {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy (id="AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy (id="addproductrating_4")
	WebElement rating4Dotbtn;
	
	@FindBy (name = "add-review")
	WebElement submitReviewBtn;
	
	@FindBy (css="div.result")
	public WebElement reviewNotification;

	public void addReview(String reviewTitle, String reviewMessage)
	{
		setTextElement(reviewTitleTxt, reviewTitle);
        setTextElement(reviewTxt, reviewMessage);
        clickButton(rating4Dotbtn);
        clickButton(submitReviewBtn);
	}

}
