package com.task5.studentmanagementsystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class StudentManagementSystem {

	private JFrame frmStudentRegistrationForm;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfMobile;
	private JTextField tfAddress;
	private JPasswordField tfPassword;
	private JTable myTable;
	private JScrollPane scrollPane;
	private JPanel updateData;
	private JPanel deleteData;
	private JPanel showData;
	private JPanel addData;
	private JTabbedPane mainTabbedPane;
	private JPanel tabPanel;
	private JPanel mainPanel;
	private ResultSet rs;
	private JTextField tfUpdateName;
	private JTextField tfUpdateEmail;
	private JTextField tfUpdateMobile;
	private JTextField tfUpdateAddress;
	private JPasswordField tfUpdatePassword;
	private JTextField tfUpdateID;
	private JButton btnUpdate;
	private JTextField tfDelete;
	private JButton btnDelete;
	String name, email, mobile, address, password;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementSystem window = new StudentManagementSystem();
					window.frmStudentRegistrationForm.setVisible(true);
					DBConnection.connection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentRegistrationForm = new JFrame();
		frmStudentRegistrationForm.setTitle("Student Management System");
		frmStudentRegistrationForm.setBounds(100, 100, 921, 544);
		frmStudentRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentRegistrationForm.setLocationRelativeTo(null);
		frmStudentRegistrationForm.setResizable(false);
		frmStudentRegistrationForm.getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 0, 160));
		mainPanel.setBounds(10, 11, 243, 452);
		frmStudentRegistrationForm.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentManagementSystem.class.getResource("/img/student management system.png")));
		lblNewLabel.setBounds(10, 21, 223, 207);
		mainPanel.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBConnection.closeDatabase();
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 418, 223, 23);
		mainPanel.add(btnExit);
		
		tabPanel = new JPanel();
		tabPanel.setBounds(263, 11, 632, 452);
		frmStudentRegistrationForm.getContentPane().add(tabPanel);
		tabPanel.setLayout(null);
		
		mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainTabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainTabbedPane.setPreferredSize(new Dimension(10, 10));
		mainTabbedPane.setBounds(0, 0, 627, 452);
		tabPanel.add(mainTabbedPane);
		
		addData = new JPanel();
		mainTabbedPane.addTab("Add Data", null, addData, null);
		addData.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register New Student");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 11, 556, 28);
		addData.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfName.setToolTipText("Enter Name");
		tfName.setColumns(10);
		tfName.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfName.setBounds(82, 54, 438, 48);
		addData.add(tfName);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfEmail.setToolTipText("Enter Name");
		tfEmail.setColumns(10);
		tfEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Email ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfEmail.setBounds(82, 113, 438, 48);
		addData.add(tfEmail);
		
		tfMobile = new JTextField();
		tfMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfMobile.setToolTipText("Enter Name");
		tfMobile.setColumns(10);
		tfMobile.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Mobile Number", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfMobile.setBounds(82, 172, 438, 48);
		addData.add(tfMobile);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAddress.setToolTipText("Enter Name");
		tfAddress.setColumns(10);
		tfAddress.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Address", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfAddress.setBounds(82, 231, 438, 48);
		addData.add(tfAddress);
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPassword.setEchoChar('*');
		tfPassword.setBorder(new TitledBorder(null, "Enter Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfPassword.setBounds(82, 290, 438, 48);
		addData.add(tfPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertData();
			}
		});
		btnRegister.setBounds(227, 349, 191, 37);
		addData.add(btnRegister);
		
		showData = new JPanel();
		showData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainTabbedPane.addTab("Show Data", null, showData, null);
		showData.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 11, 602, 328);
		showData.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportView(scrollPane);
		
		myTable = new JTable();
		myTable.setRowHeight(24);
		myTable.setPreferredScrollableViewportSize(new Dimension(800, 400));
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		myTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(myTable);
		
		JButton btnUpload = new JButton("Load Data");
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableLoad();
			}
		});
		btnUpload.setBounds(234, 350, 151, 38);
		showData.add(btnUpload);
		
		updateData = new JPanel();
		mainTabbedPane.addTab("Update Data", null, updateData, null);
		updateData.setLayout(null);
		
		tfUpdateName = new JTextField();
		tfUpdateName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdateName.setToolTipText("");
		tfUpdateName.setColumns(10);
		tfUpdateName.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfUpdateName.setBounds(95, 86, 438, 47);
		updateData.add(tfUpdateName);
		
		tfUpdateEmail = new JTextField();
		tfUpdateEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdateEmail.setToolTipText("");
		tfUpdateEmail.setColumns(10);
		tfUpdateEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Email ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfUpdateEmail.setBounds(95, 144, 438, 47);
		updateData.add(tfUpdateEmail);
		
		tfUpdateMobile = new JTextField();
		tfUpdateMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdateMobile.setToolTipText("");
		tfUpdateMobile.setColumns(10);
		tfUpdateMobile.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Mobile Number", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfUpdateMobile.setBounds(95, 198, 438, 47);
		updateData.add(tfUpdateMobile);
		
		tfUpdateAddress = new JTextField();
		tfUpdateAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdateAddress.setToolTipText("");
		tfUpdateAddress.setColumns(10);
		tfUpdateAddress.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Enter Address", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		tfUpdateAddress.setBounds(95, 256, 438, 47);
		updateData.add(tfUpdateAddress);
		
		tfUpdatePassword = new JPasswordField();
		tfUpdatePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdatePassword.setEchoChar('*');
		tfUpdatePassword.setBorder(new TitledBorder(null, "Enter Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfUpdatePassword.setBounds(95, 314, 438, 47);
		updateData.add(tfUpdatePassword);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateData();
				
				
			}
		});
		btnUpdate.setBounds(213, 367, 175, 35);
		updateData.add(btnUpdate);
		
		tfUpdateID = new JTextField();
		tfUpdateID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUpdateID.setBorder(new TitledBorder(null, "Search By ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfUpdateID.setBounds(95, 29, 438, 47);
		updateData.add(tfUpdateID);
		tfUpdateID.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setText();
				tfUpdateName.setText(name);
				tfUpdateEmail.setText(email);
				tfUpdateMobile.setText(mobile);
				tfUpdateAddress.setText(address);
				tfUpdatePassword.setText(password);
			}
		});
		btnGo.setBounds(543, 29, 57, 46);
		updateData.add(btnGo);
		
		deleteData = new JPanel();
		mainTabbedPane.addTab("Delete Data", null, deleteData, null);
		deleteData.setLayout(null);
		
		tfDelete = new JTextField();
		tfDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfDelete.setBorder(new TitledBorder(null, "Enter Id to Delete Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfDelete.setBounds(194, 56, 251, 53);
		deleteData.add(tfDelete);
		tfDelete.setColumns(10);
		
		btnDelete = new JButton("Delete Data");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yes = JOptionPane.showConfirmDialog(btnDelete, "Are you sure you want to delete data" );
				if (yes == JOptionPane.YES_OPTION) {
					deleteData();
				}
			}
		});
		btnDelete.setBounds(265, 131, 130, 35);
		deleteData.add(btnDelete);
	}
	protected void deleteData() {
		String id;
		
		id = tfDelete.getText();
		try {
			DBConnection.pst = DBConnection.con.prepareStatement("delete from registration where id=?");
			DBConnection.pst.setString(1, id);
			DBConnection.pst.executeUpdate();
			
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Record Deleted");
			reset();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@SuppressWarnings("deprecation")
	protected void updateData() {
		
		String sid,name,email,mobile,address,password;
		
		sid = tfUpdateID.getText();
		name = tfUpdateName.getText().toString().trim();
		email = tfUpdateEmail.getText().toString().trim();
		mobile = tfUpdateMobile.getText().toString().trim();
		address = tfUpdateAddress.getText().toString().trim();
		password = tfUpdatePassword.getText().toString().trim();
		
		setText();
		if(name.isEmpty()) {
			tfName.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Name Required");
			return;
		}
		if(email.isEmpty()) {
			tfEmail.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Email Required");
			return;
		}
		if(mobile.isEmpty()) {
			tfMobile.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Mobile Number is Required");
			return;
		}
		if(address.isEmpty()) {
			tfAddress.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Address Required");
			return;
		}
		if(password.isEmpty()) {
			tfPassword.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Password Required");
			return;
		}
		
		try {
			  DBConnection.pst=DBConnection.con.prepareStatement("update registration set name=?,email=?,mobile=?,address=?,password=? where id=?");
			  DBConnection.pst.setString(1, name);	
			  DBConnection.pst.setString(2, email);
			  DBConnection.pst.setString(3, mobile);
			  DBConnection.pst.setString(4, address);
			  DBConnection.pst.setString(5, password);
			  
			  DBConnection.pst.setString(6, sid);
			  DBConnection.pst.executeUpdate();
			  JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Data Update in Database Sucessfully");
			  reset();
			  
		}catch(Exception ae) {
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Data Update in Database faild");
			
		}
		
	}

	private String setText() {
		int id ,ids;
		id = Integer.parseInt(tfUpdateID.getText());
		 
		try {
			DBConnection.pst = DBConnection.con.prepareStatement("select * from registration");
			DBConnection.rs = DBConnection.pst.executeQuery();
			while (DBConnection.rs.next()) {
				ids = DBConnection.rs.getInt(1);
				name = DBConnection.rs.getString(2);
				email = DBConnection.rs.getString(3);
				mobile = DBConnection.rs.getString(4);
				address = DBConnection.rs.getString(5);
				password = DBConnection.rs.getString(6);
				if(id == ids) {
					break;
				}
			}
		}
		catch (SQLException e) {
		e.printStackTrace();			
		}
		return name;
	}
	@SuppressWarnings("deprecation")
	protected void insertData() {
		name = tfName.getText().toString().trim();
		email = tfEmail.getText().toString().trim();
		mobile = tfMobile.getText().toString().trim();
		address = tfAddress.getText().toString().trim();
		password = tfPassword.getText().toString().trim();
		
		if(name.isEmpty()) {
			tfName.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Name Required");
			return;
		}
		if(email.isEmpty()) {
			tfEmail.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Email Required");
			return;
		}
		if(mobile.isEmpty()) {
			tfMobile.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Mobile Number is Required");
			return;
		}
		if(address.isEmpty()) {
			tfAddress.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Address Required");
			return;
		}
		if(password.isEmpty()) {
			tfPassword.requestFocus();
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Password Required");
			return;
		}
		
		try {
			
			DBConnection.pst = DBConnection.con.prepareStatement("insert into registration(name,email,mobile,address,password) values(?,?,?,?,?)");
			DBConnection.pst.setString(1, name);
			DBConnection.pst.setString(2, email);
			DBConnection.pst.setString(3, mobile);
			DBConnection.pst.setString(4, address);
			DBConnection.pst.setString(5, password);
			
			DBConnection.pst.execute();
			
			reset();
			
			JOptionPane.showMessageDialog(frmStudentRegistrationForm, "Registred Successfully");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	private void reset() {
		tfName.setText("");
		tfEmail.setText("");
		tfMobile.setText("");
		tfAddress.setText("");
		tfPassword.setText("");
		
	}
	
	private void tableLoad() {
		try { 
			DBConnection.pst =DBConnection.con.prepareStatement("select * from registration");
			rs =DBConnection.pst.executeQuery();
			myTable.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
		e.printStackTrace();
		}
		
		
	}
}
