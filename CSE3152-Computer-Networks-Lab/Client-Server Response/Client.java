import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 4500);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeUTF("HELLO!!!");
        out.flush();
        System.out.println(in.readUTF());

        in.close();
        out.close();
        socket.close();
    }
}
