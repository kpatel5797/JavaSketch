// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Vector;

public class Canvas extends JPanel{

    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;

    Vector<ShapeInfo> shapes = new Vector<ShapeInfo>();
    private Vector<ShapeInfo> tempShapes = new Vector<ShapeInfo>();
    ShapeInfo newShape = null;

    Controller myController;
    boolean finishDraw = true;

    public void addListeners() {
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                myController.setSelectedShape(null);
                myController.enableToolButtons();
                myController.chooser.setEnabled(true);
                if(myController.getCurrentTool() == tools.FILL) {
                    fillShape(e);
                }
                else if(myController.getCurrentTool() == tools.ERASER) {
                    eraseShape(e);
                }
                else if(myController.getCurrentTool() == tools.SELECTION) {
                    selectShape(e);
                }
                repaint();
            }

            public void mouseReleased(MouseEvent e){
                finishDraw = true;
                repaint();
                addShape();
            }
        
        });

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                if(myController.getCurrentTool() == tools.LINE) {
                    if(myController.getCurrentColor() != null && myController.getCurrentThickness() != 0) {
                        finishDraw = false;
                        newShape = new ShapeInfo(new Line2D.Double(startX, startY, endX, endY), myController.getCurrentColor(), myController.getCurrentThickness(), 1);
                        tempShapes.add(newShape);
                    }
                }
                else if(myController.getCurrentTool() == tools.CIRCLE) {
                    if(myController.getCurrentColor() != null && myController.getCurrentThickness() != 0) {
                        finishDraw = false;
                        int diameter = Math.max(Math.abs(endX-startX), Math.abs(endY-startY));
                        newShape = new ShapeInfo(new Ellipse2D.Double(Math.min(startX, endX), Math.min(startY, endY), diameter, diameter), myController.getCurrentColor(), myController.getCurrentThickness(), 2);
                        tempShapes.add(newShape);
                    }
                }
                else if(myController.getCurrentTool() == tools.RECTANGLE) {
                    if(myController.getCurrentColor() != null && myController.getCurrentThickness() != 0) {
                        finishDraw = false;
                        newShape = new ShapeInfo(new Rectangle2D.Double(Math.min(startX, endX), Math.min(startY, endY), Math.abs(endX-startX), Math.abs(endY-startY)), myController.getCurrentColor(), myController.getCurrentThickness(), 3);
                        tempShapes.add(newShape);
                    }
                }
                else if(myController.getCurrentTool() == tools.SELECTION) {
                    moveSelectedShape();

                }
                
                repaint();
            }
        });
    }

    public void moveSelectedShape() { //code similar to the example given in class
        if(myController.selectedShape != null) {
            double x_diff = endX-startX;
            double y_diff = endY-startY;
            AffineTransform transform = new AffineTransform();
            transform.translate(x_diff, y_diff);
            myController.selectedShape.shape = transform.createTransformedShape(myController.selectedShape.shape);
            startX = endX;
            startY = endY;
        }
    }

    public void selectShape(MouseEvent e) {
        myController.selectedShape = null;
        for(int i=shapes.size() - 1; i>=0; i--) {
            if(shapes.get(i).shape.contains(e.getX(), e.getY()) || 
            (shapes.get(i).shape.getBounds().contains(e.getX(), e.getY()) && (shapes.get(i).shape.intersects(e.getX()-2.5, e.getY()-2.5, 5, 5)))){
                myController.setSelectedShape(shapes.get(i));
                myController.disableToolButtons();
                myController.chooser.setEnabled(false);
                break;
            }
        }
    }

    public void eraseShape(MouseEvent e) {
        for(int i=shapes.size() - 1; i>=0; i--) {
            if(shapes.get(i).shape.contains(e.getX(), e.getY()) ||
            (shapes.get(i).shape.getBounds().contains(e.getX(), e.getY()) && (shapes.get(i).shape.intersects(e.getX()-2.5, e.getY()-2.5, 5, 5)))){
                shapes.get(i).shape = null;
                shapes.remove(i);   
                break;
            }
        }
    }

    public void fillShape(MouseEvent e) {
        for(int i=shapes.size() - 1; i>=0; i--) {
            if(shapes.get(i).shape.contains(e.getX(), e.getY())){
                shapes.get(i).fill = myController.getCurrentColor();
                break;
            }
        }
    }

    public void addShape() {
        if(newShape != null) {
            shapes.add(newShape);
            finishDraw = false;
        }
        tempShapes.clear();
        newShape = null;
    }

    public void paintComponent(Graphics g) { //taken from class example
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  // antialiasing look nicer
                            RenderingHints.VALUE_ANTIALIAS_ON);

        for(ShapeInfo drawShape : shapes) {
            drawShape.draw(g2, myController);
        }

        

        if (!finishDraw) {
            if (tempShapes.size() > 1) {
                tempShapes.get(tempShapes.size() - 1).draw(g2, myController);
            }
        }
    }
        
    public Canvas(Controller controller) {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black));
        this.setBackground(Color.WHITE);
        myController = controller;
        myController.setCurrentCanvas(this);

        addListeners();

        
    }
}