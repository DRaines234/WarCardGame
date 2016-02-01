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
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testIsGameOver() 
    {
        WarGame game = new WarGame("test");
        assertTrue(game.isGameOver());
        
        WarGame game2 = new WarGame();
        assertFalse(game2.isGameOver());
         
                
    }
    
}
