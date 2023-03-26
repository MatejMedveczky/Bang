package org.example.cards;
import org.example.Cards;


public class BarellCard extends Cards {

    public BarellCard(String name, String type) {
        super(name, type);
    }
    public String barellCard() {
        int probability = (int)Math.floor(Math.random() * (4 - 1 + 1) + 1);
        if (probability == 1){
            return "missed";
        }
        else {
            return "hit";

        }
    }
}
