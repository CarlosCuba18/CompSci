import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import

public class MyFrame extends JFrame{ //makes MyFrame a child of JFrame, so it can call methods from JFrame
	MyFrame(){
		this.setTitle("JFrame Title goes here"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes X close the entire program (default is HIDE_ON_CLOSE)
		this.setResizable(false); // makes it (not)possible to change size
		this.setSize(420,420); //sets x and y dimentions
		this.setVisible(true); //makes it see-able
		this.getContentPane().setBackground(Color.blue); //sets color of background
		//frame.getContentPane().setBackground(new Color(a)); where a is a RGB value OR hex color value	
	}//end of constructor
}// end of class