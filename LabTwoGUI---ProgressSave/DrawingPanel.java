/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.*;
/**
 * !!!A code example from StackOverflow was used as the basis for this project
 * !!!It has been thoroughly modified and adapted to fit my needs, but some small 
 * !!!parts may resemble the original code
 * @author Ian
 */
public class DrawingPanel extends JPanel {
    
    private ArrayList<CustomRectangle> rectangles = new ArrayList<CustomRectangle>();
    private ArrayList<CustomOval> ovals = new ArrayList<CustomOval>();
    private ArrayList<CustomLine> lines = new ArrayList<CustomLine>();
    private ArrayList<CustomString> strings = new ArrayList<CustomString>();
    
    private final static int RECT = 0;
    private final static int OVAL = 1;
    private final static int LINE = 2;
    private final static int TEXT = 3;
        
    private Rectangle shape;
    private Line line;
    private Text text;
    private Color outline;
    
    public int shapeToBeDrawn = RECT;//RECT IS BASE CHOICE
    public String textToBeDrawn = "Draw Text";
    public boolean isFilled = false;
    
    public DrawingPanel(){
        
        setBackground(Color.WHITE);
        outline = Color.BLACK;
        MyMouseListener mouseL = new MyMouseListener();
        addMouseListener(mouseL);
        addMouseMotionListener(mouseL);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);        
        
        Color foreground = g.getColor();
        
        g.setColor(Color.BLACK);                        
        
        for(CustomRectangle cr : rectangles){
            g.setColor(cr.getForeground());
            Rectangle r = cr.getRectangle();
            
            if(cr.isFilled() == true){                
                g.fillRect(r.x, r.y, r.width, r.height);
                g.setColor(cr.getOutline());//Change to outline of shape
                g.drawRect(r.x, r.y, r.width, r.height);
                
            }                        
            else{
                g.drawRect(r.x, r.y, r.width, r.height);
            }
        }
        for(CustomOval co : ovals){
            g.setColor(co.getForeground());
            Rectangle r = co.getOval();
            
            if(co.isFilled() == true){                
                g.fillOval(r.x, r.y, r.width, r.height);
                g.setColor(co.getOutline());//Change to outline of shape
                g.drawOval(r.x, r.y, r.width, r.height);                
            }                        
            else{
                g.drawOval(r.x, r.y, r.width, r.height);
            }            
        }        
        for(CustomLine cl : lines)
        {
            g.setColor(cl.getForeground());            
            g.drawLine(cl.x, cl.y, cl.width, cl.height);
        }        
        for(CustomString cs : strings)
        {
            g.setColor(cs.getForeground());
            Text t = cs.getString();
            g.drawString(t.getString(), t.x, t.y);         
        }        
        
        if (shape != null)//Draws shape when mouse dragged
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(foreground);//Shows shape being drawn in selected color                                    
            g2d.draw(shape);                       
        }
    }
    public void requestToDrawText(String textToBeDrawn)
    {   
        System.out.println("TESTING");
        if(textToBeDrawn == null)
        {
            this.textToBeDrawn = "Draw Text";
        }
        else
        {
            this.textToBeDrawn = textToBeDrawn;
        }
    }
    public void setOutline(Color outline)
    {
        this.outline = outline;
    }
    public void addRectangle(Rectangle rectangle, Color fill, Color outline)
    {        
        CustomRectangle cr = new CustomRectangle(fill, outline, rectangle, isFilled);
        rectangles.add(cr);
        repaint();                
    }    
    public void addOval(Rectangle oval, Color fill, Color outline)
    {        
        CustomOval co = new CustomOval(fill, outline, oval, isFilled);
        ovals.add(co);
        repaint();
    }    
    public void addLine(Line line, Color color)
    {    
        CustomLine cl = new CustomLine(color, line);
        lines.add(cl);
        repaint();
    }    
    public void addText(Text text, Color color)
    {
        CustomString cs = new CustomString(color, text, textToBeDrawn);        
        strings.add(cs);
        repaint();
    }    
    public void clear()
    {        
        rectangles.clear();
        ovals.clear();
        lines.clear();
        strings.clear();
        repaint();
    }
    
    public class MyMouseListener extends MouseInputAdapter{

        private Point startPoint;        

        @Override
        public void mousePressed(MouseEvent e){

            startPoint = e.getPoint();                        
            shape = new Rectangle();
            line = new Line();
            text = new Text();
            
            if(shapeToBeDrawn == TEXT)
            {
                int x = e.getX();
                int y = e.getY();
                
                text.setBounds(x, y);
                repaint();
            }            
        }

        @Override
        public void mouseDragged(MouseEvent e){           

            if(shapeToBeDrawn == LINE)
            {
                int x1 = startPoint.x;
                int y1 = startPoint.y;
                int x2 = e.getX();
                int y2 = e.getY();
                
                line.setBounds(x1, y1, x2, y2);
            }
            else if(shapeToBeDrawn == RECT || shapeToBeDrawn == OVAL)
            {
                int x = Math.min(startPoint.x, e.getX());
                int y = Math.min(startPoint.y, e.getY());
                int width = Math.abs(startPoint.x - e.getX());
                int height = Math.abs(startPoint.y - e.getY());
                
                shape.setBounds(x, y, width, height);
            }
            repaint();            
        }            

        @Override
        public void mouseReleased(MouseEvent e){
            if(shapeToBeDrawn == RECT){//Creating a Rectangle
                if(shape.width != 0 || shape.height != 0){
                    addRectangle(shape, e.getComponent().getForeground(), outline);            
                }
            }
            else if(shapeToBeDrawn == OVAL){//Creating an Oval
                if(shape.width != 0 || shape.height != 0){
                    addOval(shape, e.getComponent().getForeground(), outline);            
                }
            }
            else if(shapeToBeDrawn == LINE){//Creating a Line
                if(line.x2 != 0 || line.y2 != 0){
                    addLine(line, e.getComponent().getForeground());
                }
            }
            else if(shapeToBeDrawn == TEXT){//Creating drawn Text                
                addText(text, e.getComponent().getForeground());
            }
            shape = null;
            line = null;
            text = null;
        }
    }
}
