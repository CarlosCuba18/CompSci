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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class MouseListnerDemo extends JFrame implements MouseListener{

	JLabel label;
	
	MouseListnerDemo(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.setLocationRelativeTo(null); //puts in center

		label = new JLabel();
		label.setBounds(0,0,100,100);
		label.setBackground(Color.red);
		label.setOpaque(true);
		label.addMouseListener(this);

		this.add(label);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e){
		//called when mouse button has been clicked (pressed and released) on a component
		System.out.println("You clicked me tehehe");
	}
	@Override
	public void mousePressed(MouseEvent e){
		//called when mouse has been clicked on a component
		System.out.println("You pressed me tehehe");
		label.setBackground(Color.yellow);
	}
	@Override
	public void mouseReleased(MouseEvent e){
		//called when a mouse has been released on a component
		System.out.println("You released your hold on me");
		label.setBackground(Color.green);
	}
	@Override
	public void mouseEntered(MouseEvent e){
		//called when it enters the area of a component
		System.out.println("Hello");
		label.setBackground(Color.blue);
	}
	@Override
	public void mouseExited(MouseEvent e){
		//called when it exits the area of a component
		System.out.println("Hey come back :(");
		label.setBackground(Color.red);
	}
}