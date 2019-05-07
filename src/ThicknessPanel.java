// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class ThicknessPanel extends JPanel{

    Controller myController;
    JToggleButton light;
    JToggleButton medium;
    JToggleButton heavy;
    Vector <JToggleButton> thicknessButtonsVector = new Vector<JToggleButton>();

    ButtonGroup thicknessButtons;

    public void addListeners() {
        light.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                myController.setCurrentThickness(1);
                myController.notifyThickness(1);
                if(myController.selectedShape != null) {
                    myController.selectedShapeThickness(1);
                }
            }
        });

        medium.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentThickness(5);
                myController.notifyThickness(5);
                if(myController.selectedShape != null) {
                    myController.selectedShapeThickness(5);
                }
            }
        });

        heavy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentThickness(10);
                myController.notifyThickness(10);
                if(myController.selectedShape != null) {
                    myController.selectedShapeThickness(10);
                }
            }
        });
    }
        
    public ThicknessPanel(Controller controller) {
        myController = controller;

        this.setLayout(new GridLayout(3, 1));

        light = new JToggleButton();
        light.setIcon(new ImageIcon(((new ImageIcon("src//images//light.png")).getImage()).getScaledInstance(100, 75, Image.SCALE_SMOOTH)));
        light.setBackground(Color.black);
        light.setBorder(BorderFactory.createLineBorder(Color.black));
        thicknessButtonsVector.add(light);

        medium = new JToggleButton();
        medium.setIcon(new ImageIcon(((new ImageIcon("src//images//medium.png")).getImage()).getScaledInstance(100, 75, Image.SCALE_SMOOTH)));
        medium.setBackground(Color.black);
        medium.setBorder(BorderFactory.createLineBorder(Color.black));
        thicknessButtonsVector.add(medium);

        heavy = new JToggleButton();
        heavy.setIcon(new ImageIcon(((new ImageIcon("src//images//heavy.png")).getImage()).getScaledInstance(100, 75, Image.SCALE_SMOOTH)));
        heavy.setBackground(Color.black);
        heavy.setBorder(BorderFactory.createLineBorder(Color.black));
        thicknessButtonsVector.add(heavy);

        myController.setThicknessButtons(thicknessButtonsVector);

        thicknessButtons = new ButtonGroup();

        addListeners();

        thicknessButtons.add(light);
        thicknessButtons.add(medium);
        thicknessButtons.add(heavy);

        this.add(light);
        this.add(medium);
        this.add(heavy);

    }
}