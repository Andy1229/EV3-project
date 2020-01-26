package nmsl;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import nmsl.ColorTurn;
public class BluetoothRCClientGUI {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JPanel Map = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BluetoothRCClientGUI window = new BluetoothRCClientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BluetoothRCClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final BTRCClient btrc = new BTRCClient();
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setSize(1200,1200);
		frame.setBounds(100, 100, 900, 500);
		//frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//panel.setBounds(0, 0, 434, 261);
		panel.setBounds(0, 100, 900, 900);

		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		JButton btnForward = new JButton("FORWARD");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothForward();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnForward.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnForward.setBounds(109, 11, 100, 80);
		panel.add(btnForward);
		
		JButton btnReverse = new JButton("REVERSE\r\n");
		btnReverse.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothReverse();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnReverse.setBounds(109, 169, 100, 80);
		panel.add(btnReverse);
		
		JButton btnNewButton = new JButton("RIGHT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothRight();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnNewButton.setBounds(208, 90, 100, 80);
		panel.add(btnNewButton);
		
		JButton btnLeft = new JButton("LEFT");
		btnLeft.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothLeft();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnLeft.setBounds(10, 90, 100, 80);
		panel.add(btnLeft);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothStop();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnStop.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnStop.setBounds(109, 90, 100, 80);
		panel.add(btnStop);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btrc.bluetoothExit();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnExit.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 11));
		btnExit.setBounds(279, 227, 89, 23);
		panel.add(btnExit);
		
		
//		JButton btnAuto = new JButton("Auto control");
//		btnAuto.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
//		btnAuto.setBounds(219, 298, 205, 23);
//		panel.add(btnAuto);
//		btnAuto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					btrc.bluetoothExit();
//				} catch (IOException e1) {
//					System.out.println(e1.getMessage());
//				}
//			}
//		});
//		
		
		
		
		final JButton btnKeyboardControl = new JButton("KEYBOARD CONTROL");
		btnKeyboardControl.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnKeyboardControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKeyboardControl.setFocusable(true);
			}
		});
		btnKeyboardControl.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = Character.toUpperCase(e.getKeyChar());
				if (keyChar == KeyEvent.VK_W) {
					try {
						btrc.bluetoothForward();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyChar == KeyEvent.VK_S) {
					try {
						btrc.bluetoothReverse();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyChar == KeyEvent.VK_D) {
					try {
						btrc.bluetoothRight();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyChar == KeyEvent.VK_A) {
					try {
						btrc.bluetoothLeft();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyChar == KeyEvent.VK_F) {
					try {
						btrc.bluetoothStop();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyChar == KeyEvent.VK_E) {
					try {
						btrc.bluetoothExit();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					try {
						btrc.bluetoothForward();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyCode == KeyEvent.VK_DOWN) {
					try {
						btrc.bluetoothReverse();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyCode == KeyEvent.VK_RIGHT) {
					try {
						btrc.bluetoothRight();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyCode == KeyEvent.VK_LEFT) {
					try {
						btrc.bluetoothLeft();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyCode == KeyEvent.VK_NUMPAD0) {
					try {
						btrc.bluetoothStop();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				if (keyCode == KeyEvent.VK_END) {
					try {
						btrc.bluetoothExit();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
//				if (keyCode == KeyEvent.VK_SPACE) {
//					try {
//						final String[] args = new String[] {"123"};
//						ColorTurn.main(args);
//						btrc.bluetoothHonk();
//					} catch (IOException e1) {
//						System.out.println(e1.getMessage());
//					}
//				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		}
				);
		
		btnKeyboardControl.setBounds(219, 198, 205, 23);
		panel.add(btnKeyboardControl);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		btnNewButton_1.setBounds(450, 00, 400, 300);
		panel.add(btnNewButton_1);
	}
}
