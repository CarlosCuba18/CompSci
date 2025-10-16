import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel; //draw hangman w/ graphics
import javax.swing.JLabel; //for showing current unanswered letters
import javax.swing.JButton; //buttons with each letter; glow green if right and red is wrong
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout; //so it works with resiable window
import java.awt.GridLayout;
import javax.swing.JRadioButton; //ask for input or not
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JOptionPane;//use for erros such as "already inputted" or "not a letter"
import javax.swing.JLayeredPane;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;


class HangManMethods implements ActionListener{
	
	//IF MOVED SOMEWHERE, NEEDS "Random.txt" MOVED WITH IT TO HAVE PRELOADED PHRASES 

	//overarching variables
	JFrame frame = new JFrame();
	JLayeredPane gamePane = new JLayeredPane();
	Color backgroundColor = Color.decode("#1e599c");
	Color buttonColor = Color.decode("#0e75eb");
	Color textFieldColor = Color.decode("#0588fa");
	Color textColor = Color.decode("#012d6e");
	Color textFieldBorder = Color.decode("#003866");
	Color wrongColor = Color.decode("#611401");
	Color rightColor = Color.decode("#02662c");
	LineBorder border = new LineBorder(textFieldBorder,5);
	LineBorder thickBorder = new LineBorder(textFieldBorder,10);

	//start screen components
	JPanel startScreen = new JPanel();
	JPanel titlePanel = new JPanel();
	JLabel title = new JLabel("Hangman");
	JLabel credit = new JLabel("By: Carlos Cuba");
	JButton startButton = new JButton();

	//input screen components
	JPanel inputScreen = new JPanel();
	JTextField inputField;
	boolean input = true;
	boolean radioButtonsPressed = false;
	JRadioButton yesInput;
	JRadioButton noInput;
	JButton afterInputButton;

	//gameplay components
	JPanel gamePanel = new JPanel();
	PaintPanel hangManPanel = new PaintPanel();
	JPanel lettersPanel = new JPanel();
	JPanel wordPanel = new JPanel();
	JLabel currentPhrase = new JLabel();
	JLabel numsLabel = new JLabel();
	JButton[] buttons = new JButton[26]; //enchanced for-loop to declare each button with letter; buttons[i] = new JButton(currChar); w/ panel.add(buttons[i]);
	Character[] buttonAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	int buttonsIndex = 0;
	Object[] numOfLetterPerWord;

	//variables for game
	Set<Character> alphabet = Set.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
	Set <Character> otherAcceptedChars = Set.of(',' , '.' , '!' , '?' , '-' , ' ', '\'');
	String selectedString;
	String hiddenString;
	Set<Character> answerSet;
	Set<Character> inputSet = new HashSet<>();
	int incorrect = 0;
	int exitInt = -1;


	HangManMethods(){
		//creating frame
		frame.setTitle("HangMan (X-X)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(1300,1000);
		frame.setLocationRelativeTo(null);

		//adding layered pane to frame
		gamePane.setBounds(0,0,1300,1000);
		gamePane.setLayout(null);
		frame.add(gamePane);

		//adding 3 main panels to layered pane
////////All start screen components/////////////////////////////////////
		startScreen.setOpaque(true);
		startScreen.setLayout(null);
		startScreen.setBounds(0,0,1300,1000);
		startScreen.setBackground(backgroundColor);
		gamePane.add(startScreen);


		titlePanel.setOpaque(true);
		titlePanel.setLayout(null);
		titlePanel.setBounds(100,100,1000,400);
		titlePanel.setBackground(textFieldColor);
		titlePanel.setBorder(thickBorder);

		title.setBounds(0,0,1000,250);
		title.setFont(new Font("Comic Sans", Font.BOLD,120));
		title.setForeground(textColor);
		title.setHorizontalAlignment(JLabel.CENTER);

		credit.setBounds(0,250,1000,50);
		credit.setFont(new Font("Comic Sans", Font.BOLD,40));
		credit.setForeground(textColor);
		credit.setHorizontalAlignment(JLabel.CENTER);
		
		titlePanel.add(title);
		titlePanel.add(credit);
		startScreen.add(titlePanel);

		startButton.setBounds(350,600,500,300);
		startButton.setHorizontalTextPosition(JButton.CENTER);
		startButton.addActionListener(this);
		startButton.setText("Start");
		startButton.setFocusable(false);
		startButton.setFont(new Font("Comic Sans", Font.BOLD,50));
		startButton.setForeground(Color.black); //color of text
		startButton.setBackground(buttonColor); //color of button
		startButton.setBorder(border);
		startScreen.add(startButton);

////////All input screen components/////////////////////////////////////
		inputScreen.setVisible(false);
		inputScreen.setOpaque(true);
		inputScreen.setLayout(null);
		inputScreen.setBounds(0,0,1300,1000);
		inputScreen.setBackground(backgroundColor);
		gamePane.add(inputScreen);

		yesInput = new JRadioButton("Let me pick my own phrase");
		yesInput.setBackground(buttonColor);
		yesInput.setFocusable(false);
		yesInput.setBorder(border);

		noInput = new JRadioButton("Give me a phrase to guess");
		noInput.setBackground(buttonColor);
		noInput.setFocusable(false);
		noInput.setBorder(border);

		ButtonGroup group = new ButtonGroup();
		group.add(yesInput);
		group.add(noInput);

		yesInput.setBounds(50,500,500,100);
		yesInput.setFont(new Font("Comic Sans",Font.BOLD,30));
		yesInput.addActionListener(this);
		inputScreen.add(yesInput);

		noInput.setBounds(650,500,500,100);
		noInput.addActionListener(this);
		noInput.setFont(new Font("Comic Sans", Font.BOLD,30));
		inputScreen.add(noInput);

		inputField = new JTextField();
		inputField.setBounds(50,100,1100,300);
		inputField.setFont(new Font("Comic Sans",Font.PLAIN,60));
		inputField.setText("");
		inputField.setBackground(textFieldColor);
		inputField.setForeground(textColor);
		inputField.setBorder(border);
		inputScreen.add(inputField);

		afterInputButton = new JButton("Continue");
		afterInputButton.setBounds(900,800,300,100);
		afterInputButton.addActionListener(this);
		afterInputButton.setBackground(buttonColor);
		afterInputButton.setBorder(border);
		inputScreen.add(afterInputButton);


////////All game screen components//////////////////////////////////////
		gamePanel.setVisible(false);
		gamePanel.setOpaque(true);
		gamePanel.setLayout(null);
		gamePanel.setBounds(0,0,1500,1100);
		gamePanel.setBackground(backgroundColor);
		gamePane.add(gamePanel);

		hangManPanel.setOpaque(true);
		hangManPanel.setBackground(textFieldColor);
		hangManPanel.setBounds(100,50,400,400);
		gamePanel.add(hangManPanel);

		wordPanel.setOpaque(true);
		wordPanel.setBackground(textFieldColor);
		wordPanel.setBounds(600,50,600,400);
		wordPanel.setBorder(border);
		currentPhrase.setVerticalAlignment(JLabel.CENTER);
		currentPhrase.setHorizontalAlignment(JLabel.CENTER);
		currentPhrase.setFont(new Font("Comic Sans",Font.PLAIN,70));
		currentPhrase.setPreferredSize(new Dimension(600,400));
		currentPhrase.setForeground(textColor);
		wordPanel.add(currentPhrase);
		gamePanel.add(wordPanel);

		numsLabel.setBounds(600,450,600,100);
		numsLabel.setBackground(backgroundColor);
		numsLabel.setText("Letters Per Word: ");
		numsLabel.setFont(new Font("Comic Sans",Font.BOLD,30));
		numsLabel.setOpaque(true);
		gamePanel.add(numsLabel);

		lettersPanel.setOpaque(true);
		lettersPanel.setBackground(textFieldColor);
		lettersPanel.setBorder(border);
		lettersPanel.setLayout(new GridLayout(2,13,10,10));
		for(char c : buttonAlphabet){
			buttons[buttonsIndex] = new JButton(String.valueOf(c));
			buttons[buttonsIndex].addActionListener(new ButtonArrayListener(buttons[buttonsIndex]));
			buttons[buttonsIndex].setFont(new Font("Comic Sans",Font.BOLD,30));
			lettersPanel.add(buttons[buttonsIndex]);
			buttons[buttonsIndex].setBackground(buttonColor);
			buttons[buttonsIndex].setForeground(textColor);
			buttons[buttonsIndex].setFocusable(false);
			buttonsIndex++;
		}

		lettersPanel.setBounds(50,550,1100,350);
		gamePanel.add(lettersPanel);
///////////////////////////////////////////////////////////////////////

		gamePane.moveToFront(startScreen);
		frame.setVisible(true);

	}//end of constructor

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == startButton){
			startButton.setEnabled(false);
			gamePane.moveToFront(inputScreen);
			gamePane.moveToBack(startScreen);
			startScreen.setVisible(false);
			inputScreen.setVisible(true);
		}
		else if(e.getSource() == yesInput){
			input = true;
			radioButtonsPressed = true;
		}
		else if(e.getSource() == noInput){
			input = false;
			radioButtonsPressed = true;
		}
		else if(e.getSource() == afterInputButton){
			if(radioButtonsPressed == false){
				JOptionPane.showMessageDialog(inputField,"Please select one of the 2 options.","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(input && inputField.getText().trim().equals("")){
				JOptionPane.showMessageDialog(inputField,"Please insert text or select preloaded button","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(HasIncorrectChars(inputField.getText().toLowerCase().trim())){
				JOptionPane.showMessageDialog(inputField,"Please only use letters or the the following characters: , . ! ? ' -","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(input && NoLetters(inputField.getText().toLowerCase().trim())){
				JOptionPane.showMessageDialog(inputField,"Please have atleast one letter in the answer","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{

				if(input){
					selectedString = inputField.getText().toLowerCase();
				}
				else{
					selectedString = select();
				}

				hiddenString = hide(selectedString);
				numOfLetterPerWord = LettersPerWord(selectedString);

				for(Object x:numOfLetterPerWord){
					numsLabel.setText(numsLabel.getText() + x + " ");
				}

				answerSet = createAnswerSet(selectedString);
				currentPhrase.setText("<html>" + hiddenString + "</html>");

				gamePane.moveToFront(gamePanel);
				gamePane.moveToBack(inputScreen);
				inputScreen.setVisible(false);
				gamePanel.setVisible(true);
				afterInputButton.setEnabled(false);
				yesInput.setEnabled(false);
				noInput.setEnabled(false);
				inputField.setEditable(false);
			}
		}	
	}//end of actionPerformed

	private String select(){
		String[] loadedStrings = loadFile();
		final int arraySize = loadedStrings.length;

		Random random = new Random();
		int index = random.nextInt(arraySize);

		return loadedStrings[index].toLowerCase();
	}

	private String[] loadFile(){
		ArrayList<String> list = new ArrayList<>();
		String str = "";

		try{
			File file = new File("Random.txt");
			Scanner scan = new Scanner(file);

			while(scan.hasNext()){
				str = scan.nextLine();
				str.trim();
				list.add(str);
			}
			scan.close();
		}
		catch(Exception fnf){
			System.out.println("Can't Find File");
		}

		return list.toArray(new String[0]);
	}

	private String hide(String str){
		char[] c = str.toCharArray();
		String value = "";

		for(char x:c){
			if(otherAcceptedChars.contains(x)){
				value = value + x;
			}
			else{
				value = value + "_";
			}
		}
		return value;
	}

	private Set<Character> createAnswerSet(String str){
		char[] c = str.toCharArray();
		Set<Character> answer = new HashSet<>();

		for(char x:c){
			if(x == ' '){
				continue;
			}
			answer.add(Character.toLowerCase(x));
		}
		return answer;
	}

	private String reveal(String str, Set<Character> answer, Set<Character> input){ 
		char[] strArray = str.toCharArray();
		String newString = "";

		for(Character c:strArray){
			if(otherAcceptedChars.contains(c)){
				newString = newString + c;
			}
			else if(answer.contains(c) && input.contains(c)){
				newString = newString + c;
			}
			else{
				newString = newString + "_";
			}
		}
		return newString;
	}

	public Object[] LettersPerWord(String str){
		String currString;
		Scanner scan = new Scanner(str);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num;
		char[] array;

		while(scan.hasNext()){
			currString = scan.next().toLowerCase();
			num = currString.length();
			array = currString.toCharArray();

			for(char c:array){
				if(!alphabet.contains(c)){
					num--;
				}
			}

			list.add(num);
		}
		scan.close();
		return list.toArray();
	}

	public boolean HasIncorrectChars(String str){
		char[] array = str.toCharArray();
		for(Character c:array){
			if(!(alphabet.contains(c) || otherAcceptedChars.contains(c))){
				return true;
			}
		}
		return false;
	}

	public boolean NoLetters(String str){
		char[] array = str.toCharArray();
		for(Character c:array){
			if(alphabet.contains(c)){
				return false;
			}
			else{
				continue;
			}
		}
		return true;
	}

	public void restart(){
		inputScreen.setVisible(true);
		gamePanel.setVisible(false);
		inputField.setEditable(true);
		yesInput.setEnabled(true);
		noInput.setEnabled(true);
		afterInputButton.setEnabled(true);
		gamePane.moveToFront(inputScreen);
		gamePane.moveToBack(gamePanel);

		for(JButton button:buttons){
			button.setEnabled(true);
			button.setBackground(buttonColor);
		}

		exitInt = -1;
		incorrect = 0;
		inputSet = new HashSet<>();
		inputField.setText("");
		numsLabel.setText("Letters Per Word: ");
	}

///////////////////////////////////////////////////////////////////////////////////////
	private class ButtonArrayListener implements ActionListener{
		JButton currButton;

		ButtonArrayListener(JButton button){
			currButton = button;
		}

		@Override
		public void actionPerformed(ActionEvent e){
			String c = currButton.getText();
			Character ch = c.charAt(0);

			if(answerSet.contains(ch)){
				setButtonGreen(currButton);
				inputSet.add(ch);
				hiddenString = reveal(selectedString,answerSet,inputSet);
				currentPhrase.setText("<html>" + hiddenString + "</html>");
				if(hiddenString.indexOf("_") == -1){//you won, prompt to restart
					while(exitInt == -1){
						exitInt = JOptionPane.showConfirmDialog(gamePanel,"Congrats, it was: " + selectedString + ". Play Again?","Congrats",JOptionPane.YES_NO_OPTION);
						if(exitInt == 0){//yes
							restart();
							break;
						}
						else if(exitInt == 1){//no
							System.exit(0);
							break;
						}
					}//end of while
				}//end of winning check
			}
			else{
				setButtonRed(currButton);
				inputSet.add(ch);
				incorrect++;
				hangManPanel.repaint();
				//paint
				if(incorrect == 7){//you lost, prompted to restart
					while(exitInt == -1){
						exitInt = JOptionPane.showConfirmDialog(gamePanel,"Sorry, the answer was: " + selectedString + ". Try Again?",":<",JOptionPane.YES_NO_OPTION);
						if(exitInt == 0){//yes
							restart();
							break;
						}
						else if(exitInt == 1){//no
							System.exit(0);
							break;
						}
					}//end of while

				}//end of losing check
			}
		}

		private JButton findButton(String ch){
			//cycle through buttons with getText
			String str;
			for(JButton o:buttons){
				str = o.getText();
				if(ch.equals(str)){
					return o;
				}
			}
			return null;
		}

		private void setButtonRed(JButton button){
			button.setBackground(wrongColor);
			button.setEnabled(false);
		}

		private void setButtonGreen(JButton button){
			button.setBackground(rightColor);
			button.setEnabled(false);
		}
	}// end of ButtonArrayListener class
//////////////////////////////////////////////////////////////////////////////////////
	private class PaintPanel extends JPanel{
		PaintPanel(){
			this.setOpaque(true);
			this.setBackground(Color.red);
			this.setBounds(100,50,400,400);
		}
		public void paint(Graphics g){
			Graphics2D g2D = (Graphics2D) g;
			//setting color and drawing hangpost
			g2D.setPaint(textColor);
			g2D.setStroke(new BasicStroke(10));
			g2D.drawLine(0,400,400,400);
			g2D.setStroke(new BasicStroke(5));
			g2D.drawLine(100,400,100,50);
			g2D.drawLine(100,50,300,50);
			g2D.drawLine(300,50,300,100);

			if(incorrect == 1){
				//1(head)
				g2D.drawArc(250,100,100,100,0,180);
				g2D.drawArc(250,100,100,100,180,180);
			}
			else if(incorrect == 2){
				//2(body)
				g2D.drawLine(300,200,300,300);
			}
			else if(incorrect == 3){
				//3(arm1)
				g2D.drawLine(300,220,350,260);
			}
			else if(incorrect == 4){
				//4(arm2)
				g2D.drawLine(300,220,250,260);	
			}
			else if(incorrect == 5){
				//5(leg1)
				g2D.drawLine(300,300,340,380);
			}
			else if(incorrect == 6){
				//6(leg2)
				g2D.drawLine(300,300,260,380);
			}
			else if(incorrect == 7){
				//7(ded)
				g2D.drawLine(270,140,280,130);
				g2D.drawLine(280,140,270,130);
				g2D.drawLine(320,140,330,130);
				g2D.drawLine(330,140,320,130);
			}
		}
	}//end of PaintPanel class
//////////////////////////////////////////////////////////////////////////////////////////
}//end of HangManMethods class

public class HangMan{
	public static void main(String[] args){
		HangManMethods hmm = new HangManMethods();
	}
}