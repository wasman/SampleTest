package com.diosoft;

import java.util.Arrays;

public class ArrayHelper {

    public int[] leftUnion(int[] leftArray, final int[] rightArray) {
        int leftArrayLength = getLength(leftArray);

        if (leftArrayLength == 0) {
            return new int[0];
        } else if (getLength(rightArray) == 0) {
            return Arrays.copyOf(leftArray, leftArrayLength);
        }

        int[] sortedLeftArray = Arrays.copyOf(leftArray, leftArrayLength);
        Arrays.sort(sortedLeftArray);

        int[] filteredRightArray = Arrays.stream(rightArray).parallel()
                .filter(p -> Arrays.binarySearch(sortedLeftArray, p) >= 0)
                .toArray();

        int[] resultArray = Arrays.copyOf(leftArray, filteredRightArray.length + getLength(leftArray));

        System.arraycopy(filteredRightArray, 0, resultArray, getLength(leftArray), filteredRightArray.length);

        return resultArray;

    }

    private int getLength(int[] leftArray) {
        return leftArray != null ? leftArray.length : 0;
    }


    public int[] leftUnion2(int[] leftArray, int[] rightArray) {

        int[] leftUnion = new int[leftArray.length + rightArray.length];
        System.arraycopy(leftArray, 0, leftUnion, 0, leftArray.length);
        //count of elements added from rightArray to leftUnion
        int count = 0;
        //iterating by right array and for each of element searching same element from left array - if exist adding it to results
        for (int aRightArray : rightArray) {
            for (int aLeftArray : leftArray) {
                if (aRightArray == aLeftArray) {
                    leftUnion[leftArray.length + count] = aRightArray;
                    count++;
                }
            }


        }
        //result array with appropriate length
        int[] resultArray = new int[leftArray.length+count];
        //coping correct elements to result array
        System.arraycopy(leftUnion, 0, resultArray, 0, leftArray.length+count);
        return resultArray;

    }

}
