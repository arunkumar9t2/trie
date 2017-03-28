package com.arun.trie.node;


import com.arun.trie.base.TrieNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Arunkumar on 02/12/16.
 */
public class HashMapNode<V> extends AbstractMapNode<V> {

    public HashMapNode(char character) {
        super(character);
    }

    @Override
    protected Map<Character, TrieNode<V>> onCreateMap() {
        return new LinkedHashMap<>();
    }

    @Override
    protected AbstractMapNode<V> onCreateNewNode(char character) {
        return new HashMapNode<>(character);
    }
}
