/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Derek
 */
public class WarCardTest {
    
    public WarCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMakeCard() 
    {
        WarCard card = new WarCard(1,1);
    }
    
    @Test
    public void testHeartsToString()
    {
        WarCard card = new WarCard(0,0);
        assertEquals("2 of Hearts", card.toString());
        
    }
    
    @Test
    public void testDiamondsToString()
    {
        WarCard card = new WarCard(1,1);
        assertEquals("3 of Diamonds", card.toString());
    }
    
    @Test
    public void testClubsToString()
    {
        WarCard card = new WarCard(2, 9);
        assertEquals("J of Clubs", card.toString());
    }
    
    @Test 
public void testSpades()
    {
        WarCard card = new WarCard(3, 10);
        assertEquals("Q of Spades", card.toString());
    }
}
