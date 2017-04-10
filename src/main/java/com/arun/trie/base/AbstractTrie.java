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

package com.arun.trie.base;

import java.util.List;

/**
 * An ordered data structure that can be used to store key-value pairs and provide fast searching
 * of the order O(K) where K is the length of the key.
 * <p>
 * The key in this implementation is always of the type {@link String} and does not allow duplicates,
 * in the event of having a duplicate key, the value will be overwritten. All keys in the structure
 * are case insensitive by default and converted to lower case internally.
 */
public interface AbstractTrie<V> {
    char ROOT_KEY = ' ';

    void insert(String key, V value);

    void deleteKey(String key);

    boolean contains(String key);

    V get(String key);

    List<String> getKeySuggestions(String prefix);

    List<String> keys();

    List<V> getValueSuggestions(String prefix);

    List<V> values();

    void print();

    int size();

    void clear();

    void fastClear();
}
