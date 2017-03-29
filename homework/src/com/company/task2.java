package com.company;

/**
 * Написать цикл который проверяет все элементы целочисленного массива если ел.
 * больше или равно 5 то заменить его на ноль.
 (  дано : int array[] = {3,2,5,57,9,3,1,0,-100,2}
 */
public class task2 {
    public static void main(String[] args) {
        int array[] = {3, 2, 5, 57, 9, 3, 1, 0, -100, 2};
        task2(array);
    }
    public static void task2(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= 5) {
                number[i] = 0;
            }
            System.out.println(number[i]);
        }
    }
}
