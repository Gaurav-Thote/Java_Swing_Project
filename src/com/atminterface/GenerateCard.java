package com.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GenerateCard extends JFrame {

	private JPanel contentPane;
	private JTextField tfFName;
	private JTextField tfMName;
	private JTextField tfLName;
	private JTextField tfAccountNumber;
	private JPasswordField tfPin;
	Connection con;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateCard frame = new GenerateCard();
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
	public GenerateCard() {
		setTitle("AtM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 582, 536);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(82, 123, 100, 25);
		panel.add(lblFirstName);

		tfFName = new JTextField();
		tfFName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfFName.setColumns(10);
		tfFName.setBounds(82, 147, 126, 30);
		panel.add(tfFName);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(231, 123, 116, 25);
		panel.add(lblMiddleName);

		tfMName = new JTextField();
		tfMName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfMName.setColumns(10);
		tfMName.setBounds(231, 147, 126, 30);
		panel.add(tfMName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(384, 124, 100, 23);
		panel.add(lblLastName);

		tfLName = new JTextField();
		tfLName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfLName.setColumns(10);
		tfLName.setBounds(384, 147, 126, 30);
		panel.add(tfLName);

		JLabel lblAmountNumber = new JLabel("Amount Number");
		lblAmountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmountNumber.setBounds(82, 235, 146, 25);
		panel.add(lblAmountNumber);

		tfAccountNumber = new JTextField();
		tfAccountNumber.setToolTipText("Note Fancy Aoount number can be a name too");
		tfAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfAccountNumber.setColumns(10);
		tfAccountNumber.setBounds(82, 259, 146, 30);
		panel.add(tfAccountNumber);

		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPin.setBounds(304, 236, 100, 23);
		panel.add(lblPin);

		tfPin = new JPasswordField();
		tfPin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfPin.setBounds(304, 259, 100, 30);
		panel.add(tfPin);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();

			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGenerate.setBounds(217, 337, 100, 35);
		panel.add(btnGenerate);

		JLabel lblGenerateCard = new JLabel("Generate Card");
		lblGenerateCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateCard.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGenerateCard.setBounds(199, 46, 172, 35);
		panel.add(lblGenerateCard);
	}

	@SuppressWarnings({ "deprecation" })
	public void insertData() {
		String fName, mName, lName, accountNumber;
		long pin, bal, cardNumber;

		fName = tfFName.getText().toString().trim();
		mName = tfMName.getText().toString().trim();
		lName = tfLName.getText().toString().trim();
		accountNumber = tfAccountNumber.getText().toString().trim();
		pin = Long.parseLong(tfPin.getText().trim());
		bal = (int) Math.ceil(Math.random() * 2000);
		cardNumber = (int) Math.ceil(Math.random() * 2000);
//		JOptionPane.showMessageDialog(contentPane, cardNumber);
		if (fName.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "First Name Required");
			tfFName.requestFocus();
			return;
		}
		if (mName.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Middle Name Required");
			tfMName.requestFocus();
			return;
		}
		if (lName.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Last Name Required");
			tfLName.requestFocus();
			return;
		}
		if (accountNumber.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Account Number Required");
			tfAccountNumber.requestFocus();
			return;
		}
		if (accountNumber.length() < 9) {
			JOptionPane.showMessageDialog(contentPane, "Account Number must be of 10 digit");
			tfAccountNumber.requestFocus();
			return;
		}
		if (pin < 999) {
			JOptionPane.showMessageDialog(contentPane, "Pin Must be of 4 digits");
			tfPin.requestFocus();
			return;
		}
		if (pin > 10000) {
			JOptionPane.showMessageDialog(contentPane, "Pin Must be of 4 digits");
			tfPin.requestFocus();
			return;
		}
		if (cardNumber < 999) {
			cardNumber = 2000 + cardNumber;
//			JOptionPane.showMessageDialog(contentPane, cardNumber);
		}
		if (pin > 999 && pin < 10000) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "");
				pst = con.prepareStatement(
						"insert into atm(fname,mname,lname,accountnumber,pin,bal,cardno) values(?,?,?,?,?,?,?)");
				pst.setString(1, fName);
				pst.setString(2, mName);
				pst.setString(3, lName);
				pst.setString(4, accountNumber);
				pst.setLong(5, pin);
				pst.setLong(6, bal);
				pst.setLong(7, cardNumber);

				pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(contentPane, "Last four digit of your Card is " + cardNumber);
			dispose();
			AtmInterface ai = new AtmInterface();
			ai.setVisible(true);
		}

	}
}