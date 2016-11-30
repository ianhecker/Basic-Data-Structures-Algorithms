/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Ian
 */
public class ButtonPanel extends JPanel implements ActionListener{
    
    private DrawingPanel drawingPanel;
    private final static int RECT = 0;
    private final static int OVAL = 1;
    private final static int LINE = 2;
    private final static int TEXT = 3;
    
    public ButtonPanel(DrawingPanel drawingPanel){
        
        this.drawingPanel = drawingPanel;
                        
        add( createButton("Rect"));
        add( createButton("Oval"));
        add( createButton("Line"));
        add( createButton("Text"));
        add( createTextBox());        
        add( createButton("Fill Color"));              
        add( createButton("Outline Color"));              
        add( createButton("Clear Drawing"));        
    }    
    private JButton createButton(String text){
        
        JButton button = new JButton(text);        
        button.addActionListener((ActionListener) this);
        
        return button;
    }
    private JTextField createTextBox()
    {
        JTextField textBox = new JTextField(5);
        textBox.addActionListener((ActionListener) this);
        
        return textBox;
    }            
    @Override
    public void actionPerformed(ActionEvent e){
         
        JTextField textBox = null;
        JButton button = null;
        try
        {
            button = (JButton)e.getSource();
        }
        catch (ClassCastException cce)
        {
            textBox = (JTextField)e.getSource();
        }        
        
        if(e.getActionCommand().equals("Clear Drawing")){
            drawingPanel.clear();        
        }
        else if(e.getActionCommand().equals("Rect")){
            drawingPanel.shapeToBeDrawn = RECT;                        
        }            
        else if(e.getActionCommand().equals("Oval")){
            drawingPanel.shapeToBeDrawn = OVAL;            
        }
        else if(e.getActionCommand().equals("Line")){
            drawingPanel.shapeToBeDrawn = LINE;            
        }       
        else if(e.getActionCommand().equals("Text")){
            drawingPanel.shapeToBeDrawn = TEXT;
        }        
        else if(e.getActionCommand().equals("Fill Color")){
            Color fillColor = JColorChooser.showDialog(this, "Select a color", Color.BLACK); 
            drawingPanel.setForeground(fillColor);//sets shape color
            button.setBackground(fillColor);//Sets current color as background
        }        
        else if(e.getActionCommand().equals("Outline Color")){
            Color outlineColor = JColorChooser.showDialog(this, "Select a color", Color.BLACK); 
            drawingPanel.setOutline(outlineColor);//sets shape color
            button.setBackground(outlineColor);//Sets current color as background
        }                        
        else if(e.getActionCommand() instanceof String){           
            drawingPanel.requestToDrawText(textBox.getText());            
        }        
    }//End of ActionPerformed         
}//End of Class Button Panel
