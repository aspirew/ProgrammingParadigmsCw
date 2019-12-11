package zad2;

public class Test {
    int zawartosc= 0;
    static void argNiemodyfikowalny(final Test zmienna) {
        zmienna.zawartosc = 1;
        //zmienna = null;
    }

    static void argModyfikowalny(Test zmienna) {
        zmienna.zawartosc = 1;
        zmienna = null;
    }

    public static void main(String[] args) {
        Test modyfikowalna = new Test();
        final Test niemodyfikowalna = final new Test();

        argNiemodyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);

        argNiemodyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc);

        argModyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);

        argModyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc);
    }
}