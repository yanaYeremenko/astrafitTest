package com.company;

/**
 * Написать метод который принимает массив,
 * и выводит на экран элементы массива только с четными элементами
 */
public class task10 {
    int array[] = {5, 6, 8, 1, 11, 12, 14, 2, 2};
    //newTask(array);

    /* public static void printArray(int[] number) {
         for (int index = number.length-1; index >=0; index--) {
             System.out.println("number[" + index + "]=" + number[index]);
         }
     }*/
    public static void newTask(int[] array) {
        for (int i = 2; i < array.length; i = i + 2) {
            System.out.println(i);
        }
    }
}
