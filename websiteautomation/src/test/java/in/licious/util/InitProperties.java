package in.licious.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitProperties {

	public static Properties initPropertis(String ... propertiesFileNamesWithoutExtension){
		Properties property=new Properties();
		
		try {
			for(String fileName:propertiesFileNamesWithoutExtension){			
		//	property.load(new FileReader(System.getProperty("user.dir")+"\\config\\"+fileName+".properties"));
				
				property.load(new FileReader(System.getProperty("Users/Vishwa/git/websiteautomation/config/config.properties")));
				
			
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
