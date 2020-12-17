import java.util.*;

public class HAND {
	private ArrayList<CARD> arrayOfCards;
	private int totalValue;
	private static boolean isDealer;
	
	protected int suit;
	protected int rank;
	
	protected static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	protected static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
	
	
	public HAND(boolean inputIsDealer) {
		isDealer = inputIsDealer;
		arrayOfCards = new ArrayList<CARD>();
		
		
		if(inputIsDealer == false) {
			System.out.println("Players Hand: ");
		} else {
			System.out.println("Dealers Hand: ");
			System.out.println("\t Card: ?????");
		}
	}
	
	
	public CARD addCard(CARD card) {
		this.arrayOfCards.add(card);
		return card;
    }
	

	public int getTotalValue() {
		totalValue=0;
		for (int i = 0; i < arrayOfCards.size(); i++){
			totalValue = totalValue + arrayOfCards.get(i).getValue();
		}
		
	    return totalValue;
	}
	

	public static boolean getIsDealer() {
	    return isDealer;
	}
	
	
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
			return ("\t Current Total: "+totalValue);
        }
        return result;
	}
	
	public static void main(String[] args){
		HAND h = new HAND(true);
        DECK d = new DECK(0,0);
        
        d.shuffle();
        h.addCard(d.draw());
        h.addCard(d.draw());
        h.addCard(d.draw());

        System.out.println(h);

    }

}
