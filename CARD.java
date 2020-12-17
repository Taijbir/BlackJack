/*	CARD.java
 * 	Author: Taijbir Kohli
 * 	Class: Computer Studies
 *	Teacher: Mr.Chu
 *	Date: December 17, 2020
 *	Assignment: Black Jack Assignment
 */

//Imports all
import java.util.*;

public class CARD {
	
	//fields
	protected int rank;
	protected int suit;
	protected int value;
	
	protected static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	protected static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
	
	//Constructor
	public CARD(int inputRank, int inputSuit) {
		suit = inputSuit;
		rank = inputRank;
		if(inputRank>=10) {
	        value = 10;
	    } else if (inputRank == 0){
	    	value = 11;
	    }else {
	        value=inputRank+1;
	    }
		inputRank = value;
	}
	
	//Getters
	public int getRank() {
	    return rank;
	}
	
	public int getSuit() {
	    return suit;
	}
	
	public int getValue() {
	    return value;
	}
	
	//Setters
	public void setRank(int newRank) {
		rank = newRank;
	}
	
	public void setSuit(int newSuit) {
		suit = newSuit;
	}
	
	public void setValue(int newValue) {
		value = newValue;
	}
	
	//To String method
	public String toString() {
		return "\tCard: " + ranks[rank] +" of "+ suits[suit];
	}
	
	//Main
	public static void main(String[] args) {
		//Creates ArrayList
		ArrayList<CARD> arrayOfCards = new ArrayList<CARD>();
		
		//Populates ArrayList
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j<=12; j++){
                arrayOfCards.add(new CARD(j,i));
            }
        }

      //Prints ArrayList
        System.out.println(arrayOfCards.get(0));
        System.out.println(arrayOfCards.get(13));
        System.out.println(arrayOfCards.get(25)); 
	}
}
//End