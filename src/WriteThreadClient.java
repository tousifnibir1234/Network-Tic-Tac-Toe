

import java.util.Scanner;



public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String name,name2;
    private Game game;
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public WriteThreadClient(NetworkUtil nc, String name) {
        this.nc = nc;
        this.name = name;

        this.thr = new Thread(this);
        thr.start();
    }

    public String getName2() {
        return name2;
    }

    public String setString(String s){
        return s;
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the receiver ");
            name2=input.nextLine();
//            if(Server.table.containsKey(name2)){
//                game.setReceiver(name2);
//            }

            while (true) {
                String s = input.nextLine();
                nc.write( name2 + ":" + s);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}



