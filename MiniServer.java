import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MiniServer extends Thread{

    private Socket socket = null;

    public MiniServer(Socket socket) {

        super("MiniServer");
        this.socket = socket;

    }

    public void run(){ //run() is used to perform action for a thread.
            //Read input and process here
    	DataInputStream in=null;
    	
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
			System.out.println("message from client is:"+ in.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
            //implement your methods here

}