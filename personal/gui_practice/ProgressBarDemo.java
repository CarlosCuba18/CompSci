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

public class ProgressBarDemo{
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0,500); //can be (min num, max num) or ()

	ProgressBarDemo(){
		bar.setValue(0);
		bar.setBounds(0,0,450,50);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.BOLD,25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);



		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);

		fill();
	}
	public void fill(){
		int count = 500;
		while(count > 0){
			bar.setValue(count);
			try{
				Thread.sleep(50); //(millisecs = 0.001)	
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			count--;
		}//end while
		bar.setString("Dead :<");
	}

}