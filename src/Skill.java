import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Skill {

    private static ArrayList<String> list = new ArrayList<>();
    private String name;
    private String optional;

    private double rank[];
    private String nxtskill;
    private int stat_Affinity[];
    private String skill_descp[];
    private static LinkedList<String> skills = new LinkedList<>();

    public void NextSkill(int y, int[] bonus, String c) {

        skill_descp = new String[y];
        stat_Affinity=new int[y];
        String clName = c;

        int i = 0;
        int[] bValues = bonus;


        try {
            Scanner filex = new Scanner(new File("skill.txt"));
            while (filex.hasNextLine()) {

                name = filex.nextLine();

                System.out.println(name+":");

                if (name.equals("Animal Handling")) {
                    System.out.println(" It is needed when you need to calm down a domestic animal or understand an animal's intentions,this skill helps to achieve this.");
                } else if (name.equals("Athletics")) {
                    System.out.println("You require Strength(Athletics) to overcome difficult situtations such as climbing a mountain or swimming.");
                } else if (name.equals("Intimidation")) {
                    System.out.println("This skill is necessary When you want to influence someone by threatning or taking them hostile or by physical violence");
                } else if (name.equals("Nature")) {
                    System.out.println("helps with your knowlege about terrain,climate, plants, natural cycles and animals through this skill ");
                } else if (name.equals("Perception")) {
                    System.out.println("creates awareness surroundings and your senses");
                } else if (name.equals("Survival")) {
                    System.out.println("helps you to track,hunt, guide, identify signs , predict the weather, or avoid natural hazard");
                } else if (name.equals(" History ")) {
                    System.out.println("ability to use the knowledege about historical events, legendary people, ancient kingdoms ,wars and  civilizations.");
                } else if (name.equals("Insight")) {
                    System.out.println("ability to decide true intentions of a creature");
                } else if (name.equals("Medicine")) {
                    System.out.println("helps you to save companion from death or diagnose an illness.");
                } else if (name.equals("Persuasion")) {
                    System.out.println("used to influence people with tact, social graces, or good nature");
                } else if (name.equals(" Religion")) {
                    System.out.println("gives knowledge about rites and prayers, religious hierarchies, holy symbols, and the practices of secret cults");
                } else if (name.equals("Acrobatics")) {
                    System.out.println("makes sure you stay on your feet with balance in a tricky situation");
                } else if (name.equals("Stealth")) {
                    System.out.println(" to protect yourself from enemies, slip away without being noticed, or sneak up on someone without being seen or heard");
                } else if (name.equals("Investigation")) {
                    System.out.println("ability to make deductions using clues which are found.");
                } else if (name.equals("Performance")) {
                    System.out.println("ability to impress audience by any sort of entertainment.");
                } else if (name.equals("Sleight of Hand")) {
                    System.out.println("ability to  manual trickery, such as planting something on someone else or concealing an object");
                } else if (name.equals("Arcana")) {
                    System.out.println("gives you the knowledge about our ability  spells, magic items,  symbols, magical traditions, the planes of existence");
                } else if(name.equals("Deception")){
                    System.out.println("ability to convincingly lie, either verbally or through your actions");
                }
                System.out.println("Do you want"+name+" as your skill? yes/no");
                Scanner xy = new Scanner(System.in);
                nxtskill = xy.next();

                if (nxtskill.equals("yes")) {
                    skills.add(name);
                    if (i == (y - 1)) {

                        break;
                    }
                    i += 1;
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        try {
            Scanner scan = new Scanner(new File("skill.txt"));
            while (scan.hasNextLine()) {
                String name2 = scan.nextLine();
                list.add(name2);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        for (int t = 0; t < y; t++) {

            switch (skills.get(t)) {
                case "Animal Handling":
                    if (clName.equals("barbarian") || clName.equals("bard") || clName.equals("druid") || clName.equals("fighter") ||
                            clName.equals("ranger")) {
                        stat_Affinity[t] += prof_bonus(y) ;

                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[4];
                    skill_descp[t]=" Wisdom is needed when you need to calm down a domestic animal or understand an animal's intentions,this skill helps to achieve this.";
                    break;
                case "Athletics":
                    if (clName.equals("barbarian") || clName.equals("bard") || clName.equals("fighter") || clName.equals("monk") || clName.equals("paladin") || clName.equals("ranger") ||
                            clName.equals("rogue")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[0];
                    skill_descp[t] ="You require Strength(Athletics) to overcome difficult situtations such as climbing a mountain or swimming.";
                    break;
                case "Intimidation":
                    if (clName.equals("barbarian") || clName.equals("fighter") || clName.equals("monk") || clName.equals("paladin") || clName.equals("rogue") || clName.equals("sorcerer") ||
                            clName.equals("warlord") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[5];
                    skill_descp[t] = "This skill is necessary When you want to influence someone by threatning or taking them hostile or by physical violence";
                    break;
                case "Nature":
                    if (clName.equals("bard") || clName.equals("barbarian") || clName.equals("druid") || clName.equals("ranger") || clName.equals("warlord")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[3];
                    skill_descp[t] = "intelligence uses your knowlege about terrain,climate, plants, natural cycles and animals through this skill ";
                    break;
                case "Perception":
                    if (clName.equals("bard") || clName.equals("barbarian") || clName.equals("druid") || clName.equals("fighter") || clName.equals("ranger") || clName.equals("rogue")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);

                        stat_Affinity[t] = stat_Affinity[t] + bValues[4];
                    }
                    skill_descp[t] = "creates awareness surroundings and your senses";
                    break;
                case "Survival":
                    if (clName.equals("bard") || clName.equals("druid") || clName.equals("barbarian") || clName.equals("fighter") || clName.equals("ranger")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[4];
                    skill_descp[t] = "helps you to track,hunt, guide, identify signs , predict the weather, or avoid natural hazard";
                    break;
                case "History":

                    if (clName.equals("bard") || clName.equals("cleric") || clName.equals("fighter") || clName.equals("monk") || clName.equals("warlord") || clName.equals("wizard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[3];
                    skill_descp[t] = "ability to use the knowledege about historical events, legendary people, ancient kingdoms ,wars and  civilizations.";
                    break;
                case "Insight":
                    if (clName.equals("cleric") || clName.equals("druid") || clName.equals("fighter") || clName.equals("monk") || clName.equals("paladin") || clName.equals("ranger") ||
                            clName.equals("sorcerer") || clName.equals("wizard") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[4];
                    skill_descp[t] = " ability to decide true intentions of a creature";
                    break;
                case "Medicine":
                    if (clName.equals("cleric") || clName.equals("druid") || clName.equals("paladin") || clName.equals("wizard") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[4];
                    skill_descp[t] = " helps you to save companion from death or diagnose an illness.";
                    break;
                case "Persuasion":
                    if (clName.equals("cleric") || clName.equals("paladin") || clName.equals("rogue") || clName.equals("sorcerer") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[5];
                    skill_descp[t] = "used to influence people with tact, social graces, or good nature";
                    break;
                case "Religion":
                    if (clName.equals("cleric") || clName.equals("druid") || clName.equals("monk") || clName.equals("paladin") || clName.equals("sorcerer") ||
                            clName.equals("warlord") || clName.equals("wizard") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[3];
                    skill_descp[t] = "gives knowledge about rites and prayers, religious hierarchies, holy symbols, and the practices of secret cults";
                    break;
                case " Acrobatics":
                    if (clName.equals("fighter") || clName.equals("monk") || clName.equals("rogue") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[1];
                    skill_descp[t] = " makes sure you stay on your feet with balance in a tricky situation";
                    break;
                case "Stealth":
                    if (clName.equals("monk") || clName.equals("ranger") || clName.equals("rogue") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[1];
                    skill_descp[t] = " to protect yourself from enemies, slip away without being noticed, or sneak up on someone without being seen or heard.";
                    break;
                case "Investigation":
                    if (clName.equals("ranger") || clName.equals("rogue") || clName.equals("warlord") || clName.equals("wizard") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[3];
                    skill_descp[t] = "ability to make deductions using clues which are found.";
                    break;
                case "Performance":

                    if (clName.equals("rogue") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[5];
                    skill_descp[t] = "ability to impress audience by any sort of entertainment.";
                    break;
                case "Sleight of Hand":
                    if (clName.equals("rogue") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[1];
                    skill_descp[t] = " ability to  manual trickery, such as planting something on someone else or concealing an object.";
                    break;
                case "Arcana":
                    if (clName.equals("druid") || clName.equals("sorcer") || clName.equals("warlock") || clName.equals("wizard") || clName.equals("bard")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[3];
                    skill_descp[t] = "gives you the knowledge about our ability  spells, magic items,  symbols, magical traditions, the planes of existence";
                    break;
                case "Deception":
                    if (clName.equals("rogue") || clName.equals("sorcerer") || clName.equals("bard") || clName.equals("warlock")) {
                        stat_Affinity[t] = stat_Affinity[t] + prof_bonus(y);
                    }
                    stat_Affinity[t] = stat_Affinity[t] + bValues[5];
                    skill_descp[t] = "ability to convincingly lie, either verbally or through your actions.";
                    break;
            }
        }


    }

    public void rankClassify(String m, int p) {

        int level = p;
        optional = m;
        rank=new double[level];
        switch (optional) {
            case "barbarian":
                for (int j = 0; j <level; j++) {
                    if ((skills.get(j).equals(list.get(0))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(2))) || (skills.get(j).equals(list.get(3)))
                            || (skills.get(j).equals(list.get(4))) || (skills.get(j).equals(list.get(5)))) {
                        rank[j]= 1;

                    } else {
                        rank[j]= 0.5;
                    }
                }
                break;


            case "druid":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(16))) || (skills.get(j).equals(list.get(0))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(8)))
                            || (skills.get(j).equals(list.get(3))) || (skills.get(j).equals(list.get(4))) || (skills.get(j).equals(list.get(10))) || (skills.get(j).equals(list.get(5)))) {
                        rank[j] = 1;
                    } else {
                        rank[j] = 0.5;
                    }
                }


                break;


            case "warlord":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(0))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(8))
                    ) || (skills.get(j).equals(list.get(3))) || (skills.get(j).equals(list.get(4))) || (skills.get(j).equals(list.get(10))) || (skills.get(j).equals(list.get(5)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;


            case "cleric":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(6))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(8))) || (skills.get(j).equals(list.get(9))
                    ) || (skills.get(j).equals(list.get(10)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;

            case "sorcerer":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(16))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(4))) || (skills.get(j).equals(list.get(9))) || (skills.get(j).equals(list.get(10))
                    ) || (skills.get(j).equals(list.get(2)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;
            case "bard":
                for (int j = 0; j < level; j++) {
                    rank[j] = 1;
                }
                break;
            case "monk":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(11))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(12))) || (skills.get(j).equals(list.get(6))) || (skills.get(j).equals(list.get(7))
                    ) || (skills.get(j).equals(list.get(10)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;

            case "ranger":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(0))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(2))) || (skills.get(j).equals(list.get(3))
                    ) || (skills.get(j).equals(list.get(5))) || (skills.get(j).equals(list.get(12))) || (skills.get(j).equals(list.get(4)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;


            case "paladin":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(8))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(2))
                    ) || (skills.get(j).equals(list.get(9))) || (skills.get(j).equals(list.get(10)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;


            case "rogue":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(11))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(17))) || (skills.get(j).equals(list.get(2))) || (skills.get(j).equals(list.get(4))
                    ) || (skills.get(j).equals(list.get(12))) || (skills.get(j).equals(list.get(15))) || (skills.get(j).equals(list.get(9))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(14)))) {
                        rank[j] = 1;

                    } else {
                        rank[j]= 0.5;
                    }
                }
                break;


            case "fighter":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(11))) || (skills.get(j).equals(list.get(1))) || (skills.get(j).equals(list.get(2))) || (skills.get(j).equals(list.get(6))) || (skills.get(j).equals(list.get(7))
                    ) || (skills.get(j).equals(list.get(4))) || (skills.get(j).equals(list.get(5))) || (skills.get(j).equals(list.get(0)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }
                break;


            case "wizard":
                for (int j = 0; j < level; j++) {
                    if ((skills.get(j).equals(list.get(16))) || (skills.get(j).equals(list.get(6))) || (skills.get(j).equals(list.get(7))) || (skills.get(j).equals(list.get(13))) || (skills.get(j).equals(list.get(8))
                    ) || (skills.get(j).equals(list.get(10)))) {
                        rank[j] = 1;

                    } else {
                        rank[j] = 0.5;
                    }
                }

                break;

        }


    }


    public void prints ( int level){
        System.out.println("The selected skills are:" + skills);
        for (int i = 0; i < level; i++) {
            System.out.println(skills.get(i) + ":") ;
            System.out.println( skill_descp[i]);

            System.out.println("rank:" + rank[i]);
            System.out.println("stat Affinity:" + stat_Affinity[i]);
        }
    }

    private static int prof_bonus ( int level){
        int prof_bonus;
        if (level <= 4) {
            prof_bonus = 2;
        } else if (level <= 8) {
            prof_bonus = 3;

        } else if (level <= 12) {
            prof_bonus = 4;
        } else if (level <= 16) {
            prof_bonus = 5;
        } else {
            prof_bonus = 6;
        }
        return prof_bonus;
    }
}






