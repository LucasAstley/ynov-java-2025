package fr.ynov.java.game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Interface {

    public static void createWindow(String windowName) {
        JFrame frame = new JFrame(windowName);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(Interface.class.getResource("scissors.png"))).getImage());
        createUIComponents(frame);
        frame.setVisible(true);
    }

    private static void createUIComponents(JFrame frame) {
        JPanel scorePanel = createScorePanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel resultPanel = createResultPanel();
        JPanel controlPanel = createControlPanel();

        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);
        frame.add(controlPanel, BorderLayout.PAGE_END);

        ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    private static JPanel createScorePanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 400, 0));

        JPanel playerPanel = new JPanel(new GridLayout(2, 1));
        JLabel playerNameLabel = new JLabel("Player: ");
        JLabel playerScoreLabel = new JLabel("Score: ");
        playerPanel.add(playerNameLabel);
        playerPanel.add(playerScoreLabel);

        JPanel computerPanel = new JPanel(new GridLayout(2, 1));
        JLabel computerNameLabel = new JLabel("Computer");
        JLabel computerScoreLabel = new JLabel("Score: ");
        computerPanel.add(computerNameLabel);
        computerPanel.add(computerScoreLabel);

        panel.add(playerPanel);
        panel.add(computerPanel);

        return panel;
    }

    private static JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton rockButton = createGameButton("Rock", "rock.png");
        JButton paperButton = createGameButton("Paper", "paper.png");
        JButton scissorsButton = createGameButton("Scissors", "scissors.png");

        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);

        return panel;
    }

    private static JButton createGameButton(String text, String iconName) {
        JButton button = new JButton(text);

        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(Interface.class.getResource(iconName)));

        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledImage));

        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        button.setPreferredSize(new Dimension(100, 100));

        return button;
    }

    private static JPanel createResultPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel resultLabel = new JLabel("Make your choice!");
        resultLabel.setFont(new Font(resultLabel.getFont().getName(), Font.BOLD, 14));
        panel.add(resultLabel);
        return panel;
    }

    private static JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton stopButton = new JButton("Stop Game");
        panel.add(stopButton);
        return panel;
    }
}