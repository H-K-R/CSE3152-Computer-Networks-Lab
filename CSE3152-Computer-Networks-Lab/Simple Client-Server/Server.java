import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4500);

        Socket sock = serverSocket.accept();

        DataInputStream in = new DataInputStream(sock.getInputStream());

        System.out.println("Client: " + in.readUTF());
        
        in.close();
        sock.close();
        serverSocket.close();
    }
}
