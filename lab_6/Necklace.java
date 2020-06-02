package lab_6;

import java.util.Arrays;
import java.util.Comparator;

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
        int i = 1;
        for (Stone stone: stones){
            for_pr.append(i).append(" камінь: Прозорість - ").append(stone.getTransparency()).append(", Ціна - ").append(stone.getPrice()).append(", Вага - ").append(stone.getWeight()).append("\n");
            i += 1;
        }
        return for_pr.toString();
    }

    public void sort_by_Price(){
        Arrays.sort(stones, StonePriceComparator);
    }

    private static Comparator<Stone> StonePriceComparator = (stone1, stone2) -> {

        int price1 = stone1.getPrice();
        int price2 = stone2.getPrice();

        return price2 - price1;
    };

    public void findTransp(int a, int b){
        Necklace find = new Necklace();
        for (Stone stone: stones){
            if (a<=stone.getTransparency() && stone.getTransparency()<=b){
                find.addStone(stone);
            }
        }
        if (find.getStones().length!=0){
            System.out.println("Каміння підходяще по прозорості:");
            System.out.println(find);
        }
        else{
            System.out.println("Піходящого каміння в намисті немає\n");
        }
    }
}
