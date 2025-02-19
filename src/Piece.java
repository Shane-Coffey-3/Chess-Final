import javax.swing.*;

public abstract class Piece
{
    private final char color;
    private final char type;
    private int[] coordinate;
    private final ImageIcon image;

    public abstract int[][] getMoves();

    public void move(int[] coordinate) {
        this.coordinate = coordinate;
    };

    public Piece(char color, int[] coordinate, char type, ImageIcon image) {
        this.color = color;
        this.type = type;
        this.coordinate = coordinate;
        this.image = image;
    }

    public String toString() {
        String result = "";
        if(color == 'w') result += "white ";
        else if(color == 'b') result += "black ";

        if(type == 'p') result += "pawn";
        else if(type == 'n') result += "knight";
        else if(type == 'b') result += "bishop";
        else if(type == 'r') result += "rook";
        else if(type == 'k') result += "king";
        else if(type == 'q') result += "queen";

        return result;
    }

}
