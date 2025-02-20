import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {
    public static final ImageIcon WHITE_PAWN_IMAGE = new ImageIcon("/Users/shane.coffey27/Downloads/WhitePawn.png");
    public static final ImageIcon BLACK_PAWN_IMAGE = new ImageIcon("/Users/shane.coffey27/Downloads/BlackPawn.png");

    public Pawn(char color, int[] coordinate) {
        super(color, coordinate, 'p', WHITE_PAWN_IMAGE);
    }

    @Override
    public int[][] getMoves() {return new int[][] {{-1}};}

    @Override
    public void draw(Graphics g, int x, int y) {

    }
}
