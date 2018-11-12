package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliverySummaryPage extends BasePage{

	@FindBy(xpath="//button[.='Proceed to payment']")
	private WebElement proceedToPaymentBtn;
	
	public DeliverySummaryPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProceedToPaymentBtn(){
		return proceedToPaymentBtn;
	}
}
