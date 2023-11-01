package com.atminterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OptionForTransaction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionForTransaction frame = new OptionForTransaction();
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
	public OptionForTransaction() {
		setTitle("ATM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Deposit dp = new Deposit();
				dp.setVisible(true);
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeposit.setBounds(29, 220, 163, 23);
		contentPane.add(btnDeposit);
		
		JButton tbnWithdraw = new JButton("Withdraw");
		tbnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Withdraw wd = new Withdraw();
				wd.setVisible(true);
			
			}
		});
		tbnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbnWithdraw.setBounds(374, 220, 163, 23);
		contentPane.add(tbnWithdraw);
		
		JButton btnAvailBal = new JButton("Available Balance");
		btnAvailBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AvailBal ab = new AvailBal();
				ab.setVisible(true);
			}
		});
		btnAvailBal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAvailBal.setBounds(29, 290, 163, 23);
		contentPane.add(btnAvailBal);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtmInterface ai = new AtmInterface();
				ai.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(374, 292, 163, 23);
		contentPane.add(btnCancel);
		
		JLabel lblWelcome = new JLabel("Welcome To ATM");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcome.setBounds(10, 26, 550, 84);
		contentPane.add(lblWelcome);
	}
}
