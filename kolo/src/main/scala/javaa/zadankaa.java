package javaa;

class C{
    void wykonaj() { System.out.println("C"); }
}

class B extends C{
    void wykonaj() { System.out.println("B"); }
    void xD() { super.wykonaj(); }
}

class A extends B{
    void wykonaj() { System.out.println("A"); }
    void xD() { super.xD();}
}

public class zadankaa {
    public static void main(String[] args){
        B b = new B();
        C ab = (C)b;
        B ac = new A();
        b.wykonaj();
        ab.wykonaj();
        ((A)ac).xD();

    }
}
