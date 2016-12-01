/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import javax.swing.*;
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
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));//Stacks Title on slider
        
        JSlider borderFontSlider;
        borderFontSlider = createBorderFontSlider();
        
        JLabel sliderLabel = new JLabel("Border & Font Thickness", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);                
        
        add(sliderLabel);        
        add(borderFontSlider);
    }    
    private JSlider createBorderFontSlider()
    {
        JSlider borderFontSlider = new JSlider(JSlider.VERTICAL, 1, 21, 1);
        borderFontSlider.addChangeListener((ChangeListener) this);
        borderFontSlider.setMinorTickSpacing(1);
        borderFontSlider.setPaintTicks(true);
        borderFontSlider.setPaintLabels(true);
        borderFontSlider.setBorder(
            BorderFactory.createEmptyBorder(0, 0, 10, 0));
                
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
