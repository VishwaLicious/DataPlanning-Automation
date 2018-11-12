package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	@FindBy(xpath="//span[@class='location-name']")
	private WebElement selectLocation;
	
	@FindBy(xpath="//a[contains(.,'Login')]")
	private WebElement login;
	
	@FindBy(xpath="//p[@class='city-select']//span[contains(.,'Bengaluru')]")
	private WebElement bengaluruDeliveryLocation;
	
	@FindBy(id="location_pop")
	private WebElement loactionTxtBox;
	
	@FindBy(xpath="//span[.='Cart']")
	private WebElement cart;
	//span[@class='location-name']
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectLocation(){
		return selectLocation;
	}
	public WebElement getLogin(){
		return login;
	}
	public WebElement getbengaluruDeliveryLocation(){
		return bengaluruDeliveryLocation;
	}
	public WebElement getLoactionTxtBox(){
		return loactionTxtBox;
	}
	
	public WebElement getCart(){
		return cart;
	}
}
