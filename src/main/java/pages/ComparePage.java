package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css = "a.clear-list")
	WebElement clearListLink;
	
	@FindBy(css="div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(css="table.compare-products-table")
	WebElement compareTable;
	
	
	@FindBy(tagName ="tr")
	List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCols;
	
	@FindBy (linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProductName;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	public WebElement secondProductName;
	public void clearCompareList()
	{
		clickButton(clearListLink);
	}
	
    public void compareProducts()
    {
    	System.out.println(allRows.size());
    	
    	for(WebElement row :allRows)
    	{
    		System.out.println(row.getText());
    	    for(WebElement col:allCols)
    	    {
    	    	System.out.println(col.getText());
    	    }
    	}
    }

}
