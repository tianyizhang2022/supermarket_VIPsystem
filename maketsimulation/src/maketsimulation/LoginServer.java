package maketsimulation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
	ServerSocket serverSocket;
	LoginServer(){
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Listen() {
		while(true) {
			Socket socket;
			try {
				socket = serverSocket.accept();//会不会被调用两次？
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		LoginServer LS = new LoginServer();
		LS.Listen();
	}
}
