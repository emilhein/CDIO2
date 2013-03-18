import java.io.IOException;
import userInterface.MainWindow;
import controller.Server;
public class Main {

	public static void main(String[] args) {
		int port = 8000;
		System.out.println();
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println(" Invalid port number: " + port + ".");
			}
		}
		try {
			new Server(port);
			System.out.println(" Started server on port " + port + ".");
			new MainWindow();
		} catch (IOException e) {
			System.out.println(" Cannot start server on port " + port + ".");
		}
	}

}
