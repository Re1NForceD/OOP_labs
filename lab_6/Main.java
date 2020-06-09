package lab_6;

public class Main {

    public static void main(String[] args){
        Necklace necklace = new Necklace();
        necklace.addStone(new NotAGem(10, 100, 50));
        necklace.addStone(new Gemstone(50, 2000, 25));
        necklace.addStone(new SemipreciousStones(30, 2400, 60));
        System.out.printf("Загальна ціна: %d грн\n\n", necklace.getSummaryPrice());
        System.out.printf("Загальна вага: %d карат\n\n", necklace.getSummaryWeight());
        necklace.sortByPrice();
        System.out.println("Відсортовано по ціні:");
        System.out.println(necklace);
        Necklace stoneRange = necklace.getRange();
        if (stoneRange.getStones().length!=0){
            System.out.println("Підходяще каміння:");
            System.out.println(stoneRange);
        } else {
            System.out.println("Підходящого каміння у намисті немає");
        }
        System.out.println("Done");
    }
}
