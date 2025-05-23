import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import

public class GUIPractice{
	public static void main(String[] args){
		/*
		JFrame frame = new JFrame(); //creates new frame
		frame.setTitle("JFrame Title goes here"); //sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes X close the entire program (default is HIDE_ON_CLOSE)
		frame.setResizable(false); // makes it not possible to change size
		frame.setSize(420,420); //sets x and y dimentions
		frame.setVisible(true); //makes it see-able

		//all to change image in corner of page
		//ImageIcon image = new ImageIcon(""); //put path of image or name if in same file into argument
		// frame.setIconImage(image.getImage()); //changes image in corner

		frame.getContentPane().setBackground(Color.green); //sets color of background
		//frame.getContentPane().setBackground(new Color(a)); where a is a RGB value OR hex color value
		// new Color(0,0,0) makes black (all ranges of 0-255) in order of red,green,blue
		// new Color(0xFFFFFF) makes white
		*/

		MyFrame myFrame = new MyFrame();
	}//end of main method

}// end of class