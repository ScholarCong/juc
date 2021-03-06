package cn.enjoyedu.ch1.vola;

import cn.enjoyedu.tools.SleepTools;

/**
 * 类说明：演示Volatile的提供的可见性
 *
 * volatile 适合一些多读，不适合多写的操作
 */
public class VolatileCase {
    private volatile static boolean ready;
    private static int number;

    //
    private static class PrintThread extends Thread{
        @Override
        public void run() {
            System.out.println("PrintThread is running.......");
            while(!ready);//无限循环
            System.out.println("number = "+number);
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        SleepTools.second(1);
        number = 51;
        ready = true;
        SleepTools.second(5);
        System.out.println("main is ended!");
    }
}
