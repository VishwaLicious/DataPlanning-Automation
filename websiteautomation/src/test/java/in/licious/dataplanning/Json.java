package in.licious.dataplanning;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {

	public static void main(String[] args) throws IOException {
		//String ss="select sum(revenue),sum(quantity) from aggregation-data where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
		//String ss="select sum(price) from orderdataplannew where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
		String ssw="select sum(dispatched_quantity) from operationdataplan where to='11' and source='1' and createdat='2018-10-22' and sku='pr_57234a4f6f77b'";
		String ssdp="select sum(final_forecast) from demand-plan where city_id='1' and hub_id ='1' and product_id='pr_5785b9065d7e1' and date='2018-10-14'";
		String sURLdp = "http://52.66.9.219:9200/_sql?sql="+URLEncoder.encode(ssdp); //just a string
		String sURLw = "http://52.66.9.219:9200/_sql?sql="+URLEncoder.encode(ssw); //just a string
		
		//System.out.println(wastage);
//	String	sURL1 = URLEncoder.encode(sURL, "UTF-8");
	    // Connect to the URL using java's native library
	    URL url = new URL(sURLdp);
	    URLConnection request = url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
	    String rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(final_forecast)").getAsJsonObject().get("value").getAsString();
	    
	    //May be an array, may be an object. 
	    System.out.println(rootobj);
	  // String value = rootobj.get("value").getAsString(); //just grab the zipcode
	    //System.out.println(value);
	    
	    
	    URL url1 = new URL(sURLw);
	    URLConnection request1 = url1.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp1 = new JsonParser(); //from gson
	    JsonElement root1 = jp1.parse(new InputStreamReader((InputStream) request1.getContent())); //Convert the input stream to a json element
	    String rootobj1 = root1.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(dispatched_quantity)").getAsJsonObject().get("value").getAsString();
	    
	    //May be an array, may be an object. 
	    System.out.println(rootobj1);
	    
	    int dplan = Integer.parseInt(rootobj);		
		int wastage = Integer.parseInt(rootobj1);			
		System.out.println(dplan);
		System.out.println(wastage);
		int wastagepercentage=(wastage)/dplan*100;
		System.out.println(wastagepercentage);

	}

}
