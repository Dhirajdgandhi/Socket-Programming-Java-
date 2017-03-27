/* Author : Dhiraj Deelip Gandhi.
 Client-Server connection to perform arithmetic operations on server on inputs from client.
 This is server class which establishes a socket connection between server and client on localhost.
 It performs operation on data coming from client and outputs answer back to client.    */

import java.io.*;
import java.net.*;
import java.math.*;

public class server1{

	public static void main(String arg[]) throws Exception	{
	
		System.out.println("***** ARITHMETIC SERVER ******");
		System.out.println("Server is ready to accept inputs…");
		
		ServerSocket serversoc=new ServerSocket(1341);// Server socket
		Socket clientsoc = serversoc.accept();// Accept connection from client
		
		PrintWriter out = new PrintWriter(clientsoc.getOutputStream(), true); // Output stream to client
		BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));// Input stream from server
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));// Standard input
		
		String inputline;
		
		try{
			while (true)
			{
			
				String s,op="",st;
				int i=0,c=0;
				int[] a=new int[2]; // Array to store integer operands
				
				while(true){
					s=in.readLine(); //Operator
			
					if( s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("^") )
						op=s;	
					else if(s.equals("="))
						break;
					else
					{
						a[i]=Integer.parseInt(s);
						i++;
					}
				}
			
				
				if(op.equals("+"))
					c=a[0]+a[1];
				else if(op.equals("-"))
					c=a[0]-a[1];
				else if(op.equals("*"))
					c=a[0]*a[1];
				else if(op.equals("%"))
					c=a[0]%a[1];
				else if(op.equals("^"))
					c=a[0]^a[1];
				else if(op.equals("/"))
					c=a[0]/a[1];
				
				s=Integer.toString(c);
				out.println(s);
				
			}
		
		}
		catch(Exception e){	
			System.out.println("The exception " + e + " was raised"); System.exit(0); 
		}
		
		
	}

}