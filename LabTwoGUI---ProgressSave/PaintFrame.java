/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapaintapplication;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Ian
 */
public class PaintFrame extends JFrame
{   
    private final static int FRAME_WIDTH = 1000;
    private final static int FRAME_HEIGHT = 600;    
    private final static String IMG_PATH = "src\\javapaintapplication\\resource\\CodedByAMonkey2.jpg";
    
    private void createMyGUI()
    {        
        JMenuBar menuBar = new JMenuBar();
        DrawingPanel drawingPanel = new DrawingPanel();
        ButtonPanel buttonPanel = new ButtonPanel(drawingPanel);
        RadioButtonPanel radioButtonPanel = new RadioButtonPanel(drawingPanel);        
        
        //File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");            
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveToMenuItem = new JMenuItem("Save to...");        
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveToMenuItem);        
        
        //Edit Menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);        
        
        //Choices Menu
        JMenu choicesMenu = new JMenu("Choices");        
        
        //Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {                                                            
                    try {                        
                        BufferedImage img = ImageIO.read(new File(IMG_PATH));
                        ImageIcon icon = new ImageIcon(img);
                        JLabel imgLabel = new JLabel(icon);                                                                                                                                                                        
                        
                        JOptionPane.showMessageDialog(null, imgLabel);                        
                    } 
                    catch (IOException e) {
                        e.printStackTrace();
                    }                   
                }
            });
        helpMenu.add(aboutMenuItem);
        
        //Add Menus
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(choicesMenu);
        menuBar.add(helpMenu);
        
        //JFrame Setup
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Java Paint App");
        frame.setJMenuBar(menuBar);//Put menuBar on frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(drawingPanel);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);                        
        frame.getContentPane().add(radioButtonPanel, BorderLayout.WEST);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
        frame.setVisible(true);
                
    }    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaintFrame frame = new PaintFrame();
                frame.createMyGUI();
            }            
        });
    }        
}

