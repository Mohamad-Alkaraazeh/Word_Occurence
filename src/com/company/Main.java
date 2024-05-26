package com.company;

import StringAnalyzer.StringOccurence;
import StringAnalyzer.StringOccurenceAnalyzer;

import java.io.IOException;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        String fileName = "C:\\StringOccurence\\faust.txt";
        ArrayList<String> words = new ArrayList<String>();
        Scanner input;

        try {
            input = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Es ist ein Fehler aufgetreten: Datei nicht lesbar");
            return;
        }

        while (input.hasNext()) {
            String word = input.next().replaceAll("[^a-zA-Z0-9]", "");
            if (!word.isEmpty()) {
               words.add(word);
            }
        }
        input.close();


        StringOccurenceAnalyzer stringOccurenceAnalyzer = new StringOccurenceAnalyzer();
        List<StringOccurence> occur = stringOccurenceAnalyzer.analyse(words);

        int count = 0;
        for(StringOccurence item: occur){
            count++;
            if (count == 10){
                break;
            }
            System.out.println(item.getWord() + ": " + item.getOccurence());
        }
    }

}
