package in.licious.dataplanning_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RM_CK_Ledger {
	@Test
	public void rm_ck_ledgertest()
	{
		//RestAssured.baseURI="https://planning-api.licious.in/forecast/services/systemforecast";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("ck_id", "CK_001"); 
		requestParams.put("closingStock", "10");
		requestParams.put("date", "2018-10-0");
		requestParams.put("openingStock", "100");
		requestParams.put("qtyInProduction", "0");
		requestParams.put("receivedQty", "0");
		requestParams.put("rmId", "RM_001");
		requestParams.put("rmIndent", "515.4823923444975");
		requestParams.put("rmName", "Chicken RM");
		requestParams.put("rmProductionPlan", "515.4823923444975");
		requestParams.put("uom", "KG");
		requestParams.put("updatedBy", "system");
		requestParams.put("version", "2");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("http://52.66.9.219:9200/rm-ck-ledger/data/2018-10-02|RM_001|CK_001__2");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());	
	}
}
