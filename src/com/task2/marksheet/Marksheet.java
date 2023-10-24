package com.task2.marksheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Marksheet extends JFrame {

	private JPanel contentPane;
	private JTextField tfSub1;
	private JTextField tfSub2;
	private JTextField tfSub3;
	private JTextField tfSub4;
	private JTextField tfSub5;
	private JTextField tfPracSub5;
	private JTextField tfPracSub4;
	private JTextField tfPracSub3;
	private JTextField tfPracSub2;
	private JTextField tfPracSub1;
	int subMO1, subMO2, subMO3, subMO4, subMO5, pracSubMO1, pracSubMO2, pracSubMO3, pracSubMO4, pracSubMO5;
	private JTextField tfMarksObtained;
	private JTextField tfPercentObtained;
	private JTextField tfGradeObtained;
	private JTextField tfResult;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marksheet frame = new Marksheet();
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
	public Marksheet() {
		setTitle("Marksheet\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 914, 689);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMarksheet = new JLabel("Marksheet");
		lblMarksheet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMarksheet.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarksheet.setBounds(0, 25, 904, 49);
		panel.add(lblMarksheet);
		
		JPanel theoryExam = new JPanel();
		theoryExam.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		theoryExam.setBounds(45, 138, 371, 397);
		panel.add(theoryExam);
		theoryExam.setLayout(null);
		
		JLabel lblSubject1 = new JLabel("Subject 1:-");
		lblSubject1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject1.setBounds(73, 144, 106, 38);
		theoryExam.add(lblSubject1);
		
		JLabel lblSubject2 = new JLabel("Subject 2:-");
		lblSubject2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject2.setBounds(73, 193, 106, 38);
		theoryExam.add(lblSubject2);
		
		JLabel lblSubject3 = new JLabel("Subject 3:-");
		lblSubject3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject3.setBounds(73, 242, 106, 38);
		theoryExam.add(lblSubject3);
		
		JLabel lblSubject4 = new JLabel("Subject 4:-");
		lblSubject4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject4.setBounds(73, 291, 106, 38);
		theoryExam.add(lblSubject4);
		
		JLabel lblSubject5 = new JLabel("Subject 5:-");
		lblSubject5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubject5.setBounds(73, 340, 106, 38);
		theoryExam.add(lblSubject5);
		
		JLabel lblTheoryExam = new JLabel("Theory Exam");
		lblTheoryExam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTheoryExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheoryExam.setBounds(10, 42, 351, 40);
		theoryExam.add(lblTheoryExam);
		
		tfSub1 = new JTextField();
		tfSub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfSub1.setBounds(190, 144, 91, 38);
		theoryExam.add(tfSub1);
		tfSub1.setColumns(10);
		
		tfSub2 = new JTextField();
		tfSub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfSub2.setColumns(10);
		tfSub2.setBounds(189, 193, 91, 38);
		theoryExam.add(tfSub2);
		
		tfSub3 = new JTextField();
		tfSub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfSub3.setColumns(10);
		tfSub3.setBounds(189, 242, 91, 38);
		theoryExam.add(tfSub3);
		
		tfSub4 = new JTextField();
		tfSub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfSub4.setColumns(10);
		tfSub4.setBounds(189, 291, 91, 38);
		theoryExam.add(tfSub4);
		
		tfSub5 = new JTextField();
		tfSub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfSub5.setColumns(10);
		tfSub5.setBounds(189, 340, 91, 38);
		theoryExam.add(tfSub5);
		
		JPanel practicalExam = new JPanel();
		practicalExam.setLayout(null);
		practicalExam.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		practicalExam.setBounds(483, 138, 371, 397);
		panel.add(practicalExam);
		
		JLabel lblPracSubject1 = new JLabel("Subject 1:-");
		lblPracSubject1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPracSubject1.setBounds(80, 135, 103, 38);
		practicalExam.add(lblPracSubject1);
		
		JLabel lblPracSubject2 = new JLabel("Subject 2:-");
		lblPracSubject2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPracSubject2.setBounds(80, 184, 103, 38);
		practicalExam.add(lblPracSubject2);
		
		JLabel lblPracSubject3 = new JLabel("Subject 3:-");
		lblPracSubject3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPracSubject3.setBounds(80, 233, 103, 38);
		practicalExam.add(lblPracSubject3);
		
		JLabel lblPracSubject4 = new JLabel("Subject 4:-");
		lblPracSubject4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPracSubject4.setBounds(80, 282, 103, 38);
		practicalExam.add(lblPracSubject4);
		
		JLabel lblPracSubject5 = new JLabel("Subject 5:-");
		lblPracSubject5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPracSubject5.setBounds(80, 331, 103, 38);
		practicalExam.add(lblPracSubject5);
		
		JLabel lblPracticalExam = new JLabel("Practical Exam");
		lblPracticalExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticalExam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPracticalExam.setBounds(10, 42, 351, 40);
		practicalExam.add(lblPracticalExam);
		
		tfPracSub5 = new JTextField();
		tfPracSub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPracSub5.setColumns(10);
		tfPracSub5.setBounds(192, 331, 91, 38);
		practicalExam.add(tfPracSub5);
		
		tfPracSub4 = new JTextField();
		tfPracSub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPracSub4.setColumns(10);
		tfPracSub4.setBounds(192, 282, 91, 38);
		practicalExam.add(tfPracSub4);
		
		tfPracSub3 = new JTextField();
		tfPracSub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPracSub3.setColumns(10);
		tfPracSub3.setBounds(192, 233, 91, 38);
		practicalExam.add(tfPracSub3);
		
		tfPracSub2 = new JTextField();
		tfPracSub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPracSub2.setColumns(10);
		tfPracSub2.setBounds(192, 184, 91, 38);
		practicalExam.add(tfPracSub2);
		
		tfPracSub1 = new JTextField();
		tfPracSub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPracSub1.setColumns(10);
		tfPracSub1.setBounds(193, 135, 91, 38);
		practicalExam.add(tfPracSub1);
		
		JPanel result = new JPanel();
		result.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		result.setBounds(45, 546, 809, 132);
		panel.add(result);
		result.setLayout(null);
		
		JLabel lblTotalMarks = new JLabel("Total Marks Obtained:-");
		lblTotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalMarks.setBounds(20, 62, 187, 38);
		result.add(lblTotalMarks);
		
		JLabel lblTotalMark = new JLabel("Total Marks:-");
		lblTotalMark.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalMark.setBounds(243, 62, 106, 38);
		result.add(lblTotalMark);
		
		JLabel lblPercentage = new JLabel("Percentage:-\r\n\r\n");
		lblPercentage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPercentage.setBounds(404, 62, 106, 38);
		result.add(lblPercentage);
		
		JLabel lblGrade = new JLabel("Grade:-");
		lblGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Grades gd = new Grades();
				gd.setVisible(true);
			
			}
		});
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrade.setBounds(575, 62, 64, 38);
		result.add(lblGrade);
		
		JLabel lblResult = new JLabel("Result:-");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblResult.setBounds(690, 62, 64, 38);
		result.add(lblResult);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validation();
				result();
				passFail();
				
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCalculate.setBounds(348, 11, 106, 40);
		result.add(btnCalculate);
		
		tfMarksObtained = new JTextField();
		tfMarksObtained.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfMarksObtained.setBounds(194, 63, 54, 38);
		tfMarksObtained.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfMarksObtained.setOpaque(false);
		result.add(tfMarksObtained);
		tfMarksObtained.setColumns(10);
		
		tfPercentObtained = new JTextField();
		tfPercentObtained.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfPercentObtained.setColumns(10);
		tfPercentObtained.setBounds(502, 63, 64, 38);
		tfPercentObtained.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfPercentObtained.setOpaque(false);
		result.add(tfPercentObtained);
		
		tfGradeObtained = new JTextField();
		tfGradeObtained.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfGradeObtained.setColumns(10);
		tfGradeObtained.setBounds(633, 62, 54, 38);
		tfGradeObtained.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfGradeObtained.setOpaque(false);
		result.add(tfGradeObtained);
		
		tfResult = new JTextField();
		tfResult.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfResult.setColumns(10);
		tfResult.setBounds(753, 63, 46, 38);
		tfResult.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		tfResult.setOpaque(false);
		result.add(tfResult);
		
		JLabel lblShowTotalMarks = new JLabel("500");
		lblShowTotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShowTotalMarks.setBounds(348, 62, 46, 38);
		result.add(lblShowTotalMarks);
		
		JLabel lblName = new JLabel("Name:-\r\n");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(280, 85, 74, 25);
		panel.add(lblName);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfName.setBounds(350, 85, 221, 25);
		panel.add(tfName);
		tfName.setColumns(10);
	}

	protected void passFail() {
		if(subMO1 + pracSubMO1 < 40) {
			tfResult.setText("Fail");
		}
		else if(subMO2 + pracSubMO2 < 40) {
			tfResult.setText("Fail");
		}
		else if(subMO3 + pracSubMO3 < 40) {
			tfResult.setText("Fail");
		}
		else if(subMO4 + pracSubMO4 < 40) {
			tfResult.setText("Fail");
		}
		else if(subMO5 + pracSubMO5 < 40) {
			tfResult.setText("Fail");
		}
		else {
			tfResult.setText("Pass");
		}
		
	}

	protected void result() {
		int result;
		float percent;
		
		result = subMO1 + subMO2 + subMO3 + subMO4 + subMO5 + pracSubMO1 + pracSubMO2 + pracSubMO3 + pracSubMO4 + pracSubMO5;
		tfMarksObtained.setText(""+result);
		
		percent = (float)result / 5;
		tfPercentObtained.setText(""+percent+"%");
		
		if(percent > 90) {
			tfGradeObtained.setText("A+");
		}
		if(percent > 80 && percent <= 90) {
			tfGradeObtained.setText("A");
		}
		if(percent > 70 && percent <= 80) {
			tfGradeObtained.setText("B+");
		}
		if(percent > 60 && percent <= 70) {
			tfGradeObtained.setText("B");
		}
		if(percent > 50 && percent <= 60) {
			tfGradeObtained.setText("C+");
		}
		if(percent >= 40 && percent <= 50) {
			tfGradeObtained.setText("C");
		}
		if(percent < 40) {
			tfGradeObtained.setText("F");
		}

	}

	protected void validation() {
		String sub1, sub2, sub3, sub4, sub5, pracSub1, pracSub2, pracSub3, pracSub4, pracSub5;
		
		//MO= MArks Obtained
		
		sub1 = tfSub1.getText().toString().trim();
		sub2 = tfSub2.getText().toString().trim();
		sub3 = tfSub3.getText().toString().trim();
		sub4 = tfSub4.getText().toString().trim();
		sub5 = tfSub5.getText().toString().trim();
		
		pracSub1 = tfPracSub1.getText().toString().trim();
		pracSub2 = tfPracSub2.getText().toString().trim();
		pracSub3 = tfPracSub3.getText().toString().trim();
		pracSub4 = tfPracSub4.getText().toString().trim();
		pracSub5 = tfPracSub5.getText().toString().trim();
		
		subMO1 = Integer.parseInt(sub1);
		subMO2 = Integer.parseInt(sub2);
		subMO3 = Integer.parseInt(sub3);
		subMO4 = Integer.parseInt(sub4);
		subMO5 = Integer.parseInt(sub5);
		
		pracSubMO1 = Integer.parseInt(pracSub1);
		pracSubMO2 = Integer.parseInt(pracSub2);
		pracSubMO3 = Integer.parseInt(pracSub3);
		pracSubMO4 = Integer.parseInt(pracSub4);
		pracSubMO5 = Integer.parseInt(pracSub5);
		
		if (subMO1 > 80)  {
			JOptionPane.showMessageDialog(tfSub1, "Please enter upto 80 only");
			tfSub1.requestFocus();
			return;
		}
		if (subMO2 > 80)  {
			JOptionPane.showMessageDialog(tfSub2, "Please enter upto 80 only");
			tfSub2.requestFocus();
			return;
		}
		if (subMO3 > 80)  {
			JOptionPane.showMessageDialog(tfSub3, "Please enter upto 80 only");
			tfSub3.requestFocus();
			return;
		}
		if (subMO4 > 80)  {
			JOptionPane.showMessageDialog(tfSub4, "Please enter upto 80 only");
			tfSub4.requestFocus();
			return;
		}
		if (subMO5 > 80)  {
			JOptionPane.showMessageDialog(tfSub5, "Please enter upto 80 only");
			tfSub5.requestFocus();
			return;
		}
		if (pracSubMO1 > 20)  {
			JOptionPane.showMessageDialog(tfPracSub1, "Please enter upto 20 only");
			tfPracSub1.requestFocus();
			return;
		}
		if (pracSubMO2 > 20)  {
			JOptionPane.showMessageDialog(tfPracSub2, "Please enter upto 20 only");
			tfPracSub2.requestFocus();
			return;
		}
		if (pracSubMO3 > 20)  {
			JOptionPane.showMessageDialog(tfPracSub3, "Please enter upto 20 only");
			tfPracSub3.requestFocus();
			return;
		}
		if (pracSubMO4 > 20)  {
			JOptionPane.showMessageDialog(tfPracSub4, "Please enter upto 20 only");
			tfPracSub4.requestFocus();
			return;
		}
		if (pracSubMO5 > 20)  {
			JOptionPane.showMessageDialog(tfPracSub5, "Please enter upto 20 only");
			tfPracSub5.requestFocus();
			return;
		}
		
	}
}
