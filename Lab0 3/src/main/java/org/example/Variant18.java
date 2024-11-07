package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public  class Variant18 {

    public int[] getEvenIndexedElements(int[] A) {
        int n = A.length / 2;
        int[] result = new int[n];
        for (int i = 0, j = 1; i < n; i++, j += 2) {
            result[i] = A[j];
        }
        return result;
    }

    // Boolean12 Task
    public boolean areAllPositive(int A, int B, int C) {
        return A > 0 && B > 0 && C > 0;
    }

    /**
     *
     * @param a and b are integer numbers
     * @return max of a and b
     */
    public int ifTask(int a, int b) {
        return a > b ? a : b;
    }


    /**
     *
     * @param num - option
     * @param len - length
     * @return length in another dimension type
     */
    public double switchTask(int num, double len) {
        switch (num) {
            case 1:
                return len / 10;
            case 2:
                return len * 1000;
            case 3:
                return len;
            case 4:
                return len / 1000;
            case 5:
                return len / 100;
            default:
                throw new IllegalArgumentException("Wrong num: " + num);
        }
    }



    /**
     *
     * @param n is a price for 1 kg
     * @return array of prices for 1.2, 1.4 ... 2.0 kg
     */
    public double[] forTask(double n) {
        assert n > 0: "Argument should be more than zero";
        double[] prices = new double[6];

        int index = 0;
        for (double i = 1.0; i <= 2; i += 0.2) {
            double price = Math.round(n * i * 100.0) / 100.0;
            prices[index++] = price;
        }
        return prices;
    }

    /**
     *
     * @param n - number
     * @return Double factorial of n
     */

    public double whileTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        double res = 1;

        while (n > 0) {
            res *= n;
            n -= 2;
        }

        return res;
    }


    /**
     *
     * @param n - array length, a - first value in array, b - second value in array
     * @return array where each value is a sum of all previous
     *
     *
     */

    public int[] arrayTask(int n, int a, int b) {
        assert n > 2: "Argument 'n' should be more than two";
        int[] arr = new int[n];
        arr[0] = a;
        arr[1] = b;
        for (int i = 2; i < n; i++) {
            arr[i] = Arrays.stream(Arrays.copyOfRange(arr, 0, n)).sum();
        }
        return arr;
    }

    /**
     *
     * @param m and n size of our matrix
     * @param multiplier - multiplier
     * @param arr - our initial array
     * @return transformed matrix where the element of each row is multiplied by a factor
     */
    public int[][]  twoDimensionArrayTask(int m, int n, int multiplier, int[]arr) {
        int[][] matrix = new int[m][n];
        matrix[0] = arr;
        IntStream.range(1, m).forEach(i ->
                matrix[i] = IntStream.range(0, n)
                        .map(j -> matrix[i - 1][j] * multiplier)
                        .toArray()
        );
        return matrix;
    }
}