package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
public class Main {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("filename.txt"); // file path
        BufferedReader br = new BufferedReader(in);
        String[] templete=new String[150];
        HashMap<String , Integer> words=new HashMap<>(); // engin 1 sdad ada
        while (br.readLine() != null) { // read line to line
            for ( String s: br.readLine().split("\\s+")) {
                if(words.containsKey(s)){
                    Integer counter=words.get(s);
                    counter++;
                    words.replace(s,counter);
                }else words.put(s,1);
            }
        }
        words=sortByValue(words);
        int i=0;
        for (Entry<String, Integer> word : words.entrySet() ) { //  write most used  ten words
            if (word.getValue()!=null && i<10) {
                System.out.println(word.getValue()+" --- "+word.getKey());
                i++;
            }
        }
        in.close();
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> > () {
            public int compare(Map.Entry<String, Integer> o1,  Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }




}
