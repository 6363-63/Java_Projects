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
        String template,template1="";
        HashMap<String , Integer> words=new HashMap<>();
       int i;

        while ((template=br.readLine()) != null) { // read line
            int j=1;
            String lastWord = "";
            int count=0;
            for ( String s : template.split("\\s+")) { // split with space , returns string array
                template1=lastWord+" "+s;
                lastWord=s;
                if(j>1){
                    if(words.containsKey(template1)){ // engin akin naber selam
                        Integer counter=words.get(template1);
                        counter++;
                        words.replace(template1,counter);
                    }else words.put(template1,1);
                    template1="";
                }
                j++;
            }
        }
        words=sortByValue(words);
        i=0;
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
