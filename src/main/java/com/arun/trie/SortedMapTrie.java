package com.arun.trie;


import com.arun.trie.base.TrieNode;
import com.arun.trie.node.TreeMapNode;

/**
 * Created by Arunkumar on 02/12/16.
 */
public class SortedMapTrie<V> extends MapTrie<V> {

    @Override
    protected TrieNode<V> onCreateRootNode() {
        return new TreeMapNode<>(' ');
    }
}
