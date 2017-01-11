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
