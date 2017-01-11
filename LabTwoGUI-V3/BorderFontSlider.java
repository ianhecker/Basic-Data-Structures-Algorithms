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
