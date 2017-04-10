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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Arunkumar on 06/02/17.
 */
public class T9TrieTest {
    private T9Trie<String> t9SortTrie;

    @Before
    public void setUp() throws Exception {
        initTrie();
    }

    @After
    public void tearDown() throws Exception {
        t9SortTrie.clear();
    }

    @Test
    public void deleteKey() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.deleteKey("2255");
        assertTrue(!t9SortTrie.contains("2255"));
    }

    @Test
    public void contains() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        assertTrue(t9SortTrie.contains("2255"));
    }

    @Test
    public void get() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        LinkedList<String> value = t9SortTrie.get("2255");
        assertEquals(2, value.size());
        assertEquals("call", value.get(0));
        assertEquals("ball", value.get(1));
    }

    @Test
    public void getKeySuggestions() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("abcd", "abcd");
        final List<String> keys = t9SortTrie.getKeySuggestions("22");
        assertEquals(2, keys.size());
        assertEquals("2223", keys.get(0));
        assertEquals("2255", keys.get(1));
    }

    @Test
    public void keys() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("abcd", "abcd");
        final List<String> keys = t9SortTrie.keys();
        assertEquals(2, keys.size());
        assertEquals("2223", keys.get(0));
        assertEquals("2255", keys.get(1));
    }

    @Test
    public void getValueSuggestions() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        final List<String> values = t9SortTrie.getT9ValueSuggestions("22");
        assertEquals(2, values.size());
        assertEquals("call", values.get(0));
        assertEquals("ball", values.get(1));
    }

    @Test
    public void t9Values() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        final List<String> values = t9SortTrie.t9Values();
        assertEquals(2, values.size());
        assertEquals("call", values.get(0));
        assertEquals("ball", values.get(1));
    }

    @Test
    public void size() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        t9SortTrie.insertValue("abcd", "abcd");
        assertEquals(3, t9SortTrie.size());
        t9SortTrie.deleteKey("2255");
        assertEquals(1, t9SortTrie.size());
    }

    @Test
    public void clear() throws Exception {
        clearTest();
    }

    @Test
    public void fastClear() throws Exception {
        clearTest();
    }

    private void clearTest() {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        t9SortTrie.clear();
        assertEquals(0, t9SortTrie.size());
    }

    @Test
    public void insert() throws Exception {
        /*initTrie();
        final LinkedList<String> values = new LinkedList<>();
        values.add("call");
        t9SortTrie.insert("call", values);*/
    }

    @Test
    public void insertValue() throws Exception {
        initTrie();
        t9SortTrie.insertValue("call", "call");
        t9SortTrie.insertValue("ball", "ball");
        t9SortTrie.insertValue("calk", "calk");
        t9SortTrie.insertValue("calj", "calj");
        t9SortTrie.insertValue("arun", "arun");
        t9SortTrie.insertValue("bqvo", "bqvo");
    }

    private void initTrie() {
        t9SortTrie = new T9Trie<>();
    }

}