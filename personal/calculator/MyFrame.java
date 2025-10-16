import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class MyFrame extends JFrame implements ActionListener{
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton zero;
	JButton add;
	JButton sub;
	JButton mult;
	JButton div;
	JButton equals;
	JButton clear;
	JTextField screen;
	JPanel screenPanel;
	JPanel buttonPanel;
	String currText;
	Set<String> twinSet = Set.of("++","+-","+x","+/","-+","--","-x","-/","x+","x-","xx","x/","/+","/-","/x","//");
	int cursorPosistion = 0;

	MyFrame(){
		Color myColor = Color.decode("#3f87d9");
		this.setTitle("Calculator :P");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(600,700);
		//this.getContentPane().setBackground(Color.green);
		this.setLocationRelativeTo(null);

		screen = new JTextField();
		screen.setPreferredSize(new Dimension(600,150));
		screen.setFont(new Font("Impact",Font.BOLD,60));
		screen.setEditable(false);
		screen.setCaretPosition(cursorPosistion);

		screenPanel = new JPanel();
		screenPanel.setBounds(0,0,600,150);
		screenPanel.setBackground(myColor);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,150,525,455);

		buttonPanel.setBackground(myColor);
		buttonPanel.setLayout(new GridLayout(4,0,1,1));

		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("x");
		div = new JButton("/");
		equals = new JButton("=");
		clear = new JButton("Clear");

		currText = "";

		buttonPanel.add(nine);			
		buttonPanel.add(eight);	
		buttonPanel.add(seven);
		buttonPanel.add(div);

		buttonPanel.add(six);
		buttonPanel.add(five);
		buttonPanel.add(four);
		buttonPanel.add(mult);

		buttonPanel.add(three);
		buttonPanel.add(two);
		buttonPanel.add(one);
		buttonPanel.add(sub);

		buttonPanel.add(clear);
		buttonPanel.add(zero);
		buttonPanel.add(equals);
		buttonPanel.add(add);

		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this); 
		five.addActionListener(this); 
		six.addActionListener(this); 
		seven.addActionListener(this); 
		eight.addActionListener(this); 
		nine.addActionListener(this); 
		zero.addActionListener(this); 
		add.addActionListener(this); 
		sub.addActionListener(this); 
		mult.addActionListener(this); 
		div.addActionListener(this); 
		equals.addActionListener(this); 
		clear.addActionListener(this);

		screenPanel.add(screen);
		this.add(buttonPanel);
		this.add(screenPanel);

		this.setVisible(true);

	}//end of constructor

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == one){
			currText = currText + "1";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == two){
			currText = currText + "2";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == three){
			currText = currText + "3";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == four){
			currText = currText + "4";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == five){
			currText = currText + "5";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == six){
			currText = currText + "6";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == seven){
			currText = currText + "7";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);	
		}
		else if(e.getSource() == eight){
			currText = currText + "8";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == nine){
			currText = currText + "9";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);	
		}
		else if(e.getSource() == zero){
			currText = currText + "0";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == add){
			currText = currText + "+";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == sub){
			currText = currText + "-";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == mult){
			currText = currText + "x";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == div){
			currText = currText + "/";
			screen.setText(currText);
			cursorPosistion++;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == clear){
			currText = "";
			screen.setText(currText);
			cursorPosistion = 0;
			screen.setCaretPosition(cursorPosistion);
		}
		else if(e.getSource() == equals){
			if(currText == ""){
			}
			else if(currText.charAt(0) == '+' || currText.charAt(0) == '-' || currText.charAt(0) == 'x' || currText.charAt(0) == '/'){
				currText = "";
				screen.setText(currText);
			}
			else if(currText.length() < 3){
			}
			else if(currText.charAt(currText.length()-1) == '+' || currText.charAt(currText.length()-1) == '-' || currText.charAt(currText.length()-1) == 'x' || currText.charAt(currText.length()-1) == '/'){	
			}
			else if(isNumber(currText)){
			}
			else if(!twinOps(twinSet,currText)){
				currText = "twin";
				screen.setText(currText);
			}
			else{
				double solution = solve();
				String strSolution = Double.toString(solution);
				screen.setText(strSolution);
				cursorPosistion = 0;
				screen.setCaretPosition(cursorPosistion);	
			}
		}//end of equals' else if
	}//end of actionPerformed

	public double solve(){
		double currNum = 0;
		Double[] nums = new Double[100];
		Character [] ops = new Character[100];
		int location = 0;
		final int LENGTH = currText.length();
		Character currOp = 0; 
		double answer = 0;
		int index = 0;
		Double t1,t2;

		while(location < LENGTH){ //moves into readable arrays
			currNum = findNum(location,currText);
			nums[index] = currNum;
			location += numOfDigits((int)currNum);
			if(location >= LENGTH){
				continue;
			}
			currOp = currText.charAt(location);
			ops[index] = currOp;
			location++; 
			index++;
		}

		index = 0;
		currNum = nums[0];

		Stack<Double> numStack = new Stack<>(); //push(double), pop()
		Queue<Double> q = new LinkedList<>(); //add(Double), remove() removes top[can throw a no such element exception], poll() does same but returns null if empty

		numStack.push(currNum); 
		for(Object o:ops){ //solves the priority (x and /) parts of the problem first
			if(o == null){
				continue;
			}
			currNum = nums[index+1];
			t1 = 0.0;
			t2 = 0.0;
			if((Character)o == 'x' || (Character)o == '/'){
				numStack.push(currNum);
				t2 = numStack.pop();
				t1 = numStack.pop();
				t1 = operation(t1,t2,(Character)o);
				numStack.push(t1);
			}
			else{
				q.add(numStack.pop());
				numStack.push(currNum);
			}
			index++;
		}
		q.add(numStack.pop());

		if(q.size() == 1){
			answer = q.poll();
			return answer;
		}

		Object[] simpleOp = simplify(ops); // removes the x and / and leaves only + and - in array

		
		answer = q.poll();
		for(Object c : simpleOp){ //solves the + and - to solve and print the result
			if(c == null){
				continue;
			}
			t1 = q.poll();
			answer = operation(answer,t1,(char)c);
		}
		return answer;
	}

	private double findNum(int position, String text){
		String num = "";
		Character currChar = '0';
		try{
			while(currChar.isDigit(currChar)){
				num = num + currChar;
				currChar = text.charAt(position);
				position++;
			}
		}
		catch(Exception e){
			return (double)Integer.parseInt(num);
		}
		return (double)Integer.parseInt(num);
	}

	private int numOfDigits(int num){
		int count = 0;
		while(num > 0){
			num /= 10;
			count++;	
		}
		return count;
	}

	private Double operation(double num1, double num2, char op){
		Double result = null;
		if (op == '+'){
			result = num1+num2;
		}
		else if(op == '-'){
			result = num1-num2;
		}
		else if(op == 'x'){
			result = num1*num2;
		}
		else if(op == '/'){
			if(num2 == 0){
				return null;
			}
			else{
				result = num1/num2;
			}
		}
		return result;
	}

	private Object[] simplify(Character[] ops){
		ArrayList<Character> array = new ArrayList<>();
		for(Character o: ops){
			if(o == null){
				continue;
			}
			if((Character)o == '+' || (Character)o =='-'){
				array.add(o);
			}
		}
		return array.toArray();
	}

	private boolean isNumber(String str){
		char[] c = str.toCharArray();
		for(Character o: c){
			if(!o.isDigit(o)){
				return false;
			}
		}
		return true;
	}

	private boolean twinOps(Set<String> set, String str){
		for(String x:set){
			if(str.contains(x)){
				return false;
			}
		}
		return true;
	}
}//end of MyFrame