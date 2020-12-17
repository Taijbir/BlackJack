/*	DECK.java
 * 	Author: Taijbir Kohli
 * 	Class: Computer Studies
 *	Teacher: Mr.Chu
 *	Date: December 17, 2020
 *	Assignment: Black Jack Assignment
 */

//Imports all
import java.util.*;

public class DECK extends CARD {

	//fields
	private ArrayList<CARD> arrayOfCards;

	//Constructor
	public DECK(int inputRank, int inputSuit) {
		super(inputRank, inputSuit);
		//Creates ArrayList
		arrayOfCards = new ArrayList<CARD>();
		
		//Populates ArrayList
		for (int i = 0; i <= 3; i++){
            for (int j = 0; j<=12; j++){
                arrayOfCards.add(new CARD(j,i));
            }
        }
	}
	
	//Methods
	//Shuffles deck
	public void shuffle() {
		 Random random = new Random();
		 CARD temp;
		 for(int i=0; i<200; i++) {
			 int firstIndex = random.nextInt(arrayOfCards.size()-1);
		     int secIndex = random.nextInt(arrayOfCards.size()-1);
		     temp = arrayOfCards.get(secIndex);
		     arrayOfCards.set(secIndex, arrayOfCards.get(firstIndex));
		     arrayOfCards.set(firstIndex, temp);
		 }
	}
	
	//Draws the first card of deck
	public CARD draw() {
		return arrayOfCards.remove(0);
	}
	
	//Main
	public static void main(String[] args) {
		//Deck Obj
		DECK d = new DECK(0, 0);
		
		//Shuffle Deck
		d.shuffle();
		
		//Prints and removes first card of deck
        for (int i = 0; i <= 51; i++){
            System.out.println(d.draw());
        } 
    }
}
//End
