import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    Stage stage;
    Game game;
    Client client;

    public Game getGame() {
        return game;
    }

    void showHome () throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Game controller = loader.getController();
        //controller.picHandle();
        controller.setMain(this);

        //stage.setTitle("Tic-Tac-Toe");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage=primaryStage;
        stage.setOnCloseRequest(e->{
                e.consume();
            try {
                closeGame();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        showHome();
    }

    public  void showGame() throws Exception{
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        client = new Client(serverAddress, serverPort);
        client.wr.setGame(game);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tic-tac-toe.fxml"));
        Parent root = loader.load();
        Game controller = loader.getController();
        game = controller;
        client.setGameForReadThread(controller);
        controller.setNc(client.getNetworkUtil());
        controller.setMain(this);
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public void lastpage()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Anjum.fxml"));
        Parent root = loader.load();
        Game controller = loader.getController();
        controller.setMain(this);
        stage.setScene(new Scene (root,600,600));
        stage.show();
    }

    public  void showWinner() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cvcbdf.fxml"));
        Parent root = loader.load();
        Game controller = loader.getController();
        controller.setMain(this);
        Scene scene=new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
    }

    public void draw() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("draw.fxml"));
        Parent root = loader.load();
        Game controller = loader.getController();
        controller.setMain(this);
        Scene scene=new Scene(root,436,600);
        stage.setScene(scene);
        stage.show();
    }

    public void options() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NameOptions.fxml"));
        Parent root = loader.load();
        Game controller = loader.getController();
        controller.setMain(this);
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public void closeGame() throws Exception{
        Alert al=new Alert( Alert.AlertType.CONFIRMATION);
        al.setTitle("Confirmation Dialog");
        //al.setHeaderText("Look, a Confirmation Dialog");
        al.setContentText("Are you sure you want to quit?");
        Optional <ButtonType> b=al.showAndWait();
        if(b.get()==ButtonType.OK){
            stage.close();
        }
    }

    public static void main(String[] args) {
        /*String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);*/

        launch(args);
        System.out.println(Game.n);
        for (boolean b:
             Game.bool) {
            System.out.println(b);
        }
    }
}
