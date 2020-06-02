package lab_6;

public class Stone {
    /*прозорість, ціна, вага*/
    private int transparency;
    private int price;/*в гривнях*/
    private int weight;/*в каратах*/

    public Stone(int transparency, int price, int weight) {
        this.transparency = transparency;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getTransparency() {
        return transparency;
    }

    public int getWeight() {
        return weight;
    }
}
