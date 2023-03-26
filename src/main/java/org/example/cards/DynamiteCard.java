package org.example.cards;
import org.example.Cards;

public class DynamiteCard extends Cards {
    public DynamiteCard(String name, String type) {
        super(name, type);
    }
    public String dynamite() {
        int probability = (int)Math.floor(Math.random() * (8 - 1 + 1) + 1);
        if (probability != 1){
            return "missed";
        }
        else {
            return "hit";

        }
    }
}
