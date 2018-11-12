package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutDelivery {
	
	@FindBy(xpath="//div[contains(@class,'unchecked slots-selector')]")
	private WebElement selectDeliverySlot;
	
	@FindBy(xpath="//ul[@class='slot-time']/li")
	private WebElement timeSlot;
	
	@FindBy(xpath="//div[@class='cta-section']/button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='cta-section']/button[contains(text(),'Proceed to payment')]")
	private WebElement proceedToPaymentBtn;
	
	
	public CheckoutDelivery(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getSelectDeliverySlot()
	{
		return selectDeliverySlot;
	}
	
	
	public WebElement getTimeSlot()
	{
		return timeSlot;
	}
	
	public WebElement getContinueBtn()
	{
		return continueBtn;
	}

	public WebElement getProceedtoPaybtn()
	{
		return proceedToPaymentBtn;
	}
}
