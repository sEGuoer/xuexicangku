package D20230616;

public class ThreadDeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("线程1 获得锁1");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    System.out.println("线程1 等待锁2");
                        synchronized (lock2){
                            System.out.println("线程1 获得锁2");
                        }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("线程2 获得锁2");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    System.out.println("线程2 等待锁1");
                        synchronized (lock1){
                            System.out.println("线程2 获得锁1");
                        }
                }
            }
        });
        t2.start();
    }
}
