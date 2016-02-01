
package war;

import cards.Card;

/**
 *
 * @author Derek
 */
public class WarCard implements Card
{
    private int suitValue;
    private int faceValue;
    
    public WarCard(int suitValue, int faceValue)
    {
        this.suitValue = suitValue;
        this.faceValue = faceValue;
    }
    
    @Override
    public int getSuitValue()
    {
        return suitValue;
    }
    
    @Override
    public int getFaceValue()
    {
        return faceValue;    

    }
    

    public String toString()
    {
        String[] suit = new String[] {"Hearts", "Diamonds", "Clubs", "Spades"};
        String [] value = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        
        return value[faceValue] + " of " + suit[suitValue];
    }
}
