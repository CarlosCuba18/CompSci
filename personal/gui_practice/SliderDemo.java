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

public class SliderDemo implements ChangeListener{

JFrame frame;
JPanel panel;
JLabel label;
JSlider slider;

SliderDemo(){
	frame = new JFrame("Slider Demo");
	panel = new JPanel();
	label = new JLabel();
	slider = new JSlider(0,100,50); //(min num, max num, starting pt)
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	slider.setPreferredSize(new Dimension(400,200));//(width,height)
	slider.setPaintTicks(true);
	slider.setMinorTickSpacing(10);

	slider.setPaintTrack(true);
	slider.setMajorTickSpacing(25);

	slider.setPaintLabels(true);

	panel.add(slider);
	panel.add(label);
	frame.add(panel);
	frame.setSize(500,500);
	frame.setVisible(true);

}

@Override
public void stateChanged(ChangeEvent e){

}

}//end of SliderDemo