// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class ColorPanel extends JPanel{

    Controller myController;

    JToggleButton red;
    JToggleButton blue;
    JToggleButton green;
    JToggleButton yellow;
    JToggleButton cyan;
    JToggleButton magenta;

    Vector <JToggleButton> colorButtonsVector = new Vector<JToggleButton>();
    ButtonGroup colorButtons;

    public void addListeners(){
        red.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.RED);
                myController.setChosenColor(Color.RED);
                myController.notifyColor(Color.RED);
                myController.setSelectedColorButton(red);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.RED);
                }
            }
        });

        blue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.BLUE);
                myController.setChosenColor(Color.BLUE);
                myController.notifyColor(Color.BLUE);
                myController.setSelectedColorButton(blue);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.BLUE);
                }
            }
        });

        green.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.GREEN);
                myController.setChosenColor(Color.GREEN);
                myController.notifyColor(Color.GREEN);
                myController.setSelectedColorButton(green);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.GREEN);
                }
            }
        });

        yellow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.YELLOW);
                myController.setChosenColor(Color.YELLOW);
                myController.notifyColor(Color.YELLOW);
                myController.setSelectedColorButton(yellow);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.YELLOW);
                }
            }
        });

        cyan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.CYAN);
                myController.setChosenColor(Color.CYAN);
                myController.notifyColor(Color.CYAN);
                myController.setSelectedColorButton(cyan);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.CYAN);
                }
            }
        });

        magenta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentColor(Color.MAGENTA);
                myController.setChosenColor(Color.MAGENTA);
                myController.notifyColor(Color.MAGENTA);
                myController.setSelectedColorButton(magenta);
                if(myController.selectedShape != null) {
                    myController.selectedShapeColor(Color.MAGENTA);;
                }
            }
        });
    }

        
    public ColorPanel(Controller controller) {
        myController = controller;

        this.setLayout(new GridLayout(3, 2));

        red = new JToggleButton();
        red.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(red);

        blue = new JToggleButton();
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(blue);

        green = new JToggleButton();
        green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(green);

        yellow = new JToggleButton();
        yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(yellow);

        cyan = new JToggleButton();
        cyan.setBackground(Color.CYAN);
        cyan.setOpaque(true);
        cyan.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(cyan);

        magenta = new JToggleButton();
        magenta.setBackground(Color.MAGENTA);
        magenta.setOpaque(true);
        magenta.setBorder(BorderFactory.createLineBorder(Color.black));
        colorButtonsVector.add(magenta);

        myController.setColorButtons(colorButtonsVector);

        colorButtons = new ButtonGroup();

        addListeners();

        colorButtons.add(red);
        colorButtons.add(blue);
        colorButtons.add(green);
        colorButtons.add(yellow);
        colorButtons.add(cyan);
        colorButtons.add(magenta);
        
        this.add(red);
        this.add(blue);
        this.add(green);
        this.add(yellow);
        this.add(cyan);
        this.add(magenta);
    }
}