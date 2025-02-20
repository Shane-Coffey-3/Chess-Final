import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        /*JPanel panel = new JPanel(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ImageIcon icon = Pawn.BLACK_PAWN_IMAGE;
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Image loading failed");
        } else {
            System.out.println("Image loaded successfully");
        }

        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(50, 50, icon.getIconWidth(), icon.getIconHeight());  // Position and size of the label

        panel.add(label);

        frame.add(panel);

        frame.setVisible(true);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (label.getIcon() == Pawn.WHITE_PAWN_IMAGE) {
                    label.setIcon(Pawn.BLACK_PAWN_IMAGE);
                } else {
                    label.setIcon(Pawn.WHITE_PAWN_IMAGE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/

        JFrame frame = new JFrame();
        Board board = new Board(400);
        frame.add(board);
        frame.setVisible(true);
        while(true) {}
    }
}