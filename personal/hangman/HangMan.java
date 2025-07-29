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


class HangManMethods implements ActionListener{
	Character[] buttonAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	JFrame frame = new JFrame();
	JLayeredPane gamePane = new JLayeredPane();
	JPanel startScreen = new JPanel();
	JPanel inputScreen = new JPanel();
	JPanel gamePanel = new JPanel();

	JPanel hangManPanel = new JPanel();
	JPanel lettersPanel = new JPanel();
	JPanel wordPanel = new JPanel();
	JLabel currentPhrase = new JLabel();
	JButton[] buttons = new JButton[26]; //enchanced for-loop to declare each button with letter; buttons[i] = new JButton(currChar); w/ panel.add(buttons[i]);
	int buttonsIndex = 0;

	//image for start screen
	//maybe image for background
	JButton startButton = new JButton();

	JTextField inputField;
	String inputFieldString = "";
	boolean input = true;
	JRadioButton yesInput;
	JRadioButton noInput;
	JButton afterInputButton;

	Set<Character> alphabet = Set.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
	String selectedString;
	Scanner scan = new Scanner(System.in);///////////////////////////////////////////////
	String hiddenString;
	Set<Character> answerSet;
	Set<Character> inputSet = new HashSet<>();
	int incorrect = 0;
	String scannedString;
	Character myChar;


	HangManMethods(){
		//creating frame
		frame.setTitle("HangMan (X-X)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(1500,1100);
		frame.setLocationRelativeTo(null);

		//adding layered pane to frame
		gamePane.setBounds(0,0,1500,1100);
		gamePane.setLayout(null);
		frame.add(gamePane);

		//adding 3 main panels to layered pane
////////All start screen components/////////////////////////////////////
		startScreen.setOpaque(true);
		startScreen.setLayout(null);
		startScreen.setBounds(0,0,1500,1100);
		startScreen.setBackground(Color.pink);
		gamePane.add(startScreen);

		startButton.setBounds(450,600,500,300);
		startButton.setHorizontalTextPosition(JButton.CENTER);
		startButton.addActionListener(this);
		startButton.setText("Start");
		startButton.setFocusable(false);
		startButton.setFont(new Font("Comic Sans", Font.BOLD,50));
		startButton.setForeground(Color.black); //color of text
		startButton.setBackground(Color.lightGray); //color of button
		startButton.setBorder(BorderFactory.createEtchedBorder());
		startScreen.add(startButton);

////////All input screen components/////////////////////////////////////
		inputScreen.setVisible(false);
		inputScreen.setOpaque(true);
		inputScreen.setLayout(null);
		inputScreen.setBounds(0,0,1500,1100);
		inputScreen.setBackground(Color.green);
		gamePane.add(inputScreen);

		yesInput = new JRadioButton("Let me pick my own phrase");
		noInput = new JRadioButton("Give me a phrase to guess");
		ButtonGroup group = new ButtonGroup();
		group.add(yesInput);
		group.add(noInput);

		yesInput.setBounds(120,700,500,100);
		yesInput.setFont(new Font("Comic Sans",Font.BOLD,20));
		yesInput.addActionListener(this);
		inputScreen.add(yesInput);

		noInput.setBounds(820,700,500,100);
		noInput.addActionListener(this);
		noInput.setFont(new Font("Comic Sans", Font.BOLD,20));
		inputScreen.add(noInput);

		inputField = new JTextField();
		inputField.setBounds(120,200,1200,300);
		inputField.setFont(new Font("Comic Sans",Font.PLAIN,60));
		inputField.setText("");
		inputScreen.add(inputField);

		afterInputButton = new JButton("Continue");
		afterInputButton.setBounds(1120,900,300,100);
		afterInputButton.addActionListener(this);
		inputScreen.add(afterInputButton);


////////All game screen components//////////////////////////////////////
		gamePanel.setVisible(false);
		gamePanel.setOpaque(true);
		gamePanel.setLayout(null);
		gamePanel.setBounds(0,0,1500,1100);
		gamePanel.setBackground(Color.blue);
		gamePane.add(gamePanel);

		hangManPanel.setOpaque(true);
		hangManPanel.setBackground(Color.red);
		hangManPanel.setBounds(100,50,400,400);
		gamePanel.add(hangManPanel);
		//graphics stuff

		wordPanel.setOpaque(true);
		wordPanel.setBackground(Color.orange);
		wordPanel.setBounds(700,50,600,400);
		wordPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		//fix font
		//currentPhrase.setText(hiddenString);
		wordPanel.add(currentPhrase);
		gamePanel.add(wordPanel);
		//use methods to put hidden phrase

		lettersPanel.setOpaque(true);
		lettersPanel.setBackground(Color.yellow);
		lettersPanel.setLayout(new GridLayout(2,13,10,10));
		for(char c : buttonAlphabet){
			buttons[buttonsIndex] = new JButton(String.valueOf(c));
			buttons[buttonsIndex].addActionListener(this);
			//set Font for each letter
			//make method that makes the button change color if right or wrong and make it unusable
			lettersPanel.add(buttons[buttonsIndex]);
		}

		lettersPanel.setBounds(100,550,1200,400);
		gamePanel.add(lettersPanel);




///////////////////////////////////////////////////////////////////////

		//moveToFront(Comp),moveToBack(Comp)

		gamePane.moveToFront(startScreen);
		frame.setVisible(true);

	}//end of constructor

	//make game class with main process

	private String select(){
		//have this be the opening of new page, pressing play and opening new frame asking using radio button to ask for input or use a preloaded one

		//String selectedString;

		loadFile();

		String[] loadedStrings = loadFile();
		final int arraySize = loadedStrings.length;

		Random random = new Random();
		int index = random.nextInt(arraySize);

		//selectedString = loadedStrings[index].toLowerCase();

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

		}
		catch(Exception fnf){
		}

		return list.toArray(new String[0]);
	}

	private String hide(String str){
		char[] c = str.toCharArray();
		String value = "";

		for(char x:c){
			if(x == ' '){
				value = value + " ";
			}
			else if(x == '\''){
				value = value + "'";
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
			if(c == ' '){
				newString = newString + " ";
			}
			else if(c == '\''){
				newString = newString + "'";
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

	/*

		while(incorrect < 7){
			for(;;){
				printStickMan(incorrect);
				System.out.println(hiddenString);
				System.out.println("Set: ");
				for(Character c:inputSet){
					System.out.print(c + " ");
				}
				System.out.println();

				System.out.println("Insert a letter: ");
				scannedString = scan.next();
				scannedString.trim();
				myChar = scannedString.charAt(0);

				if(scannedString.length() <= 1 && alphabet.contains(myChar)){ //its a char
					if(inputSet.contains(myChar)){
						System.out.println("You already put that");
						break;
					}
					inputSet.add(Character.toLowerCase(myChar));
					if(!answerSet.contains(myChar)){ //its wrong
						incorrect++;
						System.out.println("Wrong :<, incorrect: " + incorrect);
						//System.out.println(hiddenString);
						break;
					}
					else{ //its right
						hiddenString = reveal(selectedString,answerSet,inputSet);
						//System.out.println(hiddenString);
						if(hiddenString.indexOf("_") == -1) {
							System.out.println("You win :), it was: " + hiddenString);
							System.exit(0);
						}
					}
				}//end of if
				else{
					System.out.println("Thats not a char >:(");
				}
			}//end of infinite for loop
		}//end of while

		System.out.println("Sorry, it was: " + selectedString);
		scan.close();
	}//end of main

	private void printStickMan(int x){
		if(x == 0){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 1){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 2){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" |  |   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 3){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" |  |   ");
			System.out.println(" |  |   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 4){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" | /|   ");
			System.out.println(" |  |   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 5){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" | /|\\ ");
			System.out.println(" |  |   ");
			System.out.println(" |      ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 6){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" | /|\\ ");
			System.out.println(" |  |   ");
			System.out.println(" | /    ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
		else if(x == 7){
			System.out.println("");
			System.out.println(" /--|   ");
			System.out.println(" |  O   ");
			System.out.println(" | /|\\ ");
			System.out.println(" |  |   ");
			System.out.println(" | / \\ ");
			System.out.println(" |      ");
			System.out.println("_|______");
		}
	}
	*/

	@Override
	public void actionPerformed(ActionEvent e){
		JButton pressed = (JButton) e.getSource();
		//doesnt work for radio button
		//maybe instanceOf ot check when it is accepted

		if(e.getSource() == startButton){
			turnOffStartButton();
			gamePane.moveToFront(gamePanel);
			gamePane.moveToBack(startScreen);
			startScreen.setVisible(false);
			inputScreen.setVisible(true);
		}
		else if(e.getSource() == yesInput){
			input = true;
		}
		else if(e.getSource() == noInput){
			input = false;
		}
		else if(e.getSource() == afterInputButton){

			if(input && inputField.getText().equals("")){
				JOptionPane.showMessageDialog(inputField,"Please insert text or select preloaded button","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(input){
					selectedString = inputField.getText();
				}
				else{
					selectedString = select();
				}
				hiddenString = hide(selectedString);
				answerSet = createAnswerSet(selectedString);
				currentPhrase.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				currentPhrase.setFont(new Font("Comic Sans",Font.PLAIN,70)); //try to find font or way to make spaces between __
				currentPhrase.setPreferredSize(new Dimension(600,400));
				currentPhrase.setText("<html>" + hiddenString + "</html>");

				gamePane.moveToFront(gamePanel);
				gamePane.moveToBack(inputScreen);
				inputScreen.setVisible(false);
				gamePanel.setVisible(true);
				afterInputButton.setEnabled(false);
				//afterInputButton.setVisible(false);
				yesInput.setEnabled(false);
				noInput.setEnabled(false);
				inputField.setEditable(false);

				//turn on right at declaring so it can loop program
			}
		}

	}
		
	public void turnOffStartButton(){
		startButton.setEnabled(false);
	}
	public void turnOnStartButton(){
		startButton.setEnabled(true);
	}
	//turn on/off all 3 screens methods
}//end of class

public class HangMan{
	public static void main(String[] args){
		HangManMethods hmm = new HangManMethods();
	}
}