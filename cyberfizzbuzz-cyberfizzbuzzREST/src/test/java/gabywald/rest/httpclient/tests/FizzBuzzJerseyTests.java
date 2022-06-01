package gabywald.rest.httpclient.tests;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpServer;

import gabywald.rest.httpclient.HttpConnection;

/**
 * 
 * @author Gabriel Chandesris (2022)
 */
class FizzBuzzJerseyTests {
	
	public HttpServer httpServer = null;

	@BeforeEach
	void setUp() throws Exception {
		
		int port				= 9090;
		URI baseUri				= UriBuilder.fromUri("http://localhost/").port(port).build();
		ResourceConfig config	= new ResourceConfig(); // new ResourceConfig(HelloWorldResource.class);
		
		config.packages("gabywald.rest.jersey.resources");
		config.packages("gabywald.rest.jersey.resources.fizzbuzz");
		
		this.httpServer = JdkHttpServerFactory.createHttpServer(baseUri, config, true);
		
		// ... 
		
		// httpServer.stop( 10 );
	}
	
	@AfterEach
	void tearDown() {
		this.httpServer.stop( 1 );
	}

	@Test
	void test() {
		
		System.out.println("hc0");
		HttpConnection hc0 = new HttpConnection(true, "http://localhost:9090/helloworld");
		hc0.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc0.sendRequest( null, null );
		System.out.println(hc0.getResponse());
		Assertions.assertEquals("Hello World!", hc0.getResponse());
		
		System.out.println("hc1");
		HttpConnection hc1 = new HttpConnection(true, "http://localhost:9090/hello");
		hc1.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc1.sendRequest( null, null );
		System.out.println(hc1.getResponse());
		Assertions.assertEquals("Hello, World!", hc1.getResponse());
		
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
		Assertions.assertEquals("[1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz, fizz, 22, 23, fizz, buzz, 26, fizz, 28, 29, fizzbuzz, 31, 32, fizz, 34, buzz, fizz, 37, 38, fizz, buzz, 41, fizz, 43, 44, fizzbuzz, 46, 47, fizz, 49, buzz, fizz, 52, 53, fizz, buzz, 56, fizz, 58, 59, fizzbuzz, 61, 62, fizz, 64, buzz, fizz, 67, 68, fizz, buzz, 71, fizz, 73, 74, fizzbuzz, 76, 77, fizz, 79, buzz, fizz, 82, 83, fizz, buzz, 86, fizz, 88, 89, fizzbuzz, 91, 92, fizz, 94, buzz, fizz, 97, 98, fizz, buzz]", responseHC2);
		Assertions.assertArrayEquals(FizzBuzzJerseyTests.cyberfizzbuzz().toArray(), listHC2.toArray());
		
		System.out.println("hc3");
		HttpConnection hc3 = new HttpConnection(true, "http://localhost:9090/fizzbuzz/statistics");
		hc3.setRequestProperty(HttpHeaders.ACCEPT, ContentType.WILDCARD.getMimeType());
		hc3.sendRequest( null, null );
		System.out.println(hc3.getResponse());
		Assertions.assertEquals("3 / 5 / 100 / fizz / buzz::1", hc3.getResponse());
	}
	
	private static List<String> cyberfizzbuzz() {
		List<String> toReturn = new ArrayList<String>();
		java.util.stream.IntStream.iterate(1, i -> ++i)
		.limit(100) // limit here !
		.mapToObj(i -> { // map de remplacement
			StringBuilder sb = new StringBuilder();
			if (i%3 == 0) { sb.append("fizz"); }
			if (i%5 == 0) { sb.append("buzz"); }
			// sb.length()
			if (sb.length() == 0) { sb.append(i); }
			return sb.toString();
 		})
		// .filter( s -> s.length() > 0)
		.collect(Collectors.toList()) // !! conversion en liste
		.forEach(toReturn::add);
		return toReturn;
	}

}
