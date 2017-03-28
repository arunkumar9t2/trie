package com.arun.trie.node;

import com.arun.trie.base.TrieNode;

/**
 * Created by Arunkumar on 02/02/17.
 */

public class HashMapNodeTest extends AbstractTrieNodeTest {

    @Override
    protected TrieNode<String> createTrieNode(char character) {
        return new HashMapNode<>(character);
    }
}
