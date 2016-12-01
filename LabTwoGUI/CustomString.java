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
    private int fontSize;
                    
    public CustomString(
            Color foreground, Text text,
            String str, int fontSize)
    {
        this.foreground = foreground;
        this.text = text;
        text.str = str;
        this.fontSize = fontSize;
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
    public int getFontSize()
    {
        return fontSize;
    }
}

