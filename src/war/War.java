
package war;

/**
 *
 * @author Derek
 */
public class War 
{


    public static void main(String[] args)
    {
        WarGame game;
        int games = 100000;
        int numTurns = 0;
        int avgNumTurns = 0;
        int maxTurns = 0;
        int minTurns = games;
        int currentTurns;
        for(int i = 0; i <= games; i++)
        {
            currentTurns = 0;
            game = new WarGame();
            while(!game.isGameOver())
            {
             game.PlayRound();
             numTurns++;
             currentTurns++;
             //System.out.println(numRounds);
            }
            if (currentTurns > maxTurns)
            {
                maxTurns = currentTurns;
            }
            else if(currentTurns < minTurns)
            {
                minTurns = currentTurns;
            }
        }
        avgNumTurns = numTurns / games;
        
        
        System.out.println("Average Number of turns per game is " + avgNumTurns);
        System.out.println("The max number of turns in a game out of " + games + " is " + maxTurns);
        System.out.println("The minimum number of turns in a game out of " + games + " is " + minTurns);
    }
}
