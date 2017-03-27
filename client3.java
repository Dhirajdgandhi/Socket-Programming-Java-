
import java.io.*;  
import java.net.*; 
import java.util.Scanner;
public class client3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket clientsocket;
		try {
			Scanner stdin = new Scanner(System.in);
			clientsocket = new Socket("localhost",1220);
			
			OutputStream outToServer = clientsocket.getOutputStream();
	        DataOutputStream out = new DataOutputStream(outToServer);
	        out.writeUTF("Hello from client... ");
	        
			InputStream inFromServer = clientsocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			
			System.out.println("Enter username and password :\n");
			String username,password;
			
					username=stdin.next();
					password=stdin.next();
					out.writeUTF(username);
					out.writeUTF(password);
					
					//Authentication message
					String authenticate_msg = new String (in.readUTF());
					System.out.println("message from server: " + authenticate_msg);
					/*int flag=0;
					flag=in.read();
					
					if(flag==1)break;*/
				
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
