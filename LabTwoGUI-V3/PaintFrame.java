/* <This is a painting program designed for a college computer science course>
    Copyright (C) <2016>  <name of Ian Hecker>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package javapaintapplication;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
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
        BorderFontSlider borderFontSlider = new BorderFontSlider(drawingPanel);
        
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
                                                
                        JOptionPane.showMessageDialog(null, imgLabel, "Programmed By Space Monkeys!    &  Ian Hecker", 1);                        
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
        
        //West JPanel Setup
        JPanel westPanel = new JPanel();        
        JPanel westPanelInception = new JPanel();
        westPanelInception.setLayout(new BoxLayout(westPanelInception, BoxLayout.PAGE_AXIS));
        
        westPanelInception.add(buttonPanel);
        westPanelInception.add(borderFontSlider);
        westPanelInception.add(radioButtonPanel);        
        //AddPanels into WestPanel
        westPanel.add(westPanelInception);
        
        //JFrame Setup
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Java Paint Application - By Ian Hecker");
        frame.setJMenuBar(menuBar);//Put menuBar on frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(drawingPanel);        
        frame.getContentPane().add(westPanel, BorderLayout.WEST);                          
        
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

