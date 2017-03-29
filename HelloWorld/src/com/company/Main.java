package com.company;

import java.util.Scanner;

public class Main {

    public static void playTheGame(Scanner sc) {
        int num;
        String str;
        Scanner line = sc;
        do{
            System.out.print("Введи число):");
            try {

                num = Integer.parseInt(line.nextLine());
                if(num%2 == 0) {
                    System.out.println("Это парное число))");
                } else {
                    System.out.println("Это не парное число))");
                }
            } catch (NumberFormatException e) {
                System.out.println("Нуу это же не число(");
            }
            System.out.print("Будем продолжать? (Y/N):");
            str = line.nextLine();
            if(str.toLowerCase().equals("n")){
                System.out.println("Рада была поиграть, пока)");
                break;
            }

        } while(true);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Привет я Java, а как зовут тебя? ");
        String name = in.nextLine();
        System.out.println("Приятно познакомится "+name);
        System.out.println(name+", a хочешь поиграть в игру? Ты будушь писать число, я буду говорить парное оно или нет) (Y/N):");
        String answer = in.nextLine();

        if(answer.toLowerCase().equals("y")) {
            playTheGame(in);
        } else {
            System.out.println("Ну и ладно( пока!");
        }
    }
}
