package org.example;
import org.example.cards.BarellCard;
import org.example.cards.*;

import java.util.ArrayList;

public class DeckOfCards {

    public static ArrayList<Cards> deckList = new ArrayList<>();
    public static ArrayList<Cards> shuffledCards = new ArrayList<>();

    public static void newDeck(){

        deckList.add(new BarellCard("barell", "blue"));

        for (int i = 0; i < 2; i++){
            Cards barellCard = new BarellCard("barellCard", "blue");
            deckList.add(barellCard);

        }

        for (int i = 0; i < 3; i++){
            PrisonCard prisonCard = new PrisonCard("prison", "blue");
            deckList.add(prisonCard);
        }

        for (int i = 0; i < 30; i++){
            deckList.add(new BangCard("bang", "brown"));
        }

        for (int i = 0; i < 15; i++){
            deckList.add(new MissedCard("missed", "brown"));
        }

        for (int i = 0; i < 8; i++){
            deckList.add(new Beer("beer", "brown"));
        }

        for (int i = 0; i < 6; i++){
            deckList.add(new CatBalou("catbalou", "brown"));
        }

        for (int i = 0; i < 4; i++){
            deckList.add(new Stagecoach("stagecoach", "brown"));
        }

        for (int i = 0; i < 2; i++){
            deckList.add(new Indians("indians", "brown"));
        }

    }

    public static void shuffleCards(){
        DeckOfCards.newDeck();

        for (int i = 0; i < 71; i++){
            int length = deckList.size();
            int position = (int)Math.floor(Math.random() * (length - 1 + 1));
            Cards removedCard = deckList.get(position);
            shuffledCards.add(removedCard);
            deckList.remove(position);
        }
    }
    public static Cards cardOnTop(){
        int length = shuffledCards.size();
        int index = length - 1;
        //System.out.println("shuffledCards size " + shuffledCards.size());
        Cards topCard = shuffledCards.get(index);
        shuffledCards.remove(index);
        return topCard;
    }



}


