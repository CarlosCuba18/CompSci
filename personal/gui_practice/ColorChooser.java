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

public class ColorChooser extends JFrame implements ActionListener{
		
	JButton button;
	JLabel label;
	
	ColorChooser(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		button = new JButton("Pick a Color");
		button.addActionListener(this);

		label = new JLabel();
		label.setBackground(Color.white);
		label.setText("This is some Text");
		label.setFont(new Font("MV Boli",Font.BOLD,100));
		label.setOpaque(true);

		this.add(button);
		this.add(label);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			JColorChooser colorChooser = new JColorChooser();

			Color color = JColorChooser.showDialog(null,"Pick a Color, I guess", Color.black); //(parent component, title, initial color)
			//label.setForeground(color);
			label.setBackground(color);
		}
	}
}