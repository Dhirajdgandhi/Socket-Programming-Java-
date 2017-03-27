
import java.io.*;  
import java.net.*;
import java.util.Date;  

public class server3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket serversocket = new ServerSocket(1220);
			
			client_login_details c = new client_login_details();
			
			
			Socket server=serversocket.accept();
			DataInputStream in = new DataInputStream(server.getInputStream());
			
	        System.out.println("message from client is:"+ in.readUTF());
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
		        String username,password;
				username=in.readUTF();
				password=in.readUTF();
				
				System.out.println("Username from client : "+ username);
				System.out.println("Password from client : "+ password);
				
				DataOutputStream out = new DataOutputStream (server.getOutputStream());
				
				if(username.equals(c.getUsername()) && password.equals(c.getPassword())){
				    out.writeUTF("Welcome, " + username);
				    out.write(1);
				   
				}
				else if(username.equals(c.getUsername())){
					out.writeUTF("Enter correct password ");
				}else{
					out.writeUTF("Login Failed");
				}
	       
			
			
           // System.out.println("server pro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
