/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

/**
 *
 * @author Ian
 */
public class BorderFontSlider extends JPanel implements ChangeListener{
    
    private DrawingPanel drawingPanel;
    
    public BorderFontSlider(DrawingPanel drawingPanel)
    {
        this.drawingPanel = drawingPanel;
                
        JPanel sliderPanel = new JPanel();
        JSlider borderFontSlider;
        
        //sliderPanel slider
        borderFontSlider = createBorderFontSlider();
        sliderPanel.add(borderFontSlider);
        //sliderPanel Title and Border
        TitledBorder sliderTitle;
        sliderTitle = BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Border and Font Thickness");
        sliderTitle.setTitleJustification(TitledBorder.CENTER);        
        sliderPanel.setBorder(sliderTitle);                                        
                     
        add(sliderPanel);
    }    
    private JSlider createBorderFontSlider()
    {
        JSlider borderFontSlider = new JSlider(JSlider.HORIZONTAL, 1, 21, 1);
        borderFontSlider.addChangeListener((ChangeListener) this);
        borderFontSlider.setMinorTickSpacing(1);
        borderFontSlider.setPaintTicks(true);
        borderFontSlider.setPaintLabels(true);        
                
        return borderFontSlider;
    }    
    public void stateChanged(ChangeEvent e){                         
        
        JSlider sliderMovement = (JSlider)e.getSource();
        
        if(sliderMovement.getValueIsAdjusting()){            
            drawingPanel.setStrokeSize(sliderMovement.getValue());
            drawingPanel.setFontSize();
        }                                    
    }
}
