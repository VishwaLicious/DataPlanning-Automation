package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EggsPage extends BasePage {
	
	// Product_Name Country_Eggs
	@FindBy (xpath="//button[@data-prid='pr_590f2f3b17860']")
	private WebElement addtocart_Country_Eggs;
	
	@FindBy (xpath="//button[@data-prid='pr_590f2bc508b4a']")
	private WebElement addtocart_Classic_Eggs;

	public EggsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCountryEggs(){
		
		return addtocart_Country_Eggs;
	}
	
	public WebElement getClassicEggs(){
		
		return addtocart_Classic_Eggs;
	}
	
}
