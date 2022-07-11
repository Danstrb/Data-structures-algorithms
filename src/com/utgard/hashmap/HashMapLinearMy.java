package com.utgard.hashmap;

public class HashMapLinearMy {
    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int count = 0;

    public void put(int key, String value) {
        for (Entry b : entries)
            if (b != null && b.key == key)
                b.value = value;
        if (entries[hashIndex(key)] == null) {
            entries[hashIndex(key)] = new Entry(key, value);
            count++;
        }
        else
            for (int i = 1; i < entries.length; i++)
                if (entries[(hashIndex(key)+i) % entries.length] == null) {
                    entries[(hashIndex(key)+i) % entries.length] = new Entry(key, value);
                    count++;
                    break;
                }
    }

    public String get (int key) {
        for (Entry b : entries)
            if (b != null && b.key == key)
                return b.value;
        return null;
    }

    public void remove (int key) {
        for (int i = 0; i < entries.length; i++)
            if (entries[i].key == key) {
                entries[i] = null;
                count--;
                break;
            }
    }

    public int size () {
        return count;
    }


    private int hashIndex(int key) {
        return key % entries.length - 1;
    }


}
