import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
	

	
	public static void main(String[] args) throws SQLException, IOException {
		
		  String database_connection_url = "jdbc:postgresql://127.0.0.1:5432/test";

			 String database_user_name = "postgres";

			 String database_user_password = "root";
			
			 Connection conn= DriverManager.getConnection(database_connection_url, database_user_name, database_user_password);
			 System.out.println(conn);

			System.out.println("You are successfully connected to the PostgreSQL database server.");

			  String query="Select * from employee where emp_name=?";
			 
			  System.out.println(query);
			PreparedStatement pst=  conn.prepareStatement(query);		
			
			  InputStreamReader r=new InputStreamReader(System.in);    
			    BufferedReader br=new BufferedReader(r);    			
			    System.out.println("Enter your name :");
			   String myname= br.readLine();
			    
			   pst.setString(1, myname);

			   ResultSet rs= pst.executeQuery();
			   while(rs.next()) {
					System.out.println(rs.getString(2) + ' ' +rs.getString(3));
			   }
	}



}
