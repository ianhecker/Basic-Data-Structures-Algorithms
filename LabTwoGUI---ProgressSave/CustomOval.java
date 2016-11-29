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
    private Rectangle oval;
    private boolean filled;
            
    public CustomOval(Color foreground, Rectangle oval, Boolean filled)
    {        
        this.foreground = foreground;
        this.oval = oval;
        this.filled = filled;
    }    
    public Color getForeground()
    {
        return foreground;
    }    
    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }    
    public Rectangle getOval()
    {
        return oval;
    }    
    public boolean isFilled()
    {
        return filled;
    }
}
