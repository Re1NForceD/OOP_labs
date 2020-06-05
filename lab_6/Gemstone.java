package lab_6;

import lab_8.WrongStoneValueException;

public class Gemstone extends Stone {

    public Gemstone(int transparency, int price, int weight)
            throws WrongStoneValueException{
        super(transparency, price, weight);
    }
}
