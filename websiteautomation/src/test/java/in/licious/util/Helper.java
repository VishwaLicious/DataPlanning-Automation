package in.licious.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	public static String SCREEN_SHOT_PATH;
	public static String dateAndTimeStamp(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy-HH-mm-ss");
		 return sdf.format(new Date());
	}
	public static void customWait(long seconds){
		try{
			Thread.sleep(seconds*1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	private static WebDriver explicitWait(WebDriver driver,long timeOutInSecond,ExpectedCondition<WebDriver> expectedCondition){
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSecond);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
			}
	private static WebElement explicitWait(WebDriver driver,ExpectedCondition<WebElement> expectedCondition,long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
	}
	public  void clickOnElement(WebDriver driver,WebElement element){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10).click();
	}
	public  void clickOnElement(WebDriver driver,WebElement element,long timeOutInSecond){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).click();
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text,long timeOutInSecond){
		
			if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).isDisplayed()){
				element.clear();
				element.sendKeys(text);
			}
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text){
		
		if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10).isDisplayed()){
			element.clear();
			element.sendKeys(text);
		}
}
	 public static void takeScreenShot(String sname){
		 try {
			Robot robot=new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			SCREEN_SHOT_PATH=System.getProperty("user.dir")+"/ScreenShots/"+sname+"-"+dateAndTimeStamp()+".png";
			try {
				ImageIO.write(image, "png", new File(SCREEN_SHOT_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}	
		 
	 }
	 public  WebDriver switchToFrame(WebDriver driver,WebElement element,long timeOutInSecond){
		 return  explicitWait(driver,timeOutInSecond, ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		 }
	 public  WebDriver switchBackFromFrame(WebDriver driver){
		return driver.switchTo().defaultContent();
	 }
	 /**switchToChildWindow() method works properly only when there is two window opened
	  */
	 public  void switchToChildWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 itr.next();
		 driver.switchTo().window(itr.next());
	 }
	 /**switchBackToParentWindow() method works properly only when there is two window opened
	  */
	 public  void switchBackToParentWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 driver.switchTo().window(itr.next());
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.selectByVisibleText(text);
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.selectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.deselectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.deselectByVisibleText(text);
	 }
	 public  void mouseHover(WebDriver driver,WebElement element){
		 Actions action=new Actions(driver);
		 action.moveToElement(element);
	 }
	 public  Alert switchToAlert(WebDriver driver){
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	 }
	 
 public void scrollBar(WebDriver driver,WebElement elementToFind)
	 {
		 while(true)
	        {
	            try
	            {	
	            	elementToFind.click();
	                break;
	            }
	            catch(Throwable t)
	            {
	            	
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeAsyncScript(" ", "Window.scrollBy(0,50)");
	            }
	        }
	 }
}
