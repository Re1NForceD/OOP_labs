package lab_6;

import lab_8.WrongStoneValueException;

public abstract class Stone {
    /*прозорість, ціна, вага*/
    private int transparency;
    private int price;/*в гривнях*/
    private int weight;/*в каратах*/

    public Stone(int transparency, int price, int weight)
            throws WrongStoneValueException{
        if (transparency<0 | price<=0 | weight<=0){
            throw new WrongStoneValueException("Якийсь з параметрів не коректний!");
        }
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

    @Override
    public String toString(){
        return "Прозорість " + transparency + ", Ціна " + price + " грн., Вага " + weight + " карат";
    }

    @Override
    public boolean equals(Object o){
        return this.toString().equals(o.toString());
    }
}
