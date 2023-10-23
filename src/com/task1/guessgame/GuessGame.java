package com.task1.guessgame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GuessGame extends JFrame {

	private JPanel contentPane;
	private JTextField tfSecretNumber;
	private JTextField tfGuessedNumber;
	int secretNumber, number, score=100, highScore;
	boolean isPlaying;
	private JPanel panel;
	private JTextField tfMessage;
	private JLabel lblName;
	private JLabel lblInst;
	private JTextField tfScore;
	private JTextField tfHighScore;
	private JLabel lblScore;
	private JLabel lblNewLabel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessGame frame = new GuessGame();
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
	public GuessGame() {
		setTitle("Guess Game\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		secretNumber = (int) Math.ceil(Math.random() * 100);
		isPlaying = true;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 730, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Check!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game();	
				
			}
		});
		btnNewButton.setBounds(314, 338, 89, 23);
		panel.add(btnNewButton);
		
		tfSecretNumber = new JTextField();
		tfSecretNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfSecretNumber.setFont(new Font("Tahoma", Font.PLAIN, 50));
		tfSecretNumber.setText("?");
		tfSecretNumber.setBounds(317, 65, 86, 63);
		panel.add(tfSecretNumber);
		tfSecretNumber.setColumns(10);
		tfSecretNumber.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 93, 730, 10);
		panel.add(panel_1);
		
		tfGuessedNumber = new JTextField();
		tfGuessedNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfGuessedNumber.setFont(new Font("Tahoma", Font.PLAIN, 50));
		tfGuessedNumber.setBounds(314, 252, 86, 55);
		panel.add(tfGuessedNumber);
		tfGuessedNumber.setColumns(10);
		tfGuessedNumber.setFocusable(true);
		
		tfMessage = new JTextField();
		tfMessage.setForeground(new Color(255, 255, 255));
		tfMessage.setText("Start Guessing...");
		tfMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMessage.setBounds(428, 156, 270, 31);
		tfMessage.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfMessage.setOpaque(false);
		panel.add(tfMessage);
		tfMessage.setColumns(10);
		
		lblName = new JLabel("Guess Number");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblName.setBounds(240, 11, 253, 43);
		panel.add(lblName);
		
		lblInst = new JLabel("Between 1-100");
		lblInst.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInst.setForeground(new Color(255, 255, 255));
		lblInst.setBounds(598, 0, 122, 25);
		panel.add(lblInst);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resetting game
				secretNumber = (int) Math.ceil(Math.random() * 100);
				tfSecretNumber.setText("?");
				tfGuessedNumber.setText(""+0);
				score = 100;
				tfScore.setText(""+score);
				tfMessage.setText("Start Guessing Again...");
				panel.setBackground(new Color(0, 0, 0));
				tfScore.setText(""+score);
				isPlaying = true;
				game();
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRestart.setBounds(10, 11, 99, 43);
		panel.add(btnRestart);
		
		tfScore = new JTextField();
		tfScore.setText("100");
		tfScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfScore.setForeground(new Color(255, 255, 255));
		tfScore.setBounds(542, 252, 45, 36);
		tfScore.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfScore.setOpaque(false);
		panel.add(tfScore);
		tfScore.setColumns(10);
		
		tfHighScore = new JTextField();
		tfHighScore.setForeground(new Color(255, 255, 255));
		tfHighScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfHighScore.setBounds(542, 308, 45, 36);
		tfHighScore.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfHighScore.setOpaque(false);
		panel.add(tfHighScore);
		tfHighScore.setColumns(10);
		
		lblScore = new JLabel("Score:-");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setForeground(new Color(255, 255, 255));
		lblScore.setBounds(476, 252, 56, 36);
		panel.add(lblScore);
		
		lblNewLabel = new JLabel("High Score:-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(428, 308, 104, 36);
		panel.add(lblNewLabel);
		
	}

	protected void game() {
		if(isPlaying) {
			int inputNumber;
		
		inputNumber = Integer.parseInt(tfGuessedNumber.getText());
		number = inputNumber;
		//Conditions
		if (number == secretNumber) {
			panel.setBackground(new Color(0, 255, 0));
			tfSecretNumber.setText(""+secretNumber);
			tfMessage.setText("Hurray Your Guess is Correct!!!");
			isPlaying = false;
			if(score > highScore) {
				tfHighScore.setText(""+score);//high score set
				highScore = score;
				
			}
		}else if(number > secretNumber) {
			tfMessage.setText("Your Guess is High!!!");
			score--;
			tfScore.setText(""+score);
	
		}else if(number < secretNumber && number > 0){
			tfMessage.setText("Your Guess is low!!!");
			score--;
			tfScore.setText(""+score);
			
		}else if(number == 0){
			tfMessage.setText("Start Guessing Again...");
		}
	}
	}
}

