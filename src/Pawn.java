import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {
    public static final ImageIcon WHITE_PAWN_IMAGE = new ImageIcon("WhitePawn.png");
    ImageIcon BLACK_PAWN_IMAGE = new ImageIcon();

    public Pawn(char color, int[] coordinate) {
        super(color, coordinate, 'p', WHITE_PAWN_IMAGE);
    }

    @Override
    public int[][] getMoves() {return new int[][] {{-1}};}

}
