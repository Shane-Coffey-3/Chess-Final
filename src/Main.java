package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board(400);
        frame.add(board);
        frame.setVisible(true);
    }
}