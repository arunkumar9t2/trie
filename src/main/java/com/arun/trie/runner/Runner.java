package com.arun.trie.runner;

import com.arun.trie.MapTrie;
import com.arun.trie.SortedMapTrie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Runner {

    public static void main(String[] args) {
        final MapTrie<String> mapTrie = new SortedMapTrie<>();

        final List<String> words = getWords();
        // final List<String> words = getWordsFromFile();
        for (String word : words) {
            mapTrie.insert(word, word);
        }
        mapTrie.getKeySuggestions("th");
    }

    private static List<String> getWords() {
        final List<String> words = new ArrayList<>();
        words.add("THEM");
        words.add("THEMS");
        words.add("THEME");
        words.add("THEN");
        words.add("TOxic");
        words.add("TEA");
        words.add("Boa");
        words.add("Bob");
        words.add("Cat");
        return words;
    }

    private static List<String> getWordsFromFile() {
        final List<String> words = new ArrayList<>();
        final File file = new File("/Users/Arunkumar/Downloads/Words.txt");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.add(line);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
