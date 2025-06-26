import javax.swing.JFrame; //import for frame
import java.awt.Color; // color import
import javax.swing.ImageIcon; //image icon import
import javax.swing.JLabel;
import javax.swing.border.Border;//border import
import javax.swing.BorderFactory; //import border factory
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame{ //makes MyFrame a child of JFrame, so it can call methods from JFrame
	MyFrame(){
	} //end of constructor

	public void makeFrame(){
		//JFrame frame = new JFrame(); //creates new frame; in this case MyFrame extends Jframe so no object needs to be created
		this.setTitle("JFrame Title goes here"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes X close the entire program (default is HIDE_ON_CLOSE)
		this.setResizable(false); // makes it (not)possible to change size
		this.setSize(420,420); //sets x and y dimentions
		this.setVisible(true); //makes it see-able
		this.getContentPane().setBackground(Color.blue); //sets color of background
		//all to change image in corner of page
		ImageIcon image = new ImageIcon("picture.png"); //put path of image or name if in same file into argument
		this.setIconImage(image.getImage()); //changes image in corner
		//frame.getContentPane().setBackground(new Color(a)); where a is a RGB value OR hex color value	
			// new Color(0,0,0) makes black (all ranges of 0-255) in order of red,green,blue
			// new Color(0xFFFFFF) makes white
	}
	public void makeLabel(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1000,1000);

		//making label; label needs frame^
		JLabel label = new JLabel(); //creates label; can pass in text instead of setText
		label.setText("Testing Label"); //sets text
		frame.add(label); // adds label to frame

		//adding image to label
		ImageIcon image = new ImageIcon("picture.png"); // works for Gif, jpeg, png, and xbm
		label.setIcon(image); //puts image inside frame

		//sets location of texts
		label.setHorizontalTextPosition(JLabel.CENTER); //Jlabel.* with * being LEFT, CENTER, RIGHT of image icon
		label.setVerticalTextPosition(JLabel.TOP); // TOP, CENTER, or BOTTOM of icon

		//sets text's color and font(fix font)
		label.setForeground(Color.green); //pass in color with set constants, hex value, or RGB
		//label.setFont(new Font("MV Boli",Font.PLAIN,20)); //set font
		label.setIconTextGap(-25); //set gap of text to image

		//set background color
		label.setBackground(Color.black); //set background color
		label.setOpaque(true); //display background color

		//making border(fix later)
		//Border border = new BorderFactory.createLineBorder(Color.blue, 3); //makes border color, passes in color and width of border
		//label.setBorder(border);

		//moving image
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		//make label a fixed size (works but using pack method)
		//frame.setLayout(null);
		//label.setBounds(0,0,250,250); //(x,y,dimention,dimention); x,y is starting pt, dimentions are how big it is
		frame.pack();//automatically adjust frame to things inside label; use this method last after adding everything else (reason why its small lol)
	}




}// end of class