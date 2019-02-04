import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class Cw2_Asses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creating an object
        Character character = new Character();

        System.out.println("Enter a name for your character");
        character.characName = sc.nextLine();
        System.out.println("Enter the level you require:");
        character.level = sc.nextInt();

        System.out.println("Enter the class you want for your character out of: " +
                "\n druid\n barbarian\n warlock\n cleric\n sorcerer\n bard\n monk\n ranger\n paladin\n rogue\n fighter\n wizard");
        character.characterClass=sc.next();
        character.characInfo();

        Skill skill=new Skill();

        System.out.println("The number of skills you can choose is" + character.level);

        skill.NextSkill(character.level,character.value,character.characterClass);
        skill.rankClassify(character.characterClass,character.level);

        System.out.println("Do you want to save your character in a file or ");
        character.Prints();
        skill.prints(character.level);
        File file=new File("Character.txt");
        try {
            FileWriter filew=new FileWriter(file,true);
            PrintWriter printw= new PrintWriter(filew,true);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }


}



