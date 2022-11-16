import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 4500);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF("HELLO!!!");

        out.close();
        socket.close();
    }
}
