
import java.io.*;  
import java.net.*; 
import java.util.Scanner;
public class client41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s1;
		try {
			Scanner sc = new Scanner(System.in);
			
			s1 = new Socket("localhost",1220);
			OutputStream outToServer = s1.getOutputStream();
	        DataOutputStream out = new DataOutputStream(outToServer);
	        out.writeUTF("Hello from client 1 ");
			
	        /*InputStream s1In = s1.getInputStream();
			DataInputStream dis = new DataInputStream(s1In);
			String st = new String (dis.readUTF());
			System.out.println("message from server: "+st);
			*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
