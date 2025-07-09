import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import
import javax.swing.JLabel;
import javax.swing.border.Border;//border import
import javax.swing.BorderFactory; //import border factory
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;

public class GUIPractice{
	public static void main(String[] args){
		MyFrame myFrame = new MyFrame();
		myFrame.mouseListener();
	}//end of main method
}// end of class

/*
KEY for methods
----------
makeFrame
makeLabel
makePanel
makeButton
useBorderLayout
useFlowLayout
useGridLayout
LayeredPane
openNewWindow
optionPane
textFields
checkBoxes
radioButton
comboBox
slider
progressBar
menuBar
selectAFile
colorChooser
keyListener
mouseListener
*/