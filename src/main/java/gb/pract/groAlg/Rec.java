package gb.pract.groAlg;

public class Rec {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }


    public static int factorial(Integer goal){
        if(goal == 1){ //базовый случай
            return 1;
        } else { //рекурсивный случай
            System.out.println(goal);
            return goal * factorial(goal-1);
        }
    }
}
