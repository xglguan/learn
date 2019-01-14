package com.lldpet.java.concurrence;

/**
 * @author llduo
 * @Description
 *          Synchronized 关键字作用于实例方法
 *          线程拥有同一个示例对象锁
 * @create 2019-01-09 18:09
 */
public class SynchronizedWithInstance implements Runnable{
    //共享资源(临界资源)
    static int i = 0;

    /**
     * synchronized 修饰实例方法
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
        SynchronizedWithInstance instance = new SynchronizedWithInstance();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join(); // main 线程等待 t1 线程运行结束，再由底层调度运行
        t2.join();

        //i 的值应该是 200000
        System.out.println("临界资源i= "+i);
    }

}
