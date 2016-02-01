/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Derek
 */
public class WarTable 
{
    private LinkedList<WarCard> wonCards; 
    //won cards will act as the holding spot for all of the cards on the table at a time.
    //it will be returned to the victor.
    private int wonCardIndex = - 1; //keeps track of where we are when cards accumulate.
    
    public WarTable()
    {

        
    }
    
    public void drawCards(WarCard playerOneCard, WarCard playerTwoCard)
    {
       if(wonCardIndex < 0)
       {
           wonCards = new LinkedList();
       }
        
       wonCards.add(playerOneCard);
       wonCardIndex++;
       wonCards.add(playerTwoCard);
       wonCardIndex++;
    }
    
    public boolean isWar()
    {
        return(this.getPlayerOneFaceValue() == this.getPlayerTwoFaceValue());
        //we are asking if the face falue is the same, example, are they both 1's, queens, or aces?
    }
    
    public int getPlayerOneFaceValue()
    {
        return wonCards.get(wonCardIndex - 1).getFaceValue();
        //remember player one gets added 1st, so they are at the index -1 pos.)
    }
    
    public int getPlayerTwoFaceValue()
    {
        return wonCards.get(wonCardIndex).getFaceValue();
    }
    
    public LinkedList<WarCard> giveWinnings()
    {
        //System.out.println("Won Card Size: " + wonCards.size());
        wonCardIndex = -1;
        //we shuffle the "winnings" to simulate the randomness of player one or two
        //placing their cards first. Otherwise we get an abnormally high ratio of 
        //the condition that forces the game to go on forever via the same person
        //placing their cards first.
        Collections.shuffle(wonCards); 
        return wonCards;
    }
}
