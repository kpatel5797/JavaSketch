// Parts of code may be taken from the class examples

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

public class JavaSketch  extends JFrame{

    static JFrame window;

    public JavaSketch(String s){
        super(s);

        Controller myController = new Controller();

        ToolsPanel toolspanel = new ToolsPanel(myController);
        ColorPanel colorpanel = new ColorPanel(myController);
        ChooserPanel chooserpanel = new ChooserPanel(myController);
        ThicknessPanel thicknesspanel = new ThicknessPanel(myController);
        Canvas canvas = new Canvas(myController);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");

        newItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(ShapeInfo shape : canvas.shapes) {
                    shape.shape = null;
                }
                myController.selectedShape = null;
                myController.enableToolButtons();
                myController.chooser.setEnabled(true);
                canvas.shapes.clear();
                canvas.repaint();
            }
        });

        loadItem.setEnabled(false);

        saveItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save");
                int userChoice = fileChooser.showSaveDialog(window);

                if(userChoice == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        if(!file.getPath().endsWith(".jsketch")) {
                            file = new File(file.getPath() + ".jsketch");
                        }
                        FileOutputStream fos = new FileOutputStream(file);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        for(ShapeInfo shape : canvas.shapes) {
                            oos.writeObject(shape);
                        }
                        oos.close();
                        fos.close();
                        
                    }
                    catch (IOException exception) {
                        System.out.println(exception);
                    }
                }
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher(){
            public boolean dispatchKeyEvent(KeyEvent k) {
                if(k.getID() == KeyEvent.KEY_PRESSED && k.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    myController.selectedShape = null;
                    myController.enableToolButtons();
                    myController.chooser.setEnabled(true);
                    canvas.repaint();
                    return true;
                }
                return false;
            }
        });

        menu.add(newItem);
        menu.add(loadItem);
        menu.add(saveItem);
        menubar.add(menu);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        panel.add(toolspanel);
        panel.add(colorpanel);
        panel.add(chooserpanel);
        panel.add(thicknesspanel);

        this.add(panel, BorderLayout.WEST);
        this.getContentPane().add(canvas);
        this.setJMenuBar(menubar);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }
        
    public static void main(String[] args) {
 
        window = new JavaSketch("JavaSketch");
        
    }
}