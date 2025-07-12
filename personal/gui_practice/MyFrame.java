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


/*
KEY for methods
----------
makeFrame
makeLabel
makePanel
makeButton
useBorderLayout
useFlowLayout
useGridLayout
LayeredPane
openNewWindow
optionPane
textFields
checkBoxes
radioButton
comboBox
slider
*/

public class MyFrame extends JFrame implements ActionListener{ //makes MyFrame a child of JFrame, so it can call methods from JFrame
	//button
	JButton button;
	JLabel lab;

	//text field
	JButton textButton;
	JTextField field;

	//check box
	JButton checkButton;
	JCheckBox checkBox;
	ImageIcon xIcon;
	ImageIcon checkIcon;

	//radio button
	JRadioButton pizzaButton;
	JRadioButton burgerButton;
	JRadioButton hotDogButton;

	//combo box
	JComboBox combo;

	//dragAndDrop
	DragAndDrop dragPanel = new DragAndDrop();


	MyFrame(){
	} //end of constructor


	public void slider(){
		//uses SliderDemo
		SliderDemo sliderDemo = new SliderDemo();
	}

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
	public void makePanel(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null); //gonna learn about layout managers later
		frame.setVisible(true);
		frame.setSize(1500,1000);

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,500,500); //(x,y,width,height)with no layout manager, need to set bounds and locations manually
		frame.add(redPanel);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(500,0,500,500);
		frame.add(bluePanel);

		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,500,1000,500);
		frame.add(greenPanel);

		JLabel label = new JLabel();
		label.setText("Hello");
		ImageIcon image = new ImageIcon("picture.png");
		label.setIcon(image);
		greenPanel.setLayout(new BorderLayout());
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		//label.setBounds(100,100,50,50);
		greenPanel.add(label);
}

	public void makeButton(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500,500);
		frame.setVisible(true);

		button = new JButton(); //needs implement ActionListener
		button.setBounds(100,100,250,100);
		button.addActionListener(this);
		/* button.addActionListener(e -> System.out.println("yo")); // lambda expression that doesn't use actionPreformed or implements */
		button.setText("I'm a button");
		button.setFocusable(false); //gets rid of border around text

		ImageIcon icon = new ImageIcon("picture.png");
		//button.setIcon(icon); //puts image on button
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans", Font.BOLD,25));
		button.setIconTextGap(-10);
		button.setForeground(Color.blue);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		//button.setEnabled(false); //turns off a button

		lab = new JLabel();
		lab.setIcon(icon);
		lab.setBounds(150,250,150,150);
		lab.setVisible(false);
		frame.add(lab);


		frame.add(button);
	}
	public void useBorderLayout(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(10,10)); //used to set pixel width,length //can be empty parameter

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		panel1.setBackground(Color.blue);
		panel2.setBackground(Color.red);
		panel3.setBackground(Color.green);
		panel4.setBackground(Color.yellow);
		panel5.setBackground(Color.magenta);

		panel1.setPreferredSize(new Dimension(100,100));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,100));
		panel5.setPreferredSize(new Dimension(100,100));

		//-------------------Sub Panels----------------------

		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();

		panel6.setBackground(Color.black);
		panel7.setBackground(Color.darkGray);
		panel8.setBackground(Color.gray);
		panel9.setBackground(Color.lightGray);
		panel10.setBackground(Color.white);

		panel5.setLayout(new BorderLayout());

		panel6.setPreferredSize(new Dimension(50,50));
		panel7.setPreferredSize(new Dimension(50,50));
		panel8.setPreferredSize(new Dimension(50,50));
		panel9.setPreferredSize(new Dimension(50,50));
		panel10.setPreferredSize(new Dimension(50,50));

		panel5.add(panel6,BorderLayout.NORTH);
		panel5.add(panel7,BorderLayout.SOUTH);
		panel5.add(panel8,BorderLayout.WEST);
		panel5.add(panel9,BorderLayout.EAST);
		panel5.add(panel10,BorderLayout.CENTER);

		//----------------end subpanels ---------------------

		//priority is center,north/south, then east/west in overlap
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.WEST);
		frame.add(panel3,BorderLayout.EAST);
		frame.add(panel4,BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);
	}
	public void useFlowLayout(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); //(LEADING==left//CENTER(same as empty argument)//TRAILING==right,horizontal spacing int, vertical spacing int)
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250,250));
		panel.setBackground(Color.lightGray);
		panel.setLayout(new FlowLayout());

		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));

		frame.add(panel);
		frame.setVisible(true); //sets true at end will help things disapearing show up
	}
	public void useGridLayout(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout(3,3,10,10));//(rows,columns,hoizontal space,vertical spacing)

		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		//frame.add(new JButton("10"));

		frame.setVisible(true);
	}

	public void LayeredPane(){
		JFrame frame = new JFrame("Layered Pane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);

		JLayeredPane p1 = new JLayeredPane();
		p1.setBounds(0,0,500,500);
		frame.add(p1);

		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.red);
		label1.setBounds(50,50,200,200);

		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.green);
		label2.setBounds(100,100,200,200);

		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.blue);
		label3.setBounds(150,150,200,200);

		// order from bottom to top is Default,Palette,Modal,PopUp,Drag... ex: (JLayeredPane.DEFAULT_LAYER)
		// can also use wrapper Integer class for vaules

		p1.add(label1, Integer.valueOf(0));
		p1.add(label2, Integer.valueOf(2));
		p1.add(label3, Integer.valueOf(1));

		frame.setVisible(true);
	}
	public void openNewWindow(){
		LaunchPage launch = new LaunchPage();
		//uses LaunchPage and NewWindow files
	}

	public void optionPane(){
		//JOptionPane.showMessageDialog(null,"This is some info","Title",JOptionPane.PLAIN_MESSAGE); //(parent component, message,title,message type)
		//JOptionPane.showMessageDialog(null,"This is some info","Title",JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null,"This is some info","Title",JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showMessageDialog(null,"This is some info","Title",JOptionPane.WARNING_MESSAGE);
		//JOptionPane.showMessageDialog(null,"This is some info","Title",JOptionPane.ERROR_MESSAGE);

		//JOptionPane.showConfirmDialog(null,"do you code??","title",JOptionPane.YES_NO_CANCEL_OPTION);
		//System.out.println(JOptionPane.showConfirmDialog(null,"do you code??","title",JOptionPane.YES_NO_CANCEL_OPTION));
		//yes=0,no=1,cancel=2,x on corner=-1

		//String name = JOptionPane.showInputDialog("What is your name???");
		//System.out.println("Hello, " + name + "!");

		String[] options = {"No, You're Awesome", "Thank You", "*blush*"};
		JOptionPane.showOptionDialog(null,"You are awesome","Secret Message",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,0);
		//(parent component, message, title,option type,message type, icon, options, inital value)
		//icon replaces message type icon
		//options can be with array of strings
	}
	public void textFields(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		textButton = new JButton("Submit");
		textButton.addActionListener(this);

		field = new JTextField();
		field.setPreferredSize(new Dimension(250,40));
		field.setFont(new Font("Consolas",Font.PLAIN,35));
		field.setForeground(Color.green);
		field.setBackground(Color.black);
		field.setCaretColor(Color.white);
		field.setText("Username:");

		//field.setEditable(false);

		this.add(textButton);
		this.add(field);
		this.pack();
		this.setVisible(true);
	}
	public void checkBoxes(){ //includes how to resize fat images lol
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		checkButton = new JButton("Submit");
		checkButton.addActionListener(this);

		xIcon = new ImageIcon("xMark.png");
		Image newX = xIcon.getImage();
		Image croppedXImage = newX.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		xIcon = new ImageIcon(croppedXImage);

		checkIcon = new ImageIcon("check.png");
		Image newCheck = checkIcon.getImage();
		Image croppedCheckImage = newCheck.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		checkIcon = new ImageIcon(croppedCheckImage);

		checkBox = new JCheckBox();
		checkBox.setText("I'm not a robot");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas",Font.PLAIN,35));
		checkBox.setIcon(xIcon);
		checkBox.setSelectedIcon(checkIcon);
		
		this.add(checkButton);
		this.add(checkBox);
		this.pack();
		this.setVisible(true);
	}
	public void radioButton(){
		//group of buttons where only one can be selected at a time
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		pizzaButton = new JRadioButton("Pizza");
		burgerButton = new JRadioButton("Burger");
		hotDogButton = new JRadioButton("Hot Dog");

		ButtonGroup group = new ButtonGroup();
		group.add(pizzaButton);
		group.add(burgerButton);
		group.add(hotDogButton);

		pizzaButton.addActionListener(this);
		burgerButton.addActionListener(this);
		hotDogButton.addActionListener(this);

		/*
		ImageIcon's declared outside method
		Set it inside method
		ex:
		pizzaButton.setIcon(pizzaIcon); // also .setSelectedIcon();
		*/

		this.add(pizzaButton);
		this.add(burgerButton);
		this.add(hotDogButton);
		this.pack();
		this.setVisible(true);
	}
	public void comboBox(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());	

		String[] animals = {"Dog","Cat","Bird"};

		combo = new JComboBox(animals);
		combo.addActionListener(this);
		combo.setEditable(true);
		combo.addItem("Horse");
		combo.insertItemAt("Pig",0);
		combo.setSelectedIndex(0);
		combo.removeItem("Cat");
		combo.removeItemAt(1);
		combo.removeAllItems();  
		System.out.println("This is number of items in list: " + combo.getItemCount());

		this.add(combo);
		this.pack();
		this.setVisible(true);
	}
	public void progressBar(){ 
		//uses ProgressBarDemo (omg ignore the misspelling)
		ProgressBarDemo prog = new ProgressBarDemo();
	}
	public void menuBar(){
		MenuBarDemo menu = new MenuBarDemo();
	}
	public void selectAFile(){
		SelectAFile file = new SelectAFile();
	}
	public void colorChooser(){
		ColorChooser color = new ColorChooser();
	}
	public void keyListener(){
		KeyListenerDemo key = new KeyListenerDemo();
	}
	public void mouseListener(){
		MouseListnerDemo mouse = new MouseListnerDemo();
	}

	// try to go back to dragAndDrop and keyBinds classes to understand components more throughly
	public void dragAndDrop(){
		//uses DragAndDrop class
		this.setTitle("Drag And Drop Demo");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(dragPanel);
	}
	public void keyBinds(){
		KeyBindsDemo bind = new KeyBindsDemo();
	}
	public void twoDGraphics(){
		TwoDGraphics two = new TwoDGraphics();
	}



	//used with button, text field, radio buttons, 
	@Override 
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){ //for button
			//System.out.println("Yo");
			lab.setVisible(true);
		}
		if(e.getSource() == textButton){ //for text field
			System.out.println("Welcome " + field.getText());
			textButton.setEnabled(false);
			field.setEditable(false);
			this.dispose();
		}
		if(e.getSource() == checkButton){
			System.out.println(checkBox.isSelected());
		}
		if(e.getSource() == pizzaButton){
			System.out.println("You ordered Pizza");
		}
		else if(e.getSource() == burgerButton){
			System.out.println("You ordered Burger");
		}
		else if(e.getSource() == hotDogButton){
			System.out.println("You ordered Hot Dog");		
		}
		if(e.getSource()==combo){
			//System.out.println(combo.getSelectedItem());
			System.out.println(combo.getSelectedIndex());
		}
	}

}// end of class