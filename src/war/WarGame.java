/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.Collections;
import java.util.LinkedList;
import war.WarCard;
import war.WarDeck;
import war.WarTable;

/**
 *
 * @author Derek
 */
public class WarGame 
{
    private WarDeck originalDeck;
    private WarDeck player1;
    private WarDeck player2;
    private WarTable table;
    private LinkedList<WarCard> winnings;
    
    public WarGame()
    {
        originalDeck = new WarDeck();
        player1 = new WarDeck("Empty");
        player2 = new WarDeck("Empty");
        table = new WarTable();
        
        
        
        
        while(originalDeck.hasNext())
        {
            //dealing out the cards
            player1.addCard(originalDeck.drawCard());
            player2.addCard(originalDeck.drawCard());
        }
        
        
    }
    public WarGame(String forTesting)
    {
        originalDeck = new WarDeck();
        player1 = new WarDeck("Empty");
        player2 = new WarDeck("Empty");
        table = new WarTable();
    }
    
    public void PlayRound()
    {
        int player1Card;
        int player2Card;
        table.drawCards(player1.drawCard(), player2.drawCard());
        //System.out.println("Is War? " + table.isWar());
        while(table.isWar() && player1.hasNext() && player2.hasNext())
        {
            //The game of war rules say you each draw a face down card and the
            //a face up card in the event of war and go by the last cards drawn.

            table.drawCards(player1.drawCard(), player2.drawCard());
            
            //just in case we have to check to make sure both players have cards
            //in their deck.
          
            if(player1.hasNext() && player2.hasNext())
            {    
                 table.drawCards(player1.drawCard(), player2.drawCard());
            }
        }
        
        player1Card = table.getPlayerOneFaceValue();
        player2Card = table.getPlayerTwoFaceValue();
        //System.out.println("Player 1 Card:" + player1Card + " Player 2 Card: " + player2Card);
        winnings = table.giveWinnings();
        if(player1Card > player2Card)
        {
            
            for(int i = winnings.size()-1; i >= 0; i--)
            {
                player1.addCard(winnings.get(i));
            }
        }
        else if(player1Card < player2Card)
        {
            for(int i = winnings.size()-1; i >= 0; i--)
            {
                player2.addCard(winnings.get(i));
            }
        }
        //System.out.println("Player 1 : " + player1.getSize() + " player2 : " + player2.getSize());
    }
    
    public boolean isGameOver()
    {
        return (!player1.hasNext() || !player2.hasNext());
    }
    
}
