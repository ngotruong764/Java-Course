package client_server.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadSimpleServer {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try(ServerSocket serverSocket = new ServerSocket(5001)){
            while (true){
                // When we have the server socket instance,
                // we can wait for a connection to a client
                // At this point, this application will block here
                // and waiting for a client to initiate connection
                Socket socket = serverSocket.accept();
                System.out.println("Server accepts client connection");
                socket.setSoTimeout(900_000);
                executorService.submit(() -> handleClientRequest(socket));
            }
        } catch (IOException e){
            System.out.println("Server exception "+ e.getMessage());
        }
    }

    private static void handleClientRequest(Socket socket){
        try(socket;
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true)){
            while(true){
                String echoString = input.readLine();
                System.out.println("Server got request data: " + echoString);
                if(echoString.equalsIgnoreCase("exit")){
                    break;
                }
                output.println("Echo from server: " + echoString);
            }
        }catch (IOException e){
            System.out.println("Client socket is sut down here");
        }
    }
}
