package lab_6;

public class Main {

    public static void main(String[] args){
        Necklace necklace = new Necklace();
        necklace.addStone(new Not_a_gem(10, 100, 50));
        necklace.addStone(new Gemstone(50, 2000, 25));
        necklace.addStone(new Semiprecious_Stones(30, 2400, 60));
        System.out.printf("Загальна ціна: %d грн\n\n", necklace.getSummary_price());
        System.out.printf("Загальна вага: %d карат\n\n", necklace.getSummary_weight());
        necklace.sort_by_Price();
        System.out.println("Відсортовано по ціні:");
        System.out.println(necklace);
        Necklace stone_range = necklace.get_range();
        if (stone_range.getStones().length!=0){
            System.out.println("Підходяще каміння:");
            System.out.println(stone_range);
        } else {
            System.out.println("Підходящого каміння у намисті немає");
        }
        System.out.println("Done");
    }
}
