package controller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
			Pattern patternRM20 = Pattern.compile("^RM20 8 \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$");
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
						writer.writeBytes("S S " + " kg"); //# TODO: Indsæt netto vægt ved +, bruger . som decimal tegn.

					} else if (line.equals("T")) {
					
						// Sæt og retuner tara.
						writer.writeBytes("T S " + " kg"); //# TODO: Indsæt ny tara vægt ved +, bruger . som decimal tegn.

					} else if (line.equals("DW")) {
					
						// Fjern meddelsen fra displayet og vend tilbage til visning af netto vægt.
						//# TODO: Fjern meddelse fra displayet.
						writer.writeBytes("DW A");
					
					} else if (line.startsWith("D ") && line.length() > 2) {
						
						// Vis meddelse på displayet.
						line.substring(2); //# TODO: Vis denne meddelse på displayet.
						writer.writeBytes("D A");

					} else if (matcherRM20.matches()) {

						// Vis tre meddelser på displayet og retuner den indtastede værdi.
						matcherRM20.group(1); //# TODO: Vis denne meddelse som den første på displayet.
						matcherRM20.group(2); //# TODO: Vis denne meddelse som den anden på displayet.
						matcherRM20.group(3); //# TODO: Vis denne meddelse som den tredje på displayet.
						writer.writeBytes("RM20 A \"" + "\""); //# TODO: Retuner svar. Skal A være et B?
						
					} else {
						
						// Retuner en fejlmeddelse.
						writer.writeBytes("Error."); //# TODO: Send rigtig fejlkode.
					
					}
				}
			} catch (IOException e) {
			}
			System.out.println(" " + socket.getInetAddress().getHostAddress() + ": Disconnected.");
		}
		
	}
	
}