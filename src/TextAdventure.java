import java.util.Scanner;

public class TextAdventure {
	
	private static Scanner input;
	private static String playerName;
	private static Mansion mansion;
	
	public static void main (String[] args) {
		input = new Scanner(System.in);
		mansion = new Mansion();
		//Welcome
		System.out.println("Please enter your name.");
		playerName = input.nextLine();
		System.out.printf("Hello %s, and welcome to [insert welcome here].\n", playerName);
		System.out.println("Your goal? To [insert goal here].");
		
		//Set up initial gamestate.
		
		//More entrance text.
		
		//While loop describing game logic
		

		
		//Cleanup
		lose();
	}
	
	private static void lose() {
		System.out.println("You have lost!");
		System.out.printf("Fare thee well, %s, we will not forget you!\n", playerName);
		input.close();
	}
	
	private static void win() {
		System.out.printf("Congratulations, %s, you have won!\n", playerName);
		input.close();
		System.exit(0);
	}
	
}
