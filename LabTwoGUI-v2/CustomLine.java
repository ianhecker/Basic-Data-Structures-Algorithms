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
    private Color outline;
    private int strokeSize;
    public int width, height;
            
    public CustomLine(Color outline, Line line, int strokeSize)
    {        
        this.outline = outline;
        this.line = line;
        this.strokeSize = strokeSize;
        this.x = line.x1;
        this.y = line.y1;
        this.width = line.x2;
        this.height = line.y2;
    }    
    public Color getOutline()
    {
        return outline;
    }    
    public void setOutline(Color outline)
    {
        this.outline = outline;
    }   
    public Line getLine()
    {
        return line;
    }     
    public void setBounds(int x1, int y1, int x2, int y2)
    {
        line.setBounds(x1, y1, x2, y2);
    }
    public int getStrokeSize()
    {
        return strokeSize;
    }
}
