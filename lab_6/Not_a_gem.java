package lab_6;

import lab_8.WrongStoneValueException;

public class Not_a_gem extends Stone {

    public Not_a_gem(int transparency, int price, int weight)
            throws WrongStoneValueException{
        super(transparency, price, weight);
    }
}
