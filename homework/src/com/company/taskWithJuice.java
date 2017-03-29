package com.company;

/*
к тебе пришли друзья и все они хотят пить, а у тебя только литр твоего любимого апельсинового сока,
и ты хочешь оставить себе немного(200мл). Чтобы посчитать скольким друзьям хватит сока, ты естественно
 пишешь метод в который передается массив с числами(количество милилитров сколько может выпить один друг)
  ну и метод должен написать скольким друзьям хватило сока)) да эта задачка немного запутанно звучит,
  но вдруг у тебя будет много времени))

 */
/*
 public class Main {
 public static void main(String[] args) {
 int array[] = {600,150,200,50,100};
 int count = needJuice(array);
 System.out.println(count);
 }
 */
public class taskWithJuice {

    public static int needJuice(int[] array){
        int juiceHave = 800;
        int friendCount = 0;

        for (int i = 0; i<array.length; i++){
            juiceHave -= array[i];

            if(juiceHave > 0){
                friendCount ++;
            }
        }
        return friendCount;
    }
}
