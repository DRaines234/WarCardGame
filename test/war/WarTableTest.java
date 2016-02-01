/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Derek
 */
public class WarTableTest 
{
    WarTable table;
    WarDeck deck1;
    WarDeck deck2;
    
    public WarTableTest() 
    {
        
    }
    
    @BeforeClass
    public static void setUpClass() 
    {

    }
    
    @Before
    public void setUp() 
    {
        
        table = new WarTable();
        deck1 = new WarDeck("Empty");
        deck2 = new WarDeck("Empty");
        deck1.addCard(new WarCard(1,2));
        deck2.addCard(new WarCard(2,2));
        
    }

    @Test
    public void testIsWar() 
    {
        table.drawCards(deck1.drawCard(), deck2.drawCard());
        assertTrue(table.isWar());
    }
    
    @Test
    public void testGiveWinnings()
    {
        WarTable winTable = new WarTable();
        WarCard card1;
        WarCard card2;
        LinkedList<Integer> faceVals = new LinkedList();
        
        winTable.drawCards(new WarCard(1,2), new WarCard(1,3));
        
        for(WarCard card : winTable.giveWinnings())
        {
            faceVals.add(card.getFaceValue());
        }
        
        assertTrue(faceVals.contains(2));
        assertTrue(faceVals.contains(3));
        assertTrue(faceVals.size() == 2);
    }
    
}
