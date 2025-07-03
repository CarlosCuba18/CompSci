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


public class GUIPractice{
	public static void main(String[] args){
		MyFrame myFrame = new MyFrame();
		myFrame.optionPane();
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
*/