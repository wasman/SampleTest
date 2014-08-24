package com.diosoft;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testLeftUnion();
        testLeftUnion_WithNullLeftArray();
        testLeftUnion_WithNullRightArray();
    }

    private static void testLeftUnion() {
        System.out.println("Running test method : testLeftUnion");
        // initialize variable inputs
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};

        // initialize class to test
        ArrayHelper helper = new ArrayHelper();

        int[] returnValue = helper.leftUnion(leftArray, rightArray);

        // assert return value
        System.out.println(String.format("Result array : %s", Arrays.toString(returnValue)));
        boolean isArraysEquals = Arrays.equals(expectedArray, returnValue);
        System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
    }

    private static void testLeftUnion_WithNullLeftArray() {
        System.out.println("Running test method : testLeftUnion_WithNullLeftArray");
        // initialize variable inputs
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {};

        // initialize class to test
        ArrayHelper helper = new ArrayHelper();

        int[] returnValue = helper.leftUnion(leftArray, rightArray);

        // assert return value
        System.out.println(String.format("Result array : %s", Arrays.toString(returnValue)));
        boolean isArraysEquals = Arrays.equals(expectedArray, returnValue);
        System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
    }

    private static void testLeftUnion_WithNullRightArray() {
        System.out.println("Running test method : testLeftUnion_WithNullRightArray");
        // initialize variable inputs
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = null;
        int[] expectedArray = {1, 5, 4, 23, 65, 32, 78};

        // initialize class to test
        ArrayHelper helper = new ArrayHelper();

        int[] returnValue = helper.leftUnion(leftArray, rightArray);

        // assert return value
        System.out.println(String.format("Result array : %s", Arrays.toString(returnValue)));
        boolean isArraysEquals = Arrays.equals(expectedArray, returnValue);
        System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
    }


}
