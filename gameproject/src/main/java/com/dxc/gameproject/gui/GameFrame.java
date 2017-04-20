package com.dxc.gameproject.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    private JFrame frame;
    private JPanel backgroundPanel;
    private JPanel mainPanel;
    private JButton startButton;
    private JButton moveUpButton;
    private JButton moveDownButton;
    //private JButton moveLeftButton;
    //private JButton moveRightButton;

    public void createMainGUI() {
        frame = new JFrame("Janusz na Wakacjach");
        backgroundPanel = new JPanel();
        mainPanel = new JPanel();
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        startButton = new JButton("Start");
        moveUpButton = new JButton("Up");
        moveDownButton = new JButton("Down");
        //moveLeftButton = new JButton("Left");
        //moveRightButton = new JButton("Right");

        mainPanel.add(moveUpButton);
        mainPanel.add(moveDownButton);
        //mainPanel.add(moveRightButton);
        //panel.add(moveLeftButton);

        frame.getContentPane().add(BorderLayout.EAST, mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);
    }

}
