import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardSpace extends JPanel {
    public static final Color LIGHT_BROWN = new Color(154, 123, 79);
    public static final Color DARK_BROWN = new Color(75, 37, 28);
    
    private static BoardSpace selectedSpace = null;
    private static ArrayList<BoardSpace> highlightedSpaces = new ArrayList<>();
    
    private final int[] coordinate;
    private Piece piece;
    private final Color originalColor;
    private Color color;
    
    public BoardSpace(int[] coordinate, Color color, Piece piece) {
        this.coordinate = coordinate;
        this.originalColor = color;
        this.color = color;
        this.piece = piece;
        
        setPreferredSize(new Dimension(60, 60));
        
        
    }
    
    public void highlight() {
        if (selectedSpace == this) {
            clearHighlightedMoves();
            setColor(originalColor);
            selectedSpace = null;
        } else {
            if(selectedSpace != null) {
                selectedSpace.setColor(selectedSpace.originalColor);
            }
            
            setColor(Color.GREEN);
            selectedSpace = this;
        }
    }
    
    public void highlightMoves(int[][] moves, BoardSpace[][] board) {
        clearHighlightedMoves();
        
        for(int[] move : moves) {
            int y = move[0];
            int x = move[1];
            if(y >= 0 && y < 8 && x >= 0 && x < 8) {
                board[y][x].setColor(Color.YELLOW);
                highlightedSpaces.add(board[y][x]);
            }
        }
    }
    
    public static void clearHighlightedMoves() {
        for(BoardSpace space : highlightedSpaces) {
            if(space.getColor() == Color.YELLOW) {
                space.setColor(space.originalColor);
            }
        }
        highlightedSpaces.clear();
    }
    
    public static void clearAllHighlights() {
        clearHighlightedMoves();
        if(selectedSpace != null) {
            selectedSpace.setColor(selectedSpace.originalColor);
        }
    }
    
    
    public void setPiece(Piece piece) {
        this.piece = piece;
        repaint();
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public int[] getCoordinate() {
        return coordinate;
    }
    
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
    
    public Color getColor() {
        return color;
    }
    
    public static BoardSpace getSelectedSpace() {
        return selectedSpace;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if(piece != null) {

            piece.draw(g, getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()));
        }
    }
}
