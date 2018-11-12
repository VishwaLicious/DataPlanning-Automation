package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeekendTreatsPage extends BasePage {
	
	// In this case we have to assume that this product is linked to weekend treats  and also having a discount
	// Product_Name White_Pomfret
	@FindBy (xpath="//button[@data-prid='pr_57bb1cba0c291']")
	private WebElement addtocart_White_Pomfret;

	public WeekendTreatsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChickenSausage(){
		
		return addtocart_White_Pomfret;
	}
	

}
