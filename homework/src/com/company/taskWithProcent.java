package com.company;

/**
 *  И снова где то кто то плачет( , и кто бы мог подумать что это производитель пиццы,
 *  он не знает сколько налогов он должен заплатить. И тут твои материнские инстинкты берут
 *  гору и ты решаешься помочь и пишешь метод который принимает суму которую заработала пиццерия
 *  и проверяет если сума меньше 500 то нужно заплатить 10% от суммы, если больше 800 то 14% ну а
 *  если больше 500 и меньше 800 то 12%
 */
public class taskWithProcent {
    public static void daySum(int money) {
        //float nalog = 0;
        if(money < 500) {
            // nalog = money * 0.1f;
            System.out.println("nalog = " + money*0.1);
        }
        if (money >= 500 && money <= 800) {
            System.out.println("nalog = " + money*0.12);
        }
        if (money > 800) {
            System.out.println("nalog = " + money*0.14);
        }
    }
}
