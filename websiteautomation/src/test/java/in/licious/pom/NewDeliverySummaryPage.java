package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewDeliverySummaryPage extends BasePage{

	@FindBy(xpath="//button[.=' Proceed to Payment']")
	private WebElement proceedToPaymentBtn;
	
	@FindBy(xpath="//div[@data-time='Today 120 min']")
	private WebElement today120min;
	
	@FindBy(xpath="//div[contains(@class,'slots-selector')]")
	// below one is just for test
	//@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")
	private WebElement selectDeliverySlot;
	
	@FindBy(xpath="//ul[@class='slot-time']/li")
	// below one is just for test
	//@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div[2]/div/ul/li[1]")
	private WebElement selectTimeSlot;
	
	@FindBy(xpath="//div[@class='li-page-body delivery-summary']")
	private WebElement switchtonewframe;
	
	public NewDeliverySummaryPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProceedToPaymentBtn(){
		return proceedToPaymentBtn;
	}
	
	public WebElement gettoday120min(){
		return today120min;
	}
	
	public WebElement getSelectDeliverySlot(){
		return selectDeliverySlot;
	}
	
	public WebElement getTimeSlot(){
		return selectTimeSlot;
	}
	
	public WebElement getSwitchtoDeliverySummary(){
		return switchtonewframe;
	}
}
