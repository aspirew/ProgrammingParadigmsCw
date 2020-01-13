class IntCell {
    private int n = 0;
    private boolean blockage = false;
    private void waitForNotify(){
        try{
            wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized int getN() {
        while(blockage){
            waitForNotify();
        }
        blockage = true;
        notifyAll();
        return n;
    }
    public synchronized void setN(int n) {
        while(!blockage){
            waitForNotify();
        }
        this.n = n;
        blockage = false;
        notifyAll();
    }
}
class Count extends Thread {
    private static IntCell n = new IntCell();
    @Override public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            temp = n.getN();
            n.setN(temp + 1);
        }
    }
    public static void main(String[] args) {
        Count p = new Count();
        Count q = new Count();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The value of n is " + n.getN());
    }
}
