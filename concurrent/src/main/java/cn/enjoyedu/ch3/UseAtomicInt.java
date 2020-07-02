package cn.enjoyedu.ch3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *类说明：演示基本类型的原子操作类
 */
public class UseAtomicInt {
    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        int num = ai.getAndIncrement();
        System.out.println(num);//10   -  11
        ai.incrementAndGet();//12
        //ai.compareAndSet();
        ai.addAndGet(24);
    }
}
