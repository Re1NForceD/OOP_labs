package lab_7;

import lab_6.Gemstone;
import lab_6.NotAGem;
import lab_6.SemipreciousStones;

public class Main {

    public static void main(String[] args){
        /*necklace.addStone(new Not_a_gem(10, 100, 50));
        necklace.addStone(new Gemstone(50, 2000, 25));
        necklace.addStone(new Semiprecious_Stones(30, 2400, 60));*/
        NotAGem notagem = new NotAGem(10, 100, 50);
        Necklace necklace1 = new Necklace(notagem);
        necklace1.add(new SemipreciousStones(30, 2400, 60));
        necklace1.add(new Gemstone(50, 2000, 25));
        Necklace necklace2 = new Necklace(necklace1);
        necklace2.add(new Gemstone(55, 2100, 20));
        System.out.printf("Загальна ціна: %d грн\n\n", necklace2.getSummaryPrice());
        System.out.printf("Загальна вага: %d карат\n\n", necklace2.getSummaryWeight());
        necklace2.sortByPrice();
        System.out.println("Відсортовано по ціні:");
        System.out.println(necklace2);
        Necklace stoneRange = necklace2.getRange();
        if (stoneRange.size()!=0){
            System.out.println("Підходяще каміння:");
            System.out.println(stoneRange);
        } else {
            System.out.println("Підходящого каміння у намисті немає");
        }
        System.out.println("Done");
    }
}
