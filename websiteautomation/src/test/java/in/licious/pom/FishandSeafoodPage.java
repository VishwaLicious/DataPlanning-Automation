package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishandSeafoodPage extends BasePage {
	
	// Product_Name Basa_Fillet
	@FindBy (xpath="//button[@data-prid='pr_5746a6e241199']")
	private WebElement addtocart_Basa_Fillet;

	public FishandSeafoodPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBasaFillet(){
		
		return addtocart_Basa_Fillet;
	}
	

}
