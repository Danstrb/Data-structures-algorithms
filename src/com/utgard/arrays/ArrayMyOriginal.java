package com.utgard.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMyOriginal {

    public class ArrayMy {
        private int lenght;
        private int[] numbers;


        public ArrayMy(int lenght) {
            this.lenght = lenght;
            this.numbers = new int[0];
        }

        public void insert (int item) {
        var temporaryNumbers = Arrays.copyOf(numbers, numbers.length+1);
        temporaryNumbers[numbers.length] = item;
        numbers = temporaryNumbers;
        }

        public void print () {
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
        }

        public void removeAt (int index){
        var temporaryPre = Arrays.copyOfRange(numbers, 0,index);
        var temporaryPost = Arrays.copyOfRange(numbers, index+1, numbers.length);
        numbers = IntStream.concat(Arrays.stream(temporaryPre), Arrays.stream(temporaryPost))
                            .toArray();
        }

        public int indexOf (int number) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == number)
                    return i;
            }
            return -1;
        }
    }

}
