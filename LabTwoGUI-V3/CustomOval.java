/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.Color;
import java.awt.*;

/**
 *
 * @author Ian
 */

public class CustomOval {
    
    private Color foreground;
    private Color outline;
    private Rectangle oval;
    private boolean filled;
    private int strokeSize;
            
    public CustomOval(
            Color foreground, Color outline, Rectangle oval,
                Boolean filled, int strokeSize)
    {        
        this.foreground = foreground;
        this.outline = outline;
        this.oval = oval;
        this.filled = filled;
        this.strokeSize = strokeSize;
    }    
    public Color getForeground()
    {
        return foreground;
    }    
    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }
    public Color getOutline()
    {
        return outline;
    }
    public void setOutline(Color outline)
    {
        this.outline = outline;
    }    
    public Rectangle getOval()
    {
        return oval;
    }    
    public boolean isFilled()
    {
        return filled;
    }
    public int getStrokeSize()
    {
        return strokeSize;
    }
}
