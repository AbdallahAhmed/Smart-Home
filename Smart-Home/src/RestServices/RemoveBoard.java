package RestServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import Controller.BoardManagement;
import Controller.DeviceManagement;

@Path("/RemoveBoard/{boardname}/{username}")
public class RemoveBoard {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String RemoveBoard(@PathParam("boardname") String boardname, @PathParam("username") String username) {
		BoardManagement bm = new BoardManagement();
		Boolean valid = bm.RemoveBoard(boardname,username);
		JSONObject obj = new JSONObject();
		obj.put("valid", valid);
		return obj.toJSONString();
	}

}