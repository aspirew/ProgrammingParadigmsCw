import java.util.concurrent.Semaphore;
class IntCell2 {
    static Semaphore s = new Semaphore(1);

    private int n = 0;
    public int getN() {
        while(!s.tryAcquire());
        return n;
    }
    public void setN(int n) {
        this.n = n;
        s.release();
    }
}

class Count2 extends Thread {
    static IntCell2 n = new IntCell2();

    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            temp = n.getN();
            n.setN(temp + 1);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Count2 p = new Count2();
        Count2 q = new Count2();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }
}