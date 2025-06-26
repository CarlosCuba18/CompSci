import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import
import javax.swing.JLabel;
import javax.swing.border.Border;//border import
import javax.swing.BorderFactory; //import border factory
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

public class GUIPractice{
	public static void main(String[] args){
		//MyFrame myFrame = new MyFrame();
		//myFrame.makeLabel();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null); //gonna learn about layout managers later
		frame.setVisible(true);
		frame.setSize(750,750);

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,250,250); //(x,y,width,height)with no layout manager, need to set bounds and locations manually
		frame.add(redPanel);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250,0,250,250);
		frame.add(bluePanel);

		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,250,500,250);
		frame.add(greenPanel);

		JLabel label = new JLabel();
		label.setText("Hello");
		ImageIcon icon = new ImageIcon("picture.png");
		label.setIcon(icon);
		redPanel.add(label);





	}//end of main method

}// end of class