package com.company;

/**
 * Написать метод который принимает массив дробных чисел.
 * Он должен прибавлять к первому элементу 3.0f и если результат будет
 * больше 10 .0f то добавить 3.0f ко всем элементам.  Потом вывести результат на экран
 * (  использовать do{}while();)
 (  дано : float array[] = {9.2f,2.1f,22.0f,57.3f};
 float array2[] = {3.2f,2.1f,22.0f,57.3f};
 )

 */
public class task3 {public static void main(String[] args) {
    float array[] = {3.2f, 2.1f, 22.0f, 57.3f};
    task3(array);
    printArray(array);
    //int array[] = {3,2,5,57,9,3,1,0,-100,2};
}

    public static void printArray(float[] number) {
        for (int index = 0; index < number.length; index++) {
            System.out.println("number[" + index + "]=" + number[index]);
        }
    }

    public static void task3(float[] number) {
        int i = 0;
        do {
            number[i] += 3.0f;
            i++;
            if (i >= number.length) break;
        } while (number[0] > 10.0f);
    }
}

