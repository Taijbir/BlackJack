/*	Blackj.java
 * 	Author: Taijbir Kohli
 * 	Class: Computer Studies
 *	Teacher: Mr.Chu
 *	Date: December 17, 2020
 *	Assignment: Black Jack Assignment
 */

//Imports all
import java.util.*;

public class Blackj {
	
	//Fields
	private static int amount =1000;
	private static int bet;
	private static Scanner s = new Scanner(System.in);
	private static String winner;
	private static DECK deck;
	private static HAND playerHand;
	private static HAND dealerHand;
	
	//Methods
	
	//Getters
	public static int getBet(int bet) {
		
		//While bet is not valid, it will repeat until bet is valid
		while (bet > amount || bet < 1) {
			System.out.println("Invalid Input! How much would you like to bet? ");
			bet = s.nextInt(); 
		}
		
		//if player is going all in then print it
		if (bet == amount) {
			System.out.println("ALL IN!");
		}
		return bet;
	}
	
	//Player's Turn
	public static void playerTurn(DECK deck, HAND playerHand, HAND dealerHand) {
		//Checks for Blackjack
		if (playerHand.getTotalValue() == 21) {
			System.out.println("BLACKJACK! YOU WIN!");
			winner = "Player";
		} else {
			//Determines if player would like to hit or stand
		    Scanner scan = new Scanner(System.in);
		    System.out.println("Would you like to hit or stand?");
			String turn = scan.nextLine();
			
			//If player stands then it is the Dealers turn
			if (turn.equals("stand")) {
				//Dealers turn
				dealerTurn(deck, playerHand, dealerHand);
			
			//If player decides to hit
			} else if(turn.equals("hit")){
				
				//Draws and add new card to hand
				playerHand.addCard(deck.draw());
				System.out.println(playerHand);
				
				//Checks for Blackjack
				if (playerHand.getTotalValue() == 21) {
					System.out.println("BLACKJACK! YOU WIN!");
					winner = "Player";
				
				//Checks for Bust	
				} else if (playerHand.getTotalValue() > 21) {
					System.out.println("Your hand is busted!");
					System.out.println("The dealer has won this round!");
					winner = "Dealer";
					
				//if no winners of round are found then it recursively repeats methods until base cases are true
				} else {
					playerTurn(deck, playerHand, dealerHand);
				}
				
			//if Invalid Input then it recursively repeats methods the input is right
			} else {
				System.out.println("Invalid Input");
				playerTurn(deck, playerHand, dealerHand);
			}
		}
	}
	
	//Dealer's Turn
	public static void dealerTurn(DECK deck, HAND playerHand, HAND dealerHand) {
		System.out.println();
		
		//Checks for Blackjack
		if (dealerHand.getTotalValue() == 21) {
			System.out.println("BLACKJACK! DEALER WINS!");
			winner = "Dealer";
		}
		System.out.println("Dealer's Turn:");
		
		//Checks if player is winning, and if it true then it will recursively hit until there is a winner
		if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {
			System.out.println("The dealer decides to hit!");
			dealerHand.addCard(deck.draw());
			System.out.println(dealerHand);
			
			//Checks for Blackjack
			if (dealerHand.getTotalValue() == 21) {
				System.out.println("BLACKJACK! DEALER WINS!");
				winner = "Dealer";
				
			//Checks for Bust
			} else if (dealerHand.getTotalValue() > 21) {
				System.out.println("Dealer hand is busted!");
				System.out.println("You have won this round!");
				winner = "Player";
			} else {
				
				//recursively repeats methods until base cases are true
				dealerTurn(deck, playerHand, dealerHand);
			}
		
		//Check if Dealer is already winning, if so then it will stand
		} else {
			System.out.println(dealerHand);
			System.out.println();
			System.out.println("The dealer decides to stand!");
			if (playerHand.getTotalValue() == dealerHand.getTotalValue()) {
				System.out.println("Its a push!");
			}
			System.out.println("The dealer has won this round!");
			winner = "Dealer";
		}
	}
	

	
	//Main
	public static void main(String[] args){
		System.out.println("Welcome to Blackjack");
		
		//Counter to determine if player wants to continue
		int counter = 0;
		
		//Determines if user has enough money to bet 
		while (amount >= 1) {
			System.out.println("You have $" + amount + " to play");
			
			//Determines if player would like to continue
			if (counter >= 1) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Would you like to continue? yes or no?");
				String cont = scan.nextLine(); 
				if (cont.equals("no")) {
					break;
				}
			}
			
			//Enters bet
			System.out.println("Enter bet");
		    bet = s.nextInt(); 
		    System.out.println("Your bet is $" + getBet(bet));
		    System.out.println();
		    
		    //Creates deck Obj
	        DECK deck = new DECK(0,0);
		    
	        //Shuffles Deck
	        deck.shuffle();
		    
	        //Dealer hand in ArrayList 
		    HAND dealerHand = new HAND(true);
		    dealerHand.addCard(deck.draw());
		    dealerHand.addCard(deck.draw());
		    
		    System.out.println(dealerHand);
		    System.out.println();
		    
		    //Player hand in ArrayList 
		    HAND playerHand = new HAND(false);
		    playerHand.addCard(deck.draw());
		    playerHand.addCard(deck.draw());
		    
		    System.out.println(playerHand);
		    System.out.println();
		    
		    //Starts player turn
		    playerTurn(deck, playerHand, dealerHand);
		    
		    //Determines amount left after game
		    if (winner.equals("Dealer")) {
		    	amount = amount - bet;
		    } else if (winner.equals("Player")) {
		    	amount = amount + bet;
		    }
		    counter++;
		}
		System.out.println("Thank you for playing Blackjack \nYou finished with $" + amount);
	}
}
//End