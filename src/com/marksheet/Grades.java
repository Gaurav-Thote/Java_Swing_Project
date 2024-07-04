package com.marksheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class Grades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grades frame = new Grades();
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
	public Grades() {
		setTitle("Marksheet");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 508);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 585, 447);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPercent_4 = new JLabel("Percent >= 40 && Percent <= 50 = C");
		lblPercent_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent_4.setBounds(0, 331, 583, 37);
		panel.add(lblPercent_4);

		JLabel lblPercent_5 = new JLabel("Percent < 40 = F");
		lblPercent_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent_5.setBounds(0, 379, 583, 37);
		panel.add(lblPercent_5);

		JLabel lblPercent_3 = new JLabel("Percent > 50 && Percent <= 60 = C+");
		lblPercent_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent_3.setBounds(0, 283, 583, 37);
		panel.add(lblPercent_3);

		JLabel lblPercent_2 = new JLabel("Percent > 60 && Percent <= 70 = B");
		lblPercent_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent_2.setBounds(0, 235, 583, 37);
		panel.add(lblPercent_2);

		JLabel lblPercent_1 = new JLabel("Percent > 70 && Percent <= 80 = B+");
		lblPercent_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent_1.setBounds(0, 187, 583, 37);
		panel.add(lblPercent_1);

		JLabel lblPercent = new JLabel("Percent > 80 && Percent <= 90 = A");
		lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercent.setBounds(0, 139, 583, 37);
		panel.add(lblPercent);

		JLabel lblNewLabel = new JLabel("Percent > 90% = A+  ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 91, 583, 37);
		panel.add(lblNewLabel);

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGrade.setBounds(0, 31, 583, 37);
		panel.add(lblGrade);
	}

}
