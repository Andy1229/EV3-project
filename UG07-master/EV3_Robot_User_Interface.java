import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class EV3_Robot_User_Interface extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EV3_Robot_User_Interface frame = new EV3_Robot_User_Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EV3_Robot_User_Interface() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(31, 189, 61, 29);
		getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setBounds(125, 189, 61, 29);
		getContentPane().add(btnRight);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(81, 230, 53, 29);
		getContentPane().add(btnBack);
		
		JLabel lblEvRobotControl = new JLabel("EV3 Robot Control");
		lblEvRobotControl.setBounds(6, 6, 115, 16);
		getContentPane().add(lblEvRobotControl);
		
		JButton btnFront = new JButton("Front");
		btnFront.setBounds(79, 148, 61, 29);
		getContentPane().add(btnFront);
		
		JLabel lblDirectionControl = new JLabel("Direction Control");
		lblDirectionControl.setBounds(55, 120, 115, 16);
		getContentPane().add(lblDirectionControl);
		
		JLabel lblStateControl = new JLabel("State Control");
		lblStateControl.setBounds(286, 194, 82, 16);
		getContentPane().add(lblStateControl);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(237, 218, 53, 29);
		getContentPane().add(btnStart);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(296, 218, 61, 29);
		getContentPane().add(btnPause);
		
		JButton btnEnd = new JButton("End");
		btnEnd.setBounds(363, 218, 53, 29);
		getContentPane().add(btnEnd);
		
		textField = new JTextField();
		textField.setBounds(225, 45, 201, 132);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMap = new JLabel("Map");
		lblMap.setBounds(309, 23, 26, 16);
		getContentPane().add(lblMap);

	}
}
