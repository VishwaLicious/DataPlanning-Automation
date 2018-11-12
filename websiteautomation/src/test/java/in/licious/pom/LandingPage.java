package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

	
	@FindBy (xpath="//input[@id=\"location_pop\" and @class=\"location-input\"]")
	private WebElement locationpopup;
	
	public LandingPage (WebDriver driver)
	{
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLocation()
	{
		return locationpopup;
	}
}
