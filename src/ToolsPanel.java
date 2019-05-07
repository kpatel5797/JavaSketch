// Parts of code may be from the class examples

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


public class ToolsPanel extends JPanel{

    Controller myController;

    JToggleButton selectionTool;
    JToggleButton eraseTool;
    JToggleButton lineDraw;
    JToggleButton circleDraw;
    JToggleButton rectangleDraw;
    JToggleButton fillTool;

    Vector <JToggleButton> toolButtonsVector = new Vector<JToggleButton>();

    ButtonGroup toolButtons;

    public void addListeners(){
        selectionTool.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.SELECTION);
                notifyOthers(selectionTool);
            }
        });

        eraseTool.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.ERASER);
                notifyOthers(eraseTool);
            }
        });

        lineDraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.LINE);
                notifyOthers(lineDraw);
            }
        });

        circleDraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.CIRCLE);
                notifyOthers(circleDraw);
            }
        });

        rectangleDraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.RECTANGLE);
                notifyOthers(rectangleDraw);
            }
        });

        fillTool.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myController.setCurrentTool(tools.FILL);
                notifyOthers(fillTool);
            }
        });
    }

    private void notifyOthers(JToggleButton button) {
        selectionTool.setBorder(BorderFactory.createLineBorder(Color.black));
        eraseTool.setBorder(BorderFactory.createLineBorder(Color.black));
        lineDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        circleDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        rectangleDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        fillTool.setBorder(BorderFactory.createLineBorder(Color.black));

        button.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }
        
    public ToolsPanel(Controller controller) {

        myController = controller;

        this.setLayout(new GridLayout(3, 2));
        this.setSize(new Dimension(100, 100));

        selectionTool = new JToggleButton();
        selectionTool.setIcon(new ImageIcon(((new ImageIcon("src//images//selection.png")).getImage()).getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        selectionTool.setBackground(Color.black);
        selectionTool.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(selectionTool);

        
        eraseTool = new JToggleButton();
        eraseTool.setIcon(new ImageIcon(((new ImageIcon("src//images//eraser.png")).getImage()).getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        eraseTool.setBackground(Color.black);
        eraseTool.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(eraseTool);

        
        lineDraw = new JToggleButton();
        lineDraw.setIcon(new ImageIcon(((new ImageIcon("src//images//line.png")).getImage()).getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        lineDraw.setBackground(Color.black);
        lineDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(lineDraw);
        
        circleDraw = new JToggleButton();
        circleDraw.setIcon(new ImageIcon(((new ImageIcon("src//images//circle.png")).getImage()).getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        circleDraw.setBackground(Color.black);
        circleDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(circleDraw);
        
        rectangleDraw = new JToggleButton();
        rectangleDraw.setIcon(new ImageIcon(((new ImageIcon("src//images//rectangle.png")).getImage()).getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        rectangleDraw.setBackground(Color.black);
        rectangleDraw.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(rectangleDraw);
        
        fillTool = new JToggleButton();
        fillTool.setIcon(new ImageIcon(((new ImageIcon("src//images//fill.png")).getImage()).getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        fillTool.setBackground(Color.black);
        fillTool.setBorder(BorderFactory.createLineBorder(Color.black));
        toolButtonsVector.add(fillTool);

        myController.setToolButtons(toolButtonsVector);

        toolButtons = new ButtonGroup();

        addListeners();


        toolButtons.add(selectionTool);
        toolButtons.add(eraseTool);
        toolButtons.add(lineDraw);
        toolButtons.add(circleDraw);
        toolButtons.add(rectangleDraw);
        toolButtons.add(fillTool);

        this.add(selectionTool);
        this.add(eraseTool);
        this.add(lineDraw);
        this.add(circleDraw);
        this.add(rectangleDraw);
        this.add(fillTool);
    }
}