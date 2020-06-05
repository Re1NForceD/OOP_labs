package lab_7;

import lab_6.Stone;
import lab_8.EmptyNecklaceException;

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

    public void sort_by_Price(){
        Arrays.sort(elements, 0, size, StonePriceComparator);
    }

    private static Comparator<Stone> StonePriceComparator = (stone1, stone2) -> stone2.getPrice() - stone1.getPrice();

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
        for (Stone stone: elements){
            if (a<=stone.getTransparency() && stone.getTransparency()<=b){
                find.add(stone);
            }
        }
        return find;
    }

    public boolean equals(Collection<? extends Stone> c){
        for (Stone stone : c){
            if (!contains(stone)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder for_pr = new StringBuilder();
        for (int i=0; i<size; i++){
            for_pr.append(i+1).append(" камінь: ").append(elements[i].toString()).append("\n");
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
      AtomicBoolean state = new AtomicBoolean(false);
      c.forEach(stone -> {
          if (!contains(stone)){
              add((Stone) stone);
              state.set(true);
          }
      });
      return state.get();
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
      boolean flag = true;
      for (Stone obj : this) {
          flag = c.contains(obj);
          if (!flag)
              remove(obj);
      }
      return !flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
      boolean flag = false;
      for (Object object : c) {
          flag = remove(object);
      }
      return flag;
    }

    @Override
    public void clear() {
        elements = new Stone[INITIAL_CAPACITY];
    }
}
