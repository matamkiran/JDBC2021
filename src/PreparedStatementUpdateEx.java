import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementUpdateEx {

	public static void main(String[] args) throws SQLException, IOException {

		String database_connection_url = "jdbc:postgresql://127.0.0.1:5432/test";

		String database_user_name = "postgres";

		String database_user_password = "root";

		Connection conn = DriverManager.getConnection(database_connection_url, database_user_name,
				database_user_password);
		System.out.println(conn);

		System.out.println("You are successfully connected to the PostgreSQL database server.");

		String query = "update employee set emp_name=?  where emp_name=?";

		System.out.println(query);
		PreparedStatement pst = conn.prepareStatement(query);

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter your name :");
		String myname = br.readLine();

		System.out.println("Enter your updated name :");
		String uname = br.readLine();
		pst.setString(1,uname);
		pst.setString(2, myname);

		int i = pst.executeUpdate();
		System.out.println(i+" rows got updated !");
	}

}
