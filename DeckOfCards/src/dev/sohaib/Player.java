package dev.sohaib;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> deck;

    public Player(String name) {
        this.name = name;
        this.deck = new ArrayList<>();
    }

    public void addCards(List<Card> deck) {
        this.deck.addAll(deck);
    }

    public Card playCard() {
        return this.deck.removeFirst();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public int getCardCount() {
        return deck.size();
    }
}
