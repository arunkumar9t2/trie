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

import com.arun.trie.base.AbstractTrie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Arunkumar on 01/02/17.
 */
public abstract class AbstractStringTrieTest {

    private static final String TONY_STARK = "Tony Stark";
    private static final String BARRY_ALLEN = "Barry Allen";
    private static final String TOM_HANKS = "Tom Hanks";

    private AbstractTrie<String> stringTrie;

    @Before
    public void setUp() throws Exception {
        createRootTrie();
    }

    protected abstract AbstractTrie<String> createTrie();

    @After
    public void tearDown() throws Exception {
        stringTrie.clear();
        stringTrie = null;
    }

    @Test
    public void insert() throws Exception {
        createRootTrie();
        insertValueToTrie(null);
        assertTrue(stringTrie.size() == 0);
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TONY_STARK);
        insertValueToTrie("   " + TONY_STARK + " ");
        insertValueToTrie("   " + TONY_STARK.toLowerCase() + " ");
        insertValueToTrie(TONY_STARK.toLowerCase());
        assertTrue(stringTrie.size() == 1);
        insertValueToTrie(TOM_HANKS);
        assertTrue(stringTrie.size() == 2);
    }

    @Test
    public void deleteKey() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        stringTrie.deleteKey(TONY_STARK);
        assertTrue("Delete key", stringTrie.size() == 0);
    }

    @Test
    public void contains() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        assertTrue("Contains", stringTrie.contains(TONY_STARK));
    }

    @Test
    public void get() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        assertEquals(TONY_STARK, stringTrie.get(TONY_STARK));
        insertValueToTrie(TOM_HANKS);
        assertEquals(TOM_HANKS, stringTrie.get(TOM_HANKS));
    }

    @Test
    public void getKeySuggestions() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);

        final List<String> tSuggestions = stringTrie.getKeySuggestions("T");
        assertTrue(tSuggestions.contains(TONY_STARK.toLowerCase()));
        assertTrue(tSuggestions.contains(TOM_HANKS.toLowerCase()));

        final List<String> tonySuggestions = stringTrie.getKeySuggestions("TONY");
        assertTrue(tonySuggestions.contains(TONY_STARK.toLowerCase()));
        assertFalse(tonySuggestions.contains(TONY_STARK));
    }

    @Test
    public void keys() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);

        final List<String> suggestions = stringTrie.keys();
        assertTrue(suggestions.contains(TONY_STARK.toLowerCase()));
        assertTrue(suggestions.contains(TOM_HANKS.toLowerCase()));
        assertFalse(suggestions.contains("None"));
    }

    @Test
    public void getValueSuggestions() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);

        final List<String> tSuggestions = stringTrie.getValueSuggestions("T");
        assertTrue(tSuggestions.contains(TONY_STARK));
        assertTrue(tSuggestions.contains(TOM_HANKS));
        assertFalse(tSuggestions.contains(TONY_STARK.toLowerCase()));
        assertFalse(tSuggestions.contains(TOM_HANKS.toLowerCase()));

        final List<String> tonySuggestions = stringTrie.getValueSuggestions("TONY");
        assertTrue(tonySuggestions.contains(TONY_STARK));
        assertFalse(tonySuggestions.contains(TOM_HANKS));
        assertFalse(tonySuggestions.contains(TONY_STARK.toLowerCase()));
    }

    @Test
    public void values() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);

        final List<String> suggestions = stringTrie.values();
        assertTrue(suggestions.contains(TONY_STARK));
        assertTrue(suggestions.contains(TOM_HANKS));
        assertFalse(suggestions.contains(TONY_STARK.toLowerCase()));
        assertFalse(suggestions.contains(TOM_HANKS.toLowerCase()));
    }

    @Test
    public void size() throws Exception {
        createRootTrie();

        assertTrue(stringTrie.size() == 0);
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);
        assertTrue(stringTrie.size() == 2);
        stringTrie.deleteKey(TONY_STARK);
        assertTrue(stringTrie.size() == 1);
        stringTrie.deleteKey(TOM_HANKS);
        assertTrue(stringTrie.size() == 0);
    }

    @Test
    public void clear() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);
        stringTrie.clear();
        assertTrue(stringTrie.size() == 0);
    }

    @Test
    public void fastClear() throws Exception {
        createRootTrie();
        insertValueToTrie(TONY_STARK);
        insertValueToTrie(TOM_HANKS);
        stringTrie.fastClear();
        assertTrue(stringTrie.size() == 0);
    }

    private void createRootTrie() {
        stringTrie = createTrie();
    }

    private void insertValueToTrie(String value) {
        stringTrie.insert(value, value);
    }
}