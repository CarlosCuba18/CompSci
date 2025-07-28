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
import javax.swing.JRadioButton; //ask for input or not
import javax.swing.JTextField;
import javax.swing.JOptionPane;//use for erros such as "already inputted" or "not a letter"
import javax.swing.JLayeredPane;
import javax.swing.BorderFactory;


public class HangMan{
	public static void main(String[] args){

		JFrame frame = new JFrame();
		JLayeredPane gamePane = new JLayeredPane();
		JPanel gamePanel = new JPanel();
		JPanel startScreen = new JPanel();
		JPanel background = new JPanel();

		JPanel hangManPanel = new JPanel();
		JPanel lettersPanel = new JPanel();
		JPanel wordPanel = new JPanel();
		JLabel currentPhrase = new JLabel();
		JButton startButton = new JButton();
		JButton[] buttons = new JButton[26]; //enchanced for-loop to declare each button with letter; buttons[i] = new JButton(currChar); w/ panel.add(buttons[i]);

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
		startScreen.setOpaque(true);
		startScreen.setLayout(null);
		startScreen.setBounds(0,0,1500,1100);
		startScreen.setBackground(Color.pink);
		gamePane.add(startScreen);

		background.setOpaque(true);
		background.setLayout(null);
		background.setBounds(0,0,1500,1100);
		background.setBackground(Color.green);
		gamePane.add(background);

		gamePanel.setOpaque(true);
		gamePanel.setLayout(null);
		gamePanel.setBounds(0,0,1500,1100);
		gamePanel.setBackground(Color.blue);
		gamePane.add(gamePanel);

		//adding panels to game panel (one of the ones added to overall layered pane)
		hangManPanel.setOpaque(true);
		hangManPanel.setBackground(Color.red);
		hangManPanel.setBounds(100,50,400,400);
		gamePanel.add(hangManPanel);

		wordPanel.setOpaque(true);
		wordPanel.setBackground(Color.orange);
		wordPanel.setBounds(700,50,600,400);
		//fix font
		wordPanel.add(currentPhrase);
		gamePanel.add(wordPanel);

		lettersPanel.setOpaque(true);
		lettersPanel.setBackground(Color.yellow);
		lettersPanel.setBounds(100,550,1200,400);
		gamePanel.add(lettersPanel);

		//moveToFront(Comp),moveToBack(Comp)
		//gamePane.moveToFront(gamePanel);
		//gamePane.moveToBack(gamePanel);

		//components for start screen

		//make private class that extends button implements listner
		buttonClass b = new buttonClass();
		startButton = b.makeButton();
		//b.turnOffButton();
		//have main be the only method in Hangman, make instance of new helper class to work with everything/ have create() that makes all the frames and stuff

		startScreen.add(startButton);


		gamePane.moveToFront(startScreen);

		frame.setVisible(true);

		}/*
		Set<Character> alphabet = Set.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
		String selectedString = select();
		Scanner scan = new Scanner(System.in);
		String hiddenString = hide(selectedString);
		Set<Character> answerSet = createAnswerSet(selectedString);
		Set<Character> inputSet = new HashSet<>();
		int incorrect = 0;
		String scannedString;
		Character myChar;

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

	private static String select(){
		//have this be the opening of new page, pressing play and opening new frame asking using radio button to ask for input or use a preloaded one

		String selectedString;
		String input = "";
		Scanner scanner = new Scanner(System.in);

		System.out.println("What do you want to solve?");
		input = scanner.nextLine();
		input.trim();
		if(input != ""){
			selectedString = input.toLowerCase();
			return selectedString;
		}
		else{
			String[] loadedStrings = loadFile();
			final int arraySize = loadedStrings.length;
			Random random = new Random();
			int index = random.nextInt(arraySize);
			selectedString = loadedStrings[index].toLowerCase();
		}
		return selectedString;
	}

	private static String[] loadFile(){
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

	private static String hide(String str){
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

	private static Set<Character> createAnswerSet(String str){
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

	private static String reveal(String str, Set<Character> answer, Set<Character> input){ 
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

	private static void printStickMan(int x){
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

}

class buttonClass extends JButton implements ActionListener{
	JButton button = this;	
	buttonClass(){
	}
	public JButton makeButton(){
		this.setBounds(450,600,500,300);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.addActionListener(this);
		this.setText("I'm a button");
		this.setFocusable(false);
		this.setFont(new Font("Comic Sans", Font.BOLD,50));
		this.setForeground(Color.black); //color of text
		this.setBackground(Color.lightGray); //color of button
		this.setBorder(BorderFactory.createEtchedBorder());
		//startButton.setEnabled(false); //turns off a button
		return this;
	}
	public void turnOffButton(){
		this.setEnabled(false);
	}
	public void turnOnButton(){
		this.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			System.out.println("works");
			turnOffButton();
		}
	}
}