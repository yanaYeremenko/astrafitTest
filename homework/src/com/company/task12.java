package com.company;

/**
 * Напиши метод который будет говорить стоит мыть машину или нет в него будет передаваться номер дня недели
 * (от 0 до 6, 0 это сегодня) в методе будет массив с данными о погоде на эту неделю
 * String wether [] = {"дождь","солнце","солнце","солнце","солнце","дождь","солнце"};
 * Если в день который передали будет солнечно, то написать можно помыть если дождь то написать  не мыть.
 */
public class task12 {
    //washCar(0,3);


    public static void washCar(int day, int countSunnyDay) {
        String wether[] = {"дождь","солнце","солнце","солнце","солнце","дождь","солнце"};
        boolean wash = false;
        int countDay = 0;

        for (int i=day; i<wether.length;i++){
            if (wether[i].equals("солнце")){
                countDay++;
            }else {
                break;
            }
            if(countDay == countSunnyDay){
                wash = true;
                break;
            }
        }
        if (wash) {
            System.out.println("Yes");
        }else {
            System.out.println("Nope");
        }
    }
}
