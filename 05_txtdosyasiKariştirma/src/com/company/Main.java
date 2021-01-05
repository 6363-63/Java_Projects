package com.company;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("filename.txt"); // source file path
        FileWriter sn=new FileWriter("destfile.txt"); // destination file path
        BufferedReader br = new BufferedReader(in);
        BufferedWriter wr=new BufferedWriter(sn);
        LinkedList<String> words=new LinkedList<>();
        String line;
        while ((line=br.readLine()) != null) { // read line to line
            for ( String s: line.split("\\s")) {
                words.add(s);
            }
        }
        Collections.shuffle(words);
        wr.write(String.valueOf(words).replaceAll(",","\\s")); //
        in.close();
    }
}
