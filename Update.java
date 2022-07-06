package fms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
public class Update extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRead = new JButton("READ");
		btnRead.setFont(new Font("SimSun", Font.BOLD, 30));
		btnRead.setBackground(Color.GREEN);
		btnRead.setBounds(381, 405, 156, 50);
		contentPane.add(btnRead);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("SimSun", Font.BOLD, 30));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(653, 405, 156, 50);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setFont(new Font("SimSun", Font.BOLD, 30));
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setBounds(109, 405, 156, 50);
		contentPane.add(btnUpdate);
		
		table = new JTable();
		
		table.setBounds(10, 11, 929, 336);
		contentPane.add(table);
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root","qwerty");
	          Statement s=con.createStatement();
	            String query="select * from tblteacher ;";
	            ResultSet rs=s.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception a) {
			System.out.print(a);
		}
	}
}
