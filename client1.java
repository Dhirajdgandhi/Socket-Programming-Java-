/* Author : Dhiraj Deelip Gandhi
 Client-Server connection to perform arithmetic operations on server on inputs from client.
 This is client class which establishes a socket connection between server and client on localhost. 
 Client sends data to server and receives answer back. */

import java.io.*;
import java.net.*;

public class client1
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException{
		
		System.out.println("***** ARITHEMETIC CLIENT ******");
		
		//DataInputStream inp = new DataInputStream(System.in); // Standard input to client
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));// Standard input to client
		
		Socket clientsoc = new Socket("127.0.0.1",1341); //Creating clientsocket on localhost on port 1341
		
		PrintWriter out = new PrintWriter(clientsoc.getOutputStream(), true); //Output Stream to server
		BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream())); //Input stream from server
		
		System.out.println("Enter the inputs");
		String userinput;
		
		try	{
			while (true){
				do //Take input from user and put to output stream
				{
					userinput = stdin.readLine();
					out.println(userinput);
				}while(!userinput.equals("="));
				
				String answer = in.readLine(); //Read output from server
				System.out.println("Output from server : " + answer ); 
			
				}
			
		}
		catch(Exception e){	
			System.out.println("The exception " + e + " was raised "); System.exit(0); 
		}
		
		clientsoc.close();
		
		}//End of main

}//End of Class client1