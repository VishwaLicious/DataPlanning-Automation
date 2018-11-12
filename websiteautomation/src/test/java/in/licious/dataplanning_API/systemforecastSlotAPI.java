package in.licious.dataplanning_API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class systemforecastSlotAPI {
	    @Test
		public  void systemforecasttest() {
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
}
