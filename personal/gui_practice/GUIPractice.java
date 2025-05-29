import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import
import javax.swing.JLabel;

public class GUIPractice{
	public static void main(String[] args){
		//MyFrame myFrame = new MyFrame();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);

		//label needs frame^
		JLabel label = new JLabel(); //creates label; can pass in text instead of setText
		label.setText("Testing Label"); //sets text
		frame.add(label); // adds label to frame

		ImageIcon image = new ImageIcon("picture.png"); // works for Gif, jpeg, png, and xbm
		label.setIcon(image); //puts image inside frame

		//sets location of texts
		label.setHorizontalTextPosition(JLabel.CENTER); //Jlabel.* with * being LEFT, CENTER, RIGHT of image icon
		label.setVerticalTextPosition(JLabel.TOP); // TOP, CENTER, or BOTTOM of icon

		//sets text's color and font
		label.setForeground(Color.green); //pass in color with set constants, hex value, or RGB
		label.setFont(new Font("MV Boli",Font.PLAIN,20));


	}//end of main method

}// end of class