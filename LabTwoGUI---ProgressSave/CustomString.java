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
public class CustomString
{
    public int x, y;    
    private Text text;
    private Color foreground;
            
    public CustomString()
    {
        foreground = Color.BLACK;
        this.text = new Text();
        this.x = text.x;
        this.y = text.y;
    }    
    public CustomString(Color foreground, Text text, String str)
    {
        this.foreground = foreground;
        this.text = text;
        text.str = str;
        this.x = text.x;
        this.y = text.y;        
    }
    public Color getForeground()
    {
        return foreground;
    }    
    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }
    public Text getString()
    {
        return text;
    }
    public void setBounds(int x, int y)
    {
        text.setBounds(x, y);
    }
}

