import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4500);

        Socket sock = serverSocket.accept();

        DataInputStream in = new DataInputStream(sock.getInputStream());
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());

        System.out.println("Client: " + in.readUTF());
        out.writeUTF("Message Received by Server.");
        out.flush();

        out.close();
        in.close();
        sock.close();
        serverSocket.close();
    }
}
