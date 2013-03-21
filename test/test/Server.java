package test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import org.junit.Test;
import userInterface.MainFrame;
public class Server {

	@Test
	public void initialization() {
		controller.Server server = null;
		MainFrame window = new MainFrame();
		
		// Port
		try {
			new controller.Server(-1, window).close(); // For lav
			fail("Failed.");
		} catch (Exception e) {
		}
		try {
			new controller.Server(0, window).close(); // Laveste
		} catch (Exception e) {
			fail("Failed.");
		}
		try {
			server = new controller.Server(65535, window); // Højeste
		} catch (Exception e) {
			fail("Failed.");
		}
		try {
			new controller.Server(65535, window).close(); // Allerede i brug
			fail("Failed.");
		} catch (Exception e) {
		}
		server.close();
		try {
			new controller.Server(65536, window).close(); // For høj
		} catch (Exception e) {
		}
		
		// Window
		try {
			new controller.Server(0, null).close(); // Null
			fail("Failed.");
		} catch (Exception e) {
		}
		
	}

	@Test
	public void communication() {
		
		try {
		
			// Initialize server
			MainFrame window = new MainFrame();
			controller.Server server = new controller.Server(5576, window);

			// Initialize client
			Socket client = new Socket("localhost", 5576);
			DataOutputStream clientOut = new DataOutputStream(client.getOutputStream());
			BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			// Command: S
			clientOut.writeBytes("S");
			if (!clientIn.readLine().equals("S S 0 kg")) {
				fail("Failed.");
			}

			// Cleanup
			server.close();
			client.close();
			clientOut.close();
			clientIn.close();
			
		} catch (Exception e) {
			fail("Failed: " + e.getMessage());
		}
		
	}
	
}
