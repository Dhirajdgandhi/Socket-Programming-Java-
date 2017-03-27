// To download file from server. 
import java.io.*;
import java.net.*;

class client2 {

    private final static String serverIP = "127.0.0.1";
    private final static int serverPort = 2000;
    private final static String fileToServer = "E:/ClientFiles/client.txt";
    private final static String fileOutput = "E:/ClientFiles/fromServer.txt";
    
    public static void main(String args[]) {
        
        Socket clientSocket = null;
        InputStream is = null;
        BufferedOutputStream outToServer=null;
        
        //Connect to client and create input stream
        try {
            clientSocket = new Socket( serverIP , serverPort );
            is = clientSocket.getInputStream();
            outToServer = new BufferedOutputStream(clientSocket.getOutputStream());
            
        } catch (IOException ex) {
            // Do exception handling
        }
        
/* -------------- Sending file to server ------------------ */
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (outToServer != null) {
            File myFile = new File( fileToServer );
            byte[] mybytearray = new byte[(int) myFile.length()];
            
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(myFile);
            } catch (FileNotFoundException ex) {
                // Do exception handling
            }
            BufferedInputStream bis = new BufferedInputStream(fis);

            try {
                bis.read(mybytearray, 0, mybytearray.length);
                outToServer.write(mybytearray, 0, mybytearray.length);
                outToServer.flush();
                System.out.println("sent....");
                //outToServer.close();
                clientSocket.shutdownOutput();

                // File sent, exit the main method
                //return;
            } catch (IOException ex) {
                // Do exception handling
            }
        }
        
/* -------------- End of Sending file to server ------------------ */
        
/* -------------- Receiving file from server ------------------ */
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] aByte = new byte[1];
        int bytesRead;

        if (is != null) {

            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            System.out.println("here1");
            try {
            	System.out.println("herep3");
                fos = new FileOutputStream( fileOutput );
                bos = new BufferedOutputStream(fos);
                System.out.println(aByte.length);
                
                System.out.println("herep2");
                bytesRead = is.read(aByte, 0, aByte.length);
                System.out.println(bytesRead);
                do {
                        baos.write(aByte);
                        bytesRead = is.read(aByte);
                        //System.out.println("aByte");
                } while (bytesRead != -1);

                bos.write(baos.toByteArray());
                bos.flush();
                bos.close();
                
                String lin = baos.toString() ;
                System.out.println(lin);
                 
               /* BufferedReader input =  new BufferedReader(new FileReader("E:/fromServer.txt"));
                String line = null; //not declared within while loop
                while (( line = input.readLine()) != null){
                	System.out.println(line);
                 }
                
                */
                clientSocket.close();
            }catch (IOException ex) {
                // Exception handling
            	System.out.println("IO Exception raised while receiving file from server"+ ex);
            } 
        }
        /* --------------End of  Receiving file from server ------------------ */
    }
}
