package com.examples.code2;

import java.io.*;
import java.util.StringJoiner;


/**
 *
 * С консоли считываются адреса двух текстовых файлов.
 * Сначала источник (например c:/source.txt).
 * Затем получатель (например c:/destination.txt).
 * Источник содержит слова разделенные пробелом.
 * В получатель через запятую(StringJoiner) запишутся слова,
 * состоящие из более 9 букв.
 *
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader filenameReader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFile = filenameReader.readLine();
        String destinationFile = filenameReader.readLine();

        BufferedReader readerFromFile = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writerToFile = new BufferedWriter(new FileWriter(destinationFile));
        StringJoiner joiner = new StringJoiner(",");
        while(readerFromFile.ready()) {
            String[] tmp = readerFromFile.readLine().split(" ");
            for (String s : tmp) {
                if(s.length() > 9) joiner.add(s);
            }
        }
        writerToFile.write(String.valueOf(joiner));

        readerFromFile.close();
        writerToFile.close();
    }
}
