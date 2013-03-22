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
				System.out.println(" Invalid port number " + port + ".");
				return;
			}
		}
		MainWindow window = new MainWindow();
		try {
			new Server(port, window);//port er porten serveren k�rer �, window er serverens egen gui.
		} catch (Exception e) {
			System.out.println(" Cannot start server on port " + port + ".");
			return;
		}
		System.out.println(" Started server on port " + port + ".");
		window.show(); //Goer window synlig.
	}

}
