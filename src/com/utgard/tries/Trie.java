package com.utgard.tries;

import java.util.*;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild (char ch) {
            return children.get(ch) != null;
        }

        public boolean hasNoChild () {
            return children.isEmpty();
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        public Node getChild (char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public int countChildren() {
            return children.size();
        }

        public Node getOnlyChild () {
            if (countChildren() == 1)
                return children.get(children.keySet().toArray()[0]);
            return null;
        }
    }

    private Node root = new Node(' ');


    public void insert (String word) {
        var current = root;

        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains (String word) {
        if (word == null)
            return false;

        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse () {
        traverse(root);
    }

    private void traverse (Node root) {

        for (var child : root.getChildren())
            traverse(child);
        System.out.println(root.value);
    }

    public void remove (String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove (Node root, String word, int index) {
        if (word.length() == index) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return;

        remove(root.getChild(ch), word, index + 1);

        if (root.hasNoChild() && !root.getChild(ch).isEndOfWord)
            root.removeChild(ch);
    }

    private Node findLastNodeOf(String prefix) {
        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    public List<String> findWord(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWord(lastNode, prefix, words);

        return words;
    }

    private void findWord(Node root, String prefix, List<String> words) {
        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            findWord(child, prefix + child.value, words);
    }

    public void autoCompletion(String word) {
        List<String> list = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            root = root.getChild(ch);
            System.out.println(ch);
        }
        autoCompletion(root, word, true, list);
        for (var s : list.toArray())
            System.out.println(s);
    }

    private void autoCompletion(Node root, String word, boolean firstIteration, List<String> list) {
        if (!firstIteration) {
            word = word.concat(Character.toString(root.value));
            if (root.isEndOfWord)
                list.add(word);
        }

        for (Node child : root.getChildren())
            autoCompletion(child, word, false, list);
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        int counter = 0;
        if (root.isEndOfWord)
            counter = 1;

        for (Node child : root.getChildren())
            counter += countWords(child);
        return counter;
    }

    public boolean containsRecursive(String word) {
        if (word == null || word.equals(""))
            return false;
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (index == word.length() && root.isEndOfWord)
            return true;
        char ch = (word.toCharArray()[index++]);
        if (!root.hasChild(ch))
            return false;
        return containsRecursive(root.getChild(ch), word, index);
    }

    public String longestCommonPrefix(String[] words) {
        if (words == null)
            return "";
        Trie nodes = new Trie();
        for (String word : words)
            nodes.insert(word);

        return longestCommonPrefix(nodes.root, nodes, "");
    }

    private String longestCommonPrefix(Node root, Trie nodes, String prefix) {
        prefix += root.value;
        if (root.countChildren() == 1 && !root.isEndOfWord)
            return longestCommonPrefix(root.getOnlyChild(), nodes, prefix);
        return prefix.replaceFirst(" ", "\"") + "\"";
    }



//    public void removeMy (String word) {
//        removeMy(word.toCharArray(), root, 0, false);
//    }

//    private void removeMy (char[] chars, Node root, int index, boolean stop) {
//        var charIndex = index-1;
//
//        if (index < chars.length)
//            removeMy(chars, root.getChild(chars[index++]), index, false);
//        if (stop)
//            return;
//
//        if (charIndex == chars.length-1 && root.isEndOfWord)
//            root.isEndOfWord = false;
//        if (charIndex == chars.length-1 && !root.isEndOfWord) { // just to have a defense if word doesnt exist
//            stop = true;
//            return;
//        }
//        if (root.isEndOfWord || root.children.size() > 1) {
//            stop = true;
//            root.removeChild(chars[charIndex+1]);
//        }
//    }
}