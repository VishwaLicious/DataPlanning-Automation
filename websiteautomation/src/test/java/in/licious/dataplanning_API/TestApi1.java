package in.licious.dataplanning_API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestApi1 {
	
	@Test()
	public void logintest()
	{
		RequestSpecification request = RestAssured.given();
		// Add a header stating the Request body is a JSON
				request.header("Content-Type", "application/json");
				// Add a header stating the Request body is a JSON
				request.header("token", "e6e061838856bf47e1de730719fb2609");
				Response response = request.post("http://13.126.207.17/forecast/login");
	}
	@Test(priority=0)
	public  void createDemandPlan() {
		RestAssured.baseURI="http://13.126.207.17/forecast/services/demandplan/initialcreate";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("city_id", "2"); 
		requestParams.put("week", "42");
		requestParams.put("year", "2018");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("http://13.126.207.17/forecast/services/demandplan/initialcreate");

		int statusCode = response.getStatusCode();
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());
	}
	//@Test
	public  void test() {
		RestAssured.baseURI="https://planning-api.licious.in/forecast/services/systemforecast";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("from", "2018-09-19"); 
		requestParams.put("to", "2018-09-19");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("/slot");

		int statusCode = response.getStatusCode();
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());
	}
	@Test
	public void test1()
	{
		//RestAssured.baseURI="https://planning-api.licious.in/forecast/services/systemforecast";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("date", "2018-10-10"); 
		requestParams.put("ck_id", "CK_001");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add a header stating the Request body is a JSON
		request.header("token", "e6e061838856bf47e1de730719fb2609");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("https://planning-api.licious.in/production/services/systemdp/create");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String data = response.getContentType();
		ResponseBody data1 = response.getBody();

		System.out.println(statusCode);
		System.out.println(data);
		System.out.println(data1.asString());	
	}

@Test
public void test2()
{
	//RestAssured.baseURI="https://planning-api.licious.in/forecast/services/systemforecast";
	RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-20"); 
	requestParams.put("to", "2018-10-20");
	
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/forecast/services/systemforecast/day");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());	
}
@Test
public void test3()
{
	//RestAssured.baseURI="https://planning-api.licious.in/forecast/services/systemforecast";
	RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-03"); 
	requestParams.put("to", "2018-10-03");
	requestParams.put("category_id", "[]");
	requestParams.put("product_id", "[]");
	requestParams.put("city_id", "1");
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/forecast/dashboard/wastage");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());	
}
@Test
public void test4()
{
RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-03"); 
	requestParams.put("to", "2018-10-03");
	requestParams.put("category_id", "[]");
	requestParams.put("product_id", "[]");
	requestParams.put("city_id", "1");
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/forecast/dashboard/wastage");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());
}
@Test
public void test5()
{
RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("date", "2018-10-11"); 
	
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/forecast/services/updateActualsAndLossSaleToDemandPlan");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());
}
@Test
public void test6()
{
RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-08"); 
	requestParams.put("to", "2018-10-14"); 
	requestParams.put("city", "1"); 
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/production/services/brining/generate");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());
}
@Test
public void test7()
{
RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-15"); 
	requestParams.put("from","2018-10-21"); 
	requestParams.put("city", "1"); 
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/production/services/thawing/generate");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());
}
@Test
public void test8()
{
RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("from", "2018-10-15"); 
	requestParams.put("from","2018-10-21"); 
	requestParams.put("city", "1"); 
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	// Add a header stating the Request body is a JSON
	request.header("token", "e6e061838856bf47e1de730719fb2609");
	
	request.body(requestParams.toJSONString());
	
	Response response = request.post("http://13.126.207.17/production/services/generate");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	String data = response.getContentType();
	ResponseBody data1 = response.getBody();

	System.out.println(statusCode);
	System.out.println(data);
	System.out.println(data1.asString());
}
}
