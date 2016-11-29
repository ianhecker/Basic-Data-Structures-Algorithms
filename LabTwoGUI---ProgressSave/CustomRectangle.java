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
    private Rectangle rectangle;
    private boolean filled;
            
    public CustomRectangle(Color foreground, Rectangle rectangle, Boolean filled){
        
        this.foreground = foreground;
        this.rectangle = rectangle;
        this.filled = filled;
    }
    
    public Color getForeground(){
        return foreground;
    }
    
    public void setForeground(Color foreground){
        this.foreground = foreground;
    }
    
    public Rectangle getRectangle(){
        return rectangle;
    }
    
    public boolean isFilled(){
        return filled;
    }
}
