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
	
	JLabel label;

	KeyListenerDemo(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);

		label = new JLabel();
		label.setBounds(0,0,100,100); 
		//can use imageicon instead of colored label
		label.setBackground(Color.red);
		label.setOpaque(true);

		this.add(label);
		this.addKeyListener(this);
		this.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e){ //caled when a key is typed, uses KeyChar, char output
		switch(e.getKeyChar()){
			case 'a': label.setLocation(label.getX()-10, label.getY());
				break;
			case 'w': label.setLocation(label.getX(),label.getY()-10);
				break;
			case 's': label.setLocation(label.getX(),label.getY()+10);
				break;
			case 'd': label.setLocation(label.getX()+10,label.getY());
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e){ // called when a physical key is presed down, uses KeyCode, int output
		switch(e.getKeyCode()){ //left = 37,up = 38,down = 40, right = 39
			case 37: label.setLocation(label.getX()-10, label.getY());
				break;
			case 38: label.setLocation(label.getX(),label.getY()-10);
				break;
			case 39: label.setLocation(label.getX()+10,label.getY());
				break;
			case 40: label.setLocation(label.getX(),label.getY()+10);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e){ // called whenever a button is released
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());
	}

}// end of class