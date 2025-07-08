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
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JColorChooser;
import java.awt.event.KeyListener;


public class KeyListenerDemo extends JFrame implements KeyListener{
	
	KeyListenerDemo(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);

		this.addKeyListener(this);

		this.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e){ //caled when a key is typed, uses KeyChar, char output

	}
	@Override
	public void keyPressed(KeyEvent e){ // called when a physical key is presed down, uses KeyCode, int output

	}
	@Override
	public void keyReleased(KeyEvent e){ // called whenever a button is released
		System.out.println("You released key char: " + e.getKeyChar());
	}

}// end of class