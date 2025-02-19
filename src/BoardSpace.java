import java.awt.*;

public class BoardSpace {
    public static final Color LIGHT_BROWN = new Color(154, 123, 79);
    public static final Color DARK_BROWN = new Color(75, 37, 28);
    private final int[] coordinate;
    private Piece piece;
    private final Color color;

    public BoardSpace(int[] coordinate, Piece piece, Color color) {
        this.coordinate = coordinate;
        this.piece = piece;
        this.color = color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public Color getColor() {
        return color;
    }
}
