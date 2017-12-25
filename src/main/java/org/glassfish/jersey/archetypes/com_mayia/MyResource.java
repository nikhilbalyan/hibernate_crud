package org.glassfish.jersey.archetypes.com_mayia;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.archetypes.com_mayia.dao.CampusMindDAOImpl;
import org.glassfish.jersey.archetypes.com_mayia.pojo.CampusMind;
import org.glassfish.jersey.archetypes.com_mayia.pojo.customexception.StoringException;
import org.jboss.logging.Param;

import com.google.gson.Gson;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws StoringException 
	 */
	
	@GET
	@Path("/{getItParam}")
	public void getItParamTest(@Param int num) {
		System.out.println("num is here ==========\n\n\n\n");
		System.out.println(num);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Path("/{getIt}")
	@Path("/getIt")
	public Response getIt(/*@Param int num*/) throws StoringException {
		System.out.println("inside get IT");
		CampusMindDAOImpl campusmind = new CampusMindDAOImpl();
		campusmind.startConnection();
		Gson gs = new Gson();
		
		Object obj = gs.toJson(campusmind.read(5));

		
//		String l = gs.toJson(campusmind.add(5));
//		Gson gs = new Gson();
//		String l = gs.toJson(campusmind.add(num));
//		List<CampusMind> cmpMindPOJO = new ArrayList<CampusMind>();
//		cmpMindPOJO = campusmind.read(5);
		campusmind.closeConnection();
		return Response.status(200).entity(obj).build();
		
//		return Response.status(200).entity(cmpMindPOJO).build();
	}
	
	public String returnGetIt() {
		return "Got It";
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/postData")
	public String postMessage() throws StoringException {
		CampusMindDAOImpl campusMind = new CampusMindDAOImpl();
		campusMind.startConnection();
		campusMind.add(5);
		campusMind.closeConnection();
		return "message posted";
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{putMessage}")
	public String putMessage() {
		return "put message";
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{deleteMessage}")
	public String deleteMessage() {
		return "message deleted";
	}
}
