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

public class SelectAFile extends JFrame implements ActionListener{

	JButton button;
	
	SelectAFile(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		button = new JButton("Select File");
		button.addActionListener(this);

		this.add(button);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setCurrentDirectory(new File(".")); //"." sets to current directory, otherwise put file path

			//returns 0 if file is chosen, returns 1 if file chooser is x'ed out of
			//int response = fileChooser.showOpenDialog(null); // select file to open
			int response = fileChooser.showSaveDialog(null); // select file to save

			if (response == JFileChooser.APPROVE_OPTION){ //same as (response == 0)
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
		}
	}
}// end of SelectAFile