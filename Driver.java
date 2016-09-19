/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Driver {
    
    public static void main (String [] args)
    {
        WarGame game = new WarGame(24); //Determines total cards
        System.out.println("Let's play War!!\n");
        int[] gameCards = {5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10};
        game.assignCards(gameCards);
        System.out.println("Players have been assigned cards!");
        game.shuffleCards();
    }
}
