import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class SmtpEmail {

    private static DataOutputStream out;

    public static void main(String[] args) throws Exception{
        String user = User.username;
        String pass = User.password;

        String username = Base64.getEncoder().encodeToString(user.getBytes(StandardCharsets.UTF_8));
        String password = Base64.getEncoder().encodeToString(pass.getBytes(StandardCharsets.UTF_8));

        SSLSocket sock = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
        out = new DataOutputStream(sock.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        send("EHLO smtp.gmail.com");
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());

        send("AUTH LOGIN");
        System.out.println(in.readLine());

        send(username);
        System.out.println(in.readLine());

        send(password);
        System.out.println(in.readLine());

        send("MAIL FROM:<s1910676110@ru.ac.bd>");
        System.out.println(in.readLine());

        send("RCPT TO:<humayra.k.rime@gmail.com>");
        System.out.println(in.readLine());

        send("DATA");
        System.out.println(in.readLine());

        send("From: s1910676110@ru.ac.bd");
        send("To: humayra.k.rime@gmail.com");
        send("Subject: Smtp Mail");
        send("Hello there");
        send(".");
        System.out.println(in.readLine());

        send("QUIT");
        System.out.println(in.readLine());

    }

    static void send(String msg) throws Exception {

        out.writeBytes(msg + "\r\n");
        System.out.println("CLIENT: " + msg);
        Thread.sleep(1000);
    }

}