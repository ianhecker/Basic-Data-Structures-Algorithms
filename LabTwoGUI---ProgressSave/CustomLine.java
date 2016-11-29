/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.Color;

/**
 *
 * @author Ian
 */

public class CustomLine{        
            
    public int x, y;
    private Line line;
    private Color foreground;
    public int width, height;
    
    public CustomLine()
    {
        foreground = Color.BLACK;
        this.line = new Line();
        this.x = line.x1;
        this.y = line.y1;
        this.width = line.x2;
        this.height = line.y2;
    }    
    public CustomLine(Color foreground, Line line)
    {        
        this.foreground = foreground;
        this.line = line;        
        this.x = line.x1;
        this.y = line.y1;
        this.width = line.x2;
        this.height = line.y2;
    }    
    public Color getForeground()
    {
        return foreground;
    }    
    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }   
    public Line getLine()
    {
        return line;
    }     
    public void setBounds(int x1, int y1, int x2, int y2)
    {
        line.setBounds(x1, y1, x2, y2);
    }
    
}
