package com.codecool.thehistory;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
//        for (String word : text.split("\\s+")) {
//            wordsArray = Arrays.copyOf( wordsArray, wordsArray.length+1);
//            wordsArray[wordsArray.length-1] = word;
//        }
        String[] words = text.split("\\s+");
        String [] result = Arrays.copyOf(wordsArray, wordsArray.length + words.length);
        System.arraycopy(words, 0, result, wordsArray.length, words.length);
        wordsArray=result;




    }

    @Override
    public void removeWord(String wordToBeRemoved) {
	//TODO: check the TheHistory interface for more information
        int index = 0;
        for (int i=0; i<wordsArray.length; i++) {
            if (!wordsArray[i].equals(wordToBeRemoved)) {
                wordsArray[index++] = wordsArray[i];
            }
        }
        String [] newArray = new String[index];
        System.arraycopy( wordsArray, 0, newArray, 0, index);
        wordsArray = newArray;

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
	//TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
	//TODO: check the TheHistory interface for more information
        for (int i=0;i<wordsArray.length;i++){
            if (wordsArray[i].equals(from)){
                wordsArray[i]=to;
            }
        }
    }
    public static int findIndex(String arr[], String t)
    {

        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String listString = "";

        for (String s : wordsArray) {
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

        wordsArray = listString.split("\\s+");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
