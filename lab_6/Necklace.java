package lab_6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import lab_8.EmptyNecklaceException;

public class Necklace {

    private Stone[] stones = new Stone[0];

    public Stone[] getStones() {
        return stones;
    }

    public void addStone(Stone stone) {
        Stone[] prom = this.stones;
        this.stones = new Stone[prom.length+1];
        if (prom.length >= 0) System.arraycopy(prom, 0, this.stones, 0, prom.length);
        this.stones[prom.length] = stone;
    }

    public int getSummary_price(){
        int summary_price = 0;
        for (Stone stone: stones){
            summary_price += stone.getPrice();
        }
        return summary_price;
    }

    public int getSummary_weight(){
        int summary_weight = 0;
        for (Stone stone: stones){
            summary_weight += stone.getWeight();
        }
        return summary_weight;
    }

    @Override
    public String toString(){
        StringBuilder for_pr = new StringBuilder();
        for (int i=0; i<this.getStones().length; i++){
            for_pr.append(i+1).append(" камінь: ").append(stones[i].toString()).append("\n");
        }
        return for_pr.toString();
    }

    public void sort_by_Price(){
        Arrays.sort(stones, StonePriceComparator);
    }

    private static Comparator<Stone> StonePriceComparator = (stone1, stone2) -> stone2.getPrice() - stone1.getPrice();

    public Necklace get_range()
            throws EmptyNecklaceException{
        if (stones.length==0){
            throw new EmptyNecklaceException("Намисто не містить каміння!");
        } else {
            boolean tr = true;
            int a = 0;
            int b = 0;
            System.out.println("Знайдемо камінь у намисті, що відповідає заданому діапазону прозорості.");
            while (tr) {
                try {
                    System.out.println("Введіть нижню межу діапазону(від):");
                    Scanner scan = new Scanner(System.in);
                    String scan_a = scan.nextLine();
                    a = Integer.parseInt(scan_a);
                    tr = false;
                } catch (NumberFormatException e) {
                    System.out.println("Введіть число!!!");
                    tr = true;
                }
            }
            tr = true;
            while (tr) {
                try {
                    System.out.println("Введіть верхню межу діапазону(до):");
                    Scanner scan = new Scanner(System.in);
                    String scan_b = scan.nextLine();
                    b = Integer.parseInt(scan_b);
                    tr = false;
                } catch (NumberFormatException e) {
                    System.out.println("Введіть число!!!");
                    tr = true;
                }finally {
                    if (!tr) {
                        if (a>=b) {
                            System.out.println("Верхня межа має бути більшою ніж нижня!!!");
                            tr = true;
                        }
                    }
                }
            }
            return this.findTransp(a, b);
        }
    }

    public Necklace findTransp(int a, int b){
        Necklace find = new Necklace();
        for (Stone stone: stones){
            if (a<=stone.getTransparency() && stone.getTransparency()<=b){
                find.addStone(stone);
            }
        }
        return find;
    }
}
