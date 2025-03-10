import javax.swing.*;
import java.awt.*;
import java.util.*;

public class King extends Piece {
    public static final ImageIcon WHITE_KING_IMAGE = new ImageIcon("src/PieceImages/WhiteKing.png");
    public static final ImageIcon BLACK_KING_IMAGE = new ImageIcon("src/PieceImages/BlackKing.png");

    public King(char color, int[] coordinate) {
        super(color, coordinate, 'k', null);
    }

    @Override
    public int[][] getMoves(BoardSpace[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        int x = getCoordinate()[1];
        int y = getCoordinate()[0];
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
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
            image = new ImageIcon(WHITE_KING_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        } else if(getColor() == 'b') {
            image = new ImageIcon(BLACK_KING_IMAGE.getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_SMOOTH));
        }
        g.drawImage(image.getImage(), x - image.getIconWidth() / 2, y - image.getIconHeight() / 2, null);
    }

    public boolean isInCheck(BoardSpace[][] board) {
        // find king
        int kingY = super.getCoordinate()[1], kingX = super.getCoordinate()[0];

        System.out.println(kingY + ", " + kingX);

        // rook and queen
        int x = getCoordinate()[1];
        int y = getCoordinate()[0];

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];

            while(newY >= 0 && newY < 8 && newX >= 0 && newX < 8) {
                if(board[newY][newX].getPiece() != null) {
                    Piece piece = board[newY][newX].getPiece();
                    if(piece != null && piece.getColor() != super.getColor() && (piece.getType() == 'r' || piece.getType() == 'q')) {
                        return true;
                    }
                    break;
                }

                newY += dir[0];
                newX += dir[1];
            }
        }

        directions = new int[][] {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];

            while(newY >= 0 && newY < 8 && newX >= 0 && newX < 8) {
                if(board[newY][newX].getPiece() != null) {
                    Piece piece = board[newY][newX].getPiece();
                    if(piece != null && piece.getColor() != super.getColor() && (piece.getType() == 'b' || piece.getType() == 'q')) {
                        return true;
                    }
                    break;
                }

                newY += dir[0];
                newX += dir[1];
            }
        }

        directions = new int[][] {{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {2, 1}, {2, -1}};

        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];
            if(newY < 0 || newY > 7 || newX < 0 || newX > 7) {
                continue;
            }

            Piece piece = board[newY][newX].getPiece();
            if(piece != null && piece.getColor() != super.getColor() && piece.getType() == 'n') {
                return true;
            }
        }

        return false;
    }

}
