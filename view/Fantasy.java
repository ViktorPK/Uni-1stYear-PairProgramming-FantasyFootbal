package umarviktor.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Umar
 * @author Viktor
 * This class represents the formation chooser,the football field, the bench and the football team
 */
public class Fantasy extends JFrame {

    private JComboBox box;
    private JPanel pitch;
    private JPanel bench;
    private JPanel defense;
    public JPanel midfield;
    private JPanel attack;
    private JPanel goalie;
    private JButton imagePrompt;
    private JLabel image;
    private JPanel playerPanel;
    private JPanel newPanel;
    private JButton button2;
    private JTextField nameField;
    private Dimension minSize=new Dimension(520,600);
    
    /**
     * Class constructor. Creates a custom JFrame named "Fantasy football" which has a field that is separated in 4, a bench, and a combo box to choose formations from
     */
    public Fantasy() {
        super("Fantasy football");
        setUp();
        setVisible(true);                                                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(minSize);				
    }

    /**
     * creates the combo box, the pitch panel, the bench panel, and the panels for the different roles
     */
    private void setUp(){						//creates the combo box, the pitch panel, the bench panel, and the panels for the different roles
    	setLayout(new BorderLayout());
        String formation[] = {"Select formation","4-4-2","3-4-3","4-3-3", "3-5-2","5-3-2","3-4-3","4-5-1"};
        box = new JComboBox(formation);      
        
        pitch = new JPanel(new GridLayout(4, 1));
        bench = new JPanel();

        add(box, BorderLayout.NORTH);
        add(pitch, BorderLayout.CENTER);
        add(bench, BorderLayout.SOUTH);

        goalie = new JPanel();
        goalie.setBackground(Color.green);       
        defense = new JPanel();
        defense.setBackground(Color.green);
        midfield = new JPanel();
        midfield.setBackground(Color.green);
        attack = new JPanel();
        attack.setBackground(Color.green);
        pitch.add(goalie);
        pitch.add(defense);
        pitch.add(midfield);
        pitch.add(attack);
        bench.setBackground(Color.gray);
        bench.setBorder(BorderFactory.createLineBorder(Color.black));	
        playerPanel = new JPanel();
        imagePrompt = new JButton("+");
    }

    /**
     * adds a goalkeeper at his designated location
     * @param id the id of the player
     * @param path the path to his image
     * @param name the name of the player
     */
    public void addPlayerAtGoal(int id, String path, String name) {//adds a goalkeeper at his designated location
        if (goalie.getComponents().length < 1) {
            goalie.add(createPanel(path, id, name));
        } else {
        	bench.add(createPanel(path, id, name));
        }
    }
    /**
     * adds a striker at his designated location
     * @param id the id of the player
     * @param path the path to his image
     * @param name the name of the player
     */
    public void addPlayerAtStike(int id, String path, String name, int strikeFormation) {//adds a striker at his designated location
        if (attack.getComponents().length < strikeFormation) {
            attack.add(createPanel(path, id, name));
        } else {
            bench.add(createPanel(path, id, name));
        }
    }
    /**
     * adds a midfielder at his designated location
     * @param id the id of the player
     * @param path the path to his image
     * @param name the name of the player
     */
    public void addPlayerAtMid(int id, String path, String name, int midFormation) {//adds a midfielder at his designated location
        if (midfield.getComponents().length < midFormation) {
            midfield.add(createPanel(path, id, name));
        } else {
            bench.add(createPanel(path, id, name));
        }

    }
    /**
     * adds a defender at his designated location
     * @param id the id of the player
     * @param path the path to his image
     * @param name the name of the player
     */
    public void addPlayerAtDef(int id, String path, String name, int defFormation) { //adds a defender at his designated location
        if (defense.getComponents().length < defFormation) {
            defense.add(createPanel(path, id, name));
        } else {
            bench.add(createPanel(path, id, name));
        }
    }
    
    /**
     * //adds an actiontListener for the combo box
     * @param listener the action listener
     */
    public void addActionforBox(ActionListener listener) { //adds and actionListener to the combo box
        box.addActionListener(listener);
    }
    
    /**
     * //adds an actionListener for the button of the player
     * @param listener the action listener
     */
    public void addActionForButton(ActionListener listener) { //adds an actionListener to the button of the player
        button2.addActionListener(listener);
    }
    
    /**
     * //adds a documentListener for the textField of the player
     * @param listener the DocumentListener
     */
    public void addActionForNameField(DocumentListener listener) { //adds a documentListener for the textField of the player
        nameField.getDocument().addDocumentListener(listener);
    }
    
    /**
     * gets the string chosen from the combo box
     * @return the string chosen from the combo box
     */
    public String getSelectedItem() { //gets the string chosen from the combo box
        return (String) box.getSelectedItem();
    }
    /**
     * clears the contents of all panels
     */ 
    public void clear() { //clears the contents of all panels
        attack.removeAll();
        midfield.removeAll();
        defense.removeAll();
        goalie.removeAll();
        bench.removeAll();

    }
    
    /**
     * assigns the players image to his button and disables this button
     * @param button the button to be changed
     * @param path the path of the image
     */
    public void setImageOnButton(JButton button, String path) { //assigns the players image to his button and disables this button
        try {
            Image icon = ImageIO.read(new File(path));
            button.setText(""); 	
            button.setIcon(new ImageIcon(icon));
            button.setPreferredSize(new Dimension(icon.getWidth(button), icon.getHeight(button)));
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setDisabledIcon(button.getIcon());
            button.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(Fantasy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Creates a new PlayerPanel
     * @param path path of the image for the player
     * @param id id of the player
     * @param name name of the player
     * @return the newly created panel
     */
    public JPanel createPanel(String path, int id, String name) { //Creates a new PlayerPanel
        newPanel = new JPanel(new BorderLayout());
        button2 = new JButton("+");
        
        if(!(path.equalsIgnoreCase("None"))){
            setImageOnButton(button2,path);
        }
        
        button2.setName(String.valueOf(id));
        nameField = new JTextField(name);
        nameField.getDocument().putProperty("Key", nameField);
        nameField.setName(String.valueOf(id));
        newPanel.add(button2, BorderLayout.CENTER);
        newPanel.add(nameField, BorderLayout.SOUTH);
        return newPanel;
    }
    /**
     * updates the contents of all panels
     */
    public void updateAllPanel() { //updates the contents of all panels
        attack.revalidate();
        attack.repaint();
        midfield.revalidate();
        midfield.repaint();
        defense.revalidate();
        defense.repaint();
        pitch.revalidate();
        pitch.repaint();
        bench.revalidate();
        bench.repaint();
        revalidate();
        repaint();
    }
}
