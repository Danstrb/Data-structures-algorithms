package com.utgard.hashmap;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithDifferenceMy {
    public int countPairsWithDifferenceMy(int [] numbers, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int counter = 0;
        for (int number : numbers)
            set.add(number);
        var numbersOrdered = set.toArray();

        for (int j = 0; j <= numbersOrdered.length-1; j++) {
            for (int i = j + 1; i != numbersOrdered.length && Math.abs((int) numbersOrdered[j] - (int) numbersOrdered[i]) <= k; i++) {
                if (Math.abs((int) numbersOrdered[j] - (int) numbersOrdered[i]) == k)
                    counter++;
            }
        }
        return counter;
    }
}

//        int i = 0;
//        int j = 1;
//        int difference;
//
//        while (j < numbersOrdered.length) {
//            difference = Math.abs((int)numbersOrdered[i] - (int) numbersOrdered[j]);
//            if (difference == k) {
//                counter++;
//                i++;
//                j = i+1;
//            }
//            else if (difference < k)
//                j++;
//            else {
//                i++;
//                j = i+1;
//                continue;
//            }
//        }
//
//        return counter;
//    }
//}

//          NOTWORKING
//        for (int j = 1; numbersOrdered.length-j > 1; j++)
//            for (int i = j+1; (int)numbersOrdered[numbersOrdered.length-j] - (int)numbersOrdered[numbersOrdered.length-i] <= k; i++)
//                if ((int)numbersOrdered[numbersOrdered.length-j] - (int)numbersOrdered[numbersOrdered.length-i] == k)
//                    counter++;
