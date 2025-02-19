import java.awt.*;

public class Board {
    private final BoardSpace[][] board = new BoardSpace[8][8];

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

    public Board() {
        createBoard(DEFAULT_BOARD);
    }

    private void createBoard(int[][] boardCode) {
        for(int i = 0; i < boardCode.length; i++) {
            for(int j = 0; j < boardCode[i].length; j++) {
                Color boardSpaceColor;
                if(i % 2 == 0 && j % 2 == 0) boardSpaceColor = BoardSpace.LIGHT_BROWN;
                else boardSpaceColor = BoardSpace.DARK_BROWN;
                if(boardCode[i][j] == WHITE_PAWN_CODE) board[i][j] = new BoardSpace(new int[] {i, j}, new Pawn('w', new int[] {i, j}), boardSpaceColor);
            }
        }
    }


}
