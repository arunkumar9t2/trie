package com.arun.trie;

import com.arun.trie.base.AbstractTrie;

/**
 * Created by Arunkumar on 01/02/17.
 */

public class StringMapTrieTest extends AbstractStringTrieTest {

    @Override
    protected AbstractTrie<String> createTrie() {
        return new MapTrie<>();
    }
}
