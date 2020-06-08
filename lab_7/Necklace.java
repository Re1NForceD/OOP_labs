package lab_7;

import lab_6.Stone;
import lab_8.EmptyNecklaceException;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public void sort_by_Price(){
        Arrays.sort(elements, 0, size, StonePriceComparator);
    }

    private static final Comparator<Stone> StonePriceComparator = (stone1, stone2) -> stone2.getPrice() - stone1.getPrice();

    public Necklace get_range()
            throws EmptyNecklaceException {
        if (size==0){
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
                } finally {
                    if (!tr) {
                        if (a >= b) {
                            System.out.println("Верхня межа має бути більшою ніж нижня!!!");
                            tr = true;
                        }
                    }
                }
            }
            return findTransp(a, b);
        }
    }

    public Necklace findTransp(int a, int b){
        Necklace find = new Necklace();
        for (int i=0; i<size; i++){
            if (a<=elements[i].getTransparency() && elements[i].getTransparency()<=b){
                find.add(elements[i]);
            }
        }
        return find;
    }

    public boolean equals(Collection<?> c){
        Iterator<?> iter1 = iterator();
        Iterator<?> iter2 = c.iterator();
        while (iter1.hasNext() & iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder for_pr = new StringBuilder();
        for (int i=0; i<size; i++){
            for_pr.append(i+1).append(" камінь: ").append(elements[i].toString());
            if (i<size-1){
                for_pr.append("\n");
            }
        }
        return for_pr.toString();
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
        if (size<elements.length & !contains(Stone)) {
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
        if (contains(o)) {
            int index = Arrays.asList(elements).indexOf(o);
            int cur_size = size;
            size = 0;
            Stone[] copied = elements;
            elements = new Stone[elements.length];
            for (int i = 0; i < cur_size; i++) {
                if (i != index) {
                    this.add(copied[i]);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        AtomicBoolean state = new AtomicBoolean(true);
        c.forEach(stone -> {
            if (!contains(stone)) {
                state.set(false);
            }
        });
        return state.get();
    }

    @Override
    public boolean addAll(Collection<? extends Stone> c) {
        for (Stone stone : c) {
            add(stone);
        }
        return true  ;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag;
        boolean changed = false;
        for (Object obj : c) {
            flag = !contains(obj);
            if (flag){
                if (!changed){
                    changed=true;
                }
                remove(obj);
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag;
        boolean changed = false;
        for (Object obj : c) {
            flag = contains(obj);
            if (flag){
                if (!changed){
                    changed=true;
                }
                remove(obj);
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        elements = new Stone[INITIAL_CAPACITY];
        size = 0;
        resize = false;
    }
}
