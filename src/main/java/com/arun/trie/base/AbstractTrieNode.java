package com.arun.trie.base;

import java.util.LinkedList;

/**
 * Created by Arunkumar on 24/11/16.
 */
public abstract class AbstractTrieNode<V> implements TrieNode<V> {

    private final char character;
    private boolean key;
    private V value;

    protected AbstractTrieNode(char character) {
        key = false;
        value = null;
        this.character = character;
    }

    @Override
    public char getChar() {
        return character;
    }

    @Override
    public V getValue() {
        return value;
    }


    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean isKey() {
        return key;
    }

    @Override
    public void setKey(boolean isKey) {
        this.key = isKey;
        if (!isKey) {
            value = null;
        }
    }

    @Override
    public void clear() {
        value = null;
        key = false;
        for (TrieNode<V> node : getChildren()) {
            node.clear();
        }
    }

    @Override
    public void print() {
        print("", true);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        formString("", true, result);
        return result.toString();
    }

    private void formString(final String prefix, final boolean isTail, StringBuilder result) {
        final String data = value != null ? value.toString() : "";
        final String suffix = isTail ? "    " : "│   ";

        result.append(prefix)
                .append(isTail ? "└── " : "├── ")
                .append(character)
                .append(key ? "\'" + data : "")
                .append("\n");

        final LinkedList<TrieNode<V>> nodes = new LinkedList<>(getChildren());
        for (int i = 0; i < nodes.size() - 1; i++) {
            final AbstractTrieNode<V> child = (AbstractTrieNode<V>) nodes.get(i);
            child.formString(prefix + suffix, false, result);

        }
        if (!nodes.isEmpty()) {
            final AbstractTrieNode<V> child = (AbstractTrieNode<V>) nodes.getLast();
            child.formString(prefix + suffix, true, result);
        }
    }

    private void print(final String prefix, final boolean isTail) {
        final String data = value != null ? value.toString() : "";
        final String suffix = isTail ? "    " : "│   ";

        System.out.println(prefix
                + (isTail ? "└── " : "├── ")
                + character + (key ? "\'" + data : ""));

        final LinkedList<TrieNode<V>> nodes = new LinkedList<>(getChildren());

        for (int i = 0; i < nodes.size() - 1; i++) {
            final AbstractTrieNode<V> child = (AbstractTrieNode<V>) nodes.get(i);
            child.print(prefix + suffix, false);
        }
        if (!nodes.isEmpty()) {
            final AbstractTrieNode<V> child = (AbstractTrieNode<V>) nodes.getLast();
            child.print(prefix + suffix, true);
        }
    }

}
