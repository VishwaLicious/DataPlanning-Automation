package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExoticPage extends BasePage {
	
	// Product_Name Country_Eggs
	@FindBy (xpath="//button[@data-prid='pr_57635f9b531d9']")
	private WebElement addtocart_Lamb_Shanks;
	
	@FindBy (xpath="//button[@data-prid='pr_57920bc0525a1']")
	private WebElement addtocart_Japnese_Quail;

	public ExoticPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLambShanks(){
		
		return addtocart_Lamb_Shanks;
	}
	
	public WebElement getJapneseQuail(){
		
		return addtocart_Japnese_Quail;
	}
	
}
