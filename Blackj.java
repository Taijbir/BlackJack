import java.util.*;

public class Blackj {
	
	private static int amount =1000;
	private static int bet;
	private static Scanner s = new Scanner(System.in);
	private static String winner;
	private static DECK deck;
	private static HAND playerHand;
	private static HAND dealerHand;
	
	
	public static int getBet(int bet) {
		while (bet > amount || bet < 1) {
			System.out.println("Invalid Input! How much would you like to bet? ");
			bet = s.nextInt(); 
			System.out.println(bet);

		}
		if (bet == amount) {
			System.out.println("ALL IN!");
		}
		return bet;
	}
	
	public static void dealerTurn(DECK deck, HAND playerHand, HAND dealerHand) {
		System.out.println();
		System.out.println("Dealer's Turn:");
		if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {
			System.out.println("The dealer decides to hit!");
			dealerHand.addCard(deck.draw());
			System.out.println(dealerHand);
			if (dealerHand.getTotalValue() == 21) {
				System.out.println("BLACKJACK! DEALER WINS!");
				winner = "Dealer";
			} else if (dealerHand.getTotalValue() > 21) {
				System.out.println("Dealer hand is busted!");
				System.out.println("You have won this round!");
				winner = "Player";
			} else {
				dealerTurn(deck, playerHand, dealerHand);
			}
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
	
	public static void playerTurn(DECK deck, HAND playerHand, HAND dealerHand) {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Would you like to hit or stand?");
		String turn = scan.nextLine();
		if (turn.equals("stand")) {
			System.out.println("Stand");
			dealerTurn(deck, playerHand, dealerHand);
		} else if(turn.equals("hit")){
			playerHand.addCard(deck.draw());
			System.out.println(playerHand);
			if (playerHand.getTotalValue() == 21) {
				System.out.println("BLACKJACK! YOU WIN!");
				winner = "Player";
			} else if (playerHand.getTotalValue() > 21) {
				System.out.println("Your hand is busted!");
				System.out.println("The dealer has won this round!");
				winner = "Dealer";
			} else {
				playerTurn(deck, playerHand, dealerHand);
			}
			
		} else {
			System.out.println("Invalid Input");
			playerTurn(deck, playerHand, dealerHand);
		}
	}
	
	
	public static void main(String[] args){
		while (amount >= 1) {
			System.out.println("Thank you for playing Black Jack! You have $" + amount + " to play");
			System.out.println("Enter bet");
		    bet = s.nextInt(); 
		    System.out.println("Your bet is " + getBet(bet));
		    System.out.println();
		    
	        DECK deck = new DECK(0,0);
		    
		    
	        deck.shuffle();
		    
		    HAND dealerHand = new HAND(true);
		    dealerHand.addCard(deck.draw());
		    dealerHand.addCard(deck.draw());
		    
		    System.out.println(dealerHand);
		    System.out.println();
		    HAND playerHand = new HAND(false);
		    playerHand.addCard(deck.draw());
		    playerHand.addCard(deck.draw());
		    
		    System.out.println(playerHand);
		    System.out.println();
		    

		    playerTurn(deck, playerHand, dealerHand);
		    if (winner.equals("Dealer")) {
		    	amount = amount - bet;
		    } else if (winner.equals("Player")) {
		    	amount = amount + bet;
		    }
		}
		//add end stuff 
	}

}
