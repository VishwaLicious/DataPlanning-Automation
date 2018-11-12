package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPaymentPage {

	@FindBy(xpath="//li[@data-payname='cod']")
	private WebElement cashOnDelivery;
	
	@FindBy(xpath="//li[@data-payname='pod']")
	private WebElement payOnDelivery;
	
	@FindBy(xpath="//button[.='Place Order']")
	private WebElement placeOrder;
	
	
	@FindBy(xpath="//li[@data-payname='netbanking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//li[@data-bc='HDFC']")
	private WebElement hdfc;
	
	@FindBy(xpath="//button[@data-mode='netbanking']")
	private WebElement payNetBanking;
	
	@FindBy(xpath="//li[@data-payname='saved_payments']")
	private WebElement savedPayments;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[3]/div[3]/div/div[2]/div[8]/div/ul/li[1]/span[1]")
	private WebElement savedCard1;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[3]/div[3]/div/div[2]/div[8]/div/ul/li[1]/p/input")
	private WebElement cvv1;
	
	@FindBy(xpath="//div[@class='payment-cta']")
	private WebElement paySavedCardButton;
	
	// Credit and Debit card Elements
	@FindBy(xpath="//li[@data-payname='card']")
	private WebElement creditAndDebitCard;
	@FindBy(xpath="//input[@data-type='card-num']")
	private WebElement enterCardNo;
	@FindBy(xpath="//input[@data-type='card-mon']")
	private WebElement enterMonth;
	@FindBy(xpath="//input[@data-type='card-year']")
	private WebElement enterYear;
	@FindBy(xpath="//input[@data-type='card-cvv']")
	private WebElement enterCvv;
	@FindBy(xpath="//input[@data-type='card-name']")
	private WebElement enterName;
	@FindBy(xpath="//button[@data-mode='card']")
	private WebElement payCreditAndDebitCardButton;
	
	
	// Other Wallet Elements
	@FindBy(xpath="//li[@data-payname='wallet']")
	private WebElement payThroughOtherWallets;
	@FindBy(xpath="//li[@data-paymode='olamoney']")
	private WebElement payThroughOlaMoney;
	@FindBy(xpath="//li[@data-paymode='airtelmoney']")
	private WebElement payThroughAirtelmoney;
	@FindBy(xpath="//button[@data-mode='wallet']")
	private WebElement payThroughOtherWalletsButton;
	
	
	public NewPaymentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getCashOnDelivery(){
		return cashOnDelivery;
	}
	
	public WebElement getPayOnDelivery(){
		return payOnDelivery;
	}
	
	public WebElement getPlaceOrder(){
		return placeOrder;
	}
	
	public WebElement getNetBanking(){
		return netBanking;
	}
	
	public WebElement getSavedPayments(){
		return savedPayments;
	}
	public WebElement getHDFC(){
		return hdfc;
	}
	
	public WebElement getPayNetBankingButton(){
		return payNetBanking;
	}
	
	public WebElement getSavedCard1(){
		return savedCard1;
	}
	
	public WebElement getCvv1(){
		return cvv1;
	}
	
	public WebElement getSavedCardButton(){
		return paySavedCardButton;
	}
	
	// Credit and Debit card Elements
	public WebElement getCreditAndDebitCard(){
		return creditAndDebitCard;
	}
	public WebElement getenterCardNo(){
		return enterCardNo;
	}
	public WebElement getenterMonth(){
		return enterMonth;
	}
	public WebElement getenterYear(){
		return enterYear;
	}
	public WebElement getenterCvv(){
		return enterCvv;
	}
	public WebElement getenterName(){
		return enterName;
	}
	public WebElement getpayCreditAndDebitCardButton(){
		return payCreditAndDebitCardButton;
	}
	
	// Other wallet elements
	public WebElement getpayThroughOtherWallets(){
		return payThroughOtherWallets;
	}
	public WebElement getpayThroughOlaMoney(){
		return payThroughOlaMoney;
	}
	public WebElement getpayThroughAirtelmoney(){
		return payThroughAirtelmoney;
	}
	public WebElement getpayThroughOtherWalletsButton(){
		return payThroughOtherWalletsButton;
	}
	
}
