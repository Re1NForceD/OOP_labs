package lab_7;

import lab_6.Stone;
import lab_8.EmptyNecklaceException;

import java.util.*;

public class Necklace implements Set<Stone> {
    private static final int INITIAL_CAPACITY = 15;
    private Stone[] elements = new Stone[INITIAL_CAPACITY];
    private int size = 0;

    public Necklace() {
    }

    public Necklace(Stone Stone) {
        add(Stone);
    }

    public Necklace(Collection<Stone> collection) {
        addAll(collection);
    }

    public int getSummaryPrice(){
        int summaryPrice = 0;
        for (Stone stone: elements){
            if (stone==null){
                break;
            }
            summaryPrice += stone.getPrice();
        }
        return summaryPrice;
    }

    public int getSummaryWeight(){
        int summaryWeight = 0;
        for (Stone stone: elements){
            if (stone==null){
                break;
            }
            summaryWeight += stone.getWeight();
        }
        return summaryWeight;
    }

    public void sortByPrice(){
        Arrays.sort(elements, 0, size, StonePriceComparator);
    }

    private static final Comparator<Stone> StonePriceComparator = (stone1, stone2) -> stone2.getPrice() - stone1.getPrice();

    public Necklace getRange()
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
                    String scanA = scan.nextLine();
                    a = Integer.parseInt(scanA);
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
                    String scanB = scan.nextLine();
                    b = Integer.parseInt(scanB);
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
        StringBuilder toPrint = new StringBuilder();
        for (int i=0; i<size; i++){
            toPrint.append(i+1).append(" камінь: ").append(elements[i].toString());
            if (i<size-1){
                toPrint.append("\n");
            }
        }
        return toPrint.toString();
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
    public boolean add(Stone stone) {
        if (size<elements.length && !contains(stone)) {
            elements[size++] = stone;
        }
        else if (size==elements.lenght){
            size = 0;
            Stone[] copied = elements;
            elements = new Stone[(int)(elements.lenght*1.30)];
            this.addAll(Arrays.asList(copied));
            this.add(stone);
        }
        else {
            System.out.println("Елемент уже міститься в насмисті");
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            int index = Arrays.asList(elements).indexOf(o);
            int currentSize = size;
            size = 0;
            Stone[] copied = elements;
            elements = new Stone[elements.length];
            for (int i = 0; i < currentSize; i++) {
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
        for (Stone stone : this) {
            if (!contains(stone)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Stone> c) {
        for (Stone stone : c) {
            add(stone);
        }
        return true;
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
    }
}
