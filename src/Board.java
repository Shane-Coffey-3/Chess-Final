package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
            {0, -1, -1, -1, -1, -1, -1, -1}
    };
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
        setPreferredSize(new Dimension(boardSize, boardSize));
        setLayout(new GridLayout(8, 8));
        setFocusable(true);
        requestFocusInWindow();
        
        createBoard(DEFAULT_BOARD);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 70) {
                    flipBoard();
                }
            }
        });
    }
    
    private void createBoard(int[][] boardCode) {
        for (int i = 0; i < boardCode.length; i++) {
            for (int j = 0; j < boardCode[i].length; j++) {
                Color boardSpaceColor = ((i + j) % 2 == 0) ? BoardSpace.LIGHT_BROWN : BoardSpace.DARK_BROWN;
                int[] coordinate = {i, j};
                
                Piece piece = null;
                if (boardCode[i][j] == WHITE_PAWN_CODE) {
                    piece = new Pawn('w', coordinate);
                } else if (boardCode[i][j] == BLACK_PAWN_CODE) {
                    piece = new Pawn('b', coordinate);
                }
                
                board[i][j] = new BoardSpace(coordinate, boardSpaceColor, piece);
                add(board[i][j]);
            }
        }
    }
    
    private void flipBoard() {
        BoardSpace[][] flippedBoard = new BoardSpace[8][8];
        
        removeAll();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int newRow = 7 - i;
                int newCol = 7 - j;
                
                BoardSpace originalSpace = board[i][j];
                Piece piece = originalSpace.getPiece();
                if(piece != null) {
                    piece.setCoordinate(new int[] {newRow, newCol});
                }
                Color boardSpaceColor = ((newRow + newCol) % 2 == 0) ? BoardSpace.LIGHT_BROWN : BoardSpace.DARK_BROWN;
                
                flippedBoard[newRow][newCol] = new BoardSpace(new int[] {newRow, newCol}, boardSpaceColor, piece);
                add(flippedBoard[newRow][newCol]);
            }
        }
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = flippedBoard[i][j];
            }
        }
        
        revalidate();
        repaint();
    }
}

