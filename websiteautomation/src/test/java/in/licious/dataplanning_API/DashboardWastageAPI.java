package in.licious.dataplanning_API;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.licious.dataplanning.ElasticSearch;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DashboardWastageAPI extends ElasticSearch{
	@Test
	public void dashboardwastagetest() throws JSONException, IOException
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
		
		String wastage="52.66.9.219:9200/_sql?sql=select sum(dispatched_quantity) from operationdataplan where to='11' and source='1' and createdat='2018-10-22' and sku='pr_57234a4f6f77b'";
		 org.json.JSONObject json = readJsonFromUrl("52.66.9.219:9200/_sql?sql=select sum(dispatched_quantity) from operationdataplan where to='11' and source='1' and createdat='2018-10-22' and sku='pr_57234a4f6f77b'");
		    System.out.println(json.toString());
		    System.out.println(json.get("value"));
		int waste = Integer.parseInt(wastage);			
		System.out.println(waste);

		String demandPlan="2.66.9.219:9200/_sql?sql=select * from demand-plan where city_id='1'%20 and hub_id%20 ='1' and%20 product_id='pr_5785b9065d7e1' and date='2018-10-14'";
		int dplan = Integer.parseInt(demandPlan);			
		System.out.println(dplan);
		int wastagepercentage=waste/dplan;
		System.out.println(wastagepercentage);
	}
}
