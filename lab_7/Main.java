package lab_7;

import lab_6.Gemstone;
import lab_6.Not_a_gem;
import lab_6.Semiprecious_Stones;

public class Main {

    public static void main(String[] args){
        /*necklace.addStone(new Not_a_gem(10, 100, 50));
        necklace.addStone(new Gemstone(50, 2000, 25));
        necklace.addStone(new Semiprecious_Stones(30, 2400, 60));*/
        Not_a_gem not_a_gem = new Not_a_gem(10, 100, 50);
        Necklace necklace1 = new Necklace(not_a_gem);
        necklace1.add(new Semiprecious_Stones(30, 2400, 60));
        necklace1.add(new Gemstone(50, 2000, 25));
        Necklace necklace2 = new Necklace(necklace1);
        necklace2.add(new Gemstone(55, 2100, 20));
        System.out.printf("Загальна ціна: %d грн\n\n", necklace2.getSummary_price());
        System.out.printf("Загальна вага: %d карат\n\n", necklace2.getSummary_weight());
        necklace2.sort_by_Price();
        System.out.println("Відсортовано по ціні:");
        System.out.println(necklace2);
        necklace2.findTransp(3, 13);
        System.out.println("Done");
    }
}
