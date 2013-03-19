package controller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Server extends Thread {
	
	ServerSocket listener;

	//# New
	
	public Server(int port) throws IOException {
		listener = new ServerSocket(port);
		start();
	}
	
	//# Close
	
	public void close() {
		try {
			listener.close();
		} catch (IOException e) {
		}
	}
	
	//# Functions
	
	@Override
	public void run() {
		try {
			while (true) {
				new Client(listener.accept());
			}
		} catch (IOException e) {
		}
	}
	
	//# Classes
	
	private class Client extends Thread {
		
		Socket socket;
		BufferedReader reader;
		DataOutputStream writer;
		
		//# New
		
		public Client(Socket socket) {
			System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Connected.");
			this.socket = socket;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new DataOutputStream(socket.getOutputStream());
				start();
			} catch (IOException e) {
			}
		}
		
		//# Functions
		
		@Override
		public void run() {
			try {
				while (true) {
					String line = reader.readLine();
					if (line == null) {
						break;
					}
					System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Received: " + line + ".");
					if (line.equals("S")) {
						writer.writeBytes("Svar...");
					} else {
						writer.writeBytes("Error.");
					}
				}
			} catch (IOException e) {
			}
			System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Disconnected.");
		}
		
	}
	
}