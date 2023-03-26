package org.example;
import org.example.utilities.ZKlavesnice;
import java.util.ArrayList;
import java.util.Scanner;
import static org.example.DeckOfCards.*;

public class Game {
    public static int playerOnMove = 0;
    public static int deadPlayers;
    public static ArrayList<Players> players = new ArrayList<>();

    public static void movePlayer() {
        playerOnMove = playerOnMove + 1;
        if (playerOnMove > players.size() - 1) {
            playerOnMove = 0;
        }
    }
    public static Players getCurrentPlayer() {
        return players.get(playerOnMove);
    }
    public static Players getPlayer(int specificPlayer){
        return players.get(specificPlayer);
    }
    public static void pullCard() {
        Players currentPlayer = getCurrentPlayer();
        Cards card = DeckOfCards.cardOnTop();
        currentPlayer.cardsInHand.add(card);
        movePlayer();
        shuffledCards.remove(card);
    }
    public static void dealCards(int numberOfPlayers){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < numberOfPlayers; j++){
                pullCard();
            }
        }
    }
    public static boolean enoughCards(){
        Players player = getCurrentPlayer();
        if (player.lives < player.cardsInHand.size()){
            int cardsToDiscard = player.cardsInHand.size() - player.lives;
            System.out.println("You have to discard " + cardsToDiscard + " cards");
        }
        return true;

    }
    public static void playersTurn(){
        Players currentPlayer = getCurrentPlayer();
        if (currentPlayer.isDead() == true) {
            deadPlayers = deadPlayers + 1;
            movePlayer();
        }
        System.out.println("=======================================\n");
        System.out.println(currentPlayer.name + " is next!");
        System.out.println("You have " + currentPlayer.getLives() + " lives\n");
        System.out.println(("Your cards in hand are: \n"));
        for (int i = 0; i < currentPlayer.cardsInHand.size(); i++) {
            System.out.println(currentPlayer.cardsInHand.get(i));
        }
        System.out.println(("\nYour cards on table are: "));
        for (int i = 0; i < currentPlayer.cardsOnTable.size(); i++) {
            System.out.println(currentPlayer.cardsOnTable.get(i));
        }
        if (currentPlayer.cardsOnTable.size() == 0){
            System.out.println("You dont have any cards on the table");
        }

        System.out.println("\nNow you will pull two cards");
        pullCard();
        pullCard();
        pullCard();

        System.out.println("These are the cards you have now:");
        for (int i = 0; i < currentPlayer.cardsInHand.size(); i++) {
            System.out.println(currentPlayer.cardsInHand.get(i));
        }

        String play;
        boolean canContinue;
        int playable = 0;

        do{
            int cardToPlay;
            do{
                cardToPlay = ZKlavesnice.readInt("Which card do you want to play? (1 - " + currentPlayer.cardsInHand.size() + ")");
            }while(currentPlayer.cardsInHand.size() - 1 < cardToPlay || cardToPlay < 0);
            Cards card = currentPlayer.cardsInHand.get(cardToPlay);
            card.play();
            System.out.println(card.getName() + " played");
            play = ZKlavesnice.readString("Do you want to continue? (Y/N)");
            if (!play.equals("Y")){
                if (!play.equals("N")) {
                    System.out.println("Try again...");
                    play = ZKlavesnice.readString("Do you want to continue? (Y/N)");
                }
            }
            canContinue = Game.enoughCards();
            int cardsSize = currentPlayer.cardsInHand.size();

            if (cardsSize < 1){
                playable = 1;
            }
            if(canContinue == true){
                if(play == "N"){
                    playable = playable + 1;
                }
                else{
                    playable = 0;
                }
            }
        }while (playable != 0);
        movePlayer();
    }
    public static void playGame() {

        System.out.println("Welcome to BANG! lite");
        System.out.println("Let's play!");
        Scanner keyboard = new Scanner(System.in);
        int numberOfPlayers;

        while (true) {
            numberOfPlayers = ZKlavesnice.readInt("How many people want to play the game? (2-4)");

            if (numberOfPlayers > 4) {
                System.out.println("Too many players. Remember you can have max 4 players...");
            } else if (numberOfPlayers < 2) {
                System.out.println("Not enough players. Find more friends and come back...");
            } else {
                System.out.println("Everything is OK...");
                break;
            }
        }
        String name;

        name = ZKlavesnice.readString("What is the name of player nr. 1?");
        Players first = new Players(name);
        players.add(first);

        name = ZKlavesnice.readString("What is the name of player nr. 2?");
        Players second = new Players(name);
        players.add(second);

        if (numberOfPlayers == 3) {
            name = ZKlavesnice.readString("What is the name of player nr. 3?");
             Players third = new Players(name);
            players.add(third);
        }
        if (numberOfPlayers == 4) {
            name = ZKlavesnice.readString("What is the name of player nr. 3?");
            Players third = new Players(name);
            players.add(third);

            name = ZKlavesnice.readString("What is the name of player nr. 4?");
            Players fourth = new Players(name);
            players.add(fourth);
        } else if (numberOfPlayers < 2 || numberOfPlayers > 4){
            System.out.println("HOPLA, something went wrong, try again");
        }

        DeckOfCards.shuffleCards();
        dealCards(numberOfPlayers);

        do{
            playersTurn();
            movePlayer();
        }while (deadPlayers < numberOfPlayers - 1);

        System.out.println("The game winner is: " + players.get(0));
        System.out.println("\n Well done! \n\n Thanks for playing");

    }

    public void main(String[] args) {
        playGame();
    }

}

