/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ian
 */
public class RadioButtonPanel extends JPanel implements ActionListener {

    private DrawingPanel drawingPanel;    
    
    public RadioButtonPanel(DrawingPanel drawingPanel){
        
        this.drawingPanel = drawingPanel;
        
        JPanel radioPanel = new JPanel();
        ButtonGroup radioGroup = new ButtonGroup();
        //ButtonGroups keep only one radio button selected
        JRadioButton fillButton, emptyButton;                               
        
        //radioGroup buttons
        fillButton = createFillRadioButton("Filled", false);
        emptyButton = createFillRadioButton("Empty", true);                
        radioGroup.add(fillButton);
        radioGroup.add(emptyButton);        
        
        //radioPanel buttons
        radioPanel.add(fillButton);
        radioPanel.add(emptyButton);
        //radioTitle Title and Border
        TitledBorder radioTitle;
        radioTitle = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Shape Fill");
        radioTitle.setTitleJustification(TitledBorder.CENTER);        
        radioPanel.setBorder(radioTitle);
        
        //Add RadioPanel to main panel
        add(radioPanel);
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

