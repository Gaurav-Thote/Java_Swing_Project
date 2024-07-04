package com.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AvailBal extends JFrame {

	private JPanel Close;
	private JTextField tfAvailBal;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int bals;
	JTextField tfMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailBal frame = new AvailBal();
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
	public AvailBal() {
		setTitle("ATM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		Close = new JPanel();
		Close.setBackground(new Color(128, 128, 255));
		Close.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(Close);
		Close.setLayout(null);

		JLabel lblAvailableBalance = new JLabel("Available Balance");
		lblAvailableBalance.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAvailableBalance.setBounds(117, 32, 195, 31);
		Close.add(lblAvailableBalance);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtmInterface ai = new AtmInterface();
				ai.setVisible(true);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setBounds(152, 203, 96, 31);
		Close.add(btnClose);

		tfAvailBal = new JTextField();
		tfAvailBal.setText("" + bal());
		tfAvailBal.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tfAvailBal.setHorizontalAlignment(SwingConstants.CENTER);
		tfAvailBal.setBounds(117, 74, 167, 39);
		tfAvailBal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tfAvailBal.setOpaque(false);
		tfAvailBal.setEditable(false);
		Close.add(tfAvailBal);
		tfAvailBal.setColumns(10);

		tfMessage = new JTextField();
		tfMessage.setOpaque(false);
		tfMessage.setHorizontalAlignment(SwingConstants.CENTER);
		tfMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfMessage.setEditable(false);
		tfMessage.setColumns(10);
		tfMessage.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tfMessage.setBounds(10, 153, 414, 39);
		Close.add(tfMessage);
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
