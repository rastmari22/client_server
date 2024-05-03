import java.io.*;
import forclientandserver.Phone;
public class Client {
    public static void main(String[] args) {
        try(
                Phone phone=new Phone("127.0.0.1",8081);
        )
        {
            System.out.println("Connected to server");
            String request="Hi from Client";
            System.out.println("Request: "+request);

            phone.writeLine(request);

            String response=phone.readLine();
            System.out.println("Response from server: "+response);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}