package in.licious.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import in.licious.pom.NewDeliverySummaryPage;
import in.licious.test.BaseTest;

public class DeliverySlot  extends BaseTest{
	
	
	
	public String ss1;

	
	
	public DeliverySlot(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public static void main() {
	
	NewDeliverySummaryPage newDeliverySummary = new NewDeliverySummaryPage(driver);
	
	System.out.println("PAAAAAAAAAAAAAAAAAAAAA");
	
	
	
	//newly added lines
			//String a=newDeliverySummary.gettoday120min().getText(); 
			
			
			//WebElement wb1=newDeliverySummary.gettoday120min();
			WebElement TxtBoxContent = driver.findElement(By.xpath("//div[@class='slots-selector']"));
			Helper.customWait(2);
			System.out.println("PASS2000");
			System.out.println("Printing " + TxtBoxContent.getText());
			Helper.customWait(2);
			
			
				
			String a = TxtBoxContent.getText();
			
			Helper.customWait(2);
			//String a = TxtBoxContent.getAttribute("value");
			System.out.println("PASS2000");
			System.out.println(a);
			System.out.println("PASS1000");
			Helper.customWait(2);
			
			String b="Today 120 min";
			
			System.out.println(b);
			Helper.customWait(2);
			
			//if("a".equals("b")) 
			//if (a==b)
			if (TxtBoxContent.getText().equalsIgnoreCase("Today 120 MIN"))
			{
				
				System.out.println("Order Placing as Express Delivery");
				
				newDeliverySummary.getProceedToPaymentBtn().click();
				
				Helper.customWait(2);
			}
			
			else 
			{
				
				System.out.println("Order Placing as Scheduled Delivery");
				
				// Select the Delivery Slot for scheduled delivery
				newDeliverySummary.getSelectDeliverySlot().click();
				Helper.customWait(2);
				newDeliverySummary.getTimeSlot().click();
				Helper.customWait(2);
				newDeliverySummary.getProceedToPaymentBtn().click();
				Helper.customWait(2);
			}
			
			 String ss1=null;
	/*String a = nds.gettoday120min().getText();
	System.out.println(a);
	if(a=="today120min") 
	{
			
		nds.getProceedToPaymentBtn().click();
	}
	
	else 
	{
		
		nds.getSelectDeliverySlot().click();
		nds.getTimeSlot().click();
	}
	*/
	
	}}
