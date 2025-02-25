import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {
    public static final ImageIcon WHITE_PAWN_IMAGE = new ImageIcon("src/PieceImages/WhitePawn.png");
    public static final ImageIcon BLACK_PAWN_IMAGE = new ImageIcon("src/PieceImages/BlackPawn.png");
    
    public Pawn(char color, int[] coordinate) {
        super(color, coordinate, 'p', null);
    }

    @Override
    public int[][] getMoves(BoardSpace[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        int x = getCoordinate()[1];
        int y = getCoordinate()[0];
        
        int forward = 0;
        if(getColor() == 'w') {
            forward = -1;
        } else {
            forward = 1;
        }
        
        if(y + forward >= 0 && y + forward <= 7 && board[y + forward][x].getPiece() == null) {
            moves.add(new int[] {y + forward, x});
            if((getColor() == 'w' && y == 6) || (getColor() == 'b' && y == 1) && board[y + 2 * forward][x].getPiece() == null) {
                moves.add(new int[] {y + 2 * forward, x});
            }
        }
        
        if(y + forward >= 0 && y + forward <= 7 && x - 1 >= 0 && x - 1 <= 7 && board[y + forward][x - 1].getPiece() != null && board[y + forward][x - 1].getPiece().getColor() != getColor()) {
            moves.add(new int[] {y + forward, x - 1});
        }
        if(y + forward >= 0 && y + forward <= 7 && x + 1 >= 0 && x + 1 <= 7 && board[y + forward][x + 1].getPiece() != null && board[y + forward][x + 1].getPiece().getColor() != getColor()) {
            moves.add(new int[] {y + forward, x + 1});
        }
        
        return moves.toArray(new int[0][0]);
    }

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
