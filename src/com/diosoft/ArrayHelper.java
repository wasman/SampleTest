package com.diosoft;

import java.util.Arrays;

public class ArrayHelper {

    public int[] LeftUnion(int[] leftArray, final int[] rightArray) {
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


}
