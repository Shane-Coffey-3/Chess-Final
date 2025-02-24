import javax.swing.*;
import java.awt.*;

public class Bishop extends Piece {
    public static final ImageIcon WHITE_BISHOP_IMAGE = new ImageIcon("src/PieceImages/WhiteBishop.png");
    public static final ImageIcon BLACK_BISHOP_IMAGE = new ImageIcon("src/PieceImages/BlackBishop.png");

    public Bishop(char color, int[] coordinate) {
        super(color, coordinate, 'p', null);
    }

    @Override
    public int[][] getMoves(int[][] board) {return new int[][] {{-1, -1}};}

    @Override
    public void draw(Graphics g, int x, int y, int squareSize) {
        ImageIcon image = null;
        if(getColor() == 'w') {
            image = new ImageIcon(WHITE_BISHOP_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        } else if(getColor() == 'b') {
            image = new ImageIcon(BLACK_BISHOP_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        }
        g.drawImage(image.getImage(), x - image.getIconWidth() / 2, y - image.getIconHeight() / 2, null);
    }
}