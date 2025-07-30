package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCtest2 {
	public static void main(String[] args) {
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3305/DoItSQL";
		Connection con = null;
		Statement stmt = null;
		
		//String sql = "insert into doit_dml(col_1,col_2,col_3) values (1,'DoItSQL','2025-07-30')";
		//String sql1 = "insert into doit_dml(col_3,col_1,col_2) values ('2025-07-30',2,'DoItSQL')";
		String sql = "update doit_dml set col_2 = '변경됨',col_1 =100 where col_1 =1";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("접속 성공");
			stmt = con.createStatement();
			
			stmt.executeUpdate(sql);
			System.out.println("입력 성공");
			
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("접속 오류");
		}
			
	}
		
}

