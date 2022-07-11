package com.utgard.hashmap;

public class HashMapPractice {
        public void practice() {
            HashMapLinearMy practice = new HashMapLinearMy();

            practice.put(2, "two");
            practice.put(3, "three");
            practice.put(8, "eight");
            practice.put(1, "one");
            practice.put(6, "Six");
            practice.put(3, "newthree");
            practice.remove(3);
            System.out.println(practice.get(3));
            practice.put(7, "seven");
            System.out.println("done");
            practice.remove(7);
            System.out.println(practice.size());
    }
}
