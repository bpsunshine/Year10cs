//Choose your own adventure story.//

import java.util.Scanner;
public class Choose {
	public static void main(String [] args){
		System.out.println("You see a scary house. You are with your friends. Do you investigate? Y or N");
		Scanner inputChoice = new Scanner(System.in);
		String choice = inputChoice.nextLine();
		String upchoice = choice.toUpperCase();
		if (upchoice.equals("Y")) {
			System.out.println("You are very brave. You sneak in the side door. Continue? Y or N");
			} else {
				choice = inputChoice.nextLine();
				upchoice = choice.toUpperCase();
				System.out.println("Chicken. See ya!");
			}	
			if (upchoice.equals("Y")) {
				choice = inputChoice.nextLine();
				upchoice = choice.toUpperCase();
			System.out.println("The side door creaks! Zombies awake. Continue Y or leave N");
			} else {
				choice = inputChoice.nextLine();
				upchoice = choice.toUpperCase();
				System.out.println("The Zombies chase you and kill you.");
		
					}
					if (upchoice.equals("Y")) {
						choice = inputChoice.nextLine();
						upchoice = choice.toUpperCase();
						System.out.println("You find a cricket bat and smash the first zombie, run upstairs? Y or N.");
						} else {
							choice = inputChoice.nextLine();
							upchoice = choice.toUpperCase();
							System.out.println("The zombies downstairs eat you and your friend's brains");
						}	
						if (upchoice.equals("Y")) {
							choice = inputChoice.nextLine();
							upchoice = choice.toUpperCase();
						System.out.println("You are the first up the stairs and find a set of car keys labeled _____sCar. Pick them up Y or N");
						} else {
							choice = inputChoice.nextLine();
							upchoice = choice.toUpperCase();
							System.out.println("The Zombies run upstairs and eat you all.");
						
					}
					if (upchoice.equals("Y")) {
						choice = inputChoice.nextLine();
						upchoice = choice.toUpperCase();
						System.out.println("You tell your friends that you have to go to the bathroom and excuse yourself outside. You realise that the car keys are for the wonderful ThanosCar. Drive the ThanosCar and escape? Y or N");
						} else {
							choice = inputChoice.nextLine();
							upchoice = choice.toUpperCase();
							System.out.println("You go to the bathroom and the zombies eat you");
						}	
						if (upchoice.equals("Y")) {
							choice = inputChoice.nextLine();
							upchoice = choice.toUpperCase();
						System.out.println("You drive away in the ThanosCar and escape the evil zombies. Congratulations!");
						
					}	
	}
}