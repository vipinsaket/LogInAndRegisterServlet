import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conn {
private static String url="jdbc:postgresql://localhost:5432/registration?user=postgres&password=123";
private static  Connection con;
Scanner sc=new Scanner(System.in);


static {
	try {
	Class.forName("org.postgresql.Driver");
	con=DriverManager.getConnection(url);
		
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
		
		System.out.println("Class not found postgresql Driver");
		
	}
	catch(SQLException e) {
		
		e.printStackTrace();
		
		System.out.println("Database not connected !!!");
	}
}

public int  add(String name, String userName, String email, int age,String address, String password, String conPassword) {
	int res=0;

	
	String sql="INSERT into signup values(?,?,?,?,?,?,?)";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, userName);
        pstm.setString(3, email);
        pstm.setInt(4,age);
        pstm.setString(5,address);
        pstm.setString(6, password);
        pstm.setString(7,conPassword);
      

       res= pstm.executeUpdate();
        
	} catch (SQLException e) {
		System.out.println("\n \n Duplicate id Not allowed please enter unque id");
		e.printStackTrace();
		
	}
	return res;
	
}

public boolean validateUser(String username, String password) {
    String sql = "SELECT * FROM signup WHERE username = ? AND password = ?";
    try {
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        
        System.out.println(rs);
        System.out.println("validatieuser found");

        return rs.next(); // If a record exists, return true (user found)
    } 
    catch (SQLException e) {
    	System.out.println("user not found");
        e.printStackTrace();
    }
    return false; // User not found
}


}




