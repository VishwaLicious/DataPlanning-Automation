package in.licious.dataplanning_API;

import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.licious.util.ReadData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RM_Required_Production {
	@Test
	public void generateRM_Required_Production()
	{
	RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("date", "2018-10-08"); 
		requestParams.put("ck_id", "CK_001"); 
		 
		
		
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
		
		
		System.out.println("RM-ck-skq-config");
		
		ReadData rd = new ReadData();
		String excelFilePath="/Users/Vishwa/git/DataPlanning-Automation/websiteautomation/ExcelData/RM-ck-sku-config.xlsx";
		
		
			
		String pr_id=rd.readDataFromExcel(excelFilePath, "Sheet1", 2, 9);
		
		String pr_id1=rd.readDataFromExcel1(excelFilePath, "Sheet1", 2, 4, 9);
		
		
		//System.out.println(i);
		System.out.println(pr_id);
		System.out.println(pr_id1);
		
		
		
	}
}
