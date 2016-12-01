/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ian
 */
public class RadioButtonPanel extends JPanel implements ActionListener {

    private DrawingPanel drawingPanel;    
    
    public RadioButtonPanel(DrawingPanel drawingPanel){
        
        this.drawingPanel = drawingPanel;
        
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton fillButton, emptyButton;               
        
        fillButton = createFillRadioButton("Filled", false);
        emptyButton = createFillRadioButton("Empty", true);        
        
        buttonGroup.add(fillButton);
        buttonGroup.add(emptyButton);

        add( fillButton);
        add( emptyButton);                
    }     
    private JRadioButton createFillRadioButton(String text, boolean defaultOn){
        
        JRadioButton radioButton = new JRadioButton(text);                
        radioButton.addActionListener((ActionListener) this);
        
        if(defaultOn == true){
            radioButton.setSelected(true);}
        
        return radioButton;        
    }    
    @Override
    public void actionPerformed(ActionEvent e){                         
        
        JRadioButton radioButton = (JRadioButton)e.getSource();
        
        if(e.getActionCommand().equals("Filled")){            
            drawingPanel.isFilled = true;       
        }
        else if(e.getActionCommand().equals("Empty")){
            drawingPanel.isFilled = false;                        
        }                            
    }//End of ActionPerformed         
}//End of Class RadioButtonPanel

