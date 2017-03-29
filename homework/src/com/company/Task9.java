package com.company;

/**
 *  У нас есть метод который печатает элементы массива от первого до последнего,
 *  а напиши плиз метод который наоборот будет печатать элементы от последнего до первого)
 */
public class Task9 {
    public static void main(String[] args) {
        int array[] = {1,0,-100,2};
        task5(array);
        printArray(array);
    }

    public static void printArray(int[] number) {
        for (int index = number.length-1; index >=0; index--) {
            System.out.println("number[" + index + "]=" + number[index]);
        }
    }

    public static void task5(int[] array){
        for(int i=0;i<array.length;i++){

            int min = i;

            for(int j=i+1; j<array.length;j++){

                if( array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i]=array[min];
            array[min]=tmp;
        }
    }
}
