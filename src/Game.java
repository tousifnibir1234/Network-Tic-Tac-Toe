import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.ResourceBundle;


public class Game {
    public static int n=0, q=0,arr[]=new int[9];
    public  int p=-1;
    public static boolean[] bool=new boolean[9];
    boolean isMyMove = true;
    private Main main;
    NetworkUtil nc;
    String receiver;
    public TextField user, opponenet ;
    public void setReceiver(String text){
        this.receiver=text;
    }

    public void setNc(NetworkUtil nc) {
        this.nc = nc;
    }

    private Line2D line;

    @FXML
    void setMain(Main main) {
        this.main = main;
    }

    public Button button;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;

    @FXML
    public ImageView image=new ImageView();

    public ImageView image1=new ImageView();

    public ImageView image2=new ImageView();

    public ImageView image3=new ImageView();

    public ImageView image4=new ImageView();

    public ImageView image5=new ImageView();

    public ImageView image6=new ImageView();

    public ImageView image7=new ImageView();

    public ImageView image8=new ImageView();

    public ImageView image9=new ImageView();

    @FXML
    public GridPane grid;

    int resetVal(int m){
        if(m%2==0) return 2;
        else return 1;
    }

    public void close(){
        try {
            main.closeGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void game(){
            try {
                // button.onMouseClickedProperty();
                main.showGame();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
    }


    public Image picHandle(int i){
        Image img;
        if(i%2==0){
            img= new Image("O.png");
        }
        else {
            img= new Image("X.png");
        }
        return img;
    }

    public void buttonFunc() {

        boolean t=yup();
        if(!t && isMyMove) {
            if (button1.isPressed()) {
              if (!bool[0]) {
                bool[0] = true;
                button1.setOnAction(e -> {
                    n++;
                    p=1;
                    image1.setImage(picHandle(n+q));
                    image1.preserveRatioProperty();
                    grid.add(image1, 0, 0);
                    arr[0] = resetVal(n+q);
                    button1.setDisable(true);
                    nc.write(new Move(p, main.client.wr.getName2()));
                    isMyMove=false;
                    yup();
                });
               }
            }

            if (button2.isPressed()) {
                if (!bool[1]) {
                    bool[1] = true;
                    button2.setOnAction(e -> {
                        n++;
                        p=2;

                        image2.setImage(picHandle(n+q));
                        grid.add(image2, 1, 0);
                        arr[1] = resetVal(n+q);
                        button2.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button3.isPressed()) {
                if (!bool[2]) {
                    bool[2] = true;
                    button3.setOnAction(e -> {
                        n++;
                        p=3;

                        image3.setImage(picHandle(n+q));
                        grid.add(image3, 2, 0);
                        arr[2] = resetVal(n+q);
                        button3.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button4.isPressed()) {
                if (!bool[3]) {
                    bool[3] = true;
                    button4.setOnAction(e -> {
                        n++;
                        p=4;

                        image4.setImage(picHandle(n+q));
                        grid.add(image4, 0, 1);
                        arr[3] = resetVal(n+q);
                        button4.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button5.isPressed()) {
                if (!bool[4]) {
                    bool[4] = true;
                    button5.setOnAction(e -> {
                        n++;
                        p=5;

                        image5.setImage(picHandle(n+q));
                        grid.add(image5, 1, 1);
                        arr[4] = resetVal(n+q);
                        button5.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button6.isPressed()) {
                if (!bool[5]) {
                    bool[5] = true;
                    button6.setOnAction(e -> {
                        n++;
                        p=6;

                        image6.setImage(picHandle(n+q));
                        grid.add(image6, 2, 1);
                        arr[5] = resetVal(n+q);
                        button6.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button7.isPressed()) {
                if (!bool[6]) {
                    bool[6] = true;
                    button7.setOnAction(e -> {
                        n++;
                        p=7;

                        image7.setImage(picHandle(n+q));
                        grid.add(image7, 0, 2);
                        arr[6] = resetVal(n+q);
                        button7.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button8.isPressed()) {
                if (!bool[7]) {
                    bool[7] = true;
                    button8.setOnAction(e -> {
                        n++;
                        p=8;

                        image8.setImage(picHandle(n+q));
                        grid.add(image8, 1, 2);
                        arr[7] = resetVal(n+q);
                        button8.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

            if (button9.isPressed()) {
                if (!bool[8]) {
                    bool[8] = true;
                    button9.setOnAction(e -> {
                        n++;
                        p=9;

                        image9.setImage(picHandle(n+q));
                        grid.add(image9, 2, 2);
                        arr[8] = resetVal(n+q);
                        button9.setDisable(true);
                        nc.write(new Move(p, main.client.wr.getName2()));
                        isMyMove=false;
                        yup();
                    });
                }
            }

        }

    }

    public  boolean yup(){
        if(((arr[0]==arr[1]&&arr[1]==arr[2]&&arr[2]>0)||(arr[3]==arr[4]&&arr[4]==arr[5]&&arr[5]>0)||(arr[6]==arr[7]&&arr[7]==arr[8]&&arr[8]>0)||(arr[0]==arr[3]&&arr[3]==arr[6]&&arr[6]>0)||(arr[1]==arr[4]&&arr[4]==arr[7]&&arr[7]>0)||(arr[2]==arr[5]&&arr[5]==arr[8]&&arr[8]>0)||(arr[0]==arr[4]&&arr[4]==arr[8]&&arr[8]>0)||(arr[2]==arr[4]&&arr[4]==arr[6]&&arr[6]>0))) {
            try {
                if(!isMyMove)main.lastpage();
                else main.showWinner();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        else
            if(n+q==9){
                try {
                    main.draw();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
    }

    public void showMove(Move move) {
        int square = move.getSquare();
        System.out.println("Found move = " + square);

        if (square==1) {
            if (!bool[0]) {
                bool[0] = true;

                    q++;
                    p=1;

                    image1.setImage(picHandle(n+q));
                    grid.add(image1, 0, 0);
                    arr[0] = resetVal(n+q);
                    nc.write(new Move(p, main.client.wr.getName2()));
                    button1.setDisable(true);
                    isMyMove=true;
                    yup();

            }
        }

        if (square==2) {
            if (!bool[1]) {
                bool[1] = true;
                    q++;
                    p=2;
                    image2.setImage(picHandle(n+q));
                    grid.add(image2, 1, 0);
                    arr[1] = resetVal(n+q);
                    button2.setDisable(true);
                    nc.write(new Move(p, main.client.wr.getName2()));
                    button2.setDisable(true);
                    isMyMove=true;
                    yup();
            }
        }

        if (square==3) {
            if (!bool[2]) {
                bool[2] = true;
                q++;
                p=3;
                image3.setImage(picHandle(n+q));
                grid.add(image3, 2, 0);
                arr[2] = resetVal(n+q);
                button3.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                button3.setDisable(true);
                isMyMove=true;
                yup();
            }
        }

        if (square==4) {
            if (!bool[3]) {
                bool[3] = true;
                q++;
                p=4;
                image4.setImage(picHandle(n+q));
                grid.add(image4, 0, 1);
                arr[3] = resetVal(n+q);
                button4.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();
            }
        }

        if (square==5) {
            if (!bool[4]) {
                bool[4] = true;
                q++;
                p=5;
                image5.setImage(picHandle(n+q));
                grid.add(image5, 1, 1);
                arr[4] = resetVal(n+q);
                button5.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();
            }
        }

        if (square==6) {
            if (!bool[5]) {
                bool[5] = true;
                q++;
                p=6;
                image6.setImage(picHandle(n+q));
                grid.add(image6, 2, 1);
                arr[5] = resetVal(n+q);
                button6.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();
            }
        }

        if (square==7) {
            if (!bool[6]) {
                bool[6] = true;
                q++;
                p=7;
                image7.setImage(picHandle(n+q));
                grid.add(image7, 0, 2);
                arr[6] = resetVal(n+q);
                button7.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();
            }
        }

        if (square==8) {
            if (!bool[7]) {
                bool[7] = true;
                q++;
                p=8;
                image8.setImage(picHandle(n+q));
                grid.add(image8, 1, 2);
                arr[7] = resetVal(n+q);
                button8.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();
            }
        }

        if (square==9) {
            if (!bool[8]) {
                bool[8] = true;
                q++;
                p=9;
                image9.setImage(picHandle(n+q));
                grid.add(image9, 2, 2);
                arr[8] = resetVal(n+q);
                button9.setDisable(true);
                nc.write(new Move(p, main.client.wr.getName2()));
                isMyMove=true;
                yup();

            }
        }
    }
}