package com.company;

/**
 *  Нужно написать метод который рассчитывает сколько нужно
 *  дать корма котенку, он принимает число(это время сколько минут! котенок не ел)
 *  Если он не ел меньше часа то написать что котенка еще рано кормить если меньше или
 *  равно 2 часов то Написать чтобы дали ему 150 грам еды, а если больше 2 то написать что
 *  нужно 400грам и добавить воду)
 */
public class task8 {
    public static void task8(int minutes){
        if(minutes<60){
            System.out.println("Кормить еще рано");
        } else {
            if(minutes<=120){
                System.out.println("Дать 150грм корма");
            }else {
                System.out.println("Дать 400грм корма и добавить воды");
            }
        }
    }
}
