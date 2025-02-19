import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JPanel panel = new JPanel(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ImageIcon icon = new ImageIcon("/Users/shane.coffey27/Downloads/WhitePawn.png");
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
    }
}