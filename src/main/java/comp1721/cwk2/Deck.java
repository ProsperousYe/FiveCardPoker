package comp1721.cwk2;

import java.util.ArrayList;
import java.util.Collections;

// Implement Deck class here
public class Deck extends CardCollection {
    public Deck(){
        super();
        for(int i = 0;i<4;i++){
            String Suit = switch (i) {
                case 0 -> "C";
                case 1 -> "D";
                case 2 -> "S";
                case 3 -> "H";
                default -> throw new IllegalStateException("Unexpected value: " + i);
            };
            for(int j = 0; j < 13;j++){
                String Rank = switch (j) {
                    case 0 -> "A";
                    case 1 -> "2";
                    case 2 -> "3";
                    case 3 -> "4";
                    case 4 -> "5";
                    case 5 -> "6";
                    case 6 -> "7";
                    case 7 -> "8";
                    case 8 -> "9";
                    case 9 -> "T";
                    case 10 -> "J";
                    case 11 -> "Q";
                    case 12 -> "K";
                    default -> throw new IllegalStateException("Unexpected value: " + j);
                };
                Card card = new Card(Rank+Suit);
                cards.add(card);
            }
        }
    }

    public int size(){
        return cards.size();
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

    public boolean contains(Card card){
        return super.contains(card);
    }

    public void discard(){
        if(cards.isEmpty()){
            throw new CardException("deck is empty");
        } else {
            super.discard();
        }
    }

    public Card deal(){
        if(cards.isEmpty()){
            throw new CardException("deck is empty");
        } else {
            Card card = cards.get(0);
            cards.remove(0);
            return card;
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public void add(Card card){
        if(cards.contains(card)){
            throw new CardException("have contained");
        } else if(cards.size()==52){
            throw new CardException("has full");
        } else {
            cards.add(card);
        }
    }
}