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
    public int[][] getMoves(int[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        int x = getCoordinate()[0];
        int y = getCoordinate()[1];

        int forward = 0;
        if(getColor() == 'w') {
            forward = -1;
        } else {
            forward = 1;
        }

        if(board[y + forward][x] == -1) {
            moves.add(new int[] {y + forward, x});
        }

        if(board[y + forward][x - 1] == -1) {
            moves.add(new int[] {y + forward, x - 1});
        }
        if(board[y + forward][x + 1] == -1) {
            moves.add(new int[] {y + forward, x + 1});
        }

        if(board[y + (2 * forward)][x] == -1 && y == 3.5 + (forward * 2.5)) {

        }

        return moves.toArray();
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