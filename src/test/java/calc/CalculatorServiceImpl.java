package calc;

public class CalculatorServiceImpl {

    CalculatorService calc;

    CalculatorServiceImpl(CalculatorService calc){
        this.calc = calc;
    }

    public int sum(int a, int b) {
        return calc.sum(a,b);
    }

}
