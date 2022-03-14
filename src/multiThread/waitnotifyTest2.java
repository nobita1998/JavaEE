package multiThread;
/*
* 交替打印
* */
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();   //先唤醒另一个线程
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (number <= 100){
                    System.out.println(Thread.currentThread().getName() + "执行了" + number);
                    number++;
                    // 输出之后，此线程wait()
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class waitnotifyTest2 {
    public static void main(String[] args) {
        Number number = new Number();
        Thread threadA = new Thread(number);
        Thread threadB = new Thread(number);

        threadA.setName("线程1");
        threadB.setName("线程2");

        threadA.start();
        threadB.start();
    }

}
