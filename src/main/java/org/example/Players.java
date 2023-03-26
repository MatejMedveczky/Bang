package org.example;

import java.util.ArrayList;

import static org.example.Game.getCurrentPlayer;
import static org.example.Game.players;

public class Players {
    String name;
    int lives;
    int numberOfCards;
    boolean isAlive;

    public ArrayList<Cards> cardsInHand = new ArrayList<>();
    ArrayList<Cards> cardsOnTable = new ArrayList<>();

    public Players (String name){
        this.name = name;
        this.lives = 4;
        this.cardsInHand = new ArrayList<Cards>();
        this.cardsOnTable = new ArrayList<Cards>();
        numberOfCards = cardsInHand.size() +  1;

    }

    public String getName(){
        return name;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public void setNumberOfCards(int numberOfCards){
        this.numberOfCards = numberOfCards;
    }

    public boolean isDead(){
        Players currentPlayer = getCurrentPlayer();
        if(currentPlayer.lives == 0){
            currentPlayer.isAlive = false;
            players.remove(currentPlayer);
            for (int i = 0; i < currentPlayer.cardsInHand.size(); i++){
                throwAway(currentPlayer.cardsInHand.get(i));
            }
            for (int i = 0; i < currentPlayer.cardsOnTable.size(); i++){
                throwAway(currentPlayer.cardsOnTable.get(i));
            }
            System.out.println(currentPlayer.name + "RIP our friend, see you in the afterlife");
            return true;
        }
        else {
            return false;
        }
    }
    /*public static void pullCard(){
        Players currentPlayer = getCurrentPlayer();
        Cards card = DeckOfCards.cardOnTop();
        if (card.getType() == "brown"){
            currentPlayer.cardsInHand.add(card);
        }
    }*/

    public void throwAway(Object Cards){
        if (DiscardPile.discardPile.size() > 70){
            DiscardPile.discardPile.removeAll(DiscardPile.discardPile);
            DeckOfCards.shuffleCards();
        }
        DiscardPile.discardPile.add(Cards);

    }
    public static Cards getCardsInHand(int i){
        Players currentPlayer = getCurrentPlayer();
        return currentPlayer.cardsInHand.get(i);
    }
    public static Cards getCardsOnTable(int i){
        Players currentPlayer = getCurrentPlayer();
        return currentPlayer.cardsOnTable.get(i);
    }

}
