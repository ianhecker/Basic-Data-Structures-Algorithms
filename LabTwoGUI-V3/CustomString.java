/* <This is a painting program designed for a college computer science course>
    Copyright (C) <2016>  <name of Ian Hecker>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

