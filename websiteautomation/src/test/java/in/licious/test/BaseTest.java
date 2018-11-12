package in.licious.test;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import in.licious.util.CustomListeners;
import in.licious.util.Helper;
import in.licious.util.InitProperties;
import in.licious.util.SetUpDrivers;

@Listeners(CustomListeners.class)
public abstract class BaseTest implements  AutomationConstant {

	public static WebDriver driver;
	public static Properties properties;
	private static String browserName;
	private static String url;
	public static String userName;
	public  static  String passWord;
	public static String location;;
	public static int implicitWait;
	public static ExtentReports ereport;
	public static ExtentTest etest;
	public  static Logger log;
	
	public BaseTest(){
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(Level.INFO);
		
	}
	@BeforeSuite
	public void initFramework(){
		properties=InitProperties.initPropertis("config");
		ereport=new ExtentReports(EXTENT_REPORT_PATH);
		log.info("framework is initialised");
	}
	@BeforeTest
	public void initGlobalConstants(){
		browserName=properties.getProperty("browserName");
		url=properties.getProperty("url");
		userName=properties.getProperty("username");
		passWord=properties.getProperty("password");
		location=properties.getProperty("location");
		implicitWait=Integer.parseInt(properties.getProperty("implicitWait"));
		log.info(browserName);
		log.info(url);
		log.info(userName);
		log.info(passWord);
		log.info(implicitWait);
	}
	@BeforeMethod
	public void setUp(Method m){
		etest=ereport.startTest(m.getName());
		SetUpDrivers setupDriver=new SetUpDrivers();
		if(browserName.equalsIgnoreCase("firefox")){
			driver=setupDriver.launchFirefoxDriver(url);
		}
		else if(browserName.equalsIgnoreCase("ie")){
			driver=setupDriver.launchInternetExplorerDriver(url);
		}
		else{
			driver=setupDriver.launchChromeDriver(url);
		}
		log.info(browserName+" is launched");
		etest.log(LogStatus.PASS,browserName +" is launched");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown(ITestResult result){
		driver.close();
		log.info(browserName+" is closed");
		if(result.getStatus()==ITestResult.SUCCESS){
			etest.log(LogStatus.PASS,"pass");
		}
		else{
			etest.log(LogStatus.FAIL, "failed");
			etest.log(LogStatus.FAIL,etest.addScreenCapture(Helper.SCREEN_SHOT_PATH));
		}
		ereport.endTest(etest);
	}
	@AfterSuite
	public void closeFramework(){
		ereport.flush();
	}
}
