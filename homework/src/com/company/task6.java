package com.company;

/**
 * Написать метод который будет принимать номер месяца и печатать что это за время года (witch)

 */
public class task6 {

    public static void task6(int month){
        switch (month) {
            case(1):
            case(2):
            case(12):
                System.out.println("It's winter");
                break;
            case(3):
            case(4):
            case(5):
                System.out.println("It's spring");
                break;
            case(6):
            case(7):
            case(8):
                System.out.println("It's summer");
                break;
            case(9):
            case(10):
            case(11):
                System.out.println("It's fall");
                break;

            default:
                System.out.println("I don't know this season");
        }
    }
}
