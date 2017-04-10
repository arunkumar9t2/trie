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

package com.arun.trie;

import com.arun.trie.base.TrieNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arunkumar on 06/02/17.
 */
public class T9Trie<V> extends MapTrie<LinkedList<V>> {

    @Override
    public void insert(String key, LinkedList<V> value) {
        if (key == null) {
            return;
        }
        key = trimLowercaseString(key);

        key = convertWordToT9(key);

        TrieNode<LinkedList<V>> crawler = root;
        for (int i = 0; i < key.length(); i++) {
            final char c = key.charAt(i);
            if (!crawler.containsChild(c)) {
                crawler = crawler.addChild(c);
            } else {
                crawler = crawler.getChild(c);
            }
        }
        crawler.setKey(true);

        if (crawler.getValue() == null) {
            crawler.setValue(new LinkedList<V>());
        }

        final LinkedList<V> valuesList = crawler.getValue();
        valuesList.addAll(value);

        crawler.setValue(valuesList);
    }

    @Override
    public LinkedList<V> get(String key) {
        LinkedList<V> value = super.get(key);
        if (value == null) {
            return new LinkedList<>();
        }
        return value;
    }

    public List<V> getT9ValueSuggestions(String prefix) {
        if (prefix == null) {
            return Collections.emptyList();
        }
        prefix = trimLowercaseString(prefix);

        TrieNode<LinkedList<V>> crawler = root;
        for (int i = 0; i < prefix.length(); i++) {
            final char c = prefix.charAt(i);
            if (crawler.containsChild(c)) {
                crawler = crawler.getChild(c);
            } else {
                break;
            }
        }
        final List<V> suggestions = new LinkedList<>();
        findValueSuggestions(crawler, suggestions);
        return suggestions;
    }

    public List<V> t9Values() {
        final List<LinkedList<V>> valuesList = super.values();
        final List<V> mergedValues = new LinkedList<>();
        for (final LinkedList<V> sublist : valuesList) {
            mergedValues.addAll(sublist);
        }
        return mergedValues;
    }

    @Override
    public void deleteKey(String key) {
        super.deleteKey(convertWordToT9(key));
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(final TrieNode<LinkedList<V>> node) {
        int sum = 0;
        if (node.isKey()) {
            sum = node.getValue().size();
        }
        for (final TrieNode<LinkedList<V>> child : node.getChildren()) {
            sum += size(child);
        }
        return sum;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void insertValue(String key, V value) {
        final LinkedList<V> list = new LinkedList<>();
        list.add(value);
        insert(key, list);
    }

    private void findValueSuggestions(final TrieNode<LinkedList<V>> trieNode, final List<V> suggestions) {
        if (trieNode == null) {
            return;
        }
        if (trieNode.isKey()) {
            final LinkedList<V> values = trieNode.getValue();
            if (suggestions != null) {
                suggestions.addAll(values);
            } else {
                System.out.println("Null value for a key encountered");
            }
        }
        if (trieNode.isEnd()) {
            return;
        }
        for (final TrieNode<LinkedList<V>> child : trieNode.getChildren()) {
            findValueSuggestions(child, suggestions);
        }
    }

    private char getNumberForChar(char character) {
        if (Character.isDigit(character)) {
            return character;
        }
        switch (character) {
            case 'a':
            case 'b':
            case 'c':
                return '2';
            case 'd':
            case 'e':
            case 'f':
                return '3';
            case 'g':
            case 'h':
            case 'i':
                return '4';
            case 'j':
            case 'k':
            case 'l':
                return '5';
            case 'm':
            case 'n':
            case 'o':
                return '6';
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return '7';
            case 't':
            case 'u':
            case 'v':
                return '8';
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return '9';

        }
        return '0';
    }

    private String convertWordToT9(String word) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.toLowerCase().length(); i++) {
            final char convertedChar = getNumberForChar(word.charAt(i));
            if (convertedChar != '0')
                builder.append(convertedChar);
        }
        return builder.toString();
    }
}
