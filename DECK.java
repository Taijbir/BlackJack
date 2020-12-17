import java.util.*;

public class DECK extends CARD {


	//fields
	private ArrayList<CARD> arrayOfCards;

	//Constructor
	public DECK(int inputRank, int inputSuit) {
		super(inputRank, inputSuit);
		arrayOfCards = new ArrayList<CARD>();
		
		for (int i = 0; i <= 3; i++){
            for (int j = 0; j<=12; j++){
                arrayOfCards.add(new CARD(j,i));
            }
        }
	}
	
	//Methods
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

	public CARD draw() {
		return arrayOfCards.remove(0);
	}
	
	//Main
	public static void main(String[] args) {
		DECK d = new DECK(0, 0);
		d.shuffle();
        for (int i = 0; i <= 51; i++){
            System.out.println(d.draw());
        }
        
    }
}
