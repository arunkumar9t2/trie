package com.arun.trie.node;


import com.arun.trie.base.TrieNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Arunkumar on 02/12/16.
 */
public class TreeMapNode<V> extends AbstractMapNode<V> {

    public TreeMapNode(char character) {
        super(character);
    }

    @Override
    protected Map<Character, TrieNode<V>> onCreateMap() {
        return new TreeMap<>();
    }

    @Override
    protected AbstractMapNode<V> onCreateNewNode(char character) {
        return new TreeMapNode<>(character);
    }
}
