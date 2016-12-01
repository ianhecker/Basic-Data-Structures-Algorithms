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
    
    private ArrayList<CustomRectangle> rectangles = new ArrayList<>();
    private ArrayList<CustomOval> ovals = new ArrayList<>();
    private ArrayList<CustomLine> lines = new ArrayList<>();
    private ArrayList<CustomString> strings = new ArrayList<>();
    private ArrayList<Point> freehand = new ArrayList<>();
    private ArrayList<Color> freehandColors = new ArrayList<>();
    private ArrayList<Integer> freehandStrokeSize = new ArrayList<>();
    
    private final static int RECT = 0;
    private final static int OVAL = 1;
    private final static int LINE = 2;
    private final static int TEXT = 3;
    private final static int FREEHAND = 4;
        
    private int STROKE_SIZE = 1;
    private int FONT_SIZE = 10;
    private Color OUTLINE_COLOR = Color.BLACK;
    private int END_POINT = 123456;
    
    private Rectangle shape;
    private Line line;
    private Text text; 
    private Point point;
    
    public int shapeToBeDrawn = RECT;//RECT IS BASE CHOICE
    public String textToBeDrawn = "Enter Text!";
    public boolean isFilled = false;
    
    public DrawingPanel(){
        
        setBackground(Color.WHITE);        
        MyMouseListener mouseL = new MyMouseListener();
        addMouseListener(mouseL);
        addMouseMotionListener(mouseL);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);                
        Graphics2D g2 = (Graphics2D) g;
        
        Color foreground = g2.getColor();        
        g2.setColor(Color.BLACK);                        
        
        for(CustomRectangle cr : rectangles)//Draw Rectangles
        {
            g2.setColor(cr.getForeground());
            Rectangle r = cr.getRectangle();
            
            if(cr.isFilled() == true){                
                g2.fillRect(r.x, r.y, r.width, r.height);
            }
            g2.setColor(cr.getOutline());
            int crPosition = rectangles.indexOf(cr);
            g2.setStroke(new BasicStroke(
                    rectangles.get(crPosition).getStrokeSize()));
            g2.drawRect(r.x, r.y, r.width, r.height);
        }
        for(CustomOval co : ovals)//Draw Ovals
        {
            g2.setColor(co.getForeground());
            Rectangle r = co.getOval();
            
            if(co.isFilled() == true){                
                g2.fillOval(r.x, r.y, r.width, r.height);
            }
            g2.setColor(co.getOutline());
            int coPosition = ovals.indexOf(co);
            g2.setStroke(new BasicStroke(
                    ovals.get(coPosition).getStrokeSize()));
            g2.drawOval(r.x, r.y, r.width, r.height);
        }        
        for(CustomLine cl : lines)//Draw Lines
        {
            g2.setColor(cl.getOutline());
            int clPosition = lines.indexOf(cl);
            g2.setStroke(new BasicStroke(
                    lines.get(clPosition).getStrokeSize()));
            g2.drawLine(cl.x, cl.y, cl.width, cl.height);
        }        
        for(CustomString cs : strings)//Draw text
        {
            g2.setColor(cs.getForeground());
            Text t = cs.getString();                
            int csPosition = strings.indexOf(cs);
            g2.setFont(new Font(
                    "TimesRoman", Font.PLAIN, 
                    strings.get(csPosition).getFontSize()));
            g2.drawString(t.getString(), t.x, t.y);         
        }
        int separateFreehandCounter = 0;
        for(Point fh : freehand)//Draw Freehand
        {
            int fhPosition = freehand.indexOf(fh);
            
            if(fhPosition != 0 &&
                    freehand.get(fhPosition - 1).x != END_POINT &&
                            fh.x != END_POINT){                                                    
                g2.setColor(
                        freehandColors.get(separateFreehandCounter));
                g2.setStroke(new BasicStroke(
                        freehandStrokeSize.get(separateFreehandCounter)));
                g2.fillRect(0, 0, 1, 1);
                Point p1 = freehand.get(fhPosition - 1);
                Point p2 = fh;
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);                                
            }
            else if(fhPosition != 0 && 
                    freehand.get(fhPosition - 1).x != END_POINT){
                System.out.println(separateFreehandCounter);
                separateFreehandCounter++;}
        }     
        if (shape != null)//Draws shape when mouse dragged
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(OUTLINE_COLOR);//Shows shape being drawn in selected color                                    
            g2d.draw(shape);                       
        }
    }
    public void requestToDrawText(String textToBeDrawn)
    {           
        if(textToBeDrawn == null){
            this.textToBeDrawn = "Enter Text!";}
        else{
            this.textToBeDrawn = textToBeDrawn;}
    }
    public void setOutline(Color outline)
    {
        this.OUTLINE_COLOR = outline;
    }
    public void setStrokeSize(int strokeSize)
    {
        this.STROKE_SIZE = strokeSize;
    }
    public void setFontSize()
    {
        FONT_SIZE = (STROKE_SIZE*2);
        if(FONT_SIZE < 10){
            FONT_SIZE = 10;}
    }
    public void addRectangle(Rectangle rectangle, Color fill, Color outline)
    {        
        CustomRectangle cr = new CustomRectangle(fill, outline, rectangle, isFilled, STROKE_SIZE);
        rectangles.add(cr);
        repaint();                
    }    
    public void addOval(Rectangle oval, Color fill, Color outline)
    {        
        CustomOval co = new CustomOval(fill, outline, oval, isFilled, STROKE_SIZE);
        ovals.add(co);
        repaint();
    }    
    public void addLine(Line line, Color color)
    {    
        CustomLine cl = new CustomLine(color, line, STROKE_SIZE);
        lines.add(cl);
        repaint();
    }    
    public void addText(Text text, Color color)
    {
        CustomString cs = new CustomString(color, text, textToBeDrawn, FONT_SIZE);        
        strings.add(cs);
        repaint();
    }
    public void addFreehand(Point point)
    {            
        freehand.add(point);
        repaint();
    }
    public void addFreehandColor(Color color)
    {
        Color fc = color;
        freehandColors.add(fc);
        repaint();
    }
    public void addFreehandStrokeSize(int strokeSize)
    {
        Integer StrokeSize = new Integer(strokeSize);
        freehandStrokeSize.add(StrokeSize);
        repaint();
    }
    public void clear()
    {        
        rectangles.clear();
        ovals.clear();
        lines.clear();
        strings.clear();
        freehand.clear();
        freehandColors.clear();
        freehandStrokeSize.clear();
        repaint();
    }
    
    public class MyMouseListener extends MouseInputAdapter{

        private Point startPoint;
        Boolean updateFreehand = true;        

        @Override
        public void mousePressed(MouseEvent e){

            startPoint = e.getPoint();                        
            shape = new Rectangle();
            line = new Line();
            text = new Text();
            point = new Point();
            
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
            else if(shapeToBeDrawn == FREEHAND)
            {
                point = new Point(e.getX(), e.getY());
                addFreehand(point);
                if(updateFreehand == true){
                    addFreehandColor(OUTLINE_COLOR);
                    addFreehandStrokeSize(STROKE_SIZE);
                    updateFreehand = false;
                }
            }
            repaint();                        
        }                   
        @Override
        public void mouseReleased(MouseEvent e){
            if(shapeToBeDrawn == RECT){//Creating a Rectangle
                if(shape.width != 0 || shape.height != 0){
                    addRectangle(shape, e.getComponent().getForeground(), OUTLINE_COLOR);            
                }
            }
            else if(shapeToBeDrawn == OVAL){//Creating an Oval
                if(shape.width != 0 || shape.height != 0){
                    addOval(shape, e.getComponent().getForeground(), OUTLINE_COLOR);            
                }
            }
            else if(shapeToBeDrawn == LINE){//Creating a Line
                if(line.x2 != 0 || line.y2 != 0){
                    addLine(line, OUTLINE_COLOR);
                }
            }
            else if(shapeToBeDrawn == TEXT){//Creating drawn Text                
                addText(text, OUTLINE_COLOR);
            }
            else if(shapeToBeDrawn == FREEHAND)
            {
                point = new Point(END_POINT, END_POINT);
                addFreehand(point);
                updateFreehand = true;
            }
            shape = null;
            line = null;
            text = null;            
        }
    }
}
