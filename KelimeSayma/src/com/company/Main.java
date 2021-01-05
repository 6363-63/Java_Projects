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
        HashMap<String , Integer> words=new HashMap<>();
        while (br.readLine() != null) { // read line to line
            for ( String s: br.readLine().split("\\s+")) {
                if(words.containsKey(s)){
                    Integer counter=words.get(s);
                    counter++;
                    words.replace(s,counter);
                }else words.put(s,1);
            }
        }
        for (Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue()!=null) {
                System.out.println(word.getValue()+" --- "+word.getKey());
            }
        }
        in.close();
    }



}
