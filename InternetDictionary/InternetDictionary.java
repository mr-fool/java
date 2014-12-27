import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/** Simple /b/tard dictioanry
 * @author mr-fool
 * @version 0.o*/
public class InternetDictionary {
	public static void main(String[] args) {
		/** 
		 * @param Create a hasmap with an intial size of 10 and the default load factor*/
		HashMap<String,String> dictionary = new HashMap <String,String>(10);
		
		//Adding vocabulary into the dictionary
		dictionary.put("newfag", "Any new person, or thing, to enter a site.");
		dictionary.put("oldfag", "An Oldfag is  is a user of an online community who has been with the community a considerable amount of time");
		dictionary.put("sage","A word originating from the popular Japanese forum website 2chan.\n Sage (pronounced \"sah-geh\") - from the Japanese word \"sageru\",\n"+
		 "refers to replying to a post using the word \"sage\" in the email field in order to increase the number of replies without age-ing (or bumping) the post.\n"+
		  "This can be used as a courtesy, allowing one to quietly add comments that may not be interesting enough to warrant pushing the thread to the top. It can also be used as a way to show displeasure with the post being replied to.");
		dictionary.put("lurk","On a messageboard or anything similar, to browse the board very often, but without ever posting anything.");
		dictionary.put("over9000","A phrase that people use for something of impressive power, skill or just general fun.");
		
		Scanner keyboard = new Scanner(System.in);
		String input = "q";
		
		//Prompting the user to type a word
		do {
			System.out.println("\n Enter the word you should to look up.\n Press q to quit");
		
			input = keyboard.nextLine();
			//Formating the user input so it can be compared
			input = input.toLowerCase(); //Changing it to lower case
			input = input.replace(" ",""); //Removing the whitespace
			/**
			 * @param Taking user input and matching it with the definition 
			 * */
			if ( dictionary.containsKey(input) ) {
				String definition = dictionary.get(input);
				System.out.println("input: \n" + definition);
			}
			else {
				System.err.println("Word not found");
			}
	}while (! input.equalsIgnoreCase("q") );
	}
}
