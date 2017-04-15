package RestServices;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.core.UriBuilder;

public class RestConnector {
	private static ClientConfig config;
	private static Client client;
	private static WebTarget target;
	private static String param;
	
	public RestConnector(String serviceName){
		param = "rest/" + serviceName;
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(UriBuilder.fromUri("http://localhost:8080/Smart-Home").build());
	}
	public void addParam(String[] params){
		for(int i = 0; i < params.length; i++){
			param += "/" + params[i];
		}
	}
	
	public JSONObject getJSONObject() throws ParseException{
		JSONParser parser = new JSONParser();
 		Object obj = parser.parse(target
 				.path(param)
 				.request()
 				.accept(MediaType.TEXT_PLAIN)
 				.get(String.class).toString()); 
				 JSONObject jsonObj = (JSONObject) obj; 
				 return jsonObj;
	}
}
