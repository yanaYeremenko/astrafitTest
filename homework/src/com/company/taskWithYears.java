package com.company;

/**
 * Сделай метод который будет принимать год и определять это высокосный год или нет( если высокосны то возвращает true если нет to false) вот статья где есть онисано как определьть высокосный год от обычного
 http://www.net4lady.ru/kalendar-visokosnyx-let/
 И еще хотел расказать об одной опереции которая тебе пригодится это %
 она возвращает остаток от деления
 например 5%4 будет равно 1
 а 8%4 равно 0
 так как после деления 8 на 4 нет остатка
 5%2 = 3
 */
/*
public class Main {
    public static void main(String[] args) {
        boolean answer = whichYear(1900);
        System.out.println(answer);
    }
 */
public class taskWithYears{
        public static boolean whichYear(int year) {
            boolean visosniyYear = false;
            if(year % 4 == 0 && year % 100 != 0|| year % 4 ==0 && year % 100 == 0 && year % 400 == 0 ){
                visosniyYear = true;
            }
            return visosniyYear;
        }
}
