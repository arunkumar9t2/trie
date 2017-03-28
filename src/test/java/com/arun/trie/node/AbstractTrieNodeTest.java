package com.arun.trie.node;

import com.arun.trie.base.TrieNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arunkumar on 02/02/17.
 */
public abstract class AbstractTrieNodeTest {

    TrieNode<String> stringTrieNode;

    @Before
    public void setUp() throws Exception {
        createNode('a');
    }

    protected abstract TrieNode<String> createTrieNode(char character);

    @After
    public void tearDown() throws Exception {
        stringTrieNode.clear();
    }

    @Test
    public void getChar() throws Exception {
        createNode('a');
        assertEquals(stringTrieNode.getChar(), 'a');
    }

    @Test
    public void getValue() throws Exception {
        createNode('a');
        stringTrieNode.setValue("Arun");
        assertEquals("Arun", stringTrieNode.getValue());
        stringTrieNode.setValue("arun");
        assertEquals("arun", stringTrieNode.getValue());
        stringTrieNode.setValue("Weather");
        assertEquals("Weather", stringTrieNode.getValue());
    }

    @Test
    public void setValue() throws Exception {
        createNode('a');
        stringTrieNode.setValue("Arun");
        assertEquals("Arun", stringTrieNode.getValue());
        stringTrieNode.setValue("arun");
        assertEquals("arun", stringTrieNode.getValue());
        stringTrieNode.setValue("Weather");
        assertEquals("Weather", stringTrieNode.getValue());
    }

    @Test
    public void addChild() throws Exception {
        createNode('a');
    }

    @Test
    public void getChild() throws Exception {

    }

    @Test
    public void removeChild() throws Exception {

    }

    @Test
    public void containsChild() throws Exception {

    }

    @Test
    public void getChildren() throws Exception {
        createNode('a');
        stringTrieNode.addChild('b');
        stringTrieNode.addChild('c');
    }

    @Test
    public void isEnd() throws Exception {
        createNode('a');
        stringTrieNode.addChild('b');
        stringTrieNode.addChild('c');
        assertFalse(stringTrieNode.isEnd());
        stringTrieNode.removeChild('b');
        stringTrieNode.removeChild('c');
        assertTrue(stringTrieNode.isEnd());
    }

    @Test
    public void isKey() throws Exception {
        createNode('a');
        stringTrieNode.setKey(true);
        assertTrue(stringTrieNode.isKey());
        stringTrieNode.setKey(false);
        assertFalse(stringTrieNode.isKey());
    }

    @Test
    public void setKey() throws Exception {
        createNode('a');
        stringTrieNode.setKey(true);
        assertTrue(stringTrieNode.isKey());
        stringTrieNode.setKey(false);
        assertFalse(stringTrieNode.isKey());
    }

    @Test
    public void clear() throws Exception {
        createNode('a');
        stringTrieNode.addChild('b');
        stringTrieNode.addChild('c');
        stringTrieNode.addChild('d');
        stringTrieNode.clear();
        assertTrue(stringTrieNode.getChildren().isEmpty());
        assertTrue(stringTrieNode.isEnd());
    }

    private void createNode(char character) {
        stringTrieNode = createTrieNode(character);
    }

}