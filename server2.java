

import java.io.*;
import java.net.*;

class server2 {
	
    public static void main(String args[]) {
    	String fileToSend=null;// "F:/Academics/8th sem/DS LAB/ServerFiles/Server.txt";

        while (true) {
            ServerSocket welcomeSocket = null;
            Socket connectionSocket = null;
            BufferedOutputStream outToClient = null;
            InputStream is = null;

            try {
                welcomeSocket = new ServerSocket(2000);
                connectionSocket = welcomeSocket.accept();
                outToClient = new BufferedOutputStream(connectionSocket.getOutputStream());
                is = connectionSocket.getInputStream();
                
            } catch (IOException ex) {
                // Do exception handling
            }
            

/* -------------- Receiving file from client ------------------ */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] aByte = new byte[1];
            int bytesRead;
            
            if (is != null) {

                FileOutputStream fos = null;
                BufferedOutputStream bos = null;
                System.out.println("here1");
                try {
                	System.out.println("herep");
                    //fos = new FileOutputStream( fileToAccept );
                    //bos = new BufferedOutputStream(fos);
                    bytesRead = is.read(aByte, 0, aByte.length);

                    do {
                            baos.write(aByte);
                            bytesRead = is.read(aByte);
                    } while (bytesRead != -1);

                    fileToSend = baos.toString() ;
                    System.out.println(fileToSend);
                     
                    //bos.write(baos.toByteArray());
                    //bos.flush();
                    //bos.close();
                   // connectionSocket.close();
                } catch (IOException ex) {
                    // Do exception handling
                	System.out.println("here2");
                }
            }
            
/* -------------- End of Receiving file from client ------------------ */
            
            
        /*---------- Sending file to client ------------------*/
            if (outToClient != null) {
            	 System.out.println( fileToSend);
                File myFile = new File( fileToSend );
                byte[] mybytearray = new byte[(int) myFile.length()];
                
                FileInputStream fis = null;

                try {
                    fis = new FileInputStream(myFile);
                } catch (FileNotFoundException ex) {
                	 System.out.println("ex"+ex);
                }
                BufferedInputStream bis = new BufferedInputStream(fis);

                try {
                    bis.read(mybytearray, 0, mybytearray.length);
                    System.out.println(mybytearray[0]);
                    outToClient.write(mybytearray, 0, mybytearray.length);
                    outToClient.flush();
                    //System.out.println("sent....");
                    outToClient.close();
                    connectionSocket.close();

                    // File sent, exit the main method
                    return;
                } catch (IOException ex) {
                    // Do exception handling
                }
            }
            
            /*---------- End of Sending file to client ------------------*/
        }
    }
}
