package lab_8;

import lab_6.Not_a_gem;
import lab_7.Necklace;

public class Main {

    public static void main(String[] args){
        try {
            Not_a_gem not_a_gem = new Not_a_gem(10, 100, 0);
            Necklace necklace = new Necklace();
            System.out.printf("Загальна ціна: %d грн\n\n", necklace.getSummary_price());
            System.out.printf("Загальна вага: %d карат\n\n", necklace.getSummary_weight());
            Necklace stone_range = necklace.get_range();
            if (stone_range.size() != 0) {
                System.out.println("Підходяще каміння:");
                System.out.println(stone_range);
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
