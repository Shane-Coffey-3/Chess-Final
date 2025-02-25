import javax.swing.*;
import java.awt.*;

public class King extends Piece {
    public static final ImageIcon WHITE_KING_IMAGE = new ImageIcon("src/PieceImages/WhiteKing.png");
    public static final ImageIcon BLACK_KING_IMAGE = new ImageIcon("src/PieceImages/BlackKing.png");

    public King(char color, int[] coordinate) {
        super(color, coordinate, 'k', null);
    }

    @Override
    public int[][] getMoves(int[][] board) {return new int[][] {{-1, -1}};}

    @Override
    public void draw(Graphics g, int x, int y, int squareSize) {
        ImageIcon image = null;
        if(getColor() == 'w') {
            image = new ImageIcon(WHITE_KING_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        } else if(getColor() == 'b') {
            image = new ImageIcon(BLACK_KING_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        }
        g.drawImage(image.getImage(), x - image.getIconWidth() / 2, y - image.getIconHeight() / 2, null);
    }
}
