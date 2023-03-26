package org.example.cards;

import org.example.Cards;
import org.example.Game;
import org.example.Players;

public class Indians extends Cards {
    public Indians(String name, String type) {
        super(name, type);
    }

    public void play(){
        for (int i = 0; i < Game.players.size(); i++){
            Players shotPlayer = Game.getPlayer(i);
            int missedCards = 0;
            for(int j = 0; j < shotPlayer.cardsInHand.size(); j++){
                Cards card = shotPlayer.cardsInHand.get(i);
                if ("missed" == card.getName()){
                    missedCards = missedCards + 1;
                }
                if (missedCards > 0){
                    System.out.println("You missed");
                }
                else if (missedCards == 0){
                    System.out.println("HIT!");
                    int lives = shotPlayer.getLives();
                    shotPlayer.setLives(lives - 1);
                    shotPlayer.isDead();
                }
            }
        }
    }
}
