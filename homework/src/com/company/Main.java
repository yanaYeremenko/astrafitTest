package com.company;

//import buttons.Lessons;

public class Main {
    public static void main(String[] args) {
        String leaders[] = {"Yes Man", "Mutant", "XZkto"};
        int skills0[] = {12, 50, 45}; // скилы "Yes Man"
        int skills1[] = {25, 20, 30}; // "Mutant"
        int skills2[] = {85, 55, 45}; // "XZkto"

        if(skillsYesMan > skillsMutant){
            if(skillsMutant > skillsXZkto){
                System.out.println("1. YesMan" + skillsYesMan);
                System.out.println("2. Mutant" + skillsMutant);
                System.out.println("3. XZkto" + skillsXZkto);
            }
        }
       /* int balli = hitrometr(skills2[0]);
        System.out.println(balli);

        int averagePower = strongPower(skills0);
        System.out.println("средний потенциал ="+ averagePower);

        int ball = morePowerSkill(skills2);
        System.out.println(ball);*/

        hwoIsCooler(skills0, skills1, skills2);
    }

    public static int hitrometr(int hitr) {

        if (hitr < 20) {
            return 2;
        }
        if (hitr > 80) {
            return 3;
        } else {
            return 5;
        }
    }

    public static int strongPower(int[] array) {
        int countPower = 0;

        for (int i = 0; i < array.length; i++) {
            countPower += array[i];
        }
        countPower /= array.length;
        return countPower;
    }

    public static int morePowerSkill(int[] array) {
        int maxSkill = 0;
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxSkill < array[i]) {
                maxSkill = array[i];
                number = i;
            }
        }
        switch (number) {
            case 0:
                return 10;
            case 1:
                return 15;
            case 2:
                return 25;
        }
        return maxSkill;
    }

    public static void hwoIsCooler(int[] skills0, int[] skills1, int[] skills2) {
        int sumPowerYesMan = 0;
        int sumPowerMutant = 0;
        int sumPowerXZkto = 0;

        for (int i = 0; i < skills0.length; i++) {
            sumPowerYesMan += skills0[i];
        }

        for (int i = 0; i < skills1.length; i++) {
            sumPowerMutant += skills1[i];
        }

        for (int i = 0; i < skills2.length; i++) {
            sumPowerXZkto += skills2[i];
        }
        if (sumPowerYesMan < sumPowerMutant & sumPowerMutant < sumPowerXZkto) {
            System.out.println("XZkto has 30points");
            System.out.println("Mutant has 20points");
            System.out.println("YesMan has 10points");
        }
        if (sumPowerMutant < sumPowerXZkto & sumPowerXZkto < sumPowerYesMan) {
            System.out.println("YesMan has 30points");
            System.out.println("XZkto has 20points");
            System.out.println("Mustant has 10points");
        }
        if (sumPowerXZkto < sumPowerYesMan & sumPowerYesMan < sumPowerMutant) {
            System.out.println("Mutant has 30points");
            System.out.println("YesMan has 20points");
            System.out.println("XZkto has 10points");
        }
        if (sumPowerYesMan < sumPowerXZkto & sumPowerXZkto < sumPowerMutant) {
            System.out.println("Mutant has 30points");
            System.out.println("XZkto has 20points");
            System.out.println("YesMan has 10points");
        }
        if (sumPowerMutant < sumPowerYesMan & sumPowerYesMan < sumPowerXZkto) {
            System.out.println("XZkto has 30points");
            System.out.println("YesMan has 20points");
            System.out.println("Mutant has 10points");
        }
        if (sumPowerXZkto < sumPowerMutant & sumPowerMutant < sumPowerYesMan) {
            System.out.println("YesMan has 30points");
            System.out.println("Mutant has 20points");
            System.out.println("XZkto has 10points");
        }
    }
}
