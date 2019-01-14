package com.lldpet.java.concurrence;

/**
 * @author llduo
 * @Description
 *             Synchronized 关键字作用于实例方法
 *             每个线程拥有不同的实例对象锁
 * @create 2019-01-10 9:43
 */
public class SynchronizedWithDiffInstance implements Runnable {
    static int i = 0;

    /**
     * synchronized 作用于实例方法
     */
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //new 新实例
        Thread t1 = new Thread(new SynchronizedWithDiffInstance());
        //new 新实例
        Thread t2 = new Thread(new SynchronizedWithDiffInstance());

        t1.start();
        t2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        t1.join();
        t2.join();
        //i 小于2000000
        System.out.println(i);
    }
}
