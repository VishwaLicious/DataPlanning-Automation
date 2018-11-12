package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChickenPage extends BasePage {
	
	// Product_Name Chicken Breast (Boneless)
	@FindBy (xpath="//button[@data-prid='pr_57234a4f6f77b']")
	private WebElement chicken_Breast_Boneless;
	
	// Product_Name Chicken Thigh (Skinless, Boneless)
	@FindBy(xpath="//button[@data-prid='pr_58626f2fd9841']")
	private WebElement AddToCartBtn;
	
	// Product_Name Chicken Wings (with Skin)
	@FindBy(xpath="//button[@data-prid='pr_59a6c80d1840d']")
	private WebElement AddToCartBtn1;
	
	
	public ChickenPage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChickenBreastBoneless(){
		return chicken_Breast_Boneless;
	}
	
	public WebElement getAddToCartBtn()
	{
		return AddToCartBtn;
	}
	
	public WebElement getAddToCartBtn1()
	{
		return AddToCartBtn1;
	}
}
