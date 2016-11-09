/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintcs132;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Ian
 */
public class ButtonPanel extends JPanel implements ActionListener{
    
    private DrawingPanel drawingPanel;
    
    public ButtonPanel(DrawingPanel drawingPanel){
        
        this.drawingPanel = drawingPanel;
        
        add( createButton("Rect", null));
        add( createButton("Oval", null));
        add( createButton(" ", Color.BLACK));
        add( createButton(" ", Color.RED));
        add( createButton(" ", Color.GREEN));
        add( createButton(" ", Color.BLUE));        
        add( createButton("Clear Drawing", null));        
    }
    
    private JButton createButton(String text, Color background){
        
        JButton button = new JButton(text);
        button.setBackground(background);
        button.addActionListener((ActionListener) this);
        
        return button;
    }
    
    public void actionPerformed(ActionEvent e){
        
        JButton button = (JButton)e.getSource();
        
        if(e.getActionCommand().equals("Clear Drawing"))
            drawingPanel.clear();
        else if(e.getActionCommand().equals("Rect")){
            //drawingPanel.changeToRect();
        }            
        else if(e.getActionCommand().equals("Oval")){
        
        }
        else
            drawingPanel.setForeground(button.getBackground());
    }
    
    
}
