package dataplanning_api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateDemandPlanWithBuffers {
	@Test
	public void updateDemandPlanWithBuffersTest()
	{
	RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
	
		requestParams.put("week", "40");
		requestParams.put("year", "2018");
		requestParams.put("city_id", "1");
		//requestParams.put("week", "40");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("http://13.126.207.17/forecast/services/demandplan/create");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());
		
	}
}
