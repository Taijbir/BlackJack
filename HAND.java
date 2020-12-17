/*	HAND.java
 * 	Author: Taijbir Kohli
 * 	Class: Computer Studies
 *	Teacher: Mr.Chu
 *	Date: December 17, 2020
 *	Assignment: Black Jack Assignment
 */

//Imports all
import java.util.*;

public class HAND {
	
	//fields
	private ArrayList<CARD> arrayOfCards;
	private int totalValue;
	private static boolean isDealer;
	
	protected int suit;
	protected int rank;
	
	protected static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	protected static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
	
	//Constructor
	public HAND(boolean inputIsDealer) {
		isDealer = inputIsDealer;
		arrayOfCards = new ArrayList<CARD>();
		
		if(inputIsDealer == false) {
			System.out.println("Players Hand: ");
		} else {
			System.out.println("Dealers Hand: ");
			System.out.println("\tCard: ?????");
		}
	}
	
	//Methods:
	//Adds card called to ArrayList
	public CARD addCard(CARD card) {
		this.arrayOfCards.add(card);
		return card;
    }
	
	//Getters
	//Gets total value of the cards in the ArrayList
	public int getTotalValue() {
		totalValue = 0;
		
		for (int i = 0; i < arrayOfCards.size(); i++){
			totalValue = totalValue + arrayOfCards.get(i).getValue();
			//Determines if Ace == 11 or 1
			if(totalValue == 20 && arrayOfCards.get(i).getRank()==0) { 
				totalValue = 21;
			}
		}
	    return totalValue;
	}

	public static boolean getIsDealer() {
	    return isDealer;
	}
	
	//To String method
	public String toString() {
		int x;
		String result = "";
		if (getIsDealer() == false ) {
			x = 0;
		} else {
			x = 1;
		}
        for (int i = 0 + x; i <= arrayOfCards.size()-1; i++){
        	System.out.println(arrayOfCards.get(i));
        }
        if (x==0) {
			getTotalValue();
			return ("\tCurrent Total: "+totalValue);
        }
        return result;
	}
	
	//Main
	public static void main(String[] args){
		//Creates new Obj's
		HAND h = new HAND(true);
        DECK d = new DECK(0,0);
        
        //Shuffles deck
        d.shuffle();
        
        //Removes first card from deck and adds it too ArrayList
        h.addCard(d.draw());
        h.addCard(d.draw());
        h.addCard(d.draw());

        //Prints Hand Obj
        System.out.println(h);
    }
}

//End