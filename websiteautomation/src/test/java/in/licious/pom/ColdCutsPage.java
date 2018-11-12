package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ColdCutsPage extends BasePage {
	
	// Product_Name Chicken_Sausage_Long
	@FindBy (xpath="//button[@data-prid='pr_57235ae2ae5bb']")
	private WebElement addtocart_Chicken_Sausage;

	public ColdCutsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChickenSausage(){
		
		return addtocart_Chicken_Sausage;
	}
	

}
