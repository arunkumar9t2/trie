package com.arun.trie.node;


import com.arun.trie.base.AbstractTrieNode;
import com.arun.trie.base.TrieNode;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Arunkumar on 24/11/16.
 */
abstract class AbstractMapNode<V> extends AbstractTrieNode<V> {

    private final Map<Character, TrieNode<V>> children;

    AbstractMapNode(char character) {
        super(character);
        children = createMap();
    }

    private Map<Character, TrieNode<V>> createMap() {
        return onCreateMap();
    }

    private AbstractMapNode<V> createNode(char character) {
        return onCreateNewNode(character);
    }

    protected abstract Map<Character, TrieNode<V>> onCreateMap();

    protected abstract AbstractMapNode<V> onCreateNewNode(char character);

    @Override
    public TrieNode<V> addChild(final char character) {
        final AbstractMapNode<V> leafNode = createNode(character);
        children.put(character, leafNode);
        return leafNode;
    }

    @Override
    public TrieNode<V> getChild(final char character) {
        if (children.containsKey(character)) {
            return children.get(character);
        } else {
            return null;
        }
    }

    @Override
    public void removeChild(final char character) {
        TrieNode<V> removedNode = children.remove(character);
        if (removedNode != null) {
            removedNode.clear();
            removedNode = null;
        }
    }

    @Override
    public boolean containsChild(final char c) {
        return children.containsKey(c);
    }

    @Override
    public Collection<TrieNode<V>> getChildren() {
        return children.values();
    }

    @Override
    public boolean isEnd() {
        return children.values().isEmpty();
    }

    @Override
    public void clear() {
        super.clear();
        children.clear();
    }
}
