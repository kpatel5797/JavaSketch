// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;


enum tools {
        SELECTION, ERASER, LINE, CIRCLE, RECTANGLE, FILL
}

public class Controller {

        private tools currentTool = null;
        private Color currentColor = null;
        private int currentThickness = 0;
        ShapeInfo selectedShape = null;
        Canvas currentCanvas = null;

        Vector <JToggleButton> toolButtonsVector = new Vector<JToggleButton>();
        Vector <JToggleButton> thicknessButtonsVector = new Vector<JToggleButton>();
        Vector <JToggleButton> colorButtonsVector = new Vector<JToggleButton>();
        Vector <JToggleButton> customColorButtonsVector = new Vector<JToggleButton>();
        private JPanel chosenColor;
        private JToggleButton selectedColorButton;
        JButton chooser;

        public void setCurrentTool(tools tool){
                currentTool = tool;

        }

        public tools getCurrentTool() {
                return currentTool;
        }

        public void setCurrentColor(Color color){
                currentColor = color;

        }

        public Color getCurrentColor() {
                return currentColor;
        }

        public void initChosenColorPanel(JPanel chosencolor) {
                chosenColor = chosencolor;
        }

        public void setChosenColor(Color color) {
                chosenColor.setBackground(color);
        }

        public void setSelectedColorButton(JToggleButton button) {
                selectedColorButton = button;
        }

        public JToggleButton getSelectedColorButton() {
                return selectedColorButton;
        }

        public void setCurrentThickness(int thickness) {
                currentThickness = thickness;
        }

        public int getCurrentThickness() {
                return currentThickness;
        }

        public void setSelectedShape(ShapeInfo shape) {
                selectedShape = shape;
                if(selectedShape != null) {
                        currentColor = selectedShape.color;
                        currentThickness = selectedShape.thickness;
                        setChosenColor(currentColor);
                        notifyThickness(currentThickness);
                        notifyColor(currentColor);
                }
        }

        public void setCurrentCanvas(Canvas canvas) {
                currentCanvas = canvas;
        }

        public void setToolButtons(Vector<JToggleButton> buttons) {
                for(JToggleButton button : buttons) {
                        toolButtonsVector.add(button);
                }
        }

        public void disableToolButtons() {
                if(selectedShape != null) {
                        for(int i=1; i<toolButtonsVector.size(); i++) {
                                toolButtonsVector.get(i).setEnabled(false);
                        }
                }
        }
        
        public void enableToolButtons() {
                if(selectedShape == null) {
                        for(int i=1; i<toolButtonsVector.size(); i++) {
                                toolButtonsVector.get(i).setEnabled(true);
                        }
                }
        }

        public void setThicknessButtons(Vector<JToggleButton> buttons) {
                for(JToggleButton button : buttons) {
                        thicknessButtonsVector.add(button);
                }
        }

        public void selectedShapeThickness(int thicknessNumber) {
                selectedShape.thickness = thicknessNumber;
                currentThickness = thicknessNumber;
                notifyThickness(thicknessNumber);
                currentCanvas.repaint();
        }

        public void notifyThickness(int thicknessNumber) {
                for(JToggleButton button : thicknessButtonsVector) {
                        button.setBorder(BorderFactory.createLineBorder(Color.black));
                }

                if(thicknessNumber == 1) {
                        thicknessButtonsVector.get(0).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(thicknessNumber == 5) {
                        thicknessButtonsVector.get(1).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(thicknessNumber == 10) {
                        thicknessButtonsVector.get(2).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
        }

        public void setColorButtons(Vector<JToggleButton> buttons) {
                for(JToggleButton button : buttons) {
                        colorButtonsVector.add(button);
                }
        }

        public void selectedShapeColor(Color color) {
                selectedShape.color = color;
                currentColor = color;
                notifyColor(color);
                currentCanvas.repaint();
        }

        public void notifyColor(Color color) {
                for(JToggleButton button : colorButtonsVector) {
                        button.setBorder(BorderFactory.createLineBorder(Color.black));
                }

                for(JToggleButton button : customColorButtonsVector) {
                        button.setBorder(BorderFactory.createLineBorder(Color.black));
                }

                if(color == Color.RED) {
                        colorButtonsVector.get(0).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(color == Color.BLUE) {
                        colorButtonsVector.get(1).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(color == Color.GREEN) {
                        colorButtonsVector.get(2).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(color == Color.YELLOW) {
                        colorButtonsVector.get(3).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(color == Color.CYAN) {
                        colorButtonsVector.get(4).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                else if(color == Color.MAGENTA) {
                        colorButtonsVector.get(5).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }
                
                for(JToggleButton button : customColorButtonsVector) {
                        if(color == button.getBackground()) {
                                button.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                                break;
                        }
                }
        }

        public void setCustomPalette(Vector<JToggleButton> buttons) {
                for(JToggleButton button : buttons) {
                        customColorButtonsVector.add(button);
                }
        }

        public void setChooserButton(JButton button) {
                chooser = button;
        }
}