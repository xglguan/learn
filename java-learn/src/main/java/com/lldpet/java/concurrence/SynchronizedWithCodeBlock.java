package com.lldpet.java.concurrence;

/**
 * @author llduo
 * @Description
 *              synchronized 作用在代码块
 *              并指定对象锁
 * @create 2019-01-10 10:45
 */
public class SynchronizedWithCodeBlock implements Runnable {
    static SynchronizedWithCodeBlock instance = new SynchronizedWithCodeBlock();
    static int i = 0;

    @Override
    public void run() {
        //省略其它的耗时操作..........
        //使用同步代码块对变量i进行同步操作，所对象为 instance
        //对象锁还可以改为 this,代表当前实例
        synchronized (instance){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
