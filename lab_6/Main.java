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
        necklace.findTransp(15, 20);
        System.out.println("Done");
    }
}
