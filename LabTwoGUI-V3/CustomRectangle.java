package javapaintapplication;

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
    private int strokeSize;
            
    public CustomRectangle(
            Color foreground, Color outline, Rectangle rectangle,
            Boolean filled, int strokeSize)
    {        
        this.foreground = foreground;
        this.outline = outline;
        this.rectangle = rectangle;
        this.filled = filled;
        this.strokeSize = strokeSize;
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
    public int getStrokeSize()
    {
        return strokeSize;
    }
}
