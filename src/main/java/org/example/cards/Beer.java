package org.example.cards;

import org.example.Cards;
import org.example.Game;
import org.example.Players;

public class Beer extends Cards {
    public Beer(String name, String type) {
        super(name, type);
    }

    public void play(){
        Players player = Game.getCurrentPlayer();
        int lives = player.getLives();
        player.setLives(lives + 1);
    }
}
