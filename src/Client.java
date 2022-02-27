

import java.util.Scanner;



public class Client {

    public NetworkUtil nc;
    private ReadThread rt;
    private Main main;
    public WriteThreadClient wr;

    public void setMain(Main main) {
        this.main = main;
    }

    public NetworkUtil getNetworkUtil() {
        return nc;
    }

    public void setGameForReadThread(Game game) {
        rt.setGame(game);
    }

    public Client(String serverAddress, int serverPort) {
        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            nc = new NetworkUtil(serverAddress, serverPort);
            nc.write(clientName);

            rt = new ReadThread(nc);

            wr= new WriteThreadClient(nc, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

