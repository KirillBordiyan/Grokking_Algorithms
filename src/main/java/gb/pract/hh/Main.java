package gb.pract.hh;

public class Main {
    public static void main(String[] args, int i) {
        main(args);
    }
    public static void main(String[] args) {
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("One");
                break;
            case 2:
            case 4:
                System.out.println("Four");
                day = 1;
            case 5:
                System.out.println("Five");
        }

        System.out.println("W");
    }
}

interface A{

}
interface B extends A{

}
