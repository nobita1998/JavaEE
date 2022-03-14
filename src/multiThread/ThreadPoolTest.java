package multiThread;

import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService e1 = Executors.newCachedThreadPool();// 池子很大，并发运行的线程数量很多
        ExecutorService e2 = Executors.newFixedThreadPool(10);  // 超过10个就会排队
//        Executors.newScheduledThreadPool();
        ExecutorService e3 = Executors.newSingleThreadExecutor();      // Fixed的单数版本


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        for (int i = 0; i < 100; i++) {
            e2.execute(new MyTask(i));
        }

    }
}

class MyTask implements Runnable{
    int i;
    public MyTask(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-----------" + i);
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
