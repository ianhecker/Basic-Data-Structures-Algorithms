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
    private final static int FREEHAND = 4;
    
    public ButtonPanel(DrawingPanel drawingPanel){
        
        this.drawingPanel = drawingPanel;                  
        
        JPanel shapeGroup, textGroup, colorGroup, clearGroup;        
        shapeGroup = new JPanel();
        textGroup = new JPanel();
        colorGroup = new JPanel();
        clearGroup = new JPanel();
        JButton rect, oval, line, freehand, text, fill, outline, clear;
        JTextField textInput;               
        
        this.setLayout(new GridLayout(4, 1));
        shapeGroup.setLayout(new GridLayout(2, 2));        
        
        //shapeGroup buttons
        rect = createButton("Rect");
        oval = createButton("Oval");
        line = createButton("Line");
        freehand = createButton("Freehand");
        shapeGroup.add(rect);
        shapeGroup.add(oval);
        shapeGroup.add(line);
        shapeGroup.add(freehand);
        //shapeGroup Title and Border
        TitledBorder shapeTitle;
        shapeTitle = BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Draw Shapes");
        shapeTitle.setTitleJustification(TitledBorder.CENTER);        
        shapeGroup.setBorder(shapeTitle);                        
        
        //textGroup buttons
        text = createButton("Text");
        textInput = createTextBox();
        textGroup.add(text);
        textGroup.add(textInput);
        //textGroup Title and Border
        TitledBorder textTitle;
        textTitle = BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Draw Text");
        textTitle.setTitleJustification(TitledBorder.CENTER);
        textGroup.setBorder(textTitle);                
        
        //colorGroup buttons
        fill = createButton("Fill");
        outline = createButton("Outline");
        colorGroup.add(fill);
        colorGroup.add(outline);
        //colorGroup Title and Border
        TitledBorder colorTitle;
        colorTitle = BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Color");
        colorTitle.setTitleJustification(TitledBorder.CENTER);
        colorGroup.setBorder(colorTitle);
                      
        //clearGroup button
        clear = createButton("Clear");
        clearGroup.add(clear);
        //clearGroup Title and Border
        TitledBorder clearTitle;
        clearTitle = BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Clear all Drawings");
        clearTitle.setTitleJustification(TitledBorder.CENTER);
        clearGroup.setBorder(clearTitle);
        
        //Add all JPanels to ButtonPanel        
        
        add(shapeGroup);        
        add(textGroup); 
        add(colorGroup);
        add(clearGroup);         
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
        
        if(e.getActionCommand().equals("Clear")){
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
        else if(e.getActionCommand().equals("Freehand")){
            drawingPanel.shapeToBeDrawn = FREEHAND;            
        }       
        else if(e.getActionCommand().equals("Text")){
            drawingPanel.shapeToBeDrawn = TEXT;
        }        
        else if(e.getActionCommand().equals("Fill")){
            Color fillColor = JColorChooser.showDialog(this, "Select a color", Color.BLACK); 
            drawingPanel.setForeground(fillColor);//sets shape color
            button.setBackground(fillColor);//Sets current color as background            
        }        
        else if(e.getActionCommand().equals("Outline")){
            Color outlineColor = JColorChooser.showDialog(this, "Select a color", Color.BLACK); 
            drawingPanel.setOutline(outlineColor);//sets shape color
            button.setBackground(outlineColor);//Sets current color as background
        }                        
        else if(e.getActionCommand() instanceof String){           
            drawingPanel.requestToDrawText(textBox.getText());            
        }        
    }//End of ActionPerformed         
}//End of Class Button Panel
