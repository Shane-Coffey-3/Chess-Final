import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final BoardSpace[][] board = new BoardSpace[8][8];
    private final int boardSize;

    public static final int NO_PIECE_CODE = -1;
    public static final int WHITE_PAWN_CODE = 0;
    public static final int BLACK_PAWN_CODE = 1;
    public static final int[][] DEFAULT_BOARD = {
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {-1, -1, -1, -1, -1, -1, -1, -1}
    };

    public Board(int boardSize) {
        this.boardSize = boardSize;
        createBoard(DEFAULT_BOARD);
    }

    private void createBoard(int[][] boardCode) {
        for(int i = 0; i < boardCode.length; i++) {
            for(int j = 0; j < boardCode[i].length; j++) {
                Color boardSpaceColor;
                if(i % 2 == 0 && j % 2 == 0) boardSpaceColor = BoardSpace.LIGHT_BROWN;
                else boardSpaceColor = BoardSpace.DARK_BROWN;
                int[] coordinate = new int[] {i, j};

                switch (boardCode[i][j]) {
                    case WHITE_PAWN_CODE:
                        board[i][j] = new BoardSpace(coordinate, boardSpaceColor, new Pawn('w', coordinate));
                        break;
                    case BLACK_PAWN_CODE:
                        board[i][j] = new BoardSpace(coordinate, boardSpaceColor, new Pawn('b', coordinate));
                        break;
                    default:
                        board[i][j] = new BoardSpace(coordinate, boardSpaceColor, null);
                        break;

                }

            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int spaceSize = boardSize / 8;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                BoardSpace space = board[i][j];

                // Draw the board space color
                g.setColor(space.getColor());
                g.fillRect(j * spaceSize, i * spaceSize, spaceSize, spaceSize);

                // Draw the piece (if exists)
                Piece piece = space.getPiece();
                if (piece != null) {
                    piece.draw(g, j * spaceSize + spaceSize / 2, i * spaceSize + spaceSize / 2);
                }
            }
        }
    }

}
