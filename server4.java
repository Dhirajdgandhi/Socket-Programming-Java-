
import java.io.*;  
import java.net.*;
import java.util.Date;  

public class server4 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        boolean listeningSocket = true;
        try {
            serverSocket = new ServerSocket(1220);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 1220");
        }

        while(listeningSocket){
            Socket clientSocket = serverSocket.accept();
            MiniServer mini = new MiniServer(clientSocket);
            mini.start(); //starts the execution of the thread.JVM calls the run() method on the thread
        }
        
        serverSocket.close();       
    }

}

