package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage extends BasePage {

	@FindBy (xpath="//h5[.='Mangammanapalya HSR layout']")
	private WebElement hsr;
	
	
	// For Indiranagar Address
	@FindBy (xpath="//li[@data-addrstr='Thimma Reddy Layout, 27th Cross Rd, Kondappa Layout, Vignan Nagar, Doddanekundi, Kaggadasapura Yellammadevi Nilaya <br>Jana Jeeva Enclave Bangalore 9880335493']")
	private WebElement ind;
	
	
	@FindBy(xpath="//button[.=' Proceed to Shipment']")
	private WebElement continueBtn;
	
	public NewAddressPage (WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHSR(){
		return hsr;
	}
	
	public WebElement getInd(){
		return ind;
	}
	
	public WebElement getContinueBtn(){
		return continueBtn;
	}
}
