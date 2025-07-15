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
		screen.setFont(new Font("Impact",Font.BOLD,65));
		screen.setEditable(false);

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

		//buttonPanel.revalidate();
		//buttonPanel.repaint();

		currText = "";

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
		}
		else if(e.getSource() == two){
			currText = currText + "2";
			screen.setText(currText);
		}
		else if(e.getSource() == three){
			currText = currText + "3";
			screen.setText(currText);
		}
		else if(e.getSource() == four){
			currText = currText + "4";
			screen.setText(currText);
		}
		else if(e.getSource() == five){
			currText = currText + "5";
			screen.setText(currText);
		}
		else if(e.getSource() == six){
			currText = currText + "6";
			screen.setText(currText);
		}
		else if(e.getSource() == seven){
			currText = currText + "7";
			screen.setText(currText);	
		}
		else if(e.getSource() == eight){
			currText = currText + "8";
			screen.setText(currText);
		}
		else if(e.getSource() == nine){
			currText = currText + "9";
			screen.setText(currText);	
		}
		else if(e.getSource() == zero){
			currText = currText + "0";
			screen.setText(currText);
		}
		else if(e.getSource() == add){
			currText = currText + "+";
			screen.setText(currText);
		}
		else if(e.getSource() == sub){
			currText = currText + "-";
			screen.setText(currText);
		}
		else if(e.getSource() == mult){
			currText = currText + "x";
			screen.setText(currText);
		}
		else if(e.getSource() == div){
			currText = currText + "/";
			screen.setText(currText);
		}
		else if(e.getSource() == clear){
			currText = "";
			screen.setText(currText);
		}
		else if(e.getSource() == equals){
			if(currText.charAt(0) == '+' || currText.charAt(0) == '-' || currText.charAt(0) == 'x' || currText.charAt(0) == '/'){
				//invalid and will break so no lol
				currText = "";
				screen.setText("No break pls");
			}
			else if(currText.length() < 3){
				//input isn't complete
			}
			else{
				try{
					screen.setText(Double.toString(solve())); //try to restrain long values to beginning of text field
				}
				catch(NullPointerException ex){
					screen.setText("No >:(");
				}
			}
		}//end of equals' else if
	}//end of actionPerformed

	public double solve(){
		double num1;
		double num2;
		int location;
		char op; 
		double answer;

		num1 = findNum(0,currText);
		location = numOfDigits((int)num1);
		op = currText.charAt(location);
		num2 = findNum(location+1,currText);


		answer = operation(num1,num2,op);
		return answer;
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
}//end of MyFrame