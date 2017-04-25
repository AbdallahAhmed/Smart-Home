package RestServices;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

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
	private static String methodType;
	private static Form form;

	public RestConnector(String serviceName, String methodType){
		this.methodType = methodType;
		param = "rest/" + serviceName;
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		target = client.target(UriBuilder.fromUri("http://localhost:8080/Smart-Home").build());
		form = new Form();
	}
	public void addParamGet(String[] params){
		if(methodType.equals("GET")){
			for(int i = 0; i < params.length; i++){
				param += "/" + params[i];
			}
		}
	}

	public void addParamPost(String key, String value){
		if(methodType.equals("POST")){
			form.param(key, value);
		}
	}
	public JSONObject getJSONObject() throws ParseException{
		JSONParser parser = new JSONParser();
		Object obj = new Object();
		if(methodType.equals("GET")){
			obj = parser.parse(target
					.path(param)
					.request()
					.accept(MediaType.TEXT_PLAIN)
					.get(String.class).toString());
		}else if(methodType.equals("POST")){
			Response res = target.path(param).request()
					.accept(MediaType.TEXT_PLAIN)
					.post(Entity.form(form));
			obj = parser.parse(res.readEntity(String.class));
		}
		JSONObject jsonObj = (JSONObject) obj; 
		return jsonObj;
	}
}
