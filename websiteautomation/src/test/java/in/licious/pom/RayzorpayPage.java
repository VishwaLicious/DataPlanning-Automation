package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RayzorpayPage extends BasePage {
	
	@FindBy(xpath="//button[.='Success']")
	private WebElement success;
	
	//Input Otp for other wallets example Olamoney
	@FindBy(xpath="//input[@id='input-otp']")
	private WebElement rayorPayOlaMoneyOtp;
	
	public RayzorpayPage(WebDriver driver) {
		
		super (driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getRayzorpayPage() {
		return success;
	}
	
	public WebElement rayorPayOlaMoneyOtp() {
		return rayorPayOlaMoneyOtp;
	}

}
