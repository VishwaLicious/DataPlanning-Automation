package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	@FindBy(name="name")
	private WebElement fullName;
	
	@FindBy(name="email")
	private WebElement emailId;
	@FindBy(name="number")
	private WebElement mobileNo;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="//button[.='Signup']")
	private WebElement signUpBtn;
	//@FindBy(xpath="//span[@data-value='login']")
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div[3]/div/div[7]/h6/span[1]")
	private WebElement AlreadyHaveAnAccountlogin;
	
	
	public SignupPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFullNameTxtBox(){
		return fullName;
	}
	public WebElement getEmailTxtBox(){
		return emailId;
	}
	public WebElement getMobileNoTxtBox(){
		return mobileNo;
	}
	public WebElement getPasswordTxtBox(){
		return password;
	}
	
	public WebElement getSignUpBtn(){
		return signUpBtn;
	}
	public WebElement getAlreadyHaveAnAccountlogin() {
		return AlreadyHaveAnAccountlogin;
	}
		
}
