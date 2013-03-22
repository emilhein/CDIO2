package controller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import userInterface.MainFrame;
public class Server extends Thread {
	
	ServerSocket listener;
	MainFrame window;
	
	//# New
	
	public Server(int port, MainFrame window) throws IOException {
		if (window == null) {//Tjekker om window exsisterer.
			throw new IllegalArgumentException("Window is undefined.");
		}
		listener = new ServerSocket(port);//Hvor den lytter.
		this.window = window;
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
				new Client(listener.accept(), window);
			}
		} catch (IOException e) {
		}
	}
	
	//# Classes
	
	private class Client extends Thread {
		
		Socket socket;
		BufferedReader reader;
		DataOutputStream writer;
		MainFrame window;
		
		//# New
		
		public Client(Socket socket, MainFrame window) {
			System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Connected.");
			this.socket = socket;
			this.window = window;
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
			Pattern patternRM20 = Pattern.compile("^RM20 8 \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$"); //Moenster
			try {
				while (true) {
					String line = reader.readLine();
					if (line == null) {
						break;
					}
					System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Received: " + line + ".");
					Matcher matcherRM20 = patternRM20.matcher(line);
					if (line.equals("S")) {
					
						// Retuner netto vægt.
						writer.writeBytes("S S " + ("" + window.getNetto()).replace(",", ".") + " kg\r\n");

					} else if (line.equals("T")) {
					
						// Saet og retuner tara(tara bliver sat til nuvaerende brutto).
						double newTara = window.getBrutto();
						window.setTara(newTara);
						writer.writeBytes("T S " + ("" + newTara).replace(",", ".") + " kg\r\n");

					} else if (line.equals("DW")) {
					
						// Fjern meddelsen fra displayet og vend tilbage til visning af netto vægt.
						window.clearDisplay();
						writer.writeBytes("DW A\r\n");
					
					} else if (line.startsWith("D ") && line.length() > 2) {
						
						// Vis meddelse på displayet(paa vaegten).
						window.display(line.substring(2));
						writer.writeBytes("D A\r\n");

					} else if (matcherRM20.matches()) {

						// Vis tre meddelser på displayet og retuner den indtastede værdi.
						writer.writeBytes("RM20 B\r\n");
						writer.writeBytes("RM20 A \"" + window.prompt(matcherRM20.group(1), matcherRM20.group(2), matcherRM20.group(3)).replace("\"", "_") + "\"\r\n");
						
					} else {
						
						// Retuner en fejlmeddelse.
						writer.writeBytes("Error\r\n"); //# TODO: Send rigtig fejlkode.
					
					}
				}
			} catch (IOException e) {
			}
			System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Disconnected.");
		}
		
	}
	
}