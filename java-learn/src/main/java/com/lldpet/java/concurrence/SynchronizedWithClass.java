package com.lldpet.java.concurrence;

/**
 * @author llduo
 * @Description
 *              synchronized 修饰静态方法
 * @create 2019-01-10 10:19
 */
public class SynchronizedWithClass implements Runnable {
    static int i = 0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increaseWithInstance(){
        i++;
    }
    /**
     * synchronized 修饰静态方法
     */
    public static synchronized void increaseWithClass(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increaseWithClass();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        //new 新实例
        Thread t1 = new Thread(new SynchronizedWithClass());
        //new 新实例
        Thread t2 = new Thread(new SynchronizedWithClass());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}
