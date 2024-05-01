import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//1.	Запуск сервера;+
//2.	Начало прослушивания порта;+
//3.	Подключение клиента;+
//4.	Прием данных от клиента;+
//5.	Отправка данных клиенту;+
//6.	Отключение клиента;+
//7.	Остановка сервера.+

public class Server {
    public static void main(String[] args) {

        try(ServerSocket server=new ServerSocket(8081)){

            System.out.println("Server started!");
            System.out.println("Listening on port: "+server.getLocalPort());

            try(
                    Socket socket=server.accept();
                    BufferedWriter writer=new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
                    BufferedReader reader=new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()))
                    ) {

                        System.out.println("Client connected");


                String request = "";
                String line;
                while ((line = reader.readLine()) != null) {
                    request += line+"\n";
                    if (line.isEmpty()) {
                        break;
                    }
                }

                if (request.isEmpty()) {
                    System.out.println("4. No data received from client.");
                } else {
                    System.out.println("4. Data received from client: " + request);
                    String response="Hello from server: "+request;
                    System.out.println(response);

                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                }
                System.out.println("Client disconnected");

            }



//            writer.close();
//            socket.close();
        }catch (IOException e){
            throw new RuntimeException("Server stopped "+e);
        }


    }
}