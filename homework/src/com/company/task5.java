package com.company;

/**
 * Ну и задание для гениев))
 Сделать сортировку массива от большего к меньшему) и вывести на экран результат)

 (  дано : int array[] = {3,2,5,57,9,3,1,0,-100,2};)
 *Можно использовать заклинания любого уровня))
 */
public class task5 {
    public static void main(String[] args) {
        int array[] = {3,2,5,57,9,3,1,0,-100,2};
        task5(array);
        printArray(array);
    }
    public static void printArray(int[] number) {
        for (int index = 0; index < number.length; index++) {
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
