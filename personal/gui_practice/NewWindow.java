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


	public class NewWindow{
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Hello");

		NewWindow(){
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,500);
			frame.setLayout(null);
			frame.setVisible(true);	

			label.setBounds(0,0,100,50);
			label.setFont(new Font(null,Font.PLAIN,25));

			frame.add(label);
		}
	}//end of NewWindow