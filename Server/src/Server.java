import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import forclientandserver.Phone;
//1.	Запуск сервера;+
//2.	Начало прослушивания порта;+
//3.	Подключение клиента;+
//4.	Прием данных от клиента;+
//5.	Отправка данных клиенту;+
//6.	Отключение клиента;+
//7.	Остановка сервера.+

public class Server {
    public static void main(String[] args) {

        try(ServerSocket server=new ServerSocket(8081))
        {
            System.out.println("Server started!");
            System.out.println("Listening on port: "+server.getLocalPort());

            while (true){
                try(Phone phone=new Phone(server);
                ) {
                    System.out.println("Client connected");
                    String request = phone.readLine();//"";
    //                String line;
    //                while ((line = reader.readLine()) != null) {
    //                    request += line+"\n";
    //                    if (line.isEmpty()) {
    //                        break;
    //                    }
    //                }
                    if (request.isEmpty()) {
                        System.out.println("4. No data received from client.");
                    } else {
//                        System.out.println("Request from client: " + request);

                        String response="Hello from server!!";
//                        System.out.println("Response: "+response);

                        phone.writeLine(response);
                    }
                    System.out.println("Client disconnected");

                }
            }


        }catch (IOException e){
            throw new RuntimeException("Server stopped "+e);
        }


    }
}