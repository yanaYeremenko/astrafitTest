package com.company;

/**
 * int buildingsHeight[] = {1234, 1500, 33,432,1500,322};
 Необходимо написать метод который будет принимать массив целых
 чисел в котором записана высота разных домов), и возвращать сколько
 домов имеют наибольшую высоту. Результат вывести на экран после выполнения метода.
 ( Пояснение: так как самые высоки дома имеют высоту 1500 и их два то соответственно
 программа должна вывести тоже
 */
public class task7 {
    public static void main(String[] args) {
        int buildingsHeight[] = {1234, 1500, 33, 432, 1500, 322};

        // int count = task7(buildingsHeight);
        //printArray(buildingsHeight);
        System.out.println(task7(buildingsHeight));
    }

    public static int task7(int[] number) {
        int bildingCount=0;
        int maxHeight=0;

        for (int i=0; i<number.length;i++){

            if(maxHeight < number[i]){
                maxHeight = number[i];
                bildingCount =0;
            }
            if(maxHeight == number[i]){
                bildingCount++;
            }
        }
        return bildingCount;
    }
}
