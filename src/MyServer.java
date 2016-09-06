/**
 * Created by asla on 06/09/2016.
 */


import java.net.*;
import java.io.*;

public class MyServer extends Thread {

    int portNumber = 9090;
    ServerSocket serverSocket;
    public static void main(String[] args){
        try{
            Thread t = new MyServer();
            t.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    MyServer(){
        try{
            serverSocket = new ServerSocket(portNumber);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{

                System.out.println("Waiting for connection .... ");
                Socket server = serverSocket.accept();

                DataOutputStream output =
                        new DataOutputStream(server.getOutputStream());
                output.writeUTF("Hello, world!");

                System.out.println("Connected!");

                server.close();
            }
            catch(IOException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
