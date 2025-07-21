import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Scanner;
//comparator w/ overridded compare method to make set ignore case, A==a etc

public class MethodTester{
	public static void main(String[] args){
		String str = "abc def";
		String hiddenStr = hide(str);
		Set<Character> answerSet = createAnswerSet(str);
		Set<Character> inputSet = Set.of('a','b','c','d','e');
		int incorrect = 0;

		System.out.println(hiddenStr);

		for(Character x:answerSet){
			System.out.print(x + " ");
		}
		System.out.println();

		for(Character z:inputSet){
			System.out.print(z + " ");
		}
		System.out.println();

		hiddenStr = reveal(str,answerSet,inputSet);
		System.out.println(hiddenStr);
		
		while(incorrect < 8){
			printStickMan(incorrect);
			incorrect++;
		}
		

	}
	private static String hide(String str){
		char[] c = str.toCharArray();
		String value = "";

		for(char x:c){
			if(x == ' '){
				value = value + " ";
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
}//end of class