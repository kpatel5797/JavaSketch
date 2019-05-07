// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class ChooserPanel extends JPanel{

    Controller myController;

    Color newColor;
    JPanel title;
    JPanel colorButtons;
    JPanel chosenColor;
    JButton chooser;
    JToggleButton color1;
    JToggleButton color2;
    ButtonGroup buttons = new ButtonGroup();
    Vector <JToggleButton> colors = new Vector<JToggleButton>();

    public void addListeners() {
        chooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newColor = JColorChooser.showDialog(null, "Color Chooser", Color.black);
                if (newColor != null) {
                    myController.setCurrentColor(newColor);
                    myController.setChosenColor(newColor);
                    color1.setBorder(BorderFactory.createLineBorder(Color.black));
                    color2.setBorder(BorderFactory.createLineBorder(Color.black));
                    if(myController.getSelectedColorButton() != null) {
                        myController.getSelectedColorButton().setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                }
            }
        });

        color1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e) && myController.selectedShape == null) {
                    newColor = JColorChooser.showDialog(null, "Color Chooser", Color.black);
                    if (newColor != null) {
                        color1.setBackground(newColor);
                        color1.setOpaque(true);
                        color1.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        color2.setBorder(BorderFactory.createLineBorder(Color.black));
                        myController.setCurrentColor(newColor);
                        myController.setChosenColor(newColor);
                        if(myController.getSelectedColorButton() != null) {
                            myController.getSelectedColorButton().setBorder(BorderFactory.createLineBorder(Color.black));
                        }
                    }
                }
                else {
                    myController.setCurrentColor(color1.getBackground());
                    myController.setChosenColor(color1.getBackground());
                    color1.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    color2.setBorder(BorderFactory.createLineBorder(Color.black));
                    if(myController.getSelectedColorButton() != null) {
                        myController.getSelectedColorButton().setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                    if(myController.selectedShape != null) {
                        myController.selectedShapeColor(color1.getBackground());
                    }
                }
            }
        });

        color2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e) && myController.selectedShape == null) {
                    newColor = JColorChooser.showDialog(null, "Color Chooser", Color.black);
                    if (newColor != null) {
                        color2.setBackground(newColor);
                        color2.setOpaque(true);
                        color2.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        color1.setBorder(BorderFactory.createLineBorder(Color.black));
                        myController.setCurrentColor(newColor);
                        myController.setChosenColor(newColor);
                        if(myController.getSelectedColorButton() != null) {
                            myController.getSelectedColorButton().setBorder(BorderFactory.createLineBorder(Color.black));
                        }
                    }
                }
                else {
                    myController.setCurrentColor(color2.getBackground());
                    myController.setChosenColor(color2.getBackground());
                    color1.setBorder(BorderFactory.createLineBorder(Color.black));
                    color2.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    if(myController.getSelectedColorButton() != null) {
                        myController.getSelectedColorButton().setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                    if(myController.selectedShape != null) {
                        myController.selectedShapeColor(color2.getBackground());
                    }
                }
            }
        });
    }


    public ChooserPanel(Controller controller) {
        myController = controller;
        this.setLayout(new GridLayout(4, 2));

        title = new JPanel();
        JLabel mainTitle = new JLabel("Custom Palette");

        colorButtons = new JPanel();
        colorButtons.setLayout(new GridLayout(1, 2));

        color1 = new JToggleButton();
        color2 = new JToggleButton();
        buttons.add(color1);
        buttons.add(color2);
        colorButtons.add(color1);
        colorButtons.add(color2);
        color1.setBackground(Color.ORANGE);
        color1.setOpaque(true);
        color1.setBorder(BorderFactory.createLineBorder(Color.black));
        color2.setBackground(Color.GRAY);
        color2.setOpaque(true);
        color2.setBorder(BorderFactory.createLineBorder(Color.black));
        
        chosenColor = new JPanel();
        chosenColor.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        JLabel label = new JLabel("Current Color");
        chooser = new JButton("CHOOSER");

        colors.add(color1);
        colors.add(color2);
        myController.setCustomPalette(colors);
        myController.setChooserButton(chooser);

        this.add(title);
        this.add(colorButtons);
        this.add(chooser);
        this.add(chosenColor);

        myController.initChosenColorPanel(chosenColor);

        title.add(mainTitle);
        chosenColor.add(label);

        addListeners();
    }
}