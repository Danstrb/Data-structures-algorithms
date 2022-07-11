package com.utgard.hashmap;

import java.util.Arrays;

public class TwoSumMy {
    public int[] twoSumMy(int[] input, int target) {
        int [] result = new int[2];

        for (int i = 0; i < input.length-1; i++)
            for (int j = i+1; j < input.length; j++)
                if (input[i] + input[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    System.out.println(Arrays.toString(result));
                    return result;
                }
        return null;
    }
}
