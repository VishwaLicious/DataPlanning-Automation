package in.licious.dataplanning_API;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import in.licious.dataplanning.ElasticSearch;
import in.licious.util.ReadData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RM_Required_Production3 extends ElasticSearch {
	@Test
	public void generateRM_Required_Production() throws JSONException, IOException
	{
	RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("date", "2018-10-08"); 
		requestParams.put("ck_id", "CK_001"); 
		 
		double total = 0;
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("http://planning-api.licious.in/procurement/services/rmproductionplan/generate");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());
		
		// Get the Demand Plan for RM Indent RM_016
		
		// First get what and all products are there in RM_016
		
		String eurl="https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select * from rm-ck-sku-config where rm_id='RM_016'"); //just a string
		
		
		System.out.println("Reading RM-ck-skq-config");
		System.out.println("");
		System.out.println("Calcuting the RM required for production for RM_016");
		System.out.println("");
		
		
		ReadData rd = new ReadData();
		String excelFilePath="/Users/Vishwa/git/DataPlanning-Automation/websiteautomation/ExcelData/RM-ck-sku-config.xlsx";
		
		for (int i=1; i<=7; i++) {
			
		String pr_id=rd.readDataFromExcel(excelFilePath, "Sheet2", i, 0);
		
		String net_wt=(rd.readDataFromExcel(excelFilePath, "Sheet1", i, 0));
		
		String yield=rd.readDataFromExcel(excelFilePath, "Sheet1", i, 11);
		
		
	//	System.out.println(pr_id1);
	//	System.out.println(pr_id2);
		
		//String pr_id1=rd.readDataFromExcel1(excelFilePath, "Sheet1", 2, 4, 9);
		
		
		//System.out.println(i);
		//System.out.println(pr_id);
		//System.out.println(pr_id1);
		
		// Get the Demand Plan for T+1 for RM_16 products which is having type as 2
		
		
		// Elastic Query for Demand plan

		//String surl=null;
		String surl1="https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode(pr_id);
		
		//String arr[]= {https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from production-plan-cluster where product_id in ('pr_3rkjm1v51mm') and ck_id='ck_001' and production_date='2018-10-11'};
		
			/*//String arrData=null;
			String[] arrData = {"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from production-plan-cluster where product_id in ('pr_3rkjm1v51mm') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from production-plan-cluster where product_id in ('pr_8izjlf6xn0k') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from brining-plan-cluster where product_id in ('pr_785jd3c1us3') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from brining-plan-cluster where product_id in ('pr_ntcjmw1avau') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from brining-plan-cluster where product_id in ('pr_59a6d117e3836') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from brining-plan-cluster where product_id in ('pr_id9jj8pq34w') and ck_id='ck_001' and production_date='2018-10-11'"),
								"https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(quantity_to_produce) from brining-plan-cluster where product_id in ('pr_ov2jkm8fgq3') and ck_id='ck_001' and production_date='2018-10-11'")
								};
			int yieldarr[] = { 32, 20, 32, 32, 32, 32, 75 };
			int netweightarr[] = { 400,250,400,400,400,500,300 };
			
		
			
			for(int i=0;i<arrData.length;i++) {
			
//			for(int i = 0; i<arrData.length; i++){
//
//				System.out.println(arrData[i]);
//			}
			
			int yieldarr[] = { 32, 20, 32, 32, 32, 32, 75 };
			int netweightarr[] = { 400,250,400,400,400,500,300 };
			for(int i=0;i<arrData.length;i++) {
				System.out.println(arrData[i]);
				System.out.println(yieldarr[i]);
				System.out.println(netweightarr[i]);
			}
			
			
			for (String strTemp : arrData){
			    //  System.out.println(strTemp);
			*/    
			
		// Connect to URL using java native library
		
		URL url = new URL(surl1);
        URLConnection request1 = url.openConnection();
        request1.connect();
        
        
     // Reading data from the result query and converting to Json object to print the result
        JsonParser jp = new JsonParser(); //from Json
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request1.getContent())); //Convert the input stream to a json element
        JsonElement rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(quantity_to_produce)").getAsJsonObject().get("value"); //May be an array, may be an object.
        
        System.out.println("FG in packets = " + rootobj);
        
        System.out.println("Net_Weight in grams = " + net_wt);
 		System.out.println("Yield = " + yield);
 		
 		
 		
 		
 		//Converting the Json to String
 		String resQuery=rootobj.toString();
 		
 		//Converting String to Double
 		double d1 = Double.parseDouble(resQuery);
 		double d2 = Double.parseDouble(net_wt);
 		double d3 = Double.parseDouble(yield);
 		
 		// Do all the RM_Indent calculation on Double data type
 		
 	
 		//Yield in percentage
 		 double d4 = d3/100;
 		 
 		 System.out.println("Yield in % = " + d4);
 		 
 		// Calculating the RM Indent using the formula RM_Indent = (FG*(UOM/1000))/Yield%
 		 double d5 = (d1*(d2/1000))/d4;
 		 
 		 System.out.println("RM required for production in KG's = " + d5);
 		 
 		 System.out.println("");
 		 
 		 
 		
 		//Converting double to int
 		Double d11 =new Double(d1);
 		int i11 = d11.intValue();
 		
 		Double d22 =new Double(d2);
 		int i22 = d22.intValue();
 		
 		int i21 = i22/100;
 		
 		Double d33 =new Double(d3);
 		int i33 = d33.intValue();
 		
 		
 		/*System.out.println("FG = " + i33);
 		System.out.println("Net_Weight = " + i11);
 		System.out.println("Yield = " + i22);
 		System.out.println("Yield in % = " + i21);*/
 		
 		// Converting net weight from grams to kg's
 		
 		
 		/*//Converting String to Int
 		int v1 = Integer.parseInt(resQuery);
 		
 		int v2 = Integer.parseInt(net_wt);
 		
 		int v3 = Integer.parseInt(yield);*/
 		
 		
 	// Converting the FG into Raw material by using RM=(FG/yield%) and converting raw material from grams to kg's using RM=(FG/yield%)*(UOM/1000)
 		
 		int rawmaterial = (i33 / i21 );
 		
 	//	System.out.println("Raw Material=" + rawmaterial);
 		
 		total = total + d5;
 		double d6 = d5;
 		double d7 = d6+d5;
 		System.out.println("^^^^^^^^^^^^^^^^^^^^");
 		
 	//	int rawmaterial1 = rawmaterial * (pr_id2/1000);
 		
		
 	// Converting the FG into Raw material by using RM=(FG/yield%) and converting raw material from grams to kg's using RM=(FG/yield%)*(UOM/1000)
 		
 		
 	/*	//Converting the rootobj which is in the Json to String
        resQuery1 = rootobj.toString();
        
        // Converting String to Double 
       // String text = "12.34"; // example String
        double value = Double.parseDouble(resQuery1);
        
        //int foo = Integer.parseInt(myString);
        
        // Converting Double to Int
        
        Double d = new Double(value);
        int i = d.intValue();
        
        //Converting String to Int
        String str = Integer.toString(i);*/
 		
 		
  

		
		}
		
		System.out.println("The total RM Required for prodcution for RM_016 I,e RM_Name Basa = " + total + " " + "Kg's");
		System.out.println("");
		// Converting the FG into Raw material by using RM=(FG/yield%) and converting raw material from grams to kg's using RM=(FG/yield%)*(UOM/1000)
		
		
	}
		
	}
	

