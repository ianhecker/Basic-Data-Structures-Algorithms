/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javapaintcs132;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.*;
/**
 *
 * @author Ian
 */
public class DrawingPanel extends JPanel {

    
    private ArrayList<EmptyRectangle> rectangles = new ArrayList<EmptyRectangle>();
    private ArrayList<EmptyOval> ovals = new ArrayList<EmptyOval>();    
    private Rectangle rectShape;
    private Ellipse2D ovalShape;
    
    public DrawingPanel(){
        
        setBackground(Color.WHITE);
        
        MyMouseListener mouseL = new MyMouseListener();
        addMouseListener(mouseL);
        addMouseMotionListener(mouseL);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Color foreground = g.getColor();
        
        g.setColor(Color.BLACK);
        
        rectangles.stream().map((er) -> {
            g.setColor(er.getForeground());
            return er;
        }).map((er) -> er.getRectangle()).forEach((r) -> {
            g.drawRect(r.x, r.y, r.width, r.height);
        });
        
        ovals.stream().map((er) -> {
            g.setColor(er.getForeground());
            return er;
        }).map((er) -> er.getEllipse2D()).forEach((r) -> {
            g.drawOval(r.x, r.y, r.width, r.height);
        });
        
        if(rectShape != null){
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(foreground);
            g2.draw(rectShape);
        }
    }
    
    public void addRectangle(Rectangle rectangle, Color color){
    
        EmptyRectangle er = new EmptyRectangle(color, rectangle);
        rectangles.add(er);
        repaint();                
    }
    
    public void clear(){
        
        rectangles.clear();
        repaint();
    }
    
    public class MyMouseListener extends MouseInputAdapter{

        private Point startPoint;

        @Override
        public void mousePressed(MouseEvent e){

            startPoint = e.getPoint();
            rectShape = new Rectangle();
        }

        @Override
        public void mouseDragged(MouseEvent e){

            int x = Math.min(startPoint.x, e.getX());
            int y = Math.min(startPoint.y, e.getY());
            int width = Math.abs(startPoint.x - e.getX());
            int height = Math.abs(startPoint.y - e.getY());

            rectShape.setBounds(x, y, width, height);
            repaint();
        }            

        @Override
        public void mouseReleased(MouseEvent e){

            if(rectShape.width != 0 || rectShape.height != 0){
                addRectangle(rectShape, e.getComponent().getForeground());            
            }
            rectShape = null;
        }
    }
}
