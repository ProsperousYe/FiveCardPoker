package comp1721.cwk2;

import java.util.*;

// Implement PokerHand class here
public class PokerHand extends CardCollection{
    public PokerHand(){
        super();
    }

    public PokerHand(String s){
        super();
        String[] strings = s.split(" ");
        if(strings.length>5){
            throw new CardException("too many cards");
        } else {
            for(String string : strings) {
                cards.add(new Card(string));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0;i<cards.size();i++) {
            string.append(cards.get(i).toString());
            if(i<cards.size()-1){
                string.append(" ");
            }
        }
        return string.toString();
    }

    public int size(){
        return super.size();
    }

    public void discard(){
        if(cards.isEmpty()){
            throw new CardException("hand is empty");
        } else {
            super.discard();
        }
    }

    public void discardTo(Deck deck){
        if(cards.isEmpty()){
            throw new CardException("hand is empty");
        } else {
            for (Card card: cards) {
                deck.add(card);
            }
            cards.clear();
        }
    }

    public boolean isPair(){
        HashSet<Card.Rank> hashSet = new HashSet<>();
        for(Card card : cards){
            hashSet.add(card.getRank());
        }
        return hashSet.size() == 4;
    }

    public boolean isTwoPairs(){
        HashSet<Card.Rank> hashSet = new HashSet<>();
        HashMap<Card.Rank, Integer> hashMap = new HashMap<>();
        for(Card card : cards){
            hashSet.add(card.getRank());
        }
        for(Card card : cards){
            if(hashMap.containsKey(card.getRank())){
                hashMap.put(card.getRank(), hashMap.get(card.getRank())+1);
            } else {
                hashMap.put(card.getRank(), 1);
            }
        }
        int max = 0;
        for (Integer value: hashMap.values()) {
            if(max <= value){
                max = value;
            }
        }
        return hashSet.size() == 3 && max == 2;
    }

    public boolean isThreeOfAKind(){
        HashSet<Card.Rank> hashSet = new HashSet<>();
        HashMap<Card.Rank, Integer> hashMap = new HashMap<>();
        for(Card card : cards){
            hashSet.add(card.getRank());
        }
        for(Card card : cards){
            if(hashMap.containsKey(card.getRank())){
                hashMap.put(card.getRank(), hashMap.get(card.getRank())+1);
            } else {
                hashMap.put(card.getRank(), 1);
            }
        }
        int max = 0;
        for (Integer value: hashMap.values()) {
            if(max <= value){
                max = value;
            }
        }
        return hashSet.size() == 3 && max == 3;
    }

    public boolean isFourOfAKind(){
        HashSet<Card.Rank> hashSet = new HashSet<>();
        HashMap<Card.Rank, Integer> hashMap = new HashMap<>();
        for(Card card : cards){
            hashSet.add(card.getRank());
        }
        for(Card card : cards){
            if(hashMap.containsKey(card.getRank())){
                hashMap.put(card.getRank(), hashMap.get(card.getRank())+1);
            } else {
                hashMap.put(card.getRank(), 1);
            }
        }
        int max = 0;
        for (Integer value: hashMap.values()) {
            if(max <= value){
                max = value;
            }
        }
        return hashSet.size() == 2 && max == 4;
    }

    public boolean isFullHouse(){
        HashSet<Card.Rank> hashSet = new HashSet<>();
        HashMap<Card.Rank, Integer> hashMap = new HashMap<>();
        for(Card card : cards){
            hashSet.add(card.getRank());
        }
        for(Card card : cards){
            if(hashMap.containsKey(card.getRank())){
                hashMap.put(card.getRank(), hashMap.get(card.getRank())+1);
            } else {
                hashMap.put(card.getRank(), 1);
            }
        }
        int max = 0;
        for (Integer value: hashMap.values()) {
            if(max <= value){
                max = value;
            }
        }

        return hashSet.size() == 2 && max == 3;
    }

    public boolean isFlush(){
        HashSet<Card.Suit> hashSet = new HashSet<>();
        HashMap<Card.Suit, Integer> hashMap = new HashMap<>();
        for(Card card : cards){
            hashSet.add(card.getSuit());
        }
        for(Card card : cards){
            if(hashMap.containsKey(card.getSuit())){
                hashMap.put(card.getSuit(), hashMap.get(card.getSuit())+1);
            } else {
                hashMap.put(card.getSuit(), 1);
            }
        }
        int max = 0;
        for (Integer value: hashMap.values()) {
            if(max <= value){
                max = value;
            }
        }
//        System.out.println(hashSet);
//        System.out.println(hashMap);
//        System.out.println(hashSet.size());
        return hashSet.size() == 1 && max == 5;
    }

    public boolean isStraight(){
        HashSet<Integer> hashSet = new HashSet<>();
        int[] rankArray = new int[5];
        for(int i = 0; i<cards.size();i++){
            hashSet.add(rankToInteger(cards.get(i).getRank()));
            rankArray[i] = rankToInteger(cards.get(i).getRank());
        }
        System.out.println(hashSet);
        System.out.println(Arrays.toString(rankArray));
        if(hashSet.size()==5){
            Arrays.sort(rankArray);
            System.out.println(Arrays.toString(rankArray));
            if(rankArray[2]<11&&rankArray[2]>2) {
                if (rankArray[0] == rankArray[2] - 2 && rankArray[1] == rankArray[2] - 1 && rankArray[3] == rankArray[2] + 1 && rankArray[4] == rankArray[2] + 2){
                    return true;
                } else {
                    return false;
                }
            } else {
                if(rankArray[2]==2&&rankArray[0]==13&&rankArray[1]==1&&rankArray[3]==3&&rankArray[4]==4){
                    return true;
                } else if(rankArray[2]==1&&rankArray[0]==12&&rankArray[1]==13&&rankArray[3]==2&&rankArray[4]==3){
                    return true;
                } else if(rankArray[2]==11&&rankArray[0]==1&&rankArray[1]==10&&rankArray[3]==12&&rankArray[4]==13){
                    return true;
                } else if(rankArray[2]==12&&rankArray[0]==1&&rankArray[1]==2&&rankArray[3]==3&&rankArray[4]==13){
                    return true;
                } else if(rankArray[2]==13&&rankArray[0]==1&&rankArray[1]==2&&rankArray[3]==11&&rankArray[4]==12){
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private int rankToInteger(Card.Rank rank) {
        return switch (rank.getSymbol()) {
            case 'A' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'T' -> 10;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    @Override
    public void add(Card card){
        if(cards.contains(card)){
            throw new CardException("have contained");
        } else if(cards.size()==5){
            throw new CardException("full!");
        } else {
            cards.add(card);
        }
    }
}
