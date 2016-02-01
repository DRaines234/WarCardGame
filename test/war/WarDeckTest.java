/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import cards.Card;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Derek
 */
public class WarDeckTest {
    WarDeck deck;
    
    public WarDeckTest() 
    {
        
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        deck = new WarDeck();
    }

    @Test
    public void test52Cards()
    {
       ArrayList<Card> countingDeck = new ArrayList<>();
       while(deck.hasNext())
       {
           countingDeck.add(deck.drawCard());
       }
       assertEquals(52, countingDeck.size());
    }
    
    @Test
    public void noDuplicates()
    {
        ArrayList<Card> noDupsDeck = new ArrayList<>();
        while(deck.hasNext())
        {
            noDupsDeck.add(deck.drawCard());
        }
        
        int deckIndex = 0;
        while (deckIndex <= noDupsDeck.size()-1)
        {
            for(int compareDeckIndex = deckIndex + 1; compareDeckIndex < noDupsDeck.size()-1; compareDeckIndex++)
            {

                assertFalse(noDupsDeck.get(deckIndex).equals(noDupsDeck.get(compareDeckIndex)));
            }
            deckIndex++;
        }
        
    
    }
    @Test
    public void TesTAddCard()
    {
        WarCard card = deck.drawCard();
        WarCard compareCard = null;
        deck.addCard(card);
        
        while(deck.hasNext())
        {
            compareCard = deck.drawCard();
        }
        
        assertTrue(card.equals(compareCard));
    }
    
    
    @Test
    public void testEmptyDeck()
    {
        WarDeck emptyDeck = new WarDeck("empty");
        ArrayList<WarCard> cards = new ArrayList<>();
        
        while(emptyDeck.hasNext())
        {
            cards.add(emptyDeck.drawCard());
        }
        assertEquals(0,cards.size());
    }
    
    @Test
    public void testDrawCard()
    {
        WarDeck fullDeck = new WarDeck();
        assertEquals(52, fullDeck.getSize());
        fullDeck.drawCard();
        assertEquals(51, fullDeck.getSize());
    }
        
    @Test
    public void testDrawTooMany()
    {
        WarDeck emptyDeck = new WarDeck("empty");
        try
        {
            emptyDeck.drawCard();
            fail();
        }
        catch(IndexOutOfBoundsException ex)
        {
            System.out.println("Exception Caught");
        }
    }
}
