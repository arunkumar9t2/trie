# Trie
A java implementation of the Prefix Trie data structure.

# Introduction
Tries are map like ordered tree based data structures that provide fast searching of the order `O(k)` where `k` is the length of key. Read more about trie [here](https://en.wikipedia.org/wiki/Trie).

# Motivation
This was initially built to use in my Android app, **T9 App Launcher** to quickly search through list of installed applications and launch them.

# Public APIs
Currently there are 3 public implementations that can be chosen from.

 - **`MapTrie`:** `HashMap` backed trie implementation. 
 - **`SortedTrie`:** `TreeMap` backed trie implementation which returns suggestions and value is ascending sort order.
 - **`T9Trie`:** Helper implementation to store and retrieve suggestions for T9 sequence.

## Example usage
Creating a simple trie and getting suggestions.

    final MapTrie<String> trie = new MapTrie<>();

    trie.insert("Hello", "Hello");
    trie.insert("Help", "Help");
    trie.insert("Has", "Has");
    trie.insert("Have", "Have");
    trie.insert("Had", "Had");
    trie.insert("Hadn't", "Hadn't");
        
    // Print to stdout
    trie.print();

The above `print()` call would print the tree structure like this.

    └── h
        ├── e
        │   └── l
        │       ├── l
        │       │   └── o'Hello
        │       └── p'Help
        └── a
            ├── s'Has
            ├── v
            │   └── e'Have
            └── d'Had
                └── n
                    └── '
                        └── t'Hadn't
Now let's try to find all the words starting with `ha`. Remember that, by default the keys are **case insensitive.**

    List<String> suggestions = trie.getValueSuggestions("ha");
    System.out.print(suggestions.toString());
This will print `[Has, Have, Had, Hadn't]` to the console. **The value is left untouched.**

# Contribution
If you are a developer and would like to contribute please consider making a pull request. I would appreciate any criticisms with regards to code or implementation in general.

# License
This project is licensed under Apache 2.0 license.


