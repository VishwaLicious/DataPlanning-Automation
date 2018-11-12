package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PicklesPage extends BasePage {
	
	// Product_Name Chuncky_Chicken_Spread
	@FindBy (xpath="//button[@data-prid='pr_57de6286ab54b']")
	private WebElement addtocart_Chuncky_Chicken_Spread;

	public PicklesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChunckyChickenSpread(){
		
		return addtocart_Chuncky_Chicken_Spread;
	}
	

}
