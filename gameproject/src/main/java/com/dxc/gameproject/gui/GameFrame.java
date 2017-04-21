package com.dxc.gameproject.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new BoardPanel());
        
        setTitle("Janusz na Wakacjach");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 640);
        setLocationRelativeTo(null);
        setVisible(true);        
    }

 

      
    
}