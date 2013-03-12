package test;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
public class Server {

	@Test
	public void newServer() {
		controller.Server server = null;
		
		// For lav
		try {
			new controller.Server(-1).close();
			fail("Failed.");
		} catch (IOException e) {
			fail("Failed.");
		} catch (IllegalArgumentException e) {
		}
		
		// Laveste
		try {
			new controller.Server(0).close();
		} catch (IOException e) {
			fail("Failed.");
		}
		
		// Højeste + Allerede i brug
		try {
			server = new controller.Server(65535);
		} catch (IOException e) {
			fail("Failed.");
		}
		try {
			new controller.Server(65535).close();
			fail("Failed.");
		} catch (IOException e) {
		}
		server.close();
		
		// For høj
		try {
			new controller.Server(65536).close();
		} catch (IOException e) {
			fail("Failed.");
		} catch (IllegalArgumentException e) {
		}
		
	}

}
