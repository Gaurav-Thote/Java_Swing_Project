package com.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField tfWithdraw;
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
					Withdraw frame = new Withdraw();
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
	public Withdraw() {
		setTitle("ATM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfWithdraw = new JTextField();
		tfWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfWithdraw.setColumns(10);
		tfWithdraw.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Withdraw Amount", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfWithdraw.setBounds(116, 128, 195, 54);
		contentPane.add(tfWithdraw);

		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWithdraw.setBounds(157, 38, 102, 31);
		contentPane.add(lblWithdraw);

		JButton btnWithdraw_1 = new JButton("Withdraw");
		btnWithdraw_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw();
			}
		});
		btnWithdraw_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWithdraw_1.setBounds(71, 245, 126, 41);
		contentPane.add(btnWithdraw_1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtmInterface ai = new AtmInterface();
				ai.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(230, 244, 126, 41);
		contentPane.add(btnCancel);
	}

	protected void withdraw() {
		int withdraw;
		int ids = AtmInterface.id;
		withdraw = Integer.parseInt(tfWithdraw.getText());
		newBalance = bal() - withdraw;
//		JOptionPane.showMessageDialog(contentPane, newBalance);
		if (withdraw < 0) {
			JOptionPane.showMessageDialog(contentPane, "Add amount more than 1");
			tfWithdraw.requestFocus();
			return;
		}
		if (withdraw < bal() && withdraw % 100 == 0) {
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
			ab.tfMessage.setText("Please collect your cash");
			ab.setVisible(true);
		} else if (withdraw % 100 != 0) {
			JOptionPane.showMessageDialog(contentPane, "Amount must be in multiple of 100");
			dispose();
			AtmInterface ai = new AtmInterface();
			ai.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(contentPane, "Insufficient Fund");
			dispose();
			AtmInterface ai = new AtmInterface();
			ai.setVisible(true);
		}
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
