package fms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

import java.sql.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 612);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(66, 54, 176, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(66, 196, 176, 64);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(322, 39, 216, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(322, 196, 216, 52);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root","qwerty");
		          Statement s=con.createStatement();
		            String query="select * from tbllogin where user='"+textField.getText()+"'";
		            ResultSet rs=s.executeQuery(query);
//		            Store.name=textField.getText();
		            String uType="";
		            String password="";
		            String pass= textField_1.getText();
		            String type="";
		            while(rs.next()) {
		                password=rs.getString("pass");
		                
		            }
		            
		            if( password.equals(pass)) {
		               
		            	
		                	dispose();
		                	Home ob=new Home();
		                	ob.setTitle("Faculty Management System");
		                	ob.setVisible(true);
		                	ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                	ob.setResizable(true);
		                }
			 }catch(Exception ea) {
				 System.out.print(ea);
			 }
			}	
			
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(150, 369, 152, 58);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				
			}
		});
		btnReset.setBackground(Color.RED);
		btnReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnReset.setBounds(399, 369, 139, 58);
		contentPane.add(btnReset);
	}
}
