package D20230616;

public class XianCheng implements Runnable {
    @Override
    public synchronized void run() {
        int t = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + (t++));
           /* synchronized (this){
                System.out.println(Thread.currentThread().getName() + "  " + (t++));
            }*/
        }
    }

    public static void main(String[] args) {
        XianCheng rd = new XianCheng();
        Thread tr1 = new Thread(rd);
        Thread tr2 = new Thread(rd);
        tr1.setName("Thread1");
        tr2.setName("Thread2");
        tr1.start();
        tr2.start();
    }
}

