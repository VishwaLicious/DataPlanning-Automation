package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedMeatsPage extends BasePage {
	
	// Product_Name Lamb_CurryCut
	@FindBy (xpath="//button[@data-prid='pr_57235721c9f9a']")
	private WebElement addtocart_Lamb_CurryCut;

	public RedMeatsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLambCurryCut(){
		
		return addtocart_Lamb_CurryCut;
	}
	

}
