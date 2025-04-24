package gb.pract.groAlg;

import java.util.NoSuchElementException;

public class Main {
    private Main() {
        throw new NoSuchElementException();
    }
    public static void main(String[] args) {
        int a =0;
        int b =2;
        interface A{
            default void foo(){
                System.out.println("a");
            }
        }
        interface    B{
            default void foo(){
                System.out.println("b");
            }
        }

        class c implements A,B{

            @Override
            public void foo() {
                System.out.println("c");
            }
        }
        A c = new c();
        c.foo();
    }
}
