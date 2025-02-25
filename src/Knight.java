import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Knight extends Piece {
    public static final ImageIcon WHITE_KNIGHT_IMAGE = new ImageIcon("src/PieceImages/WhiteKnight.png");
    public static final ImageIcon BLACK_KNIGHT_IMAGE = new ImageIcon("src/PieceImages/BlackKnight.png");

    public Knight(char color, int[] coordinate) {
        super(color, coordinate, 'n', null);
    }

    @Override
    public int[][] getMoves(BoardSpace[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        int x = getCoordinate()[1];
        int y = getCoordinate()[0];
        
        int[][] directions = {{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {2, 1}, {2, -1}};
        
        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];
            if(newY < 0 || newY > 7 || newX < 0 || newX > 7) {
                continue;
            }
            
            if(board[newY][newX].getPiece() == null || board[newY][newX].getPiece().getColor() != getColor()) {
                moves.add(new int[]{newY, newX});
            }
        }
        return moves.toArray(new int[0][0]);
    }
    
    @Override
    public void draw(Graphics g, int x, int y, int squareSize) {
        ImageIcon image = null;
        if(getColor() == 'w') {
            image = new ImageIcon(WHITE_KNIGHT_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        } else if(getColor() == 'b') {
            image = new ImageIcon(BLACK_KNIGHT_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        }
        g.drawImage(image.getImage(), x - image.getIconWidth() / 2, y - image.getIconHeight() / 2, null);
    }
}
