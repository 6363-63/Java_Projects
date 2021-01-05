package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


     /*
        // read file way 1  scanner class
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


      */
        // read file way 2 with bufferreader class

        FileReader in = new FileReader("filename.txt"); // file path
        BufferedReader br = new BufferedReader(in);

        while (br.readLine() != null) { // read line to line
            System.out.println(br.readLine()); // output scream
        }
        in.close();



    }
}
