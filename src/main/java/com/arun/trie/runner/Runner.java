/*
 * Copyright 2017 Arunkumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
