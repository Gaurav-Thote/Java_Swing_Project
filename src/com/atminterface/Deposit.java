package com.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField tfDeposit;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int newBalance, bals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setTitle("ATM Interface");
		setBackground(new Color(128, 128, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDeposit.setBounds(162, 47, 102, 31);
		contentPane.add(lblDeposit);

		tfDeposit = new JTextField();
		tfDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDeposit.setColumns(10);
		tfDeposit.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Deposit Amount", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfDeposit.setBounds(113, 137, 195, 54);
		contentPane.add(tfDeposit);

		JButton btnDeposit_1 = new JButton("Deposit");
		btnDeposit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit();
			}
		});
		btnDeposit_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeposit_1.setBounds(69, 241, 126, 39);
		contentPane.add(btnDeposit_1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtmInterface ai = new AtmInterface();
				ai.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(231, 239, 126, 41);
		contentPane.add(btnCancel);
	}

	protected void deposit() {
		int deposit;
		int ids = AtmInterface.id;
		deposit = Integer.parseInt(tfDeposit.getText());
		newBalance = bal() + deposit;
//		JOptionPane.showMessageDialog(contentPane, newBalance);
		if (deposit < 0) {
			JOptionPane.showMessageDialog(contentPane, "Add amount more than 1");
			tfDeposit.requestFocus();
			return;
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "");
			pst = con.prepareStatement("update atm set bal=? where id = ?");
			pst.setLong(1, newBalance);
			pst.setInt(2, ids);
			pst.executeUpdate();

//				JOptionPane.showMessageDialog(contentPane, "Deposit successfull");

		} catch (SQLException e1) {

			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		dispose();
		AvailBal ab = new AvailBal();
		ab.tfMessage.setText("Thank you for banking with us");
		ab.setVisible(true);

	}

	private int bal() {
		try {
			connection();
			int u = AtmInterface.u, p = AtmInterface.p, cardNumber = AtmInterface.u, pin = AtmInterface.p;

			while (rs.next()) {

				bals = rs.getInt(7);
//				JOptionPane.showMessageDialog(contentPane, bals);
				u = rs.getInt(8);
				p = rs.getInt(6);

				if (cardNumber == u && pin == p) {
//					JOptionPane.showMessageDialog(contentPane, "Login Successfully");

					break;
				}

			}

		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return bals;
	}

	protected void connection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "");
			pst = con.prepareStatement("select * from atm");
			rs = pst.executeQuery();
			// JOptionPane.showMessageDialog(contentPane, "DataBase Connected");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
