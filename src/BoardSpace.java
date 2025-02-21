package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardSpace extends JPanel {
    public static final Color LIGHT_BROWN = new Color(154, 123, 79);
    public static final Color DARK_BROWN = new Color(75, 37, 28);
    
    private static BoardSpace selectedSpace = null;
    
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
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                highlight();
            }
        });
    }
    
    private void highlight() {
    if (selectedSpace == this) {
        setColor(originalColor);
        selectedSpace = null;
    } else {
        if (selectedSpace != null) {
            selectedSpace.setColor(selectedSpace.originalColor);
        }
        
        setColor(Color.YELLOW);
        selectedSpace = this;
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (piece != null) {
            piece.draw(g, getWidth() / 2, getHeight() / 2, getWidth());
        }
    }
}
