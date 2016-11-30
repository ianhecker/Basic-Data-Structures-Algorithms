package javapaintapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
/**
 *
 * @author Ian
 */
public class CustomRectangle {
    
    private Color foreground;
    private Color outline;
    private Rectangle rectangle;
    private boolean filled;
            
    public CustomRectangle(Color foreground, Color outline, Rectangle rectangle, Boolean filled)
    {        
        this.foreground = foreground;
        this.outline = outline;
        this.rectangle = rectangle;
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
    public Color getOutline()
    {
        return outline;
    }
    public void setOutline(Color outline)
    {
        this.outline = outline;
    }
    public Rectangle getRectangle()
    {
        return rectangle;
    }  
    public boolean isFilled()
    {
        return filled;
    }
}
