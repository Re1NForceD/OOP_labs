package lab_6;

import lab_8.WrongStoneValueException;

public class NotAGem extends Stone {

    public NotAGem(int transparency, int price, int weight)
            throws WrongStoneValueException{
        super(transparency, price, weight);
    }
}
