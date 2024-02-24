package marcos.restspringbootandjava.math;

public class SimpleMath {

    public Double addition(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberTwo == 0 ? 0 : numberOne / numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }
}