package multiThread;

import java.util.ArrayList;
import java.util.List;

public class waitNotifyTest {

    public static void main(String[] args) {

        Object lock = new Object();
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    list.add("abc");
                    System.out.println("插入字符串，此时list的长度为" + list.size());
                    if (list.size() == 5){
                        lock.notify();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if (list.size() != 5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B线程开始执行...");
                }
            }
        });
        threadB.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
