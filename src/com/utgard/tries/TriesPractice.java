package com.utgard.tries;

public class TriesPractice {
    public void practice () {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
//        trie.insert("card");
//        trie.insert("careful");
//        trie.insert("egg");
        String[] test = {"cool"};

        System.out.println(trie.longestCommonPrefix(test));
    }
}
