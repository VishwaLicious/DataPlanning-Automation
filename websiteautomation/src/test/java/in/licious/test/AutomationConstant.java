package in.licious.test;

import in.licious.util.Helper;

public interface AutomationConstant {

	String EXTENT_REPORT_PATH=System.getProperty("user.dir")+"\\ExtentReports\\"+Helper.dateAndTimeStamp()+"-ereport.html";
	//String SCREEN_SHOT_PATH=System.getProperty("user.dir")+"\\ScreenShots\\"+
	String Excel_Path=System.getProperty("user.dir")+"\\ExcelData\\"+Helper.dateAndTimeStamp()+"-ereport.html";
}
