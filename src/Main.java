import java.io.IOException;
import Controller.Server;
public class Main {

	public static void main(String[] args) {
		int port = 8000;
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println(" ");
		}
		try {
			new Server(port);
		} catch (IOException e) {
			System.out.println(" Cannot start server on port 8000.");
		}
	}

}
