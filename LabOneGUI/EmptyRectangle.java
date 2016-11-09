package javapaintcs132;

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
public class EmptyRectangle {
    
    private Color foreground;
    private Rectangle rectangle;
            
    public EmptyRectangle(Color foreground, Rectangle rectangle){
        
        this.foreground = foreground;
        this.rectangle = rectangle;
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
}
