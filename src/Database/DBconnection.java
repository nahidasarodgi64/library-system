package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public static final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/library";
	public static final String USER="root";
	public static final String PASS="root";
	static Connection conn=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName(JDBC_Driver);
			System.out.println("Driver Loaded");
			System.out.println("Connection to database");
			conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
	public static void main(String[] args) {
		Connection con=DBconnection.getConnection();
		if(con!=null)
			System.out.println("MySQL Connection Successfully ");
		else
			System.out.println("Not connection to mysql");
	}
	

}
