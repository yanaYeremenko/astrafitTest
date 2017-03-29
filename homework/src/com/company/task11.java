package com.company;

/**
 * Создать метод который будет говорить какой набор цветов в него передали,
 * чернобелый или цветной) набор цветов это масив строк типа  String color = {"black","white","white"};
 * - чернобелый  String color2 = {"black","red","white"}; - цветной 
 */
public class task11 {
    String color[] = {"black", "white", "white"};
    String color2[] = {"black", "red", "white"};

    //newTask1(color2);


    public static void newTask1(String[] array){
        boolean isColor = false;
        for(int i=0; i< array.length; i++) {
            if(array[i]!="black" && array[i]!="white") {
                isColor = true;
            }
        }
        if(isColor){
            System.out.println("color");
        }else {
            System.out.println("B&W");
        }
    }
}
