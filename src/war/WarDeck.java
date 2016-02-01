
package war;
import cards.Card;
import cards.Deck;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author Derek
 */
public class WarDeck implements Deck
{
    private LinkedList<WarCard> deck = new LinkedList();
    //private int cardIndex = -1; //set to -1 so we can increment to the correct position before the return.
    
    public WarDeck()
    {
        for(int suit = 0; suit < 4; suit++)
        {
            for(int value = 0; value < 13; value++)
            {
                deck.add(new WarCard(suit, value));
            }
        }
        Collections.shuffle(deck);

    }
    
    public WarDeck(String createEmptyDeck)
    {
        //this is for creating empty decks for testing various methods so we can control the cards
        //also used to create the player decks later so we can deal the cards out from the big deck.
    }
    
    @Override
    public WarCard drawCard()
    {
        if(deck.size()==0)
        {
            throw new IndexOutOfBoundsException();
        }
        
        WarCard toDraw = deck.getLast();    
        deck.removeLast(); //This card is Drawn so it is no longer int the deck.

        return toDraw;
        
    }
    
    @Override 
    public boolean hasNext()
    {
        return deck.size() > 0;
    }
    
    public void addCard(WarCard card)
    {
        deck.addFirst(card);
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public int getSize()
    {
        return deck.size();
    }
}
