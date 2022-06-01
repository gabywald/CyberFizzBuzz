package gabywald.rest.jersey;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import gabywald.rest.httpclient.HttpConnection;

// import org.glassfish.jersey.servlet.ServletContainer;

public class FizzBuzzJerseyLauncher {

	@SuppressWarnings("restriction")
	public static void main (String[] args) {
		int port				= 9090;
		URI baseUri				= UriBuilder.fromUri("http://localhost/").port(port).build();
		ResourceConfig config	= new ResourceConfig(); // new ResourceConfig(HelloWorldResource.class);
		
		config.packages("gabywald.rest.jersey.resources");
		config.packages("gabywald.rest.jersey.resources.fizzbuzz");
		
		com.sun.net.httpserver.HttpServer httpServer = 
				JdkHttpServerFactory.createHttpServer(baseUri, config, true);
		
		System.out.println("hc0");
		HttpConnection hc0 = new HttpConnection(true, "http://localhost:9090/helloworld");
		hc0.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc0.sendRequest( null, null );
		System.out.println(hc0.getResponse());
		
		System.out.println("hc1");
		HttpConnection hc1 = new HttpConnection(true, "http://localhost:9090/hello");
		hc1.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc1.sendRequest( null, null );
		System.out.println(hc1.getResponse());
		
		System.out.println("hc2");
		HttpConnection hc2 = new HttpConnection(false, "http://localhost:9090/fizzbuzz/cyber");
		hc2.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		hc2.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("int1", "3");
		parameters.put("int2", "5");
		parameters.put("limit", "100");
		parameters.put("str1", "fizz");
		parameters.put("str2", "buzz");
		hc2.sendRequest( null, parameters );
		String responseHC2 = hc2.getResponse();
		List<String> listHC2 = Arrays.asList( responseHC2.substring(1, responseHC2.length()-1).split(", ") );
		System.out.println( responseHC2 );
		System.out.println( listHC2 );
		
		System.out.println("hc3");
		HttpConnection hc3 = new HttpConnection(true, "http://localhost:9090/fizzbuzz/statistics");
		hc3.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc3.sendRequest( null, null );
		System.out.println(hc3.getResponse());
		
		httpServer.stop( 10 );
		
	}

}
