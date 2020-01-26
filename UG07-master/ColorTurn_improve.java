package nmsl;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.*;
import lejos.utility.*;

public class ColorTurn {
	public static void main(String[] args) {
		Port port = LocalEV3.get().getPort("S2");
		SensorModes sensor = new EV3ColorSensor(port);
		SampleProvider light = sensor.getMode("Red");
		float[] sample = new float[light.sampleSize()];
		Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		
		int case_one = 0;
		Motor.A.forward();
		Motor.B.backward();
		Delay.msDelay(950);
		light.fetchSample(sample, 0);
		if(sample[0]*100 < 50) {
			case_one = 1;
		}
		Motor.A.backward();
		Motor.B.forward();
		Delay.msDelay(950);
		
		
		
		int count = 0;
		
		//LCD.drawString("count = "+count, 3, 4);
		if(case_one == 1) {
			int turn = 0;
			do {
	//////			int a;
	//			light.fetchSample(sample, 0);
	//////			LCD.drawString(""+sample[0], 0, 0);
				Motor.A.forward();
				Motor.B.forward();
				Delay.msDelay(800);
				light.fetchSample(sample, 0);
				System.out.println(sample[0]);
	
				//Red
				if( sample[0]*100 >= 80 && sample[0]*100 < 90) {
					//Sound.beepSequence();
					//turn = 1;
				}
				else if(sample[0]*100 < 90){
					if(sample[0]*100 >= 30 && sample[0]*100 <= 47) {
						Sound.beepSequence();
					}
					if (turn == 0) {
					
					count += 1;
					//LCD.drawString("count=", 3, 4);
					Motor.B.backward();
					Motor.A.backward();
					Delay.msDelay(500);
				
					//90 right
					Motor.A.backward();
					Motor.B.forward();
					Delay.msDelay(1900);
					
					Motor.A.forward();
					Motor.B.forward();
					Delay.msDelay(600);
	
					//90
					Motor.A.backward();
					Motor.B.forward();
					Delay.msDelay(1880);
					
					turn = 1;
					}
					else {
						count += 1;
						Motor.B.backward();
						Motor.A.backward();
						Delay.msDelay(500);
					
						//90 left
						Motor.A.forward();
						Motor.B.backward();
						Delay.msDelay(1900);
						
						Motor.A.forward();
						Motor.B.forward();
						Delay.msDelay(600);
	
						//90
						Motor.A.forward();
						Motor.B.backward();
						Delay.msDelay(1880);
						turn = 0;
					}
				}
	
			}while(true);
		}
		else {
			int turn = 0;
			do {

				Motor.A.forward();
				Motor.B.forward();
				Delay.msDelay(800);
				light.fetchSample(sample, 0);
				System.out.println(sample[0]);
	
				//Red
				if( sample[0]*100 >= 80 && sample[0]*100 < 90) {
					//Sound.beepSequence();
					//turn = 1;
				}
				else if(sample[0]*100 < 90){
					if(sample[0]*100 >= 30 && sample[0]*100 <= 47) {
						Sound.beepSequence();
					}
					if (turn == 1) {
					
					count += 1;
					//LCD.drawString("count=", 3, 4);
					Motor.B.backward();
					Motor.A.backward();
					Delay.msDelay(500);
				
					//90 right
					Motor.A.backward();
					Motor.B.forward();
					Delay.msDelay(1900);
					
					Motor.A.forward();
					Motor.B.forward();
					Delay.msDelay(600);
	
					//90
					Motor.A.backward();
					Motor.B.forward();
					Delay.msDelay(1880);
					
					turn = 0;
					}
					else {
						count += 1;
						Motor.B.backward();
						Motor.A.backward();
						Delay.msDelay(500);
					
						//90 left
						Motor.A.forward();
						Motor.B.backward();
						Delay.msDelay(1900);
						
						Motor.A.forward();
						Motor.B.forward();
						Delay.msDelay(600);
	
						//90
						Motor.A.forward();
						Motor.B.backward();
						Delay.msDelay(1880);
						turn = 1;
					}
				}

			}while(true);
		}
	}
}
