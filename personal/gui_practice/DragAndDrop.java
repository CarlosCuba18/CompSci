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

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;


public class DragAndDrop extends JPanel{
	ImageIcon image = new ImageIcon("croc.png");
	final int WIDTH = image.getIconWidth();
	final int HEIGHT = image.getIconHeight();
	Point imageCorner;
	Point prevPt;


	DragAndDrop(){
		imageCorner = new Point(0,0);
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		image.paintIcon(this,g,(int)imageCorner.getX(),(int)imageCorner.getY()); //(frame, graphic, x pt, y pt)
	}



	private class ClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			prevPt = e.getPoint();
		}
	}//end of ClickListener

	public class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
			Point currentPt = e.getPoint();
			imageCorner.translate((int)(currentPt.getX() - prevPt.getX()),(int)(currentPt.getY() - prevPt.getY()));
			prevPt = currentPt;
			repaint();
		}
	}//end of DragListener

}// end of DragAndDrop class