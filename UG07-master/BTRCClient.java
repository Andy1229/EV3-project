package nmsl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BTRCClient {
	// static final String IP = "172.20.10.14";
	static final String IP = "10.0.1.1";
	// static final int PORT = 5678;
	static final int PORT = 1111;
	
	public void bluetoothForward() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(1);
		socket.close();
	}
	
	public void bluetoothReverse() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(2);
		socket.close();
	}
	
	public void bluetoothRight() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(3);
		socket.close();
	}
	
	public void bluetoothLeft() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(4);
		socket.close();
	}
	
	public void bluetoothStop() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(5);
		socket.close();
	}
	
	public void bluetoothExit() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(6);
		socket.close();
	}
	
	public void bluetoothHonk() throws IOException {
		Socket socket = new Socket(IP, PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(7);
		socket.close();
	}

}