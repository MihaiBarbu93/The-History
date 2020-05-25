package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        for (String word : text.split("\\s+")) {
           wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
//        wordsArrayList.set(wordsArrayList.indexOf(from) , to);
        for(int i=0;i<wordsArrayList.size();i++){
            if(wordsArrayList.get(i).equals(from)){
                wordsArrayList.set(i, to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String listString = "";

        for (String s : wordsArrayList) {
            listString += s + "\t";
        }

        String from1 = "";

        for (String t : fromWords) {
            from1 += t + "\t";
        }

        String to = "";

        for (String y : toWords) {
            to += y + "\t";
        }

        listString = listString.replaceAll(from1, to);
        wordsArrayList =new ArrayList<String>(Arrays.asList(listString.split("\t")));

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
