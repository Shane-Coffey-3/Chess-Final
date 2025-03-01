import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {
    private final BoardSpace[][] board = new BoardSpace[8][8];
    private boolean isWhiteMove;
    private char colorInCheck;

    public static final int NO_PIECE_CODE = -1;
    public static final int WHITE_PAWN_CODE = 0;
    public static final int BLACK_PAWN_CODE = 1;
    public static final int WHITE_KNIGHT_CODE = 2;
    public static final int BLACK_KNIGHT_CODE = 3;
    public static final int WHITE_BISHOP_CODE = 4;
    public static final int BLACK_BISHOP_CODE = 5;
    public static final int WHITE_ROOK_CODE = 6;
    public static final int BLACK_ROOK_CODE = 7;
    public static final int WHITE_QUEEN_CODE = 8;
    public static final int BLACK_QUEEN_CODE = 9;
    public static final int WHITE_KING_CODE = 10;
    public static final int BLACK_KING_CODE = 11;
    public static final int[][] DEFAULT_BOARD = {
            {7, 3, 5, 9, 11, 5, 3, 7},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {6, 2, 4, 8, 10, 4, 2, 6}
    };
    
    public Board(int boardSize) {
        setPreferredSize(new Dimension(boardSize, boardSize));
        setLayout(new GridLayout(8, 8));
        setFocusable(true);
        requestFocusInWindow();
        isWhiteMove = true;
        colorInCheck = ' ';
        
        createBoard(DEFAULT_BOARD);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 70) {
                    flipBoard();
                }
            }
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() * 8 / getWidth();
                int y = e.getY() * 8 / getHeight();
                BoardSpace selected = board[y][x];
                
                if(selected.getColor() == Color.YELLOW) {
                    Piece movingPiece = BoardSpace.getSelectedSpace().getPiece();
                    selected.setPiece(movingPiece);
                    movingPiece.setCoordinate(new int[] {y, x});
                    
                    BoardSpace.getSelectedSpace().setPiece(null);
                    BoardSpace.getSelectedSpace().highlight();
                    BoardSpace.clearHighlightedMoves();
                    
                    isWhiteMove = !isWhiteMove;
                    
                } else if(selected.getPiece() != null && ((isWhiteMove && selected.getPiece().getColor() == 'w') || (!isWhiteMove && selected.getPiece().getColor() == 'b'))) {
                    selected.highlight();
                    if(selected.getColor() == Color.GREEN) {
                        int[][] moves = selected.getPiece().getMoves(board);
                        selected.highlightMoves(moves, board);
                    }
                } else {
                    BoardSpace.clearAllHighlights();
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
                } else if (boardCode[i][j] == WHITE_KNIGHT_CODE) {
                    piece = new Knight('w', coordinate);
                } else if (boardCode[i][j] == BLACK_KNIGHT_CODE) {
                    piece = new Knight('b', coordinate);
                } else if (boardCode[i][j] == WHITE_BISHOP_CODE) {
                    piece = new Bishop('w', coordinate);
                } else if (boardCode[i][j] == BLACK_BISHOP_CODE) {
                    piece = new Bishop('b', coordinate);
                } else if (boardCode[i][j] == WHITE_ROOK_CODE) {
                    piece = new Rook('w', coordinate);
                } else if (boardCode[i][j] == BLACK_ROOK_CODE) {
                    piece = new Rook('b', coordinate);
                } else if(boardCode[i][j] == WHITE_QUEEN_CODE) {
                    piece = new Queen('w', coordinate);
                } else if(boardCode[i][j] == BLACK_QUEEN_CODE) {
                    piece = new Queen('b', coordinate);
                } else if(boardCode[i][j] == WHITE_KING_CODE) {
                    piece = new King('w', coordinate);
                } else if(boardCode[i][j] == BLACK_KING_CODE) {
                    piece = new King('b', coordinate);
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
    
    public BoardSpace getSpace(int y, int x) {
        return board[y][x];
    }

    public void updateColorInCheck(char colorToCheck) {
        // find king
        int[] kingCoordinate = new int[2];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                Piece piece = board[row][col].getPiece();
                if(piece != null && piece.getColor() == colorToCheck && piece.getType() == 'k') {
                    System.out.println(col + ", " + row);
                }
            }
        }

        // check all directions

        // check knights


        colorInCheck = ' ';
    }

    public char getColorInCheck() {
        return colorInCheck;
    }

}
