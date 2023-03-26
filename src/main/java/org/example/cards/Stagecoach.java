package org.example.cards;
import org.example.Cards;
import org.example.Game;
import org.example.Players;

public class Stagecoach extends Cards {

    public Stagecoach(String name, String type) {
        super(name, type);
    }

    public void play(){
        Game.pullCard();
        Game.pullCard();
    }
}
