package fms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField gender;
	private JTextField contact;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 672);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 5, 934, 70);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Faculty Management System (FMS)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TEACHER INFORMATION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(30, 86, 413, 39);
		contentPane.add(lblNewLabel_1);
		
		fname = new JTextField();
		fname.setBounds(156, 136, 187, 39);
		contentPane.add(fname);
		fname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(50, 141, 96, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Lastname:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(383, 142, 96, 20);
		contentPane.add(lblNewLabel_3);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(489, 141, 187, 39);
		contentPane.add(lname);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_4.setBounds(50, 214, 49, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_5.setBounds(289, 214, 96, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Marital Status:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_6.setBounds(561, 214, 153, 22);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Department:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_7.setBounds(50, 281, 129, 39);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Contact No.:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_8.setBounds(459, 281, 114, 39);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_9.setBounds(50, 370, 119, 63);
		contentPane.add(lblNewLabel_9);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(109, 206, 96, 39);
		contentPane.add(age);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(383, 206, 96, 39);
		contentPane.add(gender);
		
		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"--------Select------", "Single", "Married", "Divorced", "Widow"}));
		status.setToolTipText("");
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));
		status.setBounds(724, 206, 153, 36);
		contentPane.add(status);
		
		JComboBox dept = new JComboBox();
		dept.setModel(new DefaultComboBoxModel(new String[] {"------Select--------", "MCA", "MSc", "BBA", "BCA", "BTECH", "MTECH"}));
		dept.setToolTipText("");
		dept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dept.setBounds(189, 281, 153, 35);
		contentPane.add(dept);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(603, 281, 187, 39);
		contentPane.add(contact);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(173, 370, 444, 50);
		contentPane.add(address);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=age.getText();
				int age=Integer.parseInt(n);
				String sta=status.getSelectedItem().toString();
				String dep=dept.getSelectedItem().toString();
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root","qwerty");
		          
		            String query="insert into tblteacher(fname,lname,gender,age,status,contact,address,dept)values ('"+fname.getText()+"','"+lname.getText()+"','"+gender.getText()+"',"+age+",'"+sta+"','"+contact.getText()+"','"+address.getText()+"','"+dep+"')";
		            Statement s=con.createStatement();
		            int c=s.executeUpdate(query);
		            if(c>0) {
		            	JOptionPane.showMessageDialog(btnNewButton,"Inserted Sucessfully");
		            }
		            else {
		            	JOptionPane.showMessageDialog(btnNewButton,"Already Exist");
		            }
		            
				}
				catch(Exception ea) {
					System.out.print(ea);
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 30));
		btnNewButton.setBounds(383, 491, 156, 50);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                                
			        dispose();
			        Update obj=new Update();
			        obj.setVisible(true);
			}
		});
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setFont(new Font("SimSun", Font.BOLD, 30));
		btnUpdate.setBounds(692, 491, 160, 50);
		contentPane.add(btnUpdate);
		JFrame jFrame = new JFrame();
		jFrame.setResizable(true);
	}
}
