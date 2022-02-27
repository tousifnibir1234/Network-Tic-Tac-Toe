import javafx.application.Platform;

public class ReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public ReadThread(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if(o instanceof String) {
                    String s = (String) o;
                    if (s != null) {
                        System.out.println(s);
                    }
                }
                else if(o instanceof Move) {
                    Move m = (Move) o;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                game.showMove(m);
                            }
                            catch (Exception e) {
                                System.out.println("Error showing the move");
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}



