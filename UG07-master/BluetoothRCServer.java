package nmsl;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lejos.utility.Delay;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BluetoothRCServer {
	public static void main(String args[]) throws IOException {
		int input;
		ServerSocket server = new ServerSocket(1111);
		EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
		IsEscapeDownChecker isEscapeDown = new IsEscapeDownChecker(server);
		isEscapeDown.setDaemon(true);
		isEscapeDown.start();
		
		motorA.setSpeed(200);
		motorB.setSpeed(200);
		while (true) {
			Socket socket;
			try {
				socket = server.accept();
			} catch (IOException e) {
				break;
			}
			DataInputStream in = new DataInputStream(socket.getInputStream());
			input = in.readInt();
			
			if (input == 1) {
				motorA.forward();
				motorB.forward();
				
			} 
			
			if (input == 2) {
				motorA.backward();
				motorB.backward();
				
			}
			
			if (input == 3) {
				motorA.backward();
				motorB.forward();
				
			}
			
			if (input == 4) {
				motorA.forward();
				motorB.backward();
				
			}
			
			if (input == 5) {
				motorA.stop();
				
			}
			if (input == 5) {
				
				motorB.stop();
			}
			
			if (input == 6) {
				Sound.setVolume(100);
				Sound.buzz();
				server.close();
				motorA.close();
				motorB.close();
				System.exit(0);
			}
			
			if (input == 7) {
				Sound.setVolume(100);
				Sound.beep();
			}
		}
		
		Sound.setVolume(100);
		Sound.buzz();
		server.close();
		motorA.close();
		motorB.close();
		System.exit(0);
	}
}