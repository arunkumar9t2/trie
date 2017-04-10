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
 * Created by Arunkumar on 01/12/16.
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
