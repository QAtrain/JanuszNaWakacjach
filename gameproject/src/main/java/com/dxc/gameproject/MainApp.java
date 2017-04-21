package com.dxc.gameproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


import com.dxc.gameproject.gui.GameFrame;




public class MainApp {
	public static void main(String[] args) {
    	JButton startButton = new JButton("START");
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame game = new GameFrame();
            	
            }
         

        });
        JFrame frame = new JFrame("Janusz na wakacjach");
        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(startButton);
        frame.setVisible(true);    
    }
}
