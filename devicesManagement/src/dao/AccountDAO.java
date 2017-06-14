package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Account;
import library.LibraryConnectDb;

public class AccountDAO {

	private Connection conn;
    private LibraryConnectDb libConnect;
    private Statement st;
    private ResultSet rs;
    private String table;
    private PreparedStatement pst;
    
    public AccountDAO(){
    	libConnect=new LibraryConnectDb();
    	this.table="Account";
    }
    
    public Account checkLogin(String username, String password){
    	conn=libConnect.getConnectMySQL();
    	Account objAC=null;
		String sql="SELECT * FROM "+table+" WHERE username=? and password =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()){
				objAC=new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("role"),rs.getString("id_Employee"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objAC;
    }
    
    
    public ArrayList<Account> getList(){
    	ArrayList<Account> listAccount=new ArrayList<>();
    	conn=libConnect.getConnectMySQL();
    	String sql="SELECT * FROM "+table;
    	try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Account objAccount=new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("role"),rs.getString("id_Employee"));
				listAccount.add(objAccount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return listAccount;
    }
}
