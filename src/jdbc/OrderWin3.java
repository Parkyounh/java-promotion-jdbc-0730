package jdbc;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrderWin3 extends JFrame {
	String id = "root";
	String pw = "1234";
	String url = "jdbc:mysql://localhost:3305/DoItSQL";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "select * from order0729";
	JLabel lb1 = new JLabel("주문 ID");
	JLabel lb2 = new JLabel("주문 상품");
	JLabel lb3 = new JLabel("주문 수량");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JButton btn1 = new JButton("저장");
	JButton btn2 = new JButton("불러오기");
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	JTextArea ta = new JTextArea();
	
	public OrderWin3() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공!");
			stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		con.add(lb1);
		lb1.setBounds(30, 10, 80, 40);
		con.add(lb2);
		lb2.setBounds(120, 10, 80, 40);
		con.add(lb3);
		lb3.setBounds(210, 10, 80, 40);
		
		con.add(tf1);
		tf1.setBounds(30, 50, 80, 40);
		con.add(tf2);
		tf2.setBounds(120, 50, 80, 40);
		con.add(tf3);
		tf3.setBounds(210, 50, 80, 40);
		
		con.add(btn1);
		btn1.setBounds(30, 100, 80, 40);
		
		con.add(btn2);
		btn2.setBounds(110, 100, 90, 40);
		
		con.add(btn3);
		btn3.setBounds(200, 100, 80, 40);
		
		con.add(btn4);
		btn4.setBounds(280, 100, 80, 40);
		
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(30, 150, 250, 70);
		con.add(sp);
		
		this.setSize(400, 300);
		this.setLocation(800, 400);
		this.setTitle("주문 입력 시스템 v1.0");
		showOrders();
		this.setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderId = tf1.getText();
				String product = tf2.getText();
				String quantity = tf3.getText();

				sql = String.format("insert into order0729(order_id, product, quantity) values ('%s', '%s', %s)", 
						orderId, product, quantity);
				System.out.println(sql);
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				showOrders();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showOrders();
				
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderId = tf1.getText();
				String product = tf2.getText();
				String quantity = tf3.getText();

				sql = String.format("update order0729 set product = '%s', quantity = %s where order_id = '%s'", 
						 product, quantity, orderId);
				System.out.println(sql);
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				showOrders();
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String orderId = tf1.getText();

				sql = String.format("delete from order0729 where order_id = '%s'", orderId);
				System.out.println(sql);
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				showOrders();
			}
		});
		
	}
	
	public void showOrders() {
		sql = "select * from order0729";
		try {
			rs = stmt.executeQuery(sql);
			String str = "";
			while (rs.next()) {
				String orderId = rs.getString("order_id");
				String product = rs.getString("product");
				int quantity = rs.getInt("quantity");
				
				str += String.format("%s\t%s\t%d\n", orderId, product, quantity);
//				System.out.println(orderId + ", " + product + ", " + quantity);
			}
			ta.setText(str);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new OrderWin3();

	}

}




