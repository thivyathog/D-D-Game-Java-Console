

import java.util.Scanner;

public class Character {
    public String characterClass;
    public int[] input = new int[6];
    public int[] value = new int[8];
public int level;
public int skillPoints;
private static String[] names = {"Str", "Dex", "Con", "Int", "Wis", "Cha"};
   public  String characName;
   private double bab;
   private double combat;
   private int damage;

    public  void characInfo() {
        switch (characterClass) {   //using case statement choosing the character
            case "druid":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(4);

                break;

            case "barbarian":
                assign(12);
                System.out.println("hitdice of the character is:1d12");
                skillPoints=points(4);
                break;

            case "warlock":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(2);
                break;
            case "cleric":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(2);
                break;

            case "sorcerer":
                assign(6);
                System.out.println("hitdice of the character is:1d6");
                skillPoints=points(2);
                break;
            case "bard":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(6);
                break;
            case "monk":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(4);
                break;

            case "ranger":
                assign(10);
                System.out.println("hitdice of the character is:1d10");
                skillPoints=points(6);
                break;

            case "paladin":
                assign(10);
                System.out.println("hitdice of the character is:1d10");
                skillPoints=points(2);
                break;

            case "rogue":
                assign(8);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(8);
                break;

            case "fighter":
                assign(10);
                System.out.println("hitdice of the character is:1d10");
                skillPoints=points(2);
                break;

            case "wizard":
                assign(6);
                System.out.println("hitdice of the character is:1d8");
                skillPoints=points(2);
                break;
            default:
                System.out.println("please enter a valid character class");
                System.exit(0);


        }
    }

    private  int roll_Dice(int diceNumber, int faceOfDice) {
        int sum = 0;
        int dicemin = 0;
        int[] dice = new int[diceNumber];
        for (int i = 0; i < diceNumber; i++) {
            dice[i] = (int) (Math.random() * 1000 % faceOfDice + 1);
            sum += dice[i];
            if (dice[i] < dice[0]) {
                dicemin = dice[i];

            } else {
                dicemin = dice[0];
            }

        }
        sum -= dicemin;
        return sum;

    }
    private  int hp(int faces_Ofdice) { //tocalculatehitpoints
        int dicetotal = 0;
        int[] dice;
        dice = new int[1];
        for (int i = 0; i < 1; i++) {
            dice[i] = ((int) (Math.random() * 1000 % faces_Ofdice + 1));
            dicetotal = dicetotal + dice[i];
        }

        return dicetotal;
    }

    private  void assign(int hitdice) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the method number in which you want to generate your Attribute out of:");
            System.out.println("Entering the attributes directly -1 \n" +
                    " Roll 4d6 and discard the lowest value-2 \n" +
                    " Roll 4d6 and discard the lowest value and if the attribute is 16 or higher, add the value of an additional 1d6.-3 \n" +
                    "Roll Method IX -4 ");

            int generator = sc.nextInt();
            switch (generator) {
                case 1:
                    System.out.println("Enter 7 integers for the Attributes");
                    for (int i = 0; i < 6; i++) {
                        input[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        input[i] = roll_Dice(4, 6);
                    }
                    break;
                case 3:
                    int inputtemp=0;
                    for (int i = 0; i < 6; i++) {
                        input[i] = roll_Dice(4, 6);
                        if (input[i]>=16) {
                            inputtemp=input[i]+(int) (Math.random() * 1000 % 6 + 1);
                            System.out.println(inputtemp);
                            input[i]=inputtemp;
                        }
                    }
                    break;
                case 4:
                    atrribute_classify();
                    break;

                default:
                    System.out.println("Please Enter a valid method number");
                    System.exit(0);
            }
            System.out.println("The following are the generated attributes:");

            for (int i = 0; i < 6; i++) {
                System.out.println(names[i] + ": " + input[i]);
            }
            System.out.println("Do you wish to accept the values or discard it?(yes/no)");
            String accept = sc.next();
            if (accept.equals("yes")) break;
        }


        for (int i = 0; i < 6; i++) {
            if (input[i] == 10) value[i] = 0;
            else if (input[i] < 10) {
				/*finding all bonus for the odd numbers less than 10- using this equation we
			could even find the smallest difference between number 10 and 9 */
                value[i] = (input[i] / 2) - 5;
            } else {
                //finding bonus for even numbers more than 10
                value[i] = (input[i] / 2) - 5;

            }

        }
        if (value[2] < 0) {
            characInfo();
        } else {
            value[6] = value[2] + (hp(hitdice));
        }
        value[7] = value[6] - value[2];

        if (characterClass.equals("barbarian")||characterClass.equals("fighter")||characterClass.equals("monk")||characterClass.equals("paladin")){
            bab=level;
            combat=bab+input[0];
        }else if(characterClass.equals("ranger")){
            bab=(level*3)/4;

        }else{
            bab=(level/2);
        }
        combat=bab+input[0];
        damage =input[0];
    }

    private int attribute(int diceNumber) {
        int sum = 0;
        int i = 0;
        int tmpy = 0;
        int[] dice = new int[diceNumber];
        for (i = 0; i < diceNumber; i++) {
            dice[i] = (int) (Math.random() * 1000 % 6 + 1);
            sum = sum + dice[i];
        }

        for (i = 0; i < dice.length; i++) {
            for (int j = i + 1; j < dice.length; j++) {

                if (dice[i] > dice[j]) {
                    tmpy = dice[i];
                    dice[i] = dice[j];
                    dice[j] = tmpy;


                }
            }
        }
        sum = sum - (dice[0] + dice[1] + dice[2]);

        return sum;

    }

    private  void atrribute_classify() {
        switch (characterClass) {   //using case statement choosing the character

            case "cleric":
                input[0] = attribute(7);
                input[1] = attribute(6);
                input[2] = attribute(5);
                input[3] = attribute(4);
                input[4] = attribute(9);
                input[5] = attribute(8);
                break;
            case "druid":
                input[0] = attribute(7);
                input[1] = attribute(6);
                input[2] = attribute(5);
                input[3] = attribute(8);
                input[4] = attribute(9);
                input[5] = attribute(4);
                break;
            case "barbarian":
                input[0] = attribute(9);
                input[1] = attribute(7);
                input[2] = attribute(8);
                input[3] = attribute(6);
                input[4] = attribute(5);
                input[5] = attribute(4);
                break;

            case "warlock":
                input[0] = attribute(7);
                input[1] = attribute(6);
                input[2] = attribute(5);
                input[3] = attribute(4);
                input[4] = attribute(8);
                input[5] = attribute(9);
                break;
            case "sorcerer":
                input[0] = attribute(7);
                input[1] = attribute(6);
                input[2] = attribute(8);
                input[3] = attribute(5);
                input[4] = attribute(4);
                input[5] = attribute(9);
                break;
            case "bard":
                input[0] = attribute(7);
                input[1] = attribute(8);
                input[2] = attribute(6);
                input[3] = attribute(5);
                input[4] = attribute(4);
                input[5] = attribute(9);
                break;


            case "monk":
            case "ranger":
                input[0] = attribute(7);
                input[1] = attribute(9);
                input[2] = attribute(6);
                input[3] = attribute(5);
                input[4] = attribute(8);
                input[5] = attribute(4);
                break;
                case "paladin":
                input[0] = attribute(8);
                input[1] = attribute(4);
                input[2] = attribute(5);
                input[3] = attribute(6);
                input[4] = attribute(7);
                input[5] = attribute(9);
                break;
            case "rogue":
                input[0] = attribute(7);
                input[1] = attribute(9);
                input[2] = attribute(5);
                input[3] = attribute(8);
                input[4] = attribute(6);
                input[5] = attribute(4);
                break;
            case "fighter":
                input[0] = attribute(9);
                input[1] = attribute(8);
                input[2] = attribute(7);
                input[3] = attribute(6);
                input[4] = attribute(5);
                input[5] = attribute(4);
                break;
            case "wizard":
                input[0] = attribute(4);
                input[1] = attribute(6);
                input[2] = attribute(5);
                input[3] = attribute(9);
                input[4] = attribute(8);
                input[5] = attribute(7);
                break;
                default:
                    System.out.println("Please enter a valid class");
                    System.exit(0);
        }
    }
        public  int points(int number) {
            int skillPoints=0;
            if(level==1) {
                skillPoints = (number + value[3])*4;
            } else{
             skillPoints= (number + value[3]);
        }
        return skillPoints;
        }
    public  void Prints() {
        System.out.println("Name of your character:"+characName);
        System.out.println("you have selected your class as:" + characterClass);

        System.out.println("Level: " + "[" + level + "]");
        for (int i = 0; i < 6; i++) {
            if (input[i] > 11) {


                System.out.println(names[i] + ": " + "[" + input[i] + "]" + "[" + "+" + value[i] + "]");

            } else {
                System.out.println(names[i] + ": " + "[" + input[i] + "]" + " " + "[" + value[i] + "]");
            }
        }

        System.out.println("Hit Dice:" + value[7]);
        System.out.println("HP: " + value[6]);

        System.out.println("Base Attack Bonus:"+bab);
        System.out.println("Combat:"+combat+"\t Damage:"+damage);
        System.out.println("Skill points:"+skillPoints);

    }
    }







