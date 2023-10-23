package com.task3.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AtmInterface extends JFrame {

	private JPanel contentPane;
	private JTextField tfCardNumber;
	private JTextField tfPin;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	static int bal, id, u, p;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtmInterface frame = new AtmInterface();
					frame.setVisible(true);
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtmInterface() {
		setTitle("ATM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 669, 495);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfCardNumber = new JTextField();
		tfCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCardNumber.setBorder(new TitledBorder(null, "Last four digits of your card", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfCardNumber.setBounds(231, 176, 212, 47);
		panel.add(tfCardNumber);
		tfCardNumber.setColumns(10);
		
		JLabel lblNewCard = new JLabel("Don't have a card to generate");
		lblNewCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewCard.setBounds(182, 394, 242, 47);
		panel.add(lblNewCard);
		
		JLabel lblClickHere = new JLabel("Click here");
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GenerateCard gc = new GenerateCard();
				gc.setVisible(true);
			}
		});
		lblClickHere.setForeground(new Color(0, 0, 255));
		lblClickHere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClickHere.setBounds(423, 394, 85, 47);
		panel.add(lblClickHere);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection();
				check();
				
			}
		});
		btnContinue.setBounds(299, 324, 89, 23);
		panel.add(btnContinue);
		
		tfPin = new JPasswordField();
		tfPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPin.setColumns(10);
		tfPin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enter Your Pin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfPin.setBounds(231, 249, 212, 47);
		panel.add(tfPin);
		
		JLabel lblWelcome = new JLabel("Welcome To ATM");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(10, 44, 649, 47);
		panel.add(lblWelcome);
	}

	protected void check() {
	
		int cardNumber = 0, pin = 0;
			
		try {
			connection();
			cardNumber = Integer.parseInt(tfCardNumber.getText(cardNumber, 4));
			pin = Integer.parseInt(tfPin.getText(pin, 4));
			while (rs.next()) {
				u = rs.getInt(8);
				p = rs.getInt(6);
				id = rs.getInt(1);
				
				if (cardNumber == u && pin == p) {	
//					JOptionPane.showMessageDialog(contentPane, "Login Successfully as "+ fName);
					dispose();
					OptionForTransaction oft =new OptionForTransaction();
					oft.setVisible(true);
				}
				
			}
//			if (!userName.equals(u)) {
//				JOptionPane.showMessageDialog(contentPane, "UserName or Password is incorrect");						
//			}
		}catch(Exception ae) {
			ae.printStackTrace();
		}
	}

	protected void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","");
		
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pst =con.prepareStatement("select * from atm");
			rs = pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
