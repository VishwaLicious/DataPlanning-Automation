package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryInfoPage extends BasePage {

	@FindBy (xpath="//h5[.='Mangammanapalya HSR layout']")
	private WebElement hsr;
	
	@FindBy(xpath="//button[.='Continue']")
	private WebElement continueBtn;
	
	public DeliveryInfoPage (WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHSR(){
		return hsr;
	}
	public WebElement getContinueBtn(){
		return continueBtn;
	}
}
