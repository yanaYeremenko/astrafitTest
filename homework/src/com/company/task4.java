package com.company;

/**
 * Написать метод который будет принимать число. Когда мы передаем
 * туда число от 0 до 10 оно писало какое число мы ввели например мы
 * передали 3 и при выполнения этого метода должно написать «Вы ввели число три»
 * если число будет меньше нуля или больше 10 то должно писать «извините но я не знаю таких чисел
 * («   ( исп switch)

 */
public class task4 {
    public static void main(String[] args) {
        task4(11);
    }

    public static void task4(int number) {
        switch (number) {
            case (0):
                System.out.println("Вы ввели число" + number);
                break;
            case (1):
                System.out.println("Вы ввели число" + number);
                break;
            case (2):
                System.out.println("Вы ввели число" + number);
                break;
            case (3):
                System.out.println("Вы ввели число" + number);
                break;
            case (4):
                System.out.println("Вы ввели число" + number);
                break;
            case (5):
                System.out.println("Вы ввели число" + number);
                break;
            case (6):
                System.out.println("Вы ввели число" + number);
                break;
            case (7):
                System.out.println("Вы ввели число" + number);
                break;
            case (8):
                System.out.println("Вы ввели число" + number);
                break;
            case (9):
                System.out.println("Вы ввели число" + number);
                break;
            case (10):
                System.out.println("Вы ввели число" + number);
                break;
            default:
                System.out.println("Извините но я не знаю таких чисел");
        }
    }
}

