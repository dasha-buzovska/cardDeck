package com.company.playingCards;

/**
 * Created by user on 04.08.2017
 */
public class Play {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.order();
        deck.shuffle();

        for (int i = 0; i < deck.cards.size(); i++) {
            System.out.println(deck.cards.get(i).getRank().getName() + " " + deck.cards.get(i).getSuit().getName());
        }

        System.out.println(deck.drawOne().getRank().getName() + " " + deck.drawOne().getSuit().getName());
        System.out.println(deck.hasNext());

    }
}
