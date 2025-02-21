package src;
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
    public void draw(Graphics g, int x, int y, int squareSize) {
        ImageIcon image = null;
        if(getColor() == 'w') {
            image = new ImageIcon(WHITE_PAWN_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        } else if(getColor() == 'b') {
            image = new ImageIcon(BLACK_PAWN_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        }
        g.drawImage(image.getImage(), x - image.getIconWidth() / 2, y - image.getIconHeight() / 2, null);
    }
}