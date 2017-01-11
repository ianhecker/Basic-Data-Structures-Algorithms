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


/**
 *
 * @author Ian
 */
public class Text {
    
    public int x, y;
    public String str;    

    public Text()
    {
        str = "Testing";
        x = y = 0;
    }
    public void setBounds(int x, int y)
    {
        this.x = x;
        this.y = y;        
    }
    public String getString()
    {
        return str;
    }    
}
