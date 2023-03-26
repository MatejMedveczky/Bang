package org.example;

import static org.example.Game.getCurrentPlayer;

public abstract class Cards {
    private String name;
    private String type;

    public Cards(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static Cards getCard(int i){
        Players player = getCurrentPlayer();
        return player.cardsInHand.get(i - 1);
    }

    public void play(){

    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }





}
