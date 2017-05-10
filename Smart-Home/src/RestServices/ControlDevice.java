package RestServices;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Connectors.SocketConnector;
import Controller.Device;

@Path("/ControlDevice/{port}/{message}")
public class ControlDevice {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ControlDevice(@PathParam("port") String port, @PathParam("message")String msg) throws NumberFormatException, UnknownHostException, IOException
	{
		System.out.println(port + " Port Service");
		SocketConnector sc = new SocketConnector(Integer.parseInt(port));
		sc.send(msg);
		JSONObject obj = new JSONObject();
		obj.put("valid", "true");
		return obj.toJSONString();
	}
}
