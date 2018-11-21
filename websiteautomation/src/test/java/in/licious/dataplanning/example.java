package in.licious.dataplanning;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import in.licious.util.ReadData;

public class example {
	public static String data_DB() throws Throwable
	
    {
        String productId=null;
        String hubId=null;
        String date=" ";
        ResultSet res1=null;
        String resQuery=null;
        String resQuery1=null;
        //String excelFilePath="C:\\Users\\vishwa\\Desktop\\Data Planning\\Data Set.xlsx";
        //Reading data 
        String excelFilePath="/Users/Vishwa/git/DataPlanning-Automation/websiteautomation/ExcelData/Data Set.xlsx";
        JsonElement rootobj=null;
        
        ReadData rd=new ReadData();
            
            // Dev DB Access for	 OTP
            String url1="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
             
            Connection con;
                // Establishing DB connection for Dev
                con=DriverManager.getConnection(url1, "marketing", "+\"4hf~`2CMAn:8=}");
                
                // Establishing DB connection for ORT
                
                //ResultSet res = con.createStatement().executeQuery(" use licious");
                
                // To know the count of products in excel (Get last row num)
               // int productCount=rd.lastrownumber();
                //System.out.println(productCount);
                           
                //System.out.println(DB_data);
                for(int date1=1;date1<=21;date1++) {
                	date=rd.readDataFromExcel(excelFilePath, "Sheet1", date1, 4);
                	System.out.println(date);
                   
                
                		String query="select  sum(x1) as y from" 
    							+ "(select sum(quantity) as x1 from orders o, order_items oi where o.order_id=oi.order_id and o.status='delivered' "
        						
        						+ "and date(o.order_processing_date)='"+date+"' union all "
        						+ "select sum(quantity) as x1 from merchant_orders om, merchant_orderitems oim where om.order_id=oim.order_id and om.status='delivered'"
        						
        						+ "and date(om.order_processing_date)='"+date+"') as total1 ;";
                		
                		//System.out.println(query);
                		res1 = con.createStatement().executeQuery(query);
                		while (res1.next())
        				{		
                			resQuery=res1.getString(1);
                			//System.out.println(resQuery);	
                			System.out.println("Mysql="+" "+resQuery);
        				}	
                	
                		// Converting 'resQuery' which is in String to Int
                		
                		int result = Integer.parseInt(resQuery);			
                		//System.out.println(result);

                		
                		
                		
                		String sURL = "https://plan-es1.licious.app/_sql?sql="+URLEncoder.encode("select sum(order_item_quantity) from orderdataplannew where order_status='Delivered' and order_processing_date='"+date+"'"); //just a string
                        
                        
                        
//                      String    sURL1 = URLEncoder.encode(sURL, "UTF-8");
                          // Connect to the URL using java's native library
                          URL url = new URL(sURL);
                          URLConnection request = url.openConnection();
                          request.connect();

                          // Convert to a JSON object to print data
                          JsonParser jp = new JsonParser(); //from Json
                          JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
                           rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(order_item_quantity)").getAsJsonObject().get("value"); //May be an array, may be an object.
                          
                       //   Object s1=rootobj;
                           
                           //Converting the rootobj which is in the Json to String
                            resQuery1 = rootobj.toString();
                            
                            // Converting String to Double 
                           // String text = "12.34"; // example String
                            double value = Double.parseDouble(resQuery1);
                            
                            // Converting Double to Int
                            
                            Double d = new Double(value);
                            int i = d.intValue();
                            
                            //Converting String to Int
                            String str = Integer.toString(i);
                            
                            //System.out.println(i);
                          
                            
                          // Comparing the Mysql and Elastic Data after changing the data types
                          System.out.println("Elastic="+i);
                         
                          // Comparing two strings Mysql=resQuery and Elastic=str 
                         // if(resQuery.equalsIgnoreCase(str)) {
                         // Comparing two ints Mysql=result and Elastic=i
                         //if(result==i) {
                          
                          //Comparing Mysql and Elastic data
                          if(resQuery.equals(str)) {
                       	   
                       	   System.out.println("same");
                       	   
                       	   
                          }
                          else
                       	   System.out.println("Not same");
                          
                          	
                         System.out.println();
                         System.out.println();
                         
                         
                          
                          //Finding the difference of two integers
                          
                     
                          
                          
                          
                        //*************************************************************  
                          
//                          System.out.println("Elastic="+rootobj);
//                          
//                          if(resQuery==resQuery1) {
//                       	   
//                       	   System.out.println("same");
//                       	   
//                       	   
//                          }
//                          else
//                       	   System.out.println("Not same");
                          
                        //***********************************************************
                          
                          
                           
                          
                           //res1.close();
           				//return url1;
                		
                		
                	}
				return url1;
				
                	
              
        
}

public static void main(String args[]) throws Throwable {
	
	
	// Instantiate a Date object
    Date date = new Date();

    // display time and date using toString()
    System.out.println(date.toString());
    
    
	System.out.println("Main Execution");
	System.out.println();
	 data_DB();
	
	 System.out.println("************************************************");
	 Date date1 = new Date();
	 System.out.println(date1.toString());

}
	

}
    
    /*
    for(int i=1;i<=5;i++)
    {
        for(int j=0;j<=2;j++)
        {
         DB_data=rd.readDataFromExcel(excelFilePath, "Sheet1", i, 0);
        System.out.println(DB_data);
    
        //}
     res1 = con.createStatement().executeQuery(rd.readDataFromExcel(excelFilePath, "DB_Data", 1, 0)DB_data);
    
    while (res1.next())
    {
       //String otp = res1.getString(1);
      
       otp1=res1.getString(1);
      
      // System.out.println(otp);
              
               System.out.println(otp1);
      
    }
    
    }*/
//        System.out.println("Pass 44");

/*public static int dataprovider() {

}*/

