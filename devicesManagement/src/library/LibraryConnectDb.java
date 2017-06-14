package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class LibraryConnectDb {
	private Connection conn;
	private String user="root";
	private String password="";
	private static String db="DevicesManagement";
	private static String url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
	
    public Connection getConnectMySQL(){
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			System.out.println(conn);
		} catch (Exception e) {
			System.out.println("abc");
			e.printStackTrace();
		}
    	
    	return conn;
    }
    public static void main(String[] args) {
		try {
			LibraryConnectDb lb= new LibraryConnectDb();
			System.out.println(lb.getConnectMySQL());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
