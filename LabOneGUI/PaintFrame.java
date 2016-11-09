/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapaintcs132;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Ian
 */
public class PaintFrame extends JFrame {
    
    private static void createMyGUI(){
        
        DrawingPanel drawingPanel = new DrawingPanel();
        ButtonPanel buttonPanel = new ButtonPanel(drawingPanel);
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Java Paint App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawingPanel);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(600, 600);        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createMyGUI();
            }
        });
    }
    
    
}
