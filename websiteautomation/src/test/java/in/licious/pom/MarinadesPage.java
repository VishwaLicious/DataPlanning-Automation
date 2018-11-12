package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarinadesPage extends BasePage {
	
	// Product_Name Peri_Peri_Chicken_Hot
	@FindBy (xpath="//button[@data-prid='pr_572359462392e']")
	private WebElement addtocart_Peri_Peri_Chicken_Hot;

	public MarinadesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPeriPeriChickenHot(){
		
		return addtocart_Peri_Peri_Chicken_Hot;
	}
	

}
