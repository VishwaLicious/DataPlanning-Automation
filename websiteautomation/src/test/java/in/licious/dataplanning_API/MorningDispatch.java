package in.licious.dataplanning_API;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import in.licious.util.ReadData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class MorningDispatch {

	
	public static  String GenearateMorningDispatch() throws IOException{
		
		String s1 = null;
		String excelfilepath="/Users/Vishwa/git/DataPlanning-Automation/websiteautomation/ExcelData/Morning Dispatch.xlsx";
		
		
		RequestSpecification request = RestAssured.given();
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
				
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		// Passing the Raw Body for the API in JSON format 
		JSONObject requestParams = new JSONObject();
		requestParams.put("date", "2018-11-02");
		
		// Converting the request body to String
		request.body(requestParams.toJSONString());
		
		// Hitting the Morning Dispatch API 
		Response response = request.post("http://planning-api.licious.in/production/services/morningdispatch/generate");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println("Status Code = " + statusCode);
		System.out.println(data);
		System.out.println("Response Body is " + data1.asString());
		
		// Get the Demand plan latest version and hub wise and cluster wise for all the products
		
		ReadData rd = new ReadData();
		
		// Cluster ID Loop
		for (int i=1; i<2; i++) {
			
			String c_id = rd.readDataFromExcel(excelfilepath, "Sheet1", i, 3);
			
			
			
			// Product ID's Loop
			for (int i1=1; i1<2; i1++) {
				
				String pr_id = rd.readDataFromExcel(excelfilepath, "Sheet1", i1, 0);
				
				// Date's Loop
				for (int i2=1; i2<2; i2++) {
					
					String date = rd.readDataFromExcel(excelfilepath, "Sheet1", i2, 2);
					
					
					
					String csDate = rd.readDataFromExcel(excelfilepath, "Sheet1", i2, 5);
					
					
					// First Querying for the Max Version and passing the max version in Demand Plan Query 
					
					String sURL2 = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select max(version) from demand-plan where product_id='"+pr_id+"' and date='"+date+"'and cluster_id='"+c_id+"'");
					
					
					
					// Connect to the URL using java's native library
			          URL url2 = new URL(sURL2);
			          URLConnection request3 = url2.openConnection();
			        // request3.connect();
			          
			          JsonParser jp = new JsonParser();
			          
			          // Convert to a JSON object to print data
			          JsonParser jp2 = new JsonParser(); //from Json
			          JsonElement root2 = jp.parse(new InputStreamReader((InputStream) request3.getContent())); //Convert the input stream to a json element
			          JsonElement rootobj2 = root2.getAsJsonObject().get("aggregations").getAsJsonObject().get("MAX(version)").getAsJsonObject().get("value"); //May be an array, may be an object.     
			          
			          System.out.println("");
			          
			          System.out.println("Max version of Demand_Plan" + " " + rootobj2);
			         
					
					
					
					String sURL = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(final_forecast) from demand-plan where product_id='"+pr_id+"' and date='"+date+"'and cluster_id='"+c_id+"'"); //just a string
					
					String sURL1 = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(stock_units) from closingstock where product_id='"+pr_id+"' and osdate='"+csDate+"'and cluster_id='"+c_id+"'"); 
					
					 
					
					
					System.out.println(c_id);
					System.out.println(pr_id);
					System.out.println(date);
					System.out.println(csDate);
					
					//String    sURL1 = URLEncoder.encode(sURL, "UTF-8");
			          // Connect to the URL using java's native library
			          URL url = new URL(sURL);
			          URLConnection request1 = url.openConnection();
			          request1.connect();

			          // Convert to a JSON object to print data
			         // JsonParser jp = new JsonParser(); //from Json
			          JsonElement root = jp.parse(new InputStreamReader((InputStream) request1.getContent())); //Convert the input stream to a json element
			           JsonElement rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(final_forecast)").getAsJsonObject().get("value"); //May be an array, may be an object.
			         
			         //String    sURL1 = URLEncoder.encode(sURL, "UTF-8");
				          // Connect to the URL using java's native library
				          URL url1 = new URL(sURL1);
				          URLConnection request2 = url1.openConnection();
				         // request1.connect();

				          // Convert to a JSON object to print data
				          JsonParser jp1 = new JsonParser(); //from Json
				          JsonElement root1 = jp.parse(new InputStreamReader((InputStream) request2.getContent())); //Convert the input stream to a json element
				           JsonElement rootobj1 = root1.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(stock_units)").getAsJsonObject().get("value"); //May be an array, may be an object.   
				           
				        
				         //String    sURL1 = URLEncoder.encode(sURL, "UTF-8");
					          
					         
					         
			           //System.out.println(sURL);
			           
			           System.out.println();
			           System.out.println("Getting the Final Forecast Cluster Wise");
			           System.out.println();
			           System.out.println("Final_Forecast = " + rootobj + " " +" for this " + " " + pr_id + " on " + " "+ date + " " + " for " + c_id);
			           System.out.println();
			           System.out.println();
			           System.out.println("Getting the Closing Stock Cluster Wise");
			           System.out.println();
			           System.out.println("Closing Stock = " + rootobj1 + " " +" for this " + " " + pr_id + " on " + " "+ csDate + " " + " for " + c_id);
			           System.out.println();
			           System.out.println("********************************************");
			           System.out.println("********************************************");
			           
			           // Parsing the Json element to String
			           String s11 = rootobj.toString();
			           String s22 = rootobj1.toString();
			           
			           // Parsing the String to Double
			           double d1 = Double.parseDouble(s11);
			           double d2 = Double.parseDouble(s22);
			           
			           // Checking the final forecast is less than  the 95% of closing stock
			            double d3 = d2/d1 * 100;
			            
			            System.out.println(d3 + "%");
			            
			            double d4 = d2/d1;
			            
			            double d5 = d1-d2;
			            
			            if(d4<0.95) {
			            	
			            	System.out.println("Do the morning dispatch for this " +" "+ pr_id);
			            	
			            	System.out.println("Produce" +" "+ d5 + " " +"this much quantity" +" "+ "for" + " " + c_id);
			            	
			            	
			            }
			            
			            else {
			            	
			            	System.out.println("Morning dispatch is not required since FF is greater than 95% of CS ");
			            }
			           
			           
			      
			           
			           
				}
				
			}
			
			
			
		}
			
			
		
		
		
	//	System.out.println(pr_id);
		
		
		
        
		   
		return s1;
		
          
		}	
		
		
		
	
	
	
	
	
	public static void main (String[] args) throws IOException {
		
		GenearateMorningDispatch();
		
		
	}
}
