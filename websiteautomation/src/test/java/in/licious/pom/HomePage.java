package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy (xpath="//a[.='Chicken' and @class='active']")
	private WebElement chicken;
	
	@FindBy (xpath="//a[.='Fish & Seafood' and @class='active']")
	private WebElement fishSeafood;
	
	@FindBy (xpath="//a[.='Marinades' and @class='active']")
	private WebElement marinades;
	
	@FindBy (xpath="//a[@data-id='2']")
	private WebElement redmeats;
	
	@FindBy (xpath="//a[.='Eggs' and @class='active']")
	private WebElement eggs;
	
	@FindBy (xpath="//a[@data-id='7']")
	private WebElement exotic;
	
	@FindBy (xpath="//a[@data-id='20']")
	private WebElement pickles;
	
	@FindBy (xpath="//a[@data-id='19']")
	private WebElement coldcuts;
	
	@FindBy (xpath="//a[@data-id='28']")
	private WebElement weekendtreats;
	
	public HomePage (WebDriver driver) 
	{
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChickenCat(){
		return chicken;
	}
	
	public WebElement getfishSeafoodCat(){
		return fishSeafood;
	}
	
	public WebElement getmarinadesCat(){
		return marinades;
	}
	
	public WebElement getredmeats(){
		return redmeats;
	}
	
	public WebElement geteggsCat(){
		return eggs;
	}
	
	public WebElement getexoticCat(){
		return exotic;
	}
	
	public WebElement getpicklesCat(){
		return pickles;
	}
	
	public WebElement getcoldcutsCat(){
		return coldcuts;
	}
	
	public WebElement getweekendtreatsCat(){
		return weekendtreats;
	}

}
