package gabywald.rest.jersey.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gabywald.something.memory.Memory;

/**
 * 
 * @author Gabriel Chandesris (2022)
 */
@Path("fizzbuzz")
public class FizzBuzzResource {

	public static final String CLICHED_MESSAGE = "FizzBuzz !";
	
	// @PathParam("id") 
	// @FormParam("int1") 

	@POST
	@Path("cyber")
	@Produces("text/plain")
	public String getFizzBuzz(	@FormParam("int1") String int1, 
								@FormParam("int2") String int2, 
								@FormParam("limit") String limit, 
								@FormParam("str1") String str1, 
								@FormParam("str2") String str2 ) {
		// return FizzBuzzResource.CLICHED_MESSAGE;
		// return int1 + " / " + int2 + " / " + limit + " / " + str1 + " / " + str2;
		
		int int1asInt = 3;
		int int2asInt = 5;
		int limitasInt = 100;
		
		try {
			int1asInt = Integer.parseInt( int1 );
			int2asInt = Integer.parseInt( int2 );
			limitasInt = Integer.parseInt( limit );
		} catch (NumberFormatException nfe) {
			return Response.status(Status.BAD_REQUEST).build().toString();
		}
		
		final int int1asIntFinal = int1asInt;
		final int int2asIntFinal = int2asInt;
		
		// DONE check request (error if arguments not good !)
		// DONE record the requests for other endpoint !
		String key = int1 + " / " + int2 + " / " + limit + " / " + str1 + " / " + str2;
		System.out.println( Memory.getInstance().add(key) );
		
		List<String> result = java.util.stream.IntStream.iterate(1, i -> ++i)
				.limit( limitasInt ) // limit here !
				.mapToObj(i -> { // map de remplacement
					StringBuilder sb = new StringBuilder();
					if (i % int1asIntFinal == 0) { sb.append("fizz"); }
					if (i % int2asIntFinal == 0) { sb.append("buzz"); }
					// sb.length()
					if (sb.length() == 0) { sb.append(i); }
					return sb.toString();
		 		})
				.collect(Collectors.toList());
		
		StringBuilder sbToResult = new StringBuilder();
		result.forEach(sbToResult::append);
		
		return result.toString();
	}
	
	@GET
	@Path("statistics")
	@Produces("text/plain")
	public String getStatistics() {
		// TODO read records for endpoints
		// return FizzBuzzResource.CLICHED_MESSAGE;
		String maxKey	= null;
		int maxValue	= 0;
		for (String key : Memory.getInstance().keySet()) {
			int value = Memory.getInstance().get(key);
			if (value > maxValue) {
				maxKey = key;
				maxValue = value;
			}
		}
		// NOTE : could be reformated to a JSON to express the request !
		return maxKey + "::" + maxValue;
	}
	

}
