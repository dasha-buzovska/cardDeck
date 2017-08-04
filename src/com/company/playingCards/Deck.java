package com.company.playingCards;

import java.util.ArrayList;

/**
 * Created by user on 04.08.2017
 */
public class Deck {
    private final int suitSize = Suit.values.length;
    private final int rankSize = Rank.values.length;
    ArrayList<Card> cards = new ArrayList<>();
    int counter = suitSize*rankSize - 1;
    //Card[] cards = new Card[suitSize*rankSize];

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<>();
        while(!cards.isEmpty()) {
            int loc = (int) (Math.random() * cards.size());
            temp.add(cards.get(loc));
            cards.remove(loc);
        }
        cards = temp;
    }

    public void order() {
        for (int i = 0; i < suitSize; i++) {
            for (int j = 0; j < rankSize; j++) {
                cards.add(new Card(Rank.values[j], Suit.values[i]));
            }
        }
    }

        //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return cards.size() > 0;
    }

        //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
        //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
        //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (hasNext()) {
            Card lastOne = cards.get(counter);
            cards.remove(counter);
            counter--;
            return lastOne;
        }
        return null;
    }
}
