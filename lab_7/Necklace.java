package lab_7;

import lab_6.Stone;

import java.util.*;

public class Necklace implements Set<Stone> {
    private static final int INITIAL_CAPACITY = 15;
    private Stone[] elements = new Stone[INITIAL_CAPACITY];
    private int size = 0;
    private boolean resize = false;

    public Necklace() {
    }

    public Necklace(Stone Stone) {
        add(Stone);
    }

    public Necklace(Collection<Stone> collection) {
        addAll(collection);
    }

    public int getSummary_price(){
        int summary_price = 0;
        for (Stone stone: elements){
            if (stone==null){
                break;
            }
            summary_price += stone.getPrice();
        }
        return summary_price;
    }

    public int getSummary_weight(){
        int summary_weight = 0;
        for (Stone stone: elements){
            if (stone==null){
                break;
            }
            summary_weight += stone.getWeight();
        }
        return summary_weight;
    }

    @Override
    public String toString(){
        StringBuilder for_pr = new StringBuilder();
        for (int j=0; j<size; j++){
            for_pr.append(j+1).append(" камінь: Прозорість - ").append(elements[j].getTransparency()).append(", Ціна - ").append(elements[j].getPrice()).append(", Вага - ").append(elements[j].getWeight()).append("\n");
        }
        return for_pr.toString();
    }

    public void sort_by_Price(){
        Arrays.sort(elements, 0, size, StonePriceComparator);
    }

    private static Comparator<Stone> StonePriceComparator = (stone1, stone2) -> {

        int price1 = stone1.getPrice();
        int price2 = stone2.getPrice();

        return price2 - price1;
    };

    public void findTransp(int a, int b){
        Necklace find = new Necklace();
        for (int i=0; i<size; i++){
            if (a<=elements[i].getTransparency() && elements[i].getTransparency()<=b){
                find.add(elements[i]);
            }
        }
        if (find.size()!=0){
            System.out.println("Каміння підходяще по прозорості:");
            System.out.println(find);
        }
        else{
            System.out.println("Піходящого каміння в намисті немає\n");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Stone stone : this) {
            if (o.equals(stone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Stone> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Stone next() {
                return elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Stone Stone) {
        if (size<elements.length) {
            elements[size++] = Stone;
        }
        else if (size==INITIAL_CAPACITY && !resize){
            resize = true;
            size = 0;
            Stone[] copied = elements;
            elements = new Stone[(int)(INITIAL_CAPACITY*1.30)];
            this.addAll(Arrays.asList(copied));
            this.add(Stone);
        }
        else {
            System.out.println("Досягнута максимальна кількість елементів!!!");
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Arrays.asList(elements).indexOf(o);
        int cur_size = size;
        size = 0;
        Stone[] copied = elements;
        elements = new Stone[elements.length];
        for (int i=0; i<cur_size; i++){
            if (i!=index){
                this.add(copied[i]);
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return size==elements.length;
    }

    @Override
    public boolean addAll(Collection<? extends Stone> c) {
        for (Stone Stone : c) {
            add(Stone);
        }
        return true  ;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        elements = new Stone[INITIAL_CAPACITY];
        return false;
    }

    @Override
    public void clear() {

    }
}
