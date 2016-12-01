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
public class Line
{
    public int x1, x2, y1, y2;    

    public Line()
    {
        x1 = x2 = y1 = y2 = 0;
    }
    public void setBounds(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }    
}

