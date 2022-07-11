package com.utgard.sorting_algorithms;

public class QuickSortMy {

    private void sort(int[] array) {
        if (array.length <= 1)
            return;

        int pivotIndex = array.length-1;
        int pivot = array[array.length-1];
        int i = 0;
        int b = -1;

        while (i < pivotIndex) {
            if (array[i] <= pivot)
                swap(array, i, ++b);
            i++;
        }

        placePivotFromLeft(array, array.length-1, b);

        sortLeft(array, b);
        sortRight(array, b+2);
    }

    private void sortLeft(int[] array, int pivotIndex) {
        if (pivotIndex < 0)
            return;

        int i = 0;
        int b = -1;
        int pivot = array[pivotIndex];

        while (i < pivotIndex) {
            if (array[i] <= pivot)
//                placePivotFromLeft(array, i, b++);
                swap(array, i, ++b);
            i++;
        }
        placePivotFromLeft(array, pivotIndex, b);//>> item at pivotIndex is placed at b+1
        if (b == -1 && pivotIndex != 0)
            sortLeft(array,pivotIndex);
        else if (pivotIndex > 0)
            sortLeft(array, pivotIndex-1);
    }

    private void sortRight(int[] array, int pivotIndex) {
        if (pivotIndex >= array.length)
            return;

        int i = array.length-1;
        int b = array.length;
        int pivot = array[pivotIndex];

        while (i > pivotIndex) {
            if (array[i] >= pivot)
                swap(array, i, --b);
//                placePivotFromRight(array, i, b);
            i--;
        }
        placePivotFromRight(array, pivotIndex, b);
        if (b == array.length && pivotIndex != array.length-1)
            sortRight(array,pivotIndex);
        else
            sortRight(array,pivotIndex+1);
    }

    private void swap (int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void placePivotFromLeft(int[] array, int pivotIndex, int b) {
        var tempPivot = array[pivotIndex];
        for (int i = pivotIndex; i > b + 1; i--)
            array[i] = array[i-1];
        array[b+1] = tempPivot;
    }

    private void placePivotFromRight(int[] array, int pivotIndex, int b) {
        var tempPivot = array[pivotIndex];
        for (int i = pivotIndex; i < b - 1; i++)
            array[i] = array[i+1];
        array[b - 1] = tempPivot;
    }
}

//package com.utgard.sorting_algorithms;
//
//public class QuickSortMy {
//    public void sort(int[] array) {
//        int pivotIndex = array.length-1;
//        int pivot = array[array.length-1];
//        int i = 0;
//        int b = -1;
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
//                swap(array, i, ++b);
//            i++;
//        }
//
//        placePivotFromLeft(array, array.length-1, b);
//
//        sortLeft(array, b);
//        sortRight(array, b+2);
//    }
//
//    private void sortLeft(int[] array, int pivotIndex) {
//        if (pivotIndex < 0)
//            return;
//
//        int i = 0;
//        int b = -1;
//        int pivot = array[pivotIndex];
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
////                placePivotFromLeft(array, i, b++);
//                swap(array, i, ++b);
//            i++;
//        }
//        placePivotFromLeft(array, pivotIndex, b);//>> item at pivotIndex is placed at b+1
//        if (pivotIndex > 0)
//            sortLeft(array, pivotIndex-1);
//    }
//
//    private void sortRight(int[] array, int pivotIndex) {
//        if (pivotIndex >= array.length)
//            return;
//
//        int i = array.length-1; //doubtful
//        int b = array.length;
//        int pivot = array[pivotIndex];
//
//        while (i > pivotIndex) {
//            if (array[i] >= pivot)
//                swap(array, i, --b);
////                placePivotFromRight(array, i, b);
//            i--;
//        }
//        placePivotFromRight(array, pivotIndex, b);
//        sortRight(array,pivotIndex+1);
//    }
//
//    private void swap (int[] array, int index1, int index2) {
//        var temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//
//    private void placePivotFromLeft(int[] array, int pivotIndex, int b) {
//        var tempPivot = array[pivotIndex];
//        for (int i = pivotIndex; i > b + 1; i--)
//            array[i] = array[i-1];
//        array[b+1] = tempPivot;
//    }
//
//    private void placePivotFromRight(int[] array, int pivotIndex, int b) {
//        var tempPivot = array[pivotIndex];
//        for (int i = pivotIndex; i < b - 1; i++)
//            array[i] = array[i+1];
//        array[b - 1] = tempPivot;
//    }
//}

//ALMOSTFINAL WITH ANNOTATIONS
//package com.utgard.sorting_algorithms;
//
//public class QuickSortMy {
//    public void sort(int[] array) {
////        int[] array = {5,3,2,6,3};
//        int pivotIndex = array.length-1;
//        int pivot = array[array.length-1];
//
//        int i = 0;
//        int b = -1;
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
//                swap(array, i, ++b);
//            i++;
//        }
//
//        placePivotFromLeft(array, array.length-1, b); //deFacto swap (array, i, b+1), but >> item at pivotIndex is placed at b+1
//
//        sortLeft(array, b);
////        sortRight(array, array.length-1, b+1);
//        sortRightFromLeft(array, b+2);
//    }
//
//    private void sortRight(int[] array, int pivotIndex, int middleIndex) {
//        if (pivotIndex <= middleIndex)
//            return;
//
//        int i = middleIndex + 1;
//        int b = middleIndex;
//        int pivot = array[pivotIndex];
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
//                swap(array, i, ++b);
//            i++;
//        }
//
//        placePivotFromLeft(array, pivotIndex, b);
//        sortRight(array, pivotIndex-1, b);
//    }
//
//    private void sortRightFromLeft(int[] array, int pivotIndex) {
////        PIVOT IS PICKED FROM LEFT TO RIGHT, STARTING AT PIVOTINDEX (MIDDLE++)
////        CHECK IF INT AT ARRAY.LENGTH-1 INDEX IS LARGER THAN PIVOT
////          YES -> PUT(SWAP?) IT AT --B, WHERE B IS ARRAY.LENGHT + I--
////          NO -> I--
////        PLACEPIVOT AT --I
////        SORT AGAIN with pivotindex+1
////        that should be all, just not sure about PLACEPIVOT - it might need a separate method, but easy enough
//
//        if (pivotIndex >= array.length)
//            return;
//
//        int i = array.length-1; //doubtful
//        int b = array.length;
//        int pivot = array[pivotIndex];
//
//        while (i > pivotIndex) {
//            if (array[i] >= pivot)
//                swap(array, i, --b);
//            i--;
//        }
////        swap(array, i,b-1);
//        placePivotFromRight(array, pivotIndex, b);
//        sortRightFromLeft(array,pivotIndex+1);
//    }
//
//    private void sortLeft(int[] array, int pivotIndex) {
//        if (pivotIndex < 0)
//            return;
//
//        int i = 0;
//        int b = -1;
//        int pivot = array[pivotIndex];
//
//        //STEP 1 - put pivot to its place, everything smaller or equal to left, others to right
//        while (i < pivotIndex) { //for all items to the left
//            if (array[i] <= pivot) //if item is smaller than pivot, push it to the left "array"
//                swap(array, i, ++b);
//            i++;
//        }
////        swap(array, i, b+1); //add the pivot to its correct place
//        placePivotFromLeft(array, pivotIndex, b);
//        //do I want to swap it? seems more to push it there (move the rest to right)
//        if (b > 0) // b does not increase only in the last itteration (?) / so this solves it, but prone to restructure
//            sortLeft(array, pivotIndex-1); //leftSorting
//    }
//
//    private void swap (int[] array, int index1, int index2) {
//        var temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//
//    private void placePivotFromLeft(int[] array, int pivotIndex, int b) {
//        var tempPivot = array[pivotIndex];
//        for (int i = pivotIndex; i > b + 1; i--)
//            array[i] = array[i-1];
//        array[b+1] = tempPivot;
//    }
//
//    private void placePivotFromRight(int[] array, int pivotIndex, int b) {
//        var tempPivot = array[pivotIndex];
//        for (int i = pivotIndex; i < b - 1; i++)
//            array[i] = array[i+1];
//        array[b - 1] = tempPivot;
//    }
//}


//v.2.0 - ALMOST THERE>>>
//package com.utgard.sorting_algorithms;
//
//public class QuickSortMy {
//    public void sort(int[] array) {
////        int[] array = {5,3,2,6,3};
//        int pivotIndex = array.length-1;
//        int pivot = array[array.length-1];
//
//        int i = 0;
//        int b = -1;
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
//                swap(array, i, ++b);
//            i++;
//        }
//
//        placePivot(array, array.length-1, b); //deFacto swap (array, i, b+1), but >> item at pivotIndex is placed at b+1
//
//        sortLeft(array, b);
//        sortRight(array, array.length-1, b+1);
//    }
//
//    private void sortRight(int[] array, int pivotIndex, int middleIndex) {
//        if (pivotIndex <= middleIndex)
//            return;
//
//        int i = middleIndex + 1;
//        int b = middleIndex;
//        int pivot = array[pivotIndex];
//
//        while (i < pivotIndex) {
//            if (array[i] <= pivot)
//                swap(array, i, ++b);
//            i++;
//        }
//
//        placePivot(array, pivotIndex, b);
//        sortRight(array, pivotIndex-1, b);
//    }
//
//    private void sortLeft(int[] array, int pivotIndex) {
//        if (pivotIndex < 0)
//            return;
//
//        int i = 0;
//        int b = -1;
//        int pivot = array[pivotIndex];
//
//        //STEP 1 - put pivot to its place, everything smaller or equal to left, others to right
//        while (i < pivotIndex) { //for all items to the left
//            if (array[i] <= pivot) //if item is smaller than pivot, push it to the left "array"
//                swap(array, i, ++b);
//            i++;
//        }
////        swap(array, i, b+1); //add the pivot to its correct place
//        placePivot(array, pivotIndex, b);
//        //do I want to swap it? seems more to push it there (move the rest to right)
//        if (b > 0) // b does not increase only in the last itteration (?) / so this solves it, but prone to restructure
//            sortLeft(array, pivotIndex-1); //leftSorting
//    }
//
//    private void swap (int[] array, int index1, int index2) {
//        var temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//
//    private void placePivot (int[] array, int pivotIndex, int b) {
//        var tempPivot = array[pivotIndex];
//        for (int i = pivotIndex; i > b + 1; i--)
//            array[i] = array[i-1];
//        array[b+1] = tempPivot;
//    }
//}

//v1.0
//package com.utgard.sorting_algorithms;
//
//public class QuickSortMy {
//    public void sort(int[] array) {
//        int pivotIndex = array.length-1;
//        int pivot = array[array.length-1];
//
//        sort(array, pivot, pivotIndex);
//    }
//
//    private void sort(int[] array, int pivot, int pivotIndex) {
//        if (pivotIndex < 0)
//            return;
//
//        int i = 0;
//        int b = -1;
//
//        //STEP 1 - put pivot to its place, everything smaller or equal to left, others to right
//        while (i < pivotIndex) { //for all items to the left
//            if (array[i] <= pivot) //if item is smaller than pivot, push it to the left "array"
//                swap(array, i, ++b);
//            i++;
//        }
//        swap(array, i, b+1); //add the pivot to its correct place
//        //do I want to swap it? seems more to push it there (move the rest to right)
//        if (b > 0) // b does not increase only in the last itteration (?) / so this solves it, but prone to restructure
//            sort(array, array[b], pivotIndex-1); //leftSorting
//
//    }
//
//    private void swap (int[] array, int index1, int index2) {
//        var temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//}
