import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Bishop extends Piece {
    public static final ImageIcon WHITE_BISHOP_IMAGE = new ImageIcon("src/PieceImages/WhiteBishop.png");
    public static final ImageIcon BLACK_BISHOP_IMAGE = new ImageIcon("src/PieceImages/BlackBishop.png");

    public Bishop(char color, int[] coordinate) {
        super(color, coordinate, 'b', null);
    }

    @Override
    public int[][] getMoves(BoardSpace[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        int x = getCoordinate()[1];
        int y = getCoordinate()[0];
        
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];
            
            while(newY >= 0 && newY < 8 && newX >= 0 && newX < 8) {
                if(board[newY][newX].getPiece() == null) {
                    moves.add(new int[]{newY, newX});
                } else {
                    if(board[newY][newX].getPiece().getColor() != getColor()) {
                        moves.add(new int[]{newY, newX});
                    }
                    break;
                }
                
                newY += dir[0];
                newX += dir[1];
            }
        }
        return moves.toArray(new int[0][0]);
    }

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
