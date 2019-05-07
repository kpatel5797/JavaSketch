// Parts of code may be from the class examples

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

class ShapeInfo implements Serializable{
        Shape shape;
        Color color;
        int shapeindex;
        int thickness;
        Color fill;

        ShapeInfo(Shape shape, Color color, int thickness, int shapeindex) {
                this.shape = shape;
                this.color = color;
                this.thickness = thickness;
                this.shapeindex = shapeindex;
        }

        public void draw(Graphics2D g, Controller controller) {
                if(fill != null) {
                        g.setColor(this.fill);
                        g.fill(this.shape);
                }
                g.setColor(this.color);
                if(this == controller.selectedShape) {
                        float dash[] = {10.0f};
                        BasicStroke dashed = new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f, dash, 0.0f);
                        g.setStroke(dashed);
                } else {
                        g.setStroke(new BasicStroke(this.thickness));
                }
                g.draw(this.shape);
        }
}