package dataplanning_ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.ChromeDriverManager;



public class DemandPlan {
@Test
public void createDemandPlantest() throws InterruptedException
{
	WebDriver driver;
	ChromeDriverManager.getInstance().setup();
	driver = new ChromeDriver();
	driver.get("https://dev-planning.licious.in");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//input[@class='Login__formControl___MVaJ0 form-control'])[1]")).sendKeys("demo@licious.in");
	driver.findElement(By.xpath("(//input[@class='Login__formControl___MVaJ0 form-control'])[2]")).sendKeys("demo@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'System Forecast_list')]")).click();
	driver.findElement(By.xpath("//li[text()='Tue']")).click();
	Thread.sleep(1000);
	WebElement element=driver.findElement(By.xpath("(//select[@class='sc-eNQAEJ eXvGYz'])[3]"));
	element.click();
	Select sel=new Select(element);
	sel.selectByValue("42");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Update Plan']")).click();
	
	driver.findElement(By.xpath("//input[@class='sc-cIShpX ijuHgM']")).sendKeys("7e1");
	driver.findElement(By.xpath("//li[text()='Tue']")).click();
	driver.findElement(By.xpath("//td[@data-xy='4-59']")).sendKeys("10");
	driver.findElement(By.xpath("//button[@class='sc-dfVpRl fRJQJR']")).click();
	driver.findElement(By.xpath("//td[@data-xy='4-0']")).sendKeys("10");
	driver.findElement(By.xpath("//button[@class='sc-dfVpRl fRJQJR']")).click();
	
	driver.findElement(By.xpath("//button[@class='sc-fYiAbW cTewnd']")).click();
	
}
}
