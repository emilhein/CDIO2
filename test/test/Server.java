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
			fail("Failed: No exception thrown.");
		} catch (Exception e) {
		}
		try {
			new controller.Server(0, window).close(); // Laveste
		} catch (Exception e) {
			fail("Failed: " + e.getMessage());
		}
		try {
			server = new controller.Server(65535, window); // Højeste
		} catch (Exception e) {
			fail("Failed: " + e.getMessage());
		}
		try {
			new controller.Server(65535, window).close(); // Allerede i brug
			fail("Failed: No exception thrown.");
		} catch (Exception e) {
		}
		server.close();
		try {
			new controller.Server(65536, window).close(); // For høj
			fail("Failed: No exception thrown.");
		} catch (Exception e) {
		}
		
		// Window
		try {
			new controller.Server(0, null).close(); // Null
			fail("Failed: No exception thrown.");
		} catch (Exception e) {
		}
		
	}

	@Test
	public void communication() {
		
		try {
		
			// Initialize server
			MainFrame window = new MainFrame();
			controller.Server server = new controller.Server(5577, window);
			
			// Initialize client
			Socket client = new Socket("localhost", 5577);
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream writer = new DataOutputStream(client.getOutputStream());
			
			// Command: S
			writer.writeBytes("S\r\n");
			if (!reader.readLine().equals("S S 0.0 kg")) {
				fail("Failed.");
			}
			window.setBrutto(75.4);
			writer.writeBytes("S\r\n");
			if (!reader.readLine().equals("S S 75.4 kg")) {
				fail("Failed.");
			}
			
			// Command: T
			writer.writeBytes("T\r\n");
			if (!reader.readLine().equals("T S 75.4 kg")) {
				fail("Failed.");
			}
			window.setBrutto(175.4);
			writer.writeBytes("S\r\n");
			if (!reader.readLine().equals("S S 100.0 kg")) {
				fail("Failed.");
			}
			
			// Command: DW
			writer.writeBytes("DW\r\n");
			if (!reader.readLine().equals("DW A")) {
				fail("Failed.");
			}
			
			// Command: D
			writer.writeBytes("D x\r\n");
			if (!reader.readLine().equals("D A")) {
				fail("Failed.");
			}
			
			// Command: RM20
			writer.writeBytes("RM20 8 \"a b c\" \"1 2 3\" \"A B C\"\r\n");
			if (!reader.readLine().equals("RM20 B")) {
				fail("Failed.");
			}
			if (!reader.readLine().equals("RM20 A \"\"")) {
				fail("Failed.");
			}
			
			// Cleanup
			reader.close();
			writer.close();
			client.close();
			server.close();
			
		} catch (Exception e) {
			fail("Failed: " + e.getMessage());
		}
		
	}
	
}
