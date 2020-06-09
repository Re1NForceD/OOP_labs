package lab_8;

import lab_6.NotAGem;
import lab_7.Necklace;

public class Main {

    public static void main(String[] args){
        try {
            NotAGem notagem = new NotAGem(10, 100, 0);
            Necklace necklace = new Necklace();
            System.out.printf("Загальна ціна: %d грн\n\n", necklace.getSummaryPrice());
            System.out.printf("Загальна вага: %d карат\n\n", necklace.getSummaryWeight());
            Necklace stoneRange = necklace.getRange();
            if (stoneRange.size() != 0) {
                System.out.println("Підходяще каміння:");
                System.out.println(stoneRange);
            } else {
                System.out.println("Підходящого каміння у намисті немає");
            }
        }
        catch (EmptyNecklaceException e){
            System.out.println(e.getMessage());
        }
        catch (WrongStoneValueException e){
            System.out.println(e.getMessage());
            }
        System.out.println("Done");
    }
}
