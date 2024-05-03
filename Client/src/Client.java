import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket=new Socket("127.0.0.1",8081);
                BufferedWriter writer=new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
                BufferedReader reader=new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()))
        )
        {
            System.out.println("Connected to server");
            String request="Hi from Client";
            System.out.println("Request from client: "+request);
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response=reader.readLine();
            System.out.println("Response from server: "+response);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}