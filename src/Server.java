

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;



public class Server {

    private ServerSocket serverSocket;
    public int i = 1;
    public  static Hashtable<String, NetworkUtil> table;

    Server() {
        table = new Hashtable<>();
        try {
            serverSocket = new ServerSocket(33333);
           // new WriteThreadServer(table, "Server");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        String clientName = (String) nc.read();
        table.put(clientName, nc);
        new readthreadserver(table,nc);
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
