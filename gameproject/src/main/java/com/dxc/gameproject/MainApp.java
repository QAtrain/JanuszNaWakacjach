package com.dxc.gameproject;

import javax.swing.JFrame;

import com.dxc.gameproject.gui.GameFrame;

/**
 * Hello world!
 *
 */
public class MainApp 
{
    public static void main(String[] args) {
        JFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
