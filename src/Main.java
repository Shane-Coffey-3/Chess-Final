import javax.swing.*;
import java.awt.*;

public class MyProgram
{
    public static void main(String[] args)
    {
        int[][] boardArray = {
                {7, 3, 5,11, 9, 5, 3, 7},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {6, 2, 4,10, 8, 4, 2, 6}
        };
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(8, 8));
        boardPanel.setSize(600, 400);
        frame.add(boardPanel, BorderLayout.CENTER);

        JLabel[] boardImages = new JLabel[64];

        Color lightBrown = new Color(154, 123, 79);
        Color darkBrown = new Color(75, 37, 28);

        JPanel sidebarPanel = new JPanel(new BorderLayout());

        JTextField computerNametag = new JTextField("Computer");
        sidebarPanel.add(computerNametag, BorderLayout.NORTH);

        JTextField playerNametag = new JTextField("Enter your name");
        sidebarPanel.add(playerNametag, BorderLayout.SOUTH);

        JButton newGameButton = new JButton("New game");
        sidebarPanel.add(newGameButton, BorderLayout.CENTER);

        System.out.println(frame.size());
        System.out.println(boardPanel.size());

        // I don't think there's a way to do this shorter
        ImageIcon whitePawn = new ImageIcon("WhitePawn.png");
        whitePawn.setImage(whitePawn.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackPawn = new ImageIcon("BlackPawn.png");
        blackPawn.setImage(blackPawn.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon whiteKnight = new ImageIcon("WhiteKnight.png");
        whiteKnight.setImage(whiteKnight.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackKnight = new ImageIcon("BlackKnight.png");
        blackKnight.setImage(blackKnight.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon whiteBishop = new ImageIcon("WhiteBishop.png");
        whiteBishop.setImage(whiteBishop.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackBishop = new ImageIcon("BlackBishop.png");
        blackBishop.setImage(blackBishop.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon whiteRook = new ImageIcon("WhiteRook.png");
        whiteRook.setImage(whiteRook.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackRook = new ImageIcon("BlackRook.png");
        blackRook.setImage(blackRook.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon whiteQueen = new ImageIcon("WhiteQueen.png");
        whiteQueen.setImage(whiteQueen.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackQueen = new ImageIcon("BlackQueen.png");
        blackQueen.setImage(blackQueen.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon whiteKing = new ImageIcon("WhiteKing.png");
        whiteKing.setImage(whiteKing.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        ImageIcon blackKing = new ImageIcon("BlackKing.png");
        blackKing.setImage(blackKing.getImage().getScaledInstance(frame.getHeight() / 8, frame.getHeight() / 8, Image.SCALE_SMOOTH));

        for(int i = 0; i < 64; i++) {
            boardImages[i] = new JLabel();
            boardImages[i].setHorizontalAlignment(SwingConstants.CENTER);
            boardImages[i].setVerticalAlignment(SwingConstants.CENTER);

            // make checkerboard
            if((i % 2 == 0 && i % 16 >= 8) || (i % 2 == 1 && i % 16 < 8)) {
                boardImages[i].setBackground(lightBrown);
            } else {
                boardImages[i].setBackground(darkBrown);
            }

            switch(boardArray[i / 8][i % 8]) {
                case 0:
                    boardImages[i].setIcon(whitePawn);
                    break;
                case 1:
                    boardImages[i].setIcon(blackPawn);
                    break;
                case 2:
                    boardImages[i].setIcon(whiteKnight);
                    break;
                case 3:
                    boardImages[i].setIcon(blackKnight);
                    break;
                case 4:
                    boardImages[i].setIcon(whiteBishop);
                    break;
                case 5:
                    boardImages[i].setIcon(blackBishop);
                    break;
                case 6:
                    boardImages[i].setIcon(whiteRook);
                    break;
                case 7:
                    boardImages[i].setIcon(blackRook);
                    break;
                case 8:
                    boardImages[i].setIcon(whiteQueen);
                    break;
                case 9:
                    boardImages[i].setIcon(blackQueen);
                    break;
                case 10:
                    boardImages[i].setIcon(whiteKing);
                    break;
                case 11:
                    boardImages[i].setIcon(blackKing);
                    break;
                default:
            }

            boardImages[i].setOpaque(true);
            boardPanel.add(boardImages[i]);
        }

        frame.add(sidebarPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}