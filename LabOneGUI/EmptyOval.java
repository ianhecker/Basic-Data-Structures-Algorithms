/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintcs132;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Ian
 */

public class EmptyOval {
    
    private Color foreground;
    private Ellipse2D oval;
            
    public EmptyOval(Color foreground, Ellipse2D oval){
        
        this.foreground = foreground;
        this.oval = oval;
    }
    
    public Color getForeground(){
        return foreground;
    }
    
    public void setForeground(Color foreground){
        this.foreground = foreground;
    }
    
    public Ellipse2D getOval(){
        return oval;
    }
}
