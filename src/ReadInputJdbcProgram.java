import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadInputJdbcProgram {
	
	public static void main(String[] args) throws SQLException, IOException {
		
		  String database_connection_url = "jdbc:postgresql://127.0.0.1:5432/test";

			 String database_user_name = "postgres";

			 String database_user_password = "root";
			
			 Connection conn= DriverManager.getConnection(database_connection_url, database_user_name, database_user_password);
			 System.out.println(conn);

			System.out.println("You are successfully connected to the PostgreSQL database server.");

			Statement st=  conn.createStatement();		
			
			  InputStreamReader r=new InputStreamReader(System.in);    
			    BufferedReader br=new BufferedReader(r);    			
			    System.out.println("Enter your name :");
			   String myname= br.readLine();
			    
			    String query="Select * from employee where emp_name= '"+myname+"'";
				  query=query+";drop from employee1;";
				  System.out.println(query);

			   ResultSet rs= st.executeQuery(query);
			   while(rs.next()) {
					System.out.println(rs.getString(2) + ' ' +rs.getString(3));
			   }
	}

}
