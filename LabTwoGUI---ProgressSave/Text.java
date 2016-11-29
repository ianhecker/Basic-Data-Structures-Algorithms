/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
