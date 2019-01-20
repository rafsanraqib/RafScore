import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
public class Server {
	  private Statement stmt;
	  private Connection con;
	  private ServerSocket server,server1, server2,server3;
	  private Socket socket,socket1, socket2,socket3;
	  private ObjectInputStream input, input1, input2,input3;
	  private ResultSet rs;
public Server() {
		    try {
		      server = new ServerSocket(1097, 500);
		      server1 = new ServerSocket(1098,500);
		      server2 = new ServerSocket(1099, 500);
		      server3 = new ServerSocket(1096,500);
		      System.out.print("Server is Running");
		      
		      while(true) {
		      socket = server.accept(); // Accepts insert statement
		      socket1 = server1.accept(); // Accepts the select statement
		      socket2 = server2.accept();// Accepts runs
		      socket3 = server3.accept(); // Accepts name
		      input = new ObjectInputStream(socket.getInputStream());
		      System.out.println("Input works");
		      input1 = new ObjectInputStream(socket1.getInputStream());
		      System.out.println("input1 works");
		      input2 = new ObjectInputStream(socket2.getInputStream());
		      System.out.println("input2 works");
		      input3 = new ObjectInputStream(socket3.getInputStream());
		      System.out.println("input3 works");
		      String insert = (String) input.readObject();
		      String select = (String) input1.readObject(); 
		      String name = (String) input3.readObject();
		      int runs = (int) input2.readObject();
		      String URL = "jdbc:mysql://localhost/records?user=root&password=rafsan";
		      System.out.println("Initialized Socket");
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Initialized Socket");
		      con = DriverManager.getConnection(URL);
		      stmt = con.createStatement();
		      rs = stmt.executeQuery(select);
		      System.out.println("select Executed");
		      if(rs.next()) { // Checks if the name entered already exists in the database
		    	String update = "UPDATE records SET Runs = Runs + " + runs + ", Matches = Matches +3, Average = Runs/Matches WHERE Name = " + "'"+ name +"'" + ";";
		    	stmt.executeUpdate(update);  
		        System.out.println("Query Executed"); // Confirmation of query execution
		      }else { // If player name doesn't exist then a new record is created
			   stmt.execute(insert);
			   System.out.println("Query Executed");
		   }
		      
		      }
		      
		      }catch(IOException i) {
		          i.toString();
		        }catch(ClassNotFoundException c) {
		          c.toString();
		        }
		    catch(SQLException s) {
		          s.toString();
		        }
		        
		    }
	public static void main(String[] args) {
		Server s = new Server();

	}

}
