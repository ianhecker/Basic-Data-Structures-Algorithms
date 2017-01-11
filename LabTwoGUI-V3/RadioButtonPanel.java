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

