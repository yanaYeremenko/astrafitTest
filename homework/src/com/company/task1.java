package com.company;

/**
 *Написать метод который принимает целое число и возвращает целое,
 * он должен проверить если число больше 10 то он к нему прибавляет 5,
 * если нет то он должен проверить больше ли оно 5 если да то прибавить 3
 * если нет то прибавить 1. Вернуть результат)
 (Передать цифры 11, 7,2)

 */
public class task1 {
    public static void main(String[] args) {
        task1(1);
    }
    public static int task1(int number) {
        if (number > 10) {
            number += 5;
        } else {
            if(number >5){
                number += 3;
            }else{
                number+=1;
            }
        }
        System.out.println(number);
        return number;
    }
}
