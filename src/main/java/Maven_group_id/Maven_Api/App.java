package Maven_group_id.Maven_Api;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//import org.junit.Test;

public class App{

	  public static void main( String[] args ) throws Exception
	  {
		  
		// Host url
	     String host = "https://covid-193.p.rapidapi.com/statistics";
	      String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "covid-193.p.rapidapi.com";
	      String x_rapidapi_key = "38c8cc8cd7mshf46fe1ae9d050a4p10b6a9jsndf80d1d59948";//Type here your key 
	      //Params
	      String s = "Pulp";
	  // Format query for preventing encoding problems
	      String query = String.format("s=%s",
	       URLEncoder.encode(s, charset));
	      
	      
	      HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
	    	      .header("x-rapidapi-host", x_rapidapi_host)
	    	      .header("x-rapidapi-key", x_rapidapi_key)
	    	      .asJson();
	    	    System.out.println(response.getStatus());
	    	      System.out.println(response.getHeaders().get("Content-Type"));
	    	      
	    	   // Host, charset and headers vars should be the same
	    	     String i = "tt0110912";
	    	  // Format query for preventing encoding problems
	    	      query = String.format("i=%s",
	    	       URLEncoder.encode(i, charset));      
	    	      // Json response
	    	     HttpResponse <JsonNode> response1 = Unirest.get(host + "?" + query)
	    	      .header("x-rapidapi-host", x_rapidapi_host)
	    	      .header("x-rapidapi-key", x_rapidapi_key)
	    	      .asJson();
	    	  //Prettifying
	    	   
		  HttpResponse<String> response11 = Unirest.get("https://covid-193.p.rapidapi.com/countries")
					.header("X-RapidAPI-Key", "38c8cc8cd7mshf46fe1ae9d050a4p10b6a9jsndf80d1d59948")
					.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
					.asString();
	    	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    	      JsonParser jp = new JsonParser();
	    	      JsonElement je = jp.parse(response11.getBody().toString());
	    	      String prettyJsonString = gson.toJson(je);
	    	      System.out.println(prettyJsonString);

	}

}