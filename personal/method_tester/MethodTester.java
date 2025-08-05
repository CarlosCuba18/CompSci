import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MethodTester{
	public static void main(String[] args){
		Set<Character> alphabet = Set.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
		String str = "";
		Object[] words;

		words = LettersPerWord(str,alphabet,otherAcceptedChars);

		for(Object x:words){
			System.out.print(x + " ");
		}
		System.out.println();

	}
	public static Object[] LettersPerWord(String str, Set<Character> alphabet){
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
		return list.toArray();
	}

}//end of class