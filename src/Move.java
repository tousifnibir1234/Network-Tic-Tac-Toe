import java.io.Serializable;

public class Move implements Serializable {
    private int square;
    private String receiver;

    public Move(int square, String receiver) {
        this.square = square;
        this.receiver = receiver;
    }

    public int getSquare() {
        return square;
    }

    public String getreceiver() {
        return receiver;
    }
}
