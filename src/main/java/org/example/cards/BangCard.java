package org.example.cards;

import org.example.Cards;
import org.example.Game;
import org.example.Players;
import org.example.utilities.ZKlavesnice;

public class BangCard extends Cards {

    public BangCard(String name, String type) {
        super(name, type);
    }

    public void play(){
        int shotPlayerIndex = ZKlavesnice.readInt("Which111 player do you want to shoot at?");
        Players shotPlayer = Game.getPlayer(shotPlayerIndex - 1);
        int missedCards = 0;
        int missedPosition = 0;
        for(int i = 0; i < shotPlayer.cardsInHand.size(); i++){
            Cards card = shotPlayer.cardsInHand.get(i);

            if (card.getName() == "missed"){
                missedCards = missedCards + 1;
                missedPosition = i;
            }
        }
        if (missedCards > 0){
            System.out.println("You missed");
            shotPlayer.cardsInHand.remove(missedPosition);

        }
        else if (missedCards == 0){
            System.out.println("HIT!");
            int lives = shotPlayer.getLives();
            shotPlayer.setLives(lives - 1);
            shotPlayer.isDead();
        }
    }

}
