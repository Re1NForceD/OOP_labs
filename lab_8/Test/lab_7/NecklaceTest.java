package lab_7;

import lab_6.Gemstone;
import lab_6.Not_a_gem;
import lab_6.Semiprecious_Stones;
import lab_6.Stone;

import org.junit.Assert;
import org.junit.Test;

public class NecklaceTest {

    @Test
    public void getSummary_price() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertEquals(necklace.getSummary_price(), stone.getPrice());
    }

    @Test
    public void getSummary_weight() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertEquals(necklace.getSummary_weight(), stone.getWeight());
    }

    @Test
    public void sort_by_Price() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Necklace necklace1 = new Necklace(stone2);
        necklace1.add(stone1);
        necklace1.sort_by_Price();
        Necklace necklace2 = new Necklace(stone1);
        necklace2.add(stone2);
        Assert.assertTrue(necklace1.equals(necklace2));
    }

    @Test
    public void findTransp() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Necklace necklace = new Necklace(stone1);
        necklace.add(stone2);
        Necklace actual = necklace.findTransp(0, 29);
        Necklace expected = new Necklace(stone2);
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void testEquals() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace1 = new Necklace(stone);
        Necklace necklace2 = new Necklace(stone);
        Assert.assertTrue(necklace1.equals(necklace2));
    }

    @Test
    public void testToString() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertEquals("1 камінь: Прозорість 30, Ціна 3400 грн., Вага 40 карат", necklace.toString());
    }

    @Test
    public void size() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertEquals(necklace.size(), 1);
    }

    @Test
    public void isEmpty() {
      Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertFalse(necklace.isEmpty());
    }

    @Test
    public void contains() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Assert.assertTrue(necklace.contains(stone));
    }

    @Test
    public void testToArray() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Stone[] stones = new Stone[1];
        stones[0] = stone;
        Assert.assertArrayEquals(stones, necklace.toArray());
    }

    @Test
    public void add() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace();
        necklace.add(stone);
        Assert.assertEquals(1, necklace.size());
        Assert.assertTrue(necklace.contains(stone));

    }

    @Test
    public void remove() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Necklace necklace = new Necklace(stone1);
        necklace.add(stone2);
        necklace.remove(stone1);
        Assert.assertEquals(1, necklace.size());
        Assert.assertFalse(necklace.contains(stone1));
    }

    @Test
    public void containsAll() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Necklace necklace1 = new Necklace(stone1);
        necklace1.add(stone2);
        Necklace necklace2 = new Necklace(necklace1);
        necklace1.containsAll(necklace2);
        Assert.assertTrue(necklace2.containsAll(necklace1));
    }

    @Test
    public void addAll() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Necklace necklace1 = new Necklace(stone1);
        necklace1.add(stone2);
        Necklace necklace2 = new Necklace();
        necklace2.addAll(necklace1);
        Assert.assertTrue(necklace1.equals(necklace2));
    }

    @Test
    public void retainAll() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Stone stone3 = new Semiprecious_Stones(15, 180, 38);
        Necklace necklace1 = new Necklace(stone1);
        necklace1.add(stone2);
        necklace1.add(stone3);
        Necklace necklace2 = new Necklace(stone2);
        necklace2.add(stone3);
        necklace1.retainAll(necklace2);
        Assert.assertTrue(necklace1.equals(necklace2));
    }

    @Test
    public void removeAll() {
        Stone stone1 = new Gemstone(30, 3400, 40);
        Stone stone2 = new Not_a_gem(0, 100, 45);
        Stone stone3 = new Semiprecious_Stones(15, 180, 38);
        Necklace necklace1 = new Necklace(stone1);
        necklace1.add(stone2);
        necklace1.add(stone3);
        Necklace necklace2 = new Necklace(stone2);
        necklace2.add(stone3);
        necklace1.removeAll(necklace2);
        Necklace expected = new Necklace(stone1);
        Assert.assertTrue(necklace1.equals(expected));
    }

    @Test
    public void clear() {
        Stone stone = new Gemstone(30, 3400, 40);
        Necklace necklace = new Necklace(stone);
        Necklace expected = new Necklace();
        necklace.clear();
        Assert.assertTrue(necklace.equals(expected));
    }
}
